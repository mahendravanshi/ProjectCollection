package com.learn.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.Modal.Book;
import com.learn.service.BookService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BookService bookService;

    Book book = Mockito.mock(Book.class);

    List<Book> books = new ArrayList<>();
    @BeforeEach
    public void setup(){
        Mockito.when(book.getId()).thenReturn(1);
        Mockito.when(book.getName()).thenReturn("2002");
        Mockito.when(book.getPrice()).thenReturn(500.0);
        Mockito.when(book.getAuthor()).thenReturn("ABC");


        // Adding 5 books to the list
        books.add(new Book(1, "1984", 9.99, "George Orwell"));
        books.add(new Book(2, "To Kill a Mockingbird", 7.99, "Harper Lee"));
        books.add(new Book(3, "The Great Gatsby", 10.99, "F. Scott Fitzgerald"));
        books.add(new Book(4, "Moby Dick", 8.99, "Herman Melville"));
        books.add(new Book(5, "War and Peace", 12.99, "Leo Tolstoy"));

    }


    @Test
    public void addBookTest() throws Exception {


        Mockito.when(bookService.addBook(Mockito.any(Book.class))).thenReturn(book);

        var perform = mockMvc.perform(MockMvcRequestBuilders.post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)));

        perform.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("2002")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author",Matchers.is("ABC")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price",Matchers.is(500.0)));


    }

    @Test
    public void getBookByIdTest() throws Exception {


        Mockito.when(bookService.findById(1)).thenReturn(Optional.ofNullable(book));
        mockMvc.perform(MockMvcRequestBuilders.get("/book/getById/{id}",1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name",Matchers.is("2002")));
    }

    @Test
    public void getAllTest() throws Exception {

        Mockito.when(bookService.findAllBook()).thenReturn(books);

       var perform =  mockMvc.perform(MockMvcRequestBuilders.get("/book/getAll")

        );

        perform
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(books.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name",Matchers.is("To Kill a Mockingbird")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].author",Matchers.is("F. Scott Fitzgerald")));

    }


    @Test
    public void deleteBookById() throws Exception {

//        Mockito.when(bookService.deleteBookById(1)).thenReturn("Successfully deleted");
//
//        ResultActions perform  = mockMvc.perform(MockMvcRequestBuilders.delete("/book/deleteById/{id}",1));
//
//        perform
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("Successfully deleted"));

         bookService.deleteBookById(1);
         Mockito.verify(bookService,Mockito.times(1)).deleteBookById(1);
    }


    @Test
    public void exception() throws Exception {

         Mockito.when(bookService.deleteBookById(10)).thenThrow(RuntimeException.class);

         mockMvc.perform(MockMvcRequestBuilders.delete("/book/deleteById/{id}",15))
                         .andExpect(MockMvcResultMatchers.status().isNotFound());

        Assertions.assertThrows(RuntimeException.class,()->{
            bookService.deleteBookById(10);
        });

    }










}
