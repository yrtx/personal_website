package com.website.controller;

import com.website.pojo.User;
import com.website.service.CategoryService;
import com.website.service.ReviewService;
import com.website.service.UserService;
import com.website.service.WebFileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {
    @Resource
    UserService userService;
    @Resource
    CategoryService categoryService;
    @Resource
    WebFileService webFileService;
    @Resource
    ReviewService reviewService;
    @RequestMapping("/admin_main")
    public String adminMain(Model model) {
        model.addAttribute("userNum", userService.list(null).size());
        model.addAttribute("categoryNum", categoryService.list(null).size());
        model.addAttribute("webFileNum", webFileService.list(null).size());
        model.addAttribute("reviewNum", reviewService.list(null).size());
        return "admin/main";
    }
    @RequestMapping("/admin_loginUI")
    public String adminLoginUI(Model model) {
        return "admin/login";
    }
    @RequestMapping("/admin_login")
    public String adminLogin(User user, Model model, HttpSession session) {
        User login = userService.getByNameAndPwd(user.getUserName(), user.getPwd());
        if(login != null) {
            if("李悠然".equals(login.getUserName())) {
                session.setAttribute("adminLoginUser", login);
                return "redirect:admin_main";
            }
            model.addAttribute("msg", "你没有进入后台的权限");
            return "admin/login";
        }
        model.addAttribute("msg", "账号或密码错误");
        return "admin/login";
    }
    @RequestMapping("/admin_logout")
    public String admin_logout(HttpSession session) {
        session.removeAttribute("adminLoginUser");
        return "admin/login";
    }


    @RequestMapping("/fore/loginUI")
    public String loginUI() {
        return "fore/login";
    }
    @RequestMapping("/fore/registerUI")
    public String registerUI() {
        return "fore/register";
    }

}
