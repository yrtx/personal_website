package com.website.pojo;

import java.text.DateFormat;
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

    private String createDate;

    public String getCreateDate() {
        return DateFormat.getDateTimeInstance().format(createTime);
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
}