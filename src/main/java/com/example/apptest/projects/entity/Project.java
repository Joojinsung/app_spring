package com.example.apptest.projects.entity;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "projects")
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

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
