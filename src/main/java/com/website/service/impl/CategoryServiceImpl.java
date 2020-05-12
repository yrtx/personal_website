package com.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.mapper.CategoryMapper;
import com.website.pojo.Category;
import com.website.pojo.CategoryExample;
import com.website.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryMapper categoryMapper;
    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void delete(Long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public Category getById(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Category> getAll(Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        return new PageInfo<>(list(null), 5);
    }

    @Override
    public List<Category> list(CategoryExample example) {
        return categoryMapper.selectByExample(example);
    }
}
