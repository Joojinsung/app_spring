package com.example.apptest.category.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    private String ENG_category_name;
    private String KR_category_name;


}
