package com.workintech.s18.service;

import com.workintech.s18.entity.Author;

public interface AuthorService {
    Author findById(long id);

    Author save(Author author);
}
