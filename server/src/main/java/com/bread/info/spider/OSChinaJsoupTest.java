package com.bread.info.spider;

import com.alibaba.fastjson.JSONObject;
import com.bread.info.data.model.Coding;
import com.bread.info.data.model.CodingCategory;
import org.jsoup.Connection;
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

public class OSChinaJsoupTest {
    private static String BASE_URL = "https://www.oschina.net";
    private static String sessionId = "";

    public static void main(String[] args) {
        try {
            Connection.Response res = Jsoup.connect("https://www.oschina.net/home/login")
                    .data("userMail", "awd1559@gmail.com", "userPassword", "fukuokan")
                    .method(Connection.Method.POST)
                    .execute();
            sessionId = res.cookie("oscid");
            System.out.println("sessionId: " + sessionId);

            Document doc = Jsoup.connect(BASE_URL + "/project").get();
            Elements tags = doc.getElementsByTag("project-sort");
            for (Element e : tags) {
                String content = e.toString();

                String pattern = "param=\"(.*)\"";
                Pattern r = Pattern.compile(pattern, Pattern.MULTILINE|Pattern.DOTALL);
                Matcher m = r.matcher(content);

                if(m.find()) {
                    String menustring = m.group(1);
                    JSONObject menu = JSONObject.parseObject(menustring);
                    String items = menu.getJSONObject("menu").getJSONArray("items").toJSONString();
                    List<OSChinaMenu> menus = JSONObject.parseArray(items, OSChinaMenu.class);
//                    for(OSChinaMenu item : menus)
                    OSChinaMenu item = menus.get(1);
                    {
                        CodingCategory parent = new CodingCategory(item.getName());
                        //TODO: save or get the parent coding category from database
                        System.out.println("save or get parent category" + item.getName());

//                        for(OSChinaMenu c : item.getChilds())
                        OSChinaMenu c = item.getChilds().get(1);
                        {
                            System.out.print(c.getName() + ", " );
                            CodingCategory child = new CodingCategory(c.getName(), parent);
                            //TODO: save or get the coding category from database with parent

                            List<String> item_urls = new ArrayList<>();
                            processMenuItem(item_urls, BASE_URL + c.getHref(), "");
                            System.out.println("items total:" + item_urls.size());

                            processItem(item_urls.get(9));
                        }
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processItem(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements name = doc.select("span.project-name");
        if(name.size() > 0) {
            System.out.println("name: " + name.text());
        }

        Elements description = doc.select("div[class=detail editor-viewer all]");
        if(description.size() > 0) {
            System.out.println("description: " + description.get(0).toString());
        }

        Elements langs = doc.select("div#v-basic").select("section.list > div");
        if(langs.size() > 1) {
            System.out.println("lang: " + langs.get(1).select("span > a").text());
        }

//        coding.setAuthor("");

        //Links
        Elements links = doc.select("div.urls > a");
        if(links.size() > 0) {
            String homelink = links.get(0).attr("href").substring(45);
            System.out.println("homelink: " + URLDecoder.decode(homelink, "gb2312"));
        }

        if(links.size() > 1) {
            String doclink = links.get(1).attr("href").substring(45);
            System.out.println("doclink: " + URLDecoder.decode(doclink, "gb2312"));
        }
        if(links.size() > 2) {
            String sourcelink = links.get(2).attr("href").substring(45);
            System.out.println("source link: " + URLDecoder.decode(sourcelink, "gb2312"));
        }

        //oschina最后更新
//        coding.setOsLastUpdate(1.0);
        //oschina评分
        Elements rank = doc.select("div[class=box-aw vertical box]").select("span.number");
        if(rank.size() > 0) {
            System.out.println("rank: " + rank.text());
        }
//        coding.setOsRankCount(0);
        //oschina收藏数
        Elements fav = doc.select("div.collect-num").select("span.num");
        if(fav.size() > 0) {
            System.out.println("fav: " + fav.text());
        }
//        coding.setOsFavCount(0);
        //oschina评论数
        Elements comment = doc.select("div#v-comment").select("header[class=panel-heading box]").select("span[class=title box-aw] > a > span");
        if(comment.size() > 0) {
            System.out.println("comment: " + comment.text());
        } else {
            System.out.println("comment: 0");
        }
//        coding.setOsCommentCount(0);

        //Git
        Elements repo = doc.select("div.github-stats > a");
        if(repo.size() > 2) {
            System.out.println("star: " + repo.get(1).text());
            System.out.println("fork: " + repo.get(2).text());
        }

//        coding.setGitStar();
//        coding.setGitFork(0);
        //最后更新时间
//        coding.setGitLastUpdate();

    }

    private static void processMenuItem(List<String> item_urls, String url, String pageurl) throws IOException {
        System.out.println("get : " + url + pageurl);
        Document doc = Jsoup.connect(url+pageurl).get();
        Elements current_page_items = doc.select("div[class=lists news-list]").select("div[class=box item]").select("div.box-aw > a");
//        if(current_page_items.size() == 0) { System.out.println("not found ");}
        for (Element e : current_page_items) {
            item_urls.add(e.attr("href"));
        }
//        System.out.println("project_url:" + current_page_items.get(0).attr("href"));

        Elements pages = doc.select("ul.paging").select("li[class=active]").next().select("a");
//        System.out.println("next page: " + pages.get(0).attr("href"));
        if(pages.size() > 0) {
            String next_page_url = pages.get(0).attr("href");
            //processMenuItem(item_urls, url, next_page_url);
        }
    }
}
