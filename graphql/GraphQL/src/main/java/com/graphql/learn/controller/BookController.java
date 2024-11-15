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
        book.setTitle(bookInput.title());
        book.setAuthor(bookInput.author());
        book.setPrice(bookInput.price());
        book.setDesc(bookInput.desc());
        book.setPages(bookInput.pages());

        return bookService.addBook(book);
    }

    @MutationMapping("deleteById")
    public Book deleteById(@Argument Integer id){

//         return bookService.deleteById(id)?"Book deleted successfully":"Book not found with book id "+id;

        return bookService.deleteById(id)?new Book():null;
    }




    @QueryMapping("allBooks")
    public List<Book> getAll(){
        return bookService.getAllBoolks();
    }


    @QueryMapping("getBook")
    public Optional<Book> getById(@Argument Integer id){
         return bookService.getById(id);
    }



    @QueryMapping("getBookA")
    public Optional<Book> getByAuthor(@Argument String  author){
        return bookService.getByAuthor(author);
    }






}

record BookInput(
        String title,
        String desc,
        String author,
        double price,
        int pages
) {}

