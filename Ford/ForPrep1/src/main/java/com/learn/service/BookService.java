package com.learn.service;

import com.learn.Modal.Book;
import com.learn.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public String deleteBookById(Integer id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
            return "Successfully deleted";
        } else {
            return "Book not found";
        }
    }

    public Optional<Book> findById(Integer id) {
        return bookRepo.findById(id);
    }

    public List<Book> findAllBook() {
        return bookRepo.findAll();
    }
}
