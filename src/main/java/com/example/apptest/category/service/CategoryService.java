package com.example.apptest.category.service;

import com.example.apptest.category.entity.CategoryEntity;
import com.example.apptest.category.model.CategoryRecord;
import com.example.apptest.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;


    public Map<String, List<CategoryRecord>> saveCategory() {

        List<CategoryEntity> category = categoryRepository.findAll();
        List<CategoryRecord> categoryList = category.stream()
                .map(c -> new CategoryRecord(c.getENG_category_name(), c.getKR_category_name()))
                .toList();


        return Map.of("category", categoryList);
    }


}
