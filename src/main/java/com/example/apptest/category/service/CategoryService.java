package com.example.apptest.category.service;

import com.example.apptest.category.entity.CategoryEntity;
import com.example.apptest.category.model.CategoryRecord;
import com.example.apptest.category.model.SaveCategoryRecord;
import com.example.apptest.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;


    // 전체 리스트
    public Map<String, List<CategoryRecord>> getCategory() {

        List<CategoryEntity> category = categoryRepository.findAll();
        List<CategoryRecord> categoryList = category.stream()
                .map(c -> new CategoryRecord(c.getENG_category_name(), c.getKR_category_name()))
                .toList();


        return Map.of("category", categoryList);
    }


    // 저장 구현완료
    public CategoryEntity saveCategory(SaveCategoryRecord categoryRecord) {
        CategoryEntity category = CategoryEntity.builder().
                ENG_category_name(categoryRecord.ENG_category_name()).
                KR_category_name(categoryRecord.KR_category_name()).
                build();
        return categoryRepository.save(category);
    }
//
//    public CategoryEntity updateCategory(SaveCategoryRecord categoryRecord) {
//        Optional<CategoryEntity> optionalCategory = categoryRepository.findById(categoryRecord.category_id());
//
//        if (optionalCategory.isPresent()) {
//            CategoryEntity categoryEntity = optionalCategory.get();
//            CategoryEntity category = CategoryEntity.builder().
//                    ENG_category_name(categoryRecord.ENG_category_name()).
//                    KR_category_name(categoryRecord.KR_category_name()).
//                    build();
//            return categoryRepository.save(categoryEntity);
//        } else {
//            throw new IllegalArgumentException("Category not found with id: " + id);
//        }
//    }

    public void deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Category not found with id: " + id);
        }
    }
}


