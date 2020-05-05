package com.website.service;

import com.github.pagehelper.PageInfo;
import com.website.pojo.WebFile;
import com.website.pojo.WebFileExample;

import java.util.List;

public interface WebFileService {

    void addWebFile(WebFile webFile);

    void deleteWebFile(Long id);

    void updateWebFile(WebFile webFile);

    WebFile getById(Long id);

    PageInfo<WebFile> getAllByCategoryId(Integer pageNum, Long id);

    PageInfo<WebFile> getAllByUserId(Integer pageNum, Long id);

    PageInfo<WebFile> getAll(Integer pageNum);

    List<WebFile> list(WebFileExample example);

    List<WebFile> listByDownload();
}
