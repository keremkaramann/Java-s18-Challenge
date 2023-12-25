package com.workintech.s18.service;

import com.workintech.s18.entity.Author;
import com.workintech.s18.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Author findById(long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            return authorOptional.get();
        }
        throw new RuntimeException("Author with given id not found: " + id);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
