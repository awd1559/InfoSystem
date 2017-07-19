package com.bread.info.spider;

import com.alibaba.fastjson.JSONObject;
import com.bread.info.data.model.Coding;
import com.bread.info.data.model.CodingCategory;
import com.bread.info.data.repository.CodingCategoryRepository;
import com.bread.info.data.repository.CodingRepository;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OSChinaPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    private static boolean first = true;

    private CodingCategoryRepository codingCategoryRepository;
    private CodingRepository codingRepository;

    public OSChinaPageProcessor(CodingCategoryRepository codingCategoryRepository, CodingRepository codingRepository) {
        super();
        this.codingCategoryRepository = codingCategoryRepository;
        this.codingRepository = codingRepository;
    }

    @Override
    public void process(Page page) {
        String BASE_URL = "https://www.oschina.net";
        String MENU_URL = "https://www.oschina.net/project";
        String LIST_URL = "https://www\\.oschina\\.net/project/tag/\\d+/\\w+";
        String DETAIL_URL = "https://www\\.oschina\\.net/p/\\w+";

        if(first) {
            System.out.println("match menu url");
            first = false;
            String content = page.getHtml().xpath("//project-sort").toString();

            String pattern = "param=\"(.*)\"";
            Pattern r = Pattern.compile(pattern, Pattern.MULTILINE|Pattern.DOTALL);
            Matcher m = r.matcher(content);

            if(m.find()) {
                String menustring = m.group(1);
                JSONObject menu = JSONObject.parseObject(menustring);
                String items = menu.getJSONObject("menu").getJSONArray("items").toJSONString();
                List<OSChinaMenu> menus = JSONObject.parseArray(items, OSChinaMenu.class);
                for(OSChinaMenu item : menus)
                {
                    System.out.println(item.getName());
                    CodingCategory parent = new CodingCategory(item.getName());
                    codingCategoryRepository.save(parent);

                    for(OSChinaMenu c : item.getChilds())
                    {
                        System.out.print(c.getName() + ", " + c.getHref());
                        page.addTargetRequest(BASE_URL + c.getHref());

                        codingCategoryRepository.save(new CodingCategory(c.getName(), parent));
                    }
                    System.out.println();
                }
            }
        } else if (page.getUrl().regex(LIST_URL).match()) {
            System.out.println("match project list: " + page.getUrl().toString());
            String links = page.getHtml().xpath("//div[@class='lists news-list']/div[@class='box item']/div[@class='box-aw']/a/@href").get();
            System.out.println("add target:" + links);
            page.addTargetRequest(links);
        } else if (page.getUrl().regex(DETAIL_URL).match()) {
            System.out.println("match project detail");
            String title = page.getHtml().xpath("//header[@class='box']/div[@class='box-aw']/a/@title").toString();
            String content = page.getHtml().xpath("//div[@class='panel-wrapper details']/section[@class='panel-body']/div[@class='detail editor-viewer all']").toString();
            System.out.println("the title : " + title);
            System.out.println("the content:");
            System.out.println(content);

            Coding coding = new Coding();

//            System.out.println(HTML2Md.convert(content, BASE_URL));
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
