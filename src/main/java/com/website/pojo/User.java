package com.website.pojo;

public class User {
    private Long id;

    private String userName;

    private String pwd;

    private String email;

    private String salt;

    public User() {
    }

    public User(Long id, String userName, String pwd, String email, String salt) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
        this.email = email;
        this.salt = salt;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}