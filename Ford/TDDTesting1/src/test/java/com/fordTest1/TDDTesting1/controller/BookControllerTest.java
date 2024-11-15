package com.fordTest1.TDDTesting1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fordTest1.TDDTesting1.model.Book;
import com.fordTest1.TDDTesting1.service.BookService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookService bookService;

    private Book book;
    private List<Book> books;

    @BeforeEach
    public void initSetup() {
        books = new ArrayList<>();

        book = new Book();
        book.setId(UUID.randomUUID());
        book.setBookName("Book1");
        book.setAuthor("Author1");

        Book book2 = new Book();
        book2.setId(UUID.randomUUID());
        book2.setBookName("Book2");
        book2.setAuthor("Author2");

        Book book3 = new Book();
        book3.setId(UUID.randomUUID());
        book3.setBookName("Book3");
        book3.setAuthor("Author3");

        books.add(book2);
        books.add(book3);
    }

    @Test
    public void addBook_returnBook() throws Exception {
        Mockito.when(bookService.addBook(any(Book.class))).thenReturn(book);

        var perform = mockMvc.perform(post("/books/addBook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book))
        );

        perform.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.bookName", Matchers.is("Book1")))
                .andExpect(jsonPath("$.author", Matchers.is("Author1")));
    }

    @Test
    public void getBookByUUID_returnsBook() throws Exception {
        Mockito.when(bookService.getBookById(any(UUID.class))).thenReturn(book);

        var perform = mockMvc.perform(MockMvcRequestBuilders.get("/books/{id}", book.getId())
        );

        perform.andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(jsonPath("$.id").value(book.getId().toString()))
                .andExpect(jsonPath("$.bookName", Matchers.is("Book1")))
                .andExpect(jsonPath("$.author", Matchers.is("Author1")));
    }

    @Test
    public void getAllBooks_returnsListOfBooks() throws Exception {
        Mockito.when(bookService.getAll()).thenReturn(books);

        var perform = mockMvc.perform(MockMvcRequestBuilders.get("/books")
                .accept(MediaType.APPLICATION_JSON)
        );


        perform.andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(jsonPath("$[0].bookName", Matchers.is("Book2")))
                .andExpect(jsonPath("$[1].bookName", Matchers.is("Book3")))
                .andExpect(jsonPath("$",Matchers.hasSize(2)));
    }


    @Test
    public void deleteBookById_returnsNothing() throws Exception {
        var perform = mockMvc.perform(MockMvcRequestBuilders.delete("/books/{id}", book.getId()));

        perform.andExpect(MockMvcResultMatchers.status().isOk())
                        .andDo(print())
                                .andExpect(MockMvcResultMatchers.status().isNoContent());

        doNothing().when(bookService).deleteBookById(any(UUID.class));
    }





}
