package com.website.pojo;

import java.util.Date;

public class Review {
    private Long id;

    private String content;

    private Date createTime;

    private Long userId;

    private Long fileId;


    //非数据库字段
    private User user;

    private WebFile webFile;

    private String creteDate;

    public Review() {
    }

    public Review(Long id, String content, Date createTime, Long userId, Long fileId, User user, WebFile webFile, String creteDate) {
        this.id = id;
        this.content = content;
        this.createTime = createTime;
        this.userId = userId;
        this.fileId = fileId;
        this.user = user;
        this.webFile = webFile;
        this.creteDate = creteDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WebFile getWebFile() {
        return webFile;
    }

    public void setWebFile(WebFile webFile) {
        this.webFile = webFile;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", userId=" + userId +
                ", fileId=" + fileId +
                ", user=" + user +
                ", webFile=" + webFile +
                ", creteDate='" + creteDate + '\'' +
                '}';
    }
}