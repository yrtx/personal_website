package com.website.test;

import com.website.mapper.*;
import com.website.pojo.*;
import com.website.service.PermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-service.xml",
        "classpath:spring/applicationContext-trsaction.xml"})
public class TestMapper {
    @Autowired
    UserMapper userMapper;
    @Autowired
    WebFileMapper webFileMapper;
    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    PermissionMapper permissionMapper;
    @Test
    public void testAdd() {

    }
}

