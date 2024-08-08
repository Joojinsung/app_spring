package com.example.apptest.projects.service;

import com.example.apptest.global.exception.BusinessException;
import com.example.apptest.global.exception.ErrorCode;
import com.example.apptest.projects.entity.Review;
import com.example.apptest.projects.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // 리뷰 생성
    public Review addReview(Long projectId, String reviewerName, String comment, int rating) {
        Review review = new Review();
        review.setProjectId(projectId);
        review.setReviewerName(reviewerName);
        review.setComment(comment);
        review.setRating(rating);
        return reviewRepository.save(review);
    }

    // 특정 프로젝트의 모든 리뷰 조회
    public List<Review> getReviewsByProject(Long projectId) {
        return reviewRepository.findReviewsByProjectId(projectId);
    }

    // 리뷰 수정
    public Review updateReview(Long reviewId, String comment, int rating) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new BusinessException(ErrorCode.REVIEW_NOT_FOUND));

        review.setComment(comment);
        review.setRating(rating);
        return reviewRepository.save(review);
    }

    // 리뷰 삭제
    public void deleteReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new BusinessException(ErrorCode.REVIEW_NOT_FOUND));
        reviewRepository.delete(review);
    }
}
