package com.website.controller;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageInfo;
import com.website.pojo.Category;
import com.website.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

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
    public String addCategory(Category category, MultipartFile img, HttpServletRequest request) throws IOException {
        category.setUrl(createFile("/img", request, img));
        categoryService.add(category);
        return "redirect:admin_list_category";
    }
    @RequestMapping("/admin_delete_category")
    public String deleteCategory(Long id) {
        Category category = categoryService.getById(id);
        File file = new File(category.getUrl());
        file.delete();
        categoryService.delete(id);
        return "redirect:admin_list_category";
    }
    @RequestMapping("/admin_update_category")
    public String updateCategory(Category category, MultipartFile img, HttpServletRequest request) throws IOException {
        if(!img.isEmpty()) {
            Category c = categoryService.getById(category.getId());
            File file = new File(c.getUrl());
            file.delete();
            category.setUrl(createFile("/img", request, img));            System.out.println("2");
        }
        categoryService.update(category);
        return "redirect:admin_list_category";
    }
    @RequestMapping("/admin_edit_category")
    public String editCategory(Long id, Model model) {
        Category category = categoryService.getById(id);
        model.addAttribute("category", category);
        return "admin/editCategory";
    }


    private String createFile(String path, HttpServletRequest request, MultipartFile img) {
        String newFileName = IdUtil.simpleUUID();
        File newFile = new File(request.getServletContext().getRealPath(path), newFileName + ".jpg");
        newFile.getParentFile().mkdirs();
        try {
            img.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile.getPath();
    }
}
