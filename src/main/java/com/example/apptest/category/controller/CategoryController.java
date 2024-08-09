package com.example.apptest.category.controller;

import com.example.apptest.category.model.CategoryRecord;
import com.example.apptest.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CategoryController {

    final CategoryService categoryService;


    @GetMapping("/get")
    public Map<String, List<CategoryRecord>> getCategory() {

        return categoryService.saveCategory();

    }

}
