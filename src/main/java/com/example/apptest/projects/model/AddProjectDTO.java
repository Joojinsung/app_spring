package com.example.apptest.projects.model;

import java.util.List;

public record AddProjectDTO(
        Long id,
        String productName,
        int productPrice,
        String description,
        String deadLine,
        String makerDate,
        String transactionType,
        int quantity,
        List<String> imagePaths // 이미지 경로 필드 추가
) { }
