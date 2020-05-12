package com.website.service;

import com.github.pagehelper.PageInfo;
import com.website.pojo.WebFile;
import com.website.pojo.WebFileExample;

import java.util.List;

public interface WebFileService {

    void add(WebFile webFile);

    void delete(Long id);

    void update(WebFile webFile);

    WebFile getById(Long id);

    PageInfo<WebFile> getAllByCategoryId(Integer pageNum, Long id);

    PageInfo<WebFile> getAllByUserId(Integer pageNum, Long id);

    PageInfo<WebFile> getAll(Integer pageNum);

    List<WebFile> list(WebFileExample example);

}
