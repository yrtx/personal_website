package com.website.pojo;

import java.util.Date;

public class WebFile {
    private Long id;

    private String fileName;

    private String url;

    private Date createTime;

    private Integer downloadNum;

    private String isAllow;

    private Long usersId;

    private Long categoryId;

    //非数据库字段
    private User user;

    private Category category;

    private String createDate;

    private String type;

    public WebFile() {
    }

    public WebFile(Long id, String fileName, String url, Date createTime, Integer downloadNum, String isAllow, Long usersId, Long categoryId, User user, Category category, String createDate, String type) {
        this.id = id;
        this.fileName = fileName;
        this.url = url;
        this.createTime = createTime;
        this.downloadNum = downloadNum;
        this.isAllow = isAllow;
        this.usersId = usersId;
        this.categoryId = categoryId;
        this.user = user;
        this.category = category;
        this.createDate = createDate;
        this.type = type;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCreateDate() {
        String[] split = getCreateTime().toString().split(" ");
        StringBuilder date = new StringBuilder();
        date.append(split[5] + "/");
        switch (split[1]){
            case "Jan":
                date.append("01/");
                break;
            case "Feb":
                date.append("02/");
                break;
            case "Mar":
                date.append("03/");
                break;
            case "Apr":
                date.append("04/");
                break;
            case "May":
                date.append("05/");
                break;
            case "Jun":
                date.append("06/");
                break;
            case "Jul":
                date.append("07/");
                break;
            case "Aug":
                date.append("08/");
                break;
            case "Sept":
                date.append("09/");
                break;
            case "Oct":
                date.append("10/");
                break;
            case "Nov":
                date.append("11/");
                break;
            case "Dec":
                date.append("12/");
                break;
        }
        return date.append(split[2] + "  " + split[3]).toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(Integer downloadNum) {
        this.downloadNum = downloadNum;
    }

    public String getIsAllow() {
        return isAllow;
    }

    public void setIsAllow(String isAllow) {
        this.isAllow = isAllow == null ? null : isAllow.trim();
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}