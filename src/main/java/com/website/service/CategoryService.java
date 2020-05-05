package com.website.service;

import com.github.pagehelper.PageInfo;
import com.website.pojo.Category;
import com.website.pojo.CategoryExample;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);

    void deleteCategory(Long id);

    void updateCategory(Category category);

    Category getById(Long id);

    PageInfo<Category> getAll(Integer pageNum);

    List<Category> list(CategoryExample example);
}
