package com.website.controller;

import com.github.pagehelper.PageInfo;
import com.website.pojo.Category;
import com.website.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class CategoryController {
    @Resource
    CategoryService categoryService;
    @RequestMapping("/admin_list_category")
    public String listCategory(@RequestParam(defaultValue = "1") Integer pageNum, Model model) {
        PageInfo<Category> pageInfo = categoryService.getAll(pageNum);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/listCategory";
    }
    @RequestMapping("/admin_add_category")
    public String addCategory(Category category) {
        categoryService.addCategory(category);
        return "redirect:admin_list_category";
    }
    @RequestMapping("/admin_delete_category")
    public String deleteCategory(Long id) {
        categoryService.deleteCategory(id);
        return "redirect:admin_list_category";
    }
    @RequestMapping("/admin_update_category")
    public String updateCategory(Category category) {
        categoryService.updateCategory(category);
        return "redirect:admin_list_category";
    }

    @RequestMapping("/admin_edit_category")
    public String editCategory(Long id, Model model) {
        Category category = categoryService.getById(id);
        model.addAttribute("category", category);
        return "admin/editCategory";
    }

}
