package com.workintech.s18.service;

import com.workintech.s18.entity.Category;

public interface CategoryService {
    Category findById(long id);

    Category save(Category book);
}
