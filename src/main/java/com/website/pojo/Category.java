package com.website.pojo;

public class Category {
    private Long id;

    private String categoryName;

    private String url;

    //非数据库字段
    private String showUrl;

    public String getShowUrl() {
        String[] split = url.split("\\\\");
        return "/" + split[split.length-3] + "/" + split[split.length-2]
                + "/" + split[split.length-1];
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}