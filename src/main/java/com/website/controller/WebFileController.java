package com.website.controller;

import com.github.pagehelper.PageInfo;
import com.website.pojo.WebFile;
import com.website.service.ReviewService;
import com.website.service.WebFileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class WebFileController {
    @Resource
    WebFileService webFileService;
    @Resource
    ReviewService reviewService;

    @RequestMapping("/admin_list_webFile")
    public String listWebFile(@RequestParam(defaultValue = "1")Integer pageNum, Model model) {
        PageInfo<WebFile> pageInfo = webFileService.getAll(pageNum);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/listWebFile";
    }

    @RequestMapping("/admin_delete_webFile")
    public String admin_delete_webFile(Long id) {
        reviewService.deleteByWebFileId(id);
        webFileService.delete(id);
        return "redirect:admin_list_webFile";
    }

    @RequestMapping("/isAllow")
    public String isAllow(WebFile webFile) {
        webFile.setIsAllow("N".equals(webFile.getIsAllow()) ? "Y" : "N");
        webFileService.update(webFile);
        return "redirect:admin_list_webFile";
    }

}
