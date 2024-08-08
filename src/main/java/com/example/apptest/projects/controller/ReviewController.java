package com.example.apptest.projects.controller;

import com.example.apptest.projects.entity.Review;
import com.example.apptest.projects.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 리뷰 생성
    @PostMapping("/{projectId}")
    public ResponseEntity<Review> addReview(
            @PathVariable Long projectId,
            @RequestParam String reviewerName,
            @RequestParam String comment,
            @RequestParam int rating) {

        Review review = reviewService.addReview(projectId, reviewerName, comment, rating);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    // 특정 프로젝트의 리뷰 조회
    @GetMapping("/{projectId}")
    public ResponseEntity<List<Review>> getReviewsByProject(@PathVariable Long projectId) {
        List<Review> reviews = reviewService.getReviewsByProject(projectId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // 리뷰 수정
    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(
            @PathVariable Long reviewId,
            @RequestParam String comment,
            @RequestParam int rating) {

        Review updatedReview = reviewService.updateReview(reviewId, comment, rating);
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

    // 리뷰 삭제
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
