package com.example.apptest.projects.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private Long id;

    @NotBlank(message = "리뷰 작성자의 이름은 필수 항목입니다.")
    private String reviewerName;

    @NotBlank(message = "리뷰 내용은 필수 항목입니다.")
    private String comment;

    @Min(value = 1, message = "별점은 1점 이상이어야 합니다.")
    @Max(value = 5, message = "별점은 5점 이하이어야 합니다.")
    private int rating;

    @NotNull(message = "프로젝트 ID는 필수 항목입니다.")
    private Long projectId;

    private Date createdDate;

    private Date lastModifiedDate;
}
