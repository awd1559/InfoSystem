package com.bread.info.spider;

import com.alibaba.fastjson.JSONObject;
import com.bread.info.data.model.Coding;
import com.bread.info.data.model.CodingCategory;
import com.bread.info.data.repository.CodingCategoryRepository;
import com.bread.info.data.repository.CodingRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OSChinaJsoupProcessor {
    private static String BASE_URL = "https://www.oschina.net";
    private CodingRepository codingRepository;
    private CodingCategoryRepository codingCategoryRepository;

    public OSChinaJsoupProcessor(CodingRepository codingRepository, CodingCategoryRepository codingCategoryRepository) {
        this.codingRepository = codingRepository;
        this.codingCategoryRepository = codingCategoryRepository;
    }

    public void run() throws IOException {
        Document doc = Jsoup.connect(BASE_URL + "/project").get();
        Elements tags = doc.getElementsByTag("project-sort");
        for (Element e : tags) {
            String content = e.toString();

            String pattern = "param=\"(.*)\"";
            Pattern r = Pattern.compile(pattern, Pattern.MULTILINE | Pattern.DOTALL);
            Matcher m = r.matcher(content);

            if (m.find()) {
                String menustring = m.group(1);
                JSONObject menu = JSONObject.parseObject(menustring);
                String items = menu.getJSONObject("menu").getJSONArray("items").toJSONString();
                List<OSChinaMenu> menus = JSONObject.parseArray(items, OSChinaMenu.class);
                for (OSChinaMenu item : menus) {
                    CodingCategory parent = codingCategoryRepository.findByName(item.getName());
                    if(parent == null) {
                        parent = new CodingCategory(item.getName());
                        codingCategoryRepository.save(parent);
                    }

                    for (OSChinaMenu c : item.getChilds()) {
                        CodingCategory child = codingCategoryRepository.findByNameAAndParent(item.getName(), parent);
                        if(child == null) {
                            child = new CodingCategory(c.getName(), parent);
                            codingCategoryRepository.save(child);
                        }

                        List<String> item_urls = new ArrayList<>();
                        processMenuItem(item_urls, BASE_URL + c.getHref(), "");

                        for(String item_url : item_urls) {
                            processItem(child, item_url);
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
    private void processItem(CodingCategory category, String url) throws IOException {
        Document doc = Jsoup.connect(url).get();


        Elements name = doc.select("span.project-name");

        Coding coding = codingRepository.findByNameAndCategory(name.text(), category);

        if(coding == null) {
            coding = new Coding();
            coding.setName(name.text());
            coding.setCategory(category);
        }

        coding.setTag("");

        Elements description = doc.select("div[class=detail editor-viewer all]");
        if(description.size() > 0) {
            coding.setDescription(description.get(0).toString());
        }

        Elements langs = doc.select("div#v-basic").select("section.list > div");
        if(langs.size() > 1) {
            coding.setLanguage(langs.get(1).select("span > a").text());
        }

        coding.setAuthor("");

        //Links
        Elements links = doc.select("div.urls > a");
        if(links.size() > 0) {
            String homelink = links.get(0).attr("href").substring(45);
            coding.setHomelink(URLDecoder.decode(homelink, "gb2312"));
        }

        if(links.size() > 1) {
            String doclink = links.get(1).attr("href").substring(45);
            coding.setDoclink(URLDecoder.decode(doclink, "gb2312"));
        }
        if(links.size() > 2) {
            String sourcelink = links.get(2).attr("href").substring(45);
            coding.setSourcelink(URLDecoder.decode(sourcelink, "gb2312"));
        }


        //oschina最后更新
//        coding.setOsLastUpdate(1.0d);
        //oschina评分
        Elements rank = doc.select("div[class=box-aw vertical box]").select("span.number");
        if(rank.size() > 0) {
            coding.setOsRankCount(Float.valueOf(rank.text()));
        } else {
            coding.setOsRankCount(0.0f);
        }

        //oschina收藏数
        Elements fav = doc.select("div.collect-num").select("span.num");
        if(fav.size() > 0) {
            coding.setOsFavCount(Integer.valueOf(fav.text()));
        }

        //oschina评论数
        Elements comment = doc.select("div#v-comment").select("header[class=panel-heading box]").select("span[class=title box-aw] > a > span");
        if(comment.size() > 0) {
            coding.setOsCommentCount(Integer.valueOf(comment.text()));
        } else {
            coding.setOsCommentCount(0);
        }


        //Git
        Elements repo = doc.select("div.github-stats > a");
        if(repo.size() > 2) {
            coding.setGitStar(Integer.valueOf(repo.get(1).text()));
            coding.setGitFork(Integer.valueOf(repo.get(2).text()));
        }
        //最后更新时间
//        coding.setGitLastUpdate();

        codingRepository.save(coding);
    }

    private void processMenuItem(List<String> item_urls, String url, String pageurl) throws IOException {
//        System.out.println("get : " + url + pageurl);
        Document doc = Jsoup.connect(url + pageurl).get();
        Elements current_page_items = doc.select("div[class=lists news-list]").select("div[class=box item]").select("div.box-aw > a");
        for (Element e : current_page_items) {
            item_urls.add(e.attr("href"));
        }

        Elements pages = doc.select("ul.paging").select("li[class=active]").next().select("a");
        if (pages.size() > 0) {
            String next_page_url = pages.get(0).attr("href");
            processMenuItem(item_urls, url, next_page_url);
        }
    }
}
