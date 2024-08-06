package com.example.apptest.projects.entity;

public enum CategoryType {
    FACTORY_SEARCH("공장찾기"),
    DESIGN("디자인"),
    ACCESSORIES("악세사리"),
    FABRIC_PRODUCTION("원단제작"),
    MATERIALS("원부자재"),
    CLOTHING_PRODUCTION("의류제작"),
    CLOTHING_PATTERN("의류패턴"),
    AUTOMATIC_CUTTING("자동재단"),
    TRANSFER_PRINTING("전사/나염"),
    CONSULTING("컨설팅"),
    PROMOTIONAL_MATERIAL("판촉물");
    private final String categoryName; // categoryName으로 변경

    CategoryType(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
