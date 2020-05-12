package com.website.controller;

import com.website.pojo.User;
import com.website.service.CategoryService;
import com.website.service.ReviewService;
import com.website.service.UserService;
import com.website.service.WebFileService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
    @RequestMapping("/admin")
    public String adminLoginUI(Model model) {
        return "admin/login";
    }
    @RequestMapping("/admin_login")
    public String adminLogin(User user, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPwd());
        try {
            subject.login(token);
            Session session=subject.getSession();
            session.setAttribute("loginUser", subject.getPrincipal());
            return "redirect:admin_main";
        } catch (AuthenticationException e) {
            model.addAttribute("msg", "账号或密码错误");
            return "admin/login";
        }
    }

    @RequestMapping("/fore/loginUI")
    public String loginUI() {
        return "fore/login";
    }
    @RequestMapping("/fore/registerUI")
    public String registerUI() {
        return "fore/register";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }
}
