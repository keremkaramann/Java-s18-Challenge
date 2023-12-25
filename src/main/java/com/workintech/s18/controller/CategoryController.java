package com.workintech.s18.controller;


import com.workintech.s18.dto.CategoryResponse;
import com.workintech.s18.entity.Category;
import com.workintech.s18.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/")
    public CategoryResponse save(@RequestBody Category category) {
        Category savedCategory = categoryService.save(category);
        return new CategoryResponse(savedCategory.getId(), savedCategory.getName());
    }

    @GetMapping("/{id}")
    public CategoryResponse get(@PathVariable long id) {
        Category foundCategory = categoryService.findById(id);
        return new CategoryResponse(foundCategory.getId(), foundCategory.getName());
    }
}
