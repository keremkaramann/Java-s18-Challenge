package com.workintech.s18.service;

import com.workintech.s18.entity.Book;
import com.workintech.s18.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    @Override
    public Book findById(long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            return bookOptional.get();
        }
        throw new RuntimeException("Book with given id is not exist");
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
