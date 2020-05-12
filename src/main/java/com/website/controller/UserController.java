package com.website.controller;

import com.github.pagehelper.PageInfo;
import com.website.pojo.Role;
import com.website.pojo.User;
import com.website.service.RoleService;
import com.website.service.UserRoleService;
import com.website.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    UserService userService;
    @Resource
    UserRoleService userRoleService;
    @Resource
    RoleService roleService;

    @RequestMapping("/admin_list_user")
    public String list(Model model, @RequestParam(defaultValue = "1") Integer pageNum){
        PageInfo<User> pageInfo = userService.getAll(pageNum);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/listUser";
    }
    @RequestMapping("/admin_edit_user_role")
    public String admin_edit_user_role(Model model, Long id) {
        List<Long> currentRoleIds = userRoleService.getAllRoleByUser(id);
        List<Role> roles = roleService.list(null);
        model.addAttribute("currentRoleIds", currentRoleIds);
        model.addAttribute("roles", roles);
        model.addAttribute("userId", id);
        return "admin/editUserToRole";
    }
    @RequestMapping("/admin_update_user_role")
    public String admin_update_user_role(Long userId, Long[] roleIds) {
        userRoleService.updateUserToRole(userId, roleIds);
        return "redirect:admin_list_user";
    }
}
