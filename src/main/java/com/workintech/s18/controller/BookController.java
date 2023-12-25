package com.workintech.s18.controller;

import com.workintech.s18.dto.AuthorResponse;
import com.workintech.s18.dto.BookResponse;
import com.workintech.s18.entity.Author;
import com.workintech.s18.entity.Book;
import com.workintech.s18.entity.Category;
import com.workintech.s18.service.AuthorService;
import com.workintech.s18.service.BookService;
import com.workintech.s18.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    @PostMapping("/{categoryId}")
    public BookResponse save(@RequestBody Book book, @PathVariable Long id) {
        Category category = categoryService.findById(id);

        book.setCategory(category);
        bookService.save(book);

        return new BookResponse(book.getId(), book.getName(),
                book.getCategory().getName(), null);
    }

    @PostMapping("/saveByAuthor")
    public BookResponse save(@RequestBody Book book,
                             @RequestParam long categoryId,
                             @RequestParam long authorId){
        //Saving Category Bi-directional
        Category category = categoryService.findById(categoryId);
        book.setCategory(category);
        category.addBook(book);
        //Saving Author Bi-directional
        Author author = authorService.findById(authorId);
        book.setAuthor(author);
        author.addBook(book);

        bookService.save(book);
        return new BookResponse(book.getId(), book.getName(),
                book.getCategory().getName(),
                new AuthorResponse(author.getId(),
                        (author.getFirstName() + " " +author.getLastName())));
    }

}
