package com.springboot.caching.Srevice;

import com.springboot.caching.Entity.Book;
import com.springboot.caching.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book save(Book book){
        return bookRepository.save(book);
    }

    @CachePut(cacheNames = "books",key = "#book.id")
    public Book update(Book book){

        bookRepository.updateAddress(book.getId(),book.getName());
        return book;
    }

    @Cacheable(cacheNames = "books",key = "#id")
    public Book getBook(int id){

        Optional<Book> book= bookRepository.findById(id);
        if(book.isPresent()){
            return  book.get();
        }
        return new Book();
    }
}
