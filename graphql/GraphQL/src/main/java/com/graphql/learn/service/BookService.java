package com.graphql.learn.service;


import com.graphql.learn.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {

      Book addBook(Book book);

      List<Book>  getAllBoolks();

      Optional<Book> getById(Integer id);





}
