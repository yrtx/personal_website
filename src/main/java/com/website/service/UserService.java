package com.website.service;

import com.github.pagehelper.PageInfo;
import com.website.pojo.User;
import com.website.pojo.UserExample;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(User user);

    User get(Long id);
    User getByName(String name);
    User getByNameAndPwd(String name, String pwd);
    List<User> list(UserExample example);

    PageInfo<User> getAll(Integer pageNum);
}
