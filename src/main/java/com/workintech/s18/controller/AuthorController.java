package com.workintech.s18.controller;

import com.workintech.s18.dto.AuthorResponse;
import com.workintech.s18.dto.AuthorResponseWithBooks;
import com.workintech.s18.dto.BookResponse;
import com.workintech.s18.entity.Author;
import com.workintech.s18.entity.Book;
import com.workintech.s18.service.AuthorService;
import com.workintech.s18.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;

    @PostMapping("/")
    public Author save(@RequestBody Author author) {
        return authorService.save(author);
    }

    @PostMapping("/{bookId}")
    public AuthorResponseWithBooks save(@RequestBody Author author, @PathVariable long bookId){
        Book book = bookService.findById(bookId);
        author.addBook(book);
        book.setAuthor(author);
        authorService.save(author);
        List<BookResponse> bookResponseList = new ArrayList<>();
        //bu kodu util paketinin altına taşı
        for(Book authorBook: author.getBookList()){
            bookResponseList.add(new BookResponse(authorBook.getId(), authorBook.getName(),
                    authorBook.getCategory().getName(),
                    new AuthorResponse(author.getId(),
                            author.getFirstName() + " " + author.getLastName())));
        }
        return new AuthorResponseWithBooks(bookResponseList);
    }
}
