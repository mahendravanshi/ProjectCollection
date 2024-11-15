package com.graphql.learn.service.impl;

import com.graphql.learn.entities.Book;
import com.graphql.learn.repository.BookRepo;
import com.graphql.learn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;


    @Override
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public List<Book> getAllBoolks() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> getById(Integer id) {
        return bookRepo.findById(id);
    }

    @Override
    public Optional<Book> getByAuthor(String author) {
        return bookRepo.findByAuthor(author);
    }

    @Override
    public boolean deleteById(Integer id) {

          boolean check = bookRepo.existsById(id);

          if (check) {
              bookRepo.deleteById(id);
              return true;
          }

          return false;
    }


}
