package com.website.controller;

import com.github.pagehelper.PageInfo;
import com.website.pojo.Review;
import com.website.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class ReviewController {

    @Resource
    ReviewService reviewService;
    @RequestMapping("/admin_list_review")
    public String listReview(@RequestParam(defaultValue = "1") Integer pageNum,
                             Long id, Model model) {
        PageInfo<Review> pageInfo = reviewService.getAllByWebFileId(pageNum, id);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("other", "&id="+id);
        return "admin/listReview";
    }
    @RequestMapping("/admin_delete_review")
    public String deleteReview(Long id, Long fileId, Model model) {
        reviewService.deleteReview(id);
        return "redirect:admin_list_review?id="+fileId;
    }
}
