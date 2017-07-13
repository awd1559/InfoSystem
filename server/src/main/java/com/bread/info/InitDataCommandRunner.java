package com.bread.info;

import com.bread.info.data.model.CodingCategory;
import com.bread.info.data.repository.CodingCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class InitDataCommandRunner implements CommandLineRunner {
    @Autowired
    private CodingCategoryRepository codingCategoryRepository;

    @Override
    public void run(String... strings) throws Exception {

        CodingCategory web = new CodingCategory("web应用");
        CodingCategory mobile = new CodingCategory("手机开发");
        CodingCategory ios = new CodingCategory("ios");
        CodingCategory prog = new CodingCategory("程序开发");
        CodingCategory dev = new CodingCategory("开发工具");
        CodingCategory jquery = new CodingCategory("jquery");
        CodingCategory site = new CodingCategory("建站工具");
        CodingCategory enter = new CodingCategory("企业应用");
        CodingCategory server = new CodingCategory("数据库");

        codingCategoryRepository.save(web);
        codingCategoryRepository.save(mobile);
        codingCategoryRepository.save(ios);
        codingCategoryRepository.save(prog);
        codingCategoryRepository.save(dev);
        codingCategoryRepository.save(jquery);
        codingCategoryRepository.save(site);
        codingCategoryRepository.save(enter);
        codingCategoryRepository.save(server);

        codingCategoryRepository.save(new CodingCategory("spdy", web));
        codingCategoryRepository.save(new CodingCategory("api", web));
        codingCategoryRepository.save(new CodingCategory("微信", web));
        codingCategoryRepository.save(new CodingCategory("rest", web));
        codingCategoryRepository.save(new CodingCategory("htm5", web));

        codingCategoryRepository.save(new CodingCategory("android", mobile));
        codingCategoryRepository.save(new CodingCategory("Native", mobile));
        codingCategoryRepository.save(new CodingCategory("WP", mobile));
        codingCategoryRepository.save(new CodingCategory("mobile game", mobile));


        codingCategoryRepository.save(new CodingCategory("active", ios));
        codingCategoryRepository.save(new CodingCategory("图像", ios));
        codingCategoryRepository.save(new CodingCategory("标签", ios));
        codingCategoryRepository.save(new CodingCategory("地图", ios));

        codingCategoryRepository.save(new CodingCategory("UI组件", prog));
        codingCategoryRepository.save(new CodingCategory("GUI框架", prog));
        codingCategoryRepository.save(new CodingCategory("报表", prog));
        codingCategoryRepository.save(new CodingCategory("图标", prog));

        codingCategoryRepository.save(new CodingCategory("Git", dev));
        codingCategoryRepository.save(new CodingCategory("PHP", dev));
        codingCategoryRepository.save(new CodingCategory("项目构建", dev));
        codingCategoryRepository.save(new CodingCategory("ruby", dev));
        codingCategoryRepository.save(new CodingCategory("python", dev));

        codingCategoryRepository.save(new CodingCategory("picker", jquery));
        codingCategoryRepository.save(new CodingCategory("dialog", jquery));
        codingCategoryRepository.save(new CodingCategory("tabs", jquery));

        codingCategoryRepository.save(new CodingCategory("搜索引擎", site));
        codingCategoryRepository.save(new CodingCategory("邮件列表", site));
        codingCategoryRepository.save(new CodingCategory("bbs", site));
        codingCategoryRepository.save(new CodingCategory("wiki", site));

        codingCategoryRepository.save(new CodingCategory("OA", enter));
        codingCategoryRepository.save(new CodingCategory("BI", enter));
        codingCategoryRepository.save(new CodingCategory("ERP", enter));
        codingCategoryRepository.save(new CodingCategory("POS", enter));
        codingCategoryRepository.save(new CodingCategory("Doc", enter));

        codingCategoryRepository.save(new CodingCategory("FastCGI", server));
        codingCategoryRepository.save(new CodingCategory("Paas", server));
        codingCategoryRepository.save(new CodingCategory("Docker", server));
        codingCategoryRepository.save(new CodingCategory("apache", server));
        codingCategoryRepository.save(new CodingCategory("CGI", server));
    }
}
