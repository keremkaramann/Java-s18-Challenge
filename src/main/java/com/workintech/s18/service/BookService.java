package com.workintech.s18.service;

import com.workintech.s18.entity.Book;

public interface BookService {
    Book findById(long id);
    Book save(Book book);
}
