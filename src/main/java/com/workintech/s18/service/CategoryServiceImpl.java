package com.workintech.s18.service;

import com.workintech.s18.entity.Author;
import com.workintech.s18.entity.Category;
import com.workintech.s18.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category findById(long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            return categoryOptional.get();
        }
        throw new RuntimeException("Author with given id not found: " + id);
    }

    @Override
    public Category save(Category book) {
        return categoryRepository.save(book);
    }
}
