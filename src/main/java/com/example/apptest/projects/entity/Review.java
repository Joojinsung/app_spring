package com.example.apptest.projects.entity;

import com.example.apptest.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String reviewerName; // 리뷰 작성자 닉네임

    @Column(nullable = false, length = 500)
    private String comment; // 리뷰 내용

    @Column(nullable = false)
    private int rating; // 별점 (1~5)

    @Column(name = "project_id", nullable = false)
    private Long projectId; //프로젝트 정보

//    @ElementCollection
//    @CollectionTable(name = "review_images", joinColumns = @JoinColumn(name = "review_id"))
//    @Column(name = "review_image_path")
//    private List<String> reviewImagePaths; // 리뷰 이미지 경로들

}
