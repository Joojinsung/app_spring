package com.example.apptest.projects.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    @Enumerated(EnumType.STRING)
    private CategoryType category;

    @Column(name = "seller_id") // 판매자 ID를 저장
    private Long sellerId;

    private int productPrice;

    @Column(length = 1000)
    private String description;


    private String deadLine;

    private String makerDate;

    @ElementCollection
    private List<String> imagePaths;

    private String transactionType;

    private int quantity;

}
