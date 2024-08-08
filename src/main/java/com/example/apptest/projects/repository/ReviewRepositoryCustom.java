package com.example.apptest.projects.repository;

import com.example.apptest.projects.entity.Review;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> findReviewsByProjectId(Long projectId);
}
