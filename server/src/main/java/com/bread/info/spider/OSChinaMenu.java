package com.bread.info.spider;

import java.util.List;

public class OSChinaMenu {
    private String name;
    private String href;
    private List<OSChinaMenu> childs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<OSChinaMenu> getChilds() {
        return childs;
    }

    public void setChilds(List<OSChinaMenu> childs) {
        this.childs = childs;
    }
}
