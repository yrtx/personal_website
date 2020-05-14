package com.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.mapper.UserMapper;
import com.website.mapper.UserRoleMapper;
import com.website.pojo.*;
import com.website.service.RoleService;
import com.website.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Resource
    UserMapper userMapper;
    @Resource
    UserRoleMapper userRoleMapper;
    @Resource
    RoleService roleService;

    @Override
    public User getByName(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(name);
        List<User> users = list(example);
        if(users.isEmpty())
            return null;
        return users.get(0);
    }

    @Override
    public User getByNameAndPwd(String name, String pwd) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(name).
                andPwdEqualTo(pwd);
        List<User> users = list(example);
        if(users.isEmpty()) {
            return null;
        }
        logger.debug(name + "登录成功");
        return users.get(0);
    }

    @Override
    public void add(User u) {
        int insert = userMapper.insert(u);
        if(insert <= 0) {
            logger.error("注册失败");
        }else{
            userRoleMapper.insert(new UserRoleKey(u.getId(), roleService.getIdByName("用户")));
        }
    }

    @Override
    public void update(User u) {
        userMapper.updateByPrimaryKeySelective(u);
    }

    @Override
    public User get(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> list(UserExample example){
        return userMapper.selectByExample(example);
    }
    @Override
    public PageInfo<User> getAll(Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        UserExample example = new UserExample();
        example.setOrderByClause("id desc");
        return new PageInfo<>(list(example), 5);
    }
}
