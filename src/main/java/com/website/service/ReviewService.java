package com.website.service;

import com.github.pagehelper.PageInfo;
import com.website.pojo.Review;
import com.website.pojo.ReviewExample;

import java.util.List;

public interface ReviewService {
    void add(Review review);

    void delete(Long id);

    void deleteByWebFileId(Long id);

    void update(Review review);

    Review getById(Long id);

    PageInfo<Review> getAllByWebFileId(Integer pageNum, Long id);

    List<Review> list(ReviewExample example);
}
