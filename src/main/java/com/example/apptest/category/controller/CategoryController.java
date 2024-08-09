package com.example.apptest.category.controller;

import com.example.apptest.category.entity.CategoryEntity;
import com.example.apptest.category.model.CategoryRecord;
import com.example.apptest.category.model.SaveCategoryRecord;
import com.example.apptest.category.service.CategoryService;
import jdk.jshell.Snippet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.web.servlet.function.ServerResponse.status;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CategoryController {

    final CategoryService categoryService;


    @GetMapping("/get")
    public Map<String, List<CategoryRecord>> getCategory() {
        return categoryService.getCategory();
    }

    // todo : 회원정보 인증유저, 권한확인해야함
    @PostMapping("/save")
    public ResponseEntity<Snippet.Status> saveCategory(@RequestBody SaveCategoryRecord saveCategoryRecord) {
        categoryService.saveCategory(saveCategoryRecord);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    // todo : 회원정보 인증유저, 권한확인해야함, 카테고리 아읻 ㅣ필요
    @PutMapping("/update/{id}")
    public CategoryEntity updateCategory(@RequestBody SaveCategoryRecord categoryRecord) {
//        return categoryService.updateCategory(categoryRecord);
        return null;
    }

    // todo : 회원정보 인증유저, 권한확인해야함
    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "Category with ID " + id + " has been deleted.";
    }
}