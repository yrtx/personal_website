package com.website.mapper;

import com.website.pojo.WebFile;
import com.website.pojo.WebFileExample;
import java.util.List;

public interface WebFileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WebFile record);

    int insertSelective(WebFile record);

    List<WebFile> selectByExample(WebFileExample example);

    WebFile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WebFile record);

    int updateByPrimaryKey(WebFile record);
}