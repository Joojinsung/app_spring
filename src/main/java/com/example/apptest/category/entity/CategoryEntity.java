package com.example.apptest.category.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor

public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    private String ENG_category_name;
    private String KR_category_name;

    @Builder
    public CategoryEntity(String ENG_category_name, String KR_category_name) {
        this.ENG_category_name = ENG_category_name;
        this.KR_category_name = KR_category_name;
    }
}
