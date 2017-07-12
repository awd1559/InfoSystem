package com.bread.info.util;

import java.util.List;

public class ResultPagable<T> {
    private List<T> items;
    private int pageTotal;

    public ResultPagable(List<T> items) {
        this.items = items;
        this.pageTotal = items.size();
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }
}
