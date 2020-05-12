package com.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.mapper.WebFileMapper;
import com.website.pojo.WebFile;
import com.website.pojo.WebFileExample;
import com.website.service.CategoryService;
import com.website.service.UserService;
import com.website.service.WebFileService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 是否上架可以在代码里写
 */
@Service
public class WebFileServiceImpl implements WebFileService {
    Logger logger = Logger.getLogger(WebFileServiceImpl.class);
    @Resource
    WebFileMapper webFileMapper;
    @Resource
    UserService userService;
    @Resource
    CategoryService categoryService;
    @Override
    public void add(WebFile webFile) {
        webFile.setIsAllow("N");
        webFile.setDownloadNum(0);
        webFile.setCreateTime(new Date());
        int insert = webFileMapper.insert(webFile);
        if(insert <= 0) {
            logger.error("添加文件失败");
        }
    }

    @Override
    public void delete(Long id) {
        webFileMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(WebFile webFile) {
        webFileMapper.updateByPrimaryKeySelective(webFile);
    }

    @Override
    public WebFile getById(Long id) {
        return webFileMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<WebFile> list(WebFileExample example) {
        List<WebFile> webFiles = webFileMapper.selectByExample(example);
        for(WebFile webFile : webFiles) {
            webFile.setUser(userService.get(webFile.getUsersId()));
            webFile.setCategory(categoryService.getById(webFile.getCategoryId()));
        }
        return webFiles;
    }

    @Override
    public PageInfo<WebFile> getAllByCategoryId(Integer pageNum, Long id) {
        PageHelper.startPage(pageNum, 6);
        WebFileExample example = new WebFileExample();
        example.createCriteria().andCategoryIdEqualTo(id).andIsAllowNotEqualTo("N");
        return new PageInfo<>(list(example), 5);
    }

    @Override
    public PageInfo<WebFile> getAllByUserId(Integer pageNum, Long id) {
        PageHelper.startPage(pageNum, 6);
        WebFileExample example = new WebFileExample();
        example.createCriteria().andUsersIdEqualTo(id).andIsAllowNotEqualTo("N");
        return new PageInfo<>(list(example), 5);
    }

    @Override
    public PageInfo<WebFile> getAll(Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        WebFileExample example = new WebFileExample();
        example.setOrderByClause("is_allow");
        return new PageInfo<>(list(example), 5);
    }

}
