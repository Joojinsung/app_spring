package com.example.apptest.projects.repository;

import com.example.apptest.projects.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // 특정 프로젝트에 대한 리뷰를 조회하는 메소드
    List<Review> findByProjectId(Long projectId);

    List<Review> findReviewsByProjectId(Long projectId);
}
