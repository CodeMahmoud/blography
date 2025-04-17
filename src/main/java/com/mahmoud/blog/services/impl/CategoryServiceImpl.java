package com.mahmoud.blog.services.impl;

import com.mahmoud.blog.domain.dtos.CategoryDto;
import com.mahmoud.blog.domain.entities.Category;
import com.mahmoud.blog.domain.repositories.CategoryRepository;
import com.mahmoud.blog.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();

    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
       categoryRepository.existsByNameIgnoreCase(category.getName());
       if (categoryRepository.existsByNameIgnoreCase(category.getName())) {
           throw new IllegalArgumentException("Category with name " + category.getName() + " already exists");
       }
       return categoryRepository.save(category);
    }

}
