package com.springboot.caching.Controller;


import com.springboot.caching.Entity.Book;
import com.springboot.caching.Srevice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public Book addBook(Book book){
        return bookService.save(book);
    }

    @PostMapping("update")
    public Book update(Book book){
        return bookService.update(book);
    }
}
