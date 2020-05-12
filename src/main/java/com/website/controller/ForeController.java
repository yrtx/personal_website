package com.website.controller;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageInfo;
import com.website.pojo.*;
import com.website.service.*;
import com.website.util.MyMailUtil;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 添加数据库字段：文件类型
 * 上传显示文件上传进度
 */
@Controller
@RequestMapping("/fore")
public class ForeController {

    private static String randomCaptcha;
    @Resource
    UserService userService;
    @Resource
    CategoryService categoryService;
    @Resource
    WebFileService webFileService;
    @Resource
    ReviewService reviewService;

    @RequestMapping("/main")
    public String main(Model model) {
        List<Category> categories = categoryService.list(null);
        model.addAttribute("categories", categories);
        return "fore/main";
    }

    @RequestMapping("/downloadFile")
    public ResponseEntity<byte[]> download(Long id) throws IOException {
        WebFile webFile = webFileService.getById(id);
        webFile.setDownloadNum(webFile.getDownloadNum() + 1);
        webFileService.update(webFile);
        File file = new File(webFile.getUrl());
        String type = FileTypeUtil.getType(file);
        HttpHeaders headers = new HttpHeaders();
        String fileName=new String((webFile.getFileName()+"."+type).getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

    @RequestMapping("/uploadFileUI")
    public String uploadFileUI(Model model) {
        List<Category> categories = categoryService.list(null);
        model.addAttribute("categories", categories);
        return "fore/uploadFile";
    }
    @RequestMapping("/uploadFile")
    public String uploadFile(HttpServletRequest request, MultipartFile upFile, WebFile webFile) throws IOException {
        String newFileName = IdUtil.simpleUUID();
        File newFile = new File(request.getServletContext().getRealPath("/webFile"), newFileName);
        newFile.getParentFile().mkdirs();
        upFile.transferTo(newFile);
        webFile.setUrl(newFile.getPath());
        webFileService.add(webFile);
        return "redirect:main";
    }

    @RequestMapping("/listWebFileItemByCategory")
    public String listWebFileItemByCategory(@RequestParam(defaultValue = "1") Integer pageNum, Long id, Model model) {
        PageInfo<WebFile> pageInfo = webFileService.getAllByCategoryId(pageNum, id);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("other", "&id="+id);
        return "fore/listWebFileByCategory";
    }

    @RequestMapping("/listWebFileItem")
    public String listWebFileItem(@RequestParam(defaultValue = "1") Integer pageNum, Long id, Model model) {
        WebFile webFile = webFileService.getById(id);
        model.addAttribute("webFile", webFile);

        PageInfo<Review> pageInfo = reviewService.getAllByWebFileId(pageNum, id);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("other", "&id="+id);

        return "fore/listWebFileItem";
    }

    @RequestMapping("/addReview")
    public String addReview(Review review) {
        reviewService.add(review);
        return "redirect:listWebFileItem?id="+review.getFileId();
    }

    @RequestMapping("/deleteReview")
    public String deleteReview(Long id, Long fileId) {
        reviewService.delete(id);
        return "redirect:listWebFileItem?id="+fileId;
    }
    @RequestMapping("/editUser")
    public String editUser(Long id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "fore/editUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user, String captcha) {
        if(!captcha.equals(randomCaptcha)) {
            return "fore/editUser";
        }
        if(user.getPwd().length()!=0) {
            byShiroToUser(user);
        }else {
            user.setPwd(null);
        }
        userService.update(user);
        return "redirect:main";
    }

    @RequestMapping("/login")
    public String login(User user, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPwd());
        try {
            subject.login(token);
            Session session=subject.getSession();
            session.setAttribute("loginUser", subject.getPrincipal());
            return "redirect:main";
        } catch (AuthenticationException e) {
            model.addAttribute("msg", "账号或密码错误");
            return "fore/login";
        }
    }

    @RequestMapping("/sendCaptcha")
    public String sendCaptcha(String email, Model model) {
        randomCaptcha = RandomUtil.randomNumbers(4);
        MyMailUtil.sendMail(email, randomCaptcha);
        return null;    //返回null是为了防止jsp抛出异常
    }
    @RequestMapping("/register")
    public String register(User user, Model model, String captcha) {
        if(!randomCaptcha.equals(captcha)) {
            model.addAttribute("msg", "验证码错误");
            return "fore/register";
        }
        if(userService.getByName(user.getUserName()) != null) {
            model.addAttribute("msg", "用户名已存在");
            return "fore/register";
        }
        byShiroToUser(user);
        userService.add(user);
        return "fore/login";
    }

    private void byShiroToUser(User user) {
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";
        String encodedPassword = new SimpleHash(algorithmName,user.getPwd(),salt,times).toString();
        user.setPwd(encodedPassword);
        user.setSalt(salt);
    }

}
