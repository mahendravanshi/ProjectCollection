package com.fordTest1.TDDTesting1.service;

import com.fordTest1.TDDTesting1.exception.CustomException;
import com.fordTest1.TDDTesting1.model.Book;
import com.fordTest1.TDDTesting1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookService {

    @Autowired
    private BookRepository bookRepository;
    public Book addBook(Book book) {
        if(book==null){
            throw new CustomException("Cannot add null book");
        }
        return bookRepository.save(book);
    }



    public Book getBookById(UUID id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty()){
            throw new CustomException("Book not found with UUID");
        }
        return book.get();

    }

    public List<Book> getAll() {
        List<Book> books =  bookRepository.findAll();
        if(books.isEmpty()) throw new CustomException("No book found in database");

        return books;
    }


    public void deleteBookById(UUID uuid) {

    }
}
