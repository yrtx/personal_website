package com.website.controller;

import com.github.pagehelper.PageInfo;
import com.website.pojo.User;
import com.website.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/admin_list_user")
    public String list(Model model, @RequestParam(defaultValue = "1") Integer pageNum){
        PageInfo<User> pageInfo = userService.getAll(pageNum);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/listUser";
    }
}
