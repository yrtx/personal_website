package com.website.pojo;

public class User {
    private Long id;

    private String userName;

    private String pwd;

    private String email;

    public User() {
    }

    public User(Long id, String userName, String pwd, String email) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}