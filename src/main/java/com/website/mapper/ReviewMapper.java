package com.website.mapper;

import com.website.pojo.Review;
import com.website.pojo.ReviewExample;
import java.util.List;

public interface ReviewMapper {
    int deleteByPrimaryKey(Long id);

    int bathDeleteByWebFileId(Long id);

    int insert(Review record);

    int insertSelective(Review record);

    List<Review> selectByExample(ReviewExample example);

    Review selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Review record);

    int updateByPrimaryKey(Review record);
}