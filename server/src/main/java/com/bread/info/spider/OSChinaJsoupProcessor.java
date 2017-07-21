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

    public void run() {

        Document doc = null;
        try {
            doc = Jsoup.connect(BASE_URL + "/project").get();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
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
                    CodingCategory parent = null;
                    List<CodingCategory> parentlist = codingCategoryRepository.findBySubject(item.getName());
                    if(parentlist == null || parentlist.size() == 0) {
                        parent = new CodingCategory(item.getName());
                        codingCategoryRepository.save(parent);
                    } else {
                        parent = parentlist.get(0);
                    }

                    for (OSChinaMenu c : item.getChilds()) {
                        List<CodingCategory> result = codingCategoryRepository.findBySubjectAndParent(c.getName(), parent);
                        CodingCategory child = null;
                        if(result == null || result.size() == 0) {
                            child = new CodingCategory(c.getName(), parent);
                            codingCategoryRepository.save(child);
                        } else {
                            child = result.get(0);
                        }

                        List<String> item_urls = new ArrayList<>();
                        System.out.println("scan page: " + BASE_URL + c.getHref());
                        processMenuItem(item_urls, BASE_URL + c.getHref(), "");
                        System.out.println("get " + c.getName() +" count: " + item_urls.size());

                        for(String item_url : item_urls) {
                            List<Coding> result1 = codingRepository.findByHomelink(item_url);
                            if(result1 != null && result1.size() > 0) continue;
                            processItem(child, item_url);
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
    private void processItem(CodingCategory category, String url) {
        System.out.println("get : " + url);
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Elements name = doc.select("span.project-name");

        Coding coding = null;
        List<Coding> result = codingRepository.findByNameAndCategory(name.text(), category);

        if(result == null || result.size() == 0) {
            coding = new Coding();
            coding.setName(name.text());
            coding.setCategory(category);
        } else {
            return;
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
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        //oschina最后更新
//        coding.setOsLastUpdate(1.0d);
        //oschina评分
        Elements rank = doc.select("div[class=box-aw vertical box]").select("span.number");
        if(rank.size() > 0) {
            Float floatrank = 0.0f;
            try {
                floatrank = Float.valueOf(rank.text());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            coding.setOsRankCount(floatrank);
        } else {
            coding.setOsRankCount(0.0f);
        }

        //oschina收藏数
        Elements fav = doc.select("div.collect-num").select("span.num");
        if(fav.size() > 0) {
            int intfav = 0;
            try {
                intfav = Integer.valueOf(fav.text());
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
            coding.setOsFavCount(intfav);
        }

        //oschina评论数
        Elements comment = doc.select("div#v-comment").select("header[class=panel-heading box]").select("span[class=title box-aw] > a > span");
        if(comment.size() > 0) {
            int intcomment = 0;
            try {
                intcomment = Integer.valueOf(comment.text());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            coding.setOsCommentCount(intcomment);
        } else {
            coding.setOsCommentCount(0);
        }


        //Git
        Elements repo = doc.select("div.github-stats > a");
        if(repo.size() > 2) {
            int intstar = 0;
            int intfork = 0;
            try {
                intstar = Integer.valueOf(repo.get(1).text());
                intfork = Integer.valueOf(repo.get(2).text());
            } catch(NumberFormatException e) {
                e.printStackTrace();
            }
            coding.setGitStar(intstar);
            coding.setGitFork(intfork);
        }
        //最后更新时间
//        coding.setGitLastUpdate();

        codingRepository.save(coding);
    }

    private void processMenuItem(List<String> item_urls, String url, String pageurl) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url + pageurl).get();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
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
