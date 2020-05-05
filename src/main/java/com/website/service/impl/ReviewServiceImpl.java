package com.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.mapper.ReviewMapper;
import com.website.pojo.Review;
import com.website.pojo.ReviewExample;
import com.website.service.ReviewService;
import com.website.service.UserService;
import com.website.service.WebFileService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    Logger logger = Logger.getLogger(ReviewServiceImpl.class);
    @Resource
    ReviewMapper reviewMapper;
    @Resource
    WebFileService webFileService;
    @Resource
    UserService userService;
    @Override
    public void addReview(Review review) {
        review.setCreateTime(new Date());
        int insert = reviewMapper.insert(review);
        if(insert <= 0) {
            logger.error("添加评论失败");
        }
    }

    @Override
    public void deleteReview(Long id) {
        reviewMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteReviewByWebFileId(Long id) {
        reviewMapper.bathDeleteByWebFileId(id);
    }

    @Override
    public void updateReview(Review review) {
        reviewMapper.updateByPrimaryKeySelective(review);
    }

    @Override
    public Review getById(Long id) {
        return reviewMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Review> getAllByWebFileId(Integer pageNum, Long id) {
        PageHelper.startPage(pageNum, 6);
        ReviewExample example = new ReviewExample();
        example.createCriteria().andFileIdEqualTo(id);
        return new PageInfo<>(list(example), 5);
    }

    @Override
    public List<Review> list(ReviewExample example) {
        List<Review> reviews = reviewMapper.selectByExample(example);
        for(Review review : reviews) {
            review.setWebFile(webFileService.getById(review.getFileId()));
            review.setUser(userService.get(review.getUserId()));
        }
        return reviews;
    }
}
