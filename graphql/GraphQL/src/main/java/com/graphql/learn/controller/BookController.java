package com.graphql.learn.controller;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.graphql.learn.entities.Book;
import com.graphql.learn.service.BookService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {


    @Autowired
    private BookService bookService;



     //create book

    @MutationMapping("createBook")
    public Book addBook(@Argument(name="book") BookInput bookInput) {
        Book book = new Book();
        book.setTitle(bookInput.getTitle());
        book.setAuthor(bookInput.getAuthor());
        book.setPrice(bookInput.getPrice());
        book.setDesc(bookInput.getDesc());
        book.setPages(bookInput.getPages());

        return bookService.addBook(book);
    }



    @QueryMapping("allBooks")
    public List<Book> getAll(){
        return bookService.getAllBoolks();
    }



    @QueryMapping("getBook")
    public Optional<Book> getById(@Argument Integer id){
         return bookService.getById(id);
    }





}

@Getter
@Setter
class BookInput{

        private String title;
        private String desc;
        private String author;
        private double price;
        private int pages;
}
