package com.learn.service;

import com.learn.Modal.Book;
import com.learn.repo.BookRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

      @Mock
      private BookRepo bookRepo;

      @InjectMocks
      private BookService bookService;

      Book book;

      @BeforeEach
      public void setup(){

            book = Book.builder().id(1).author("ABC").name("Book1").price(500.0).build();

      }

      @Test
      public void addBookTest(){

            when(bookRepo.save(book)).thenReturn(book);
            Book expected = bookService.addBook(book);

            assertEquals(expected.getId(),book.getId());
            assertEquals(book,expected);

      }


      @Test
      public void findByIdTest(){
            Integer id = 1;
            when(bookRepo.findById(1)).thenReturn(Optional.ofNullable(book));
            Optional<Book> expected = bookService.findById(id);

            Assertions.assertThat(expected.get()).isNotNull();
            Assertions.assertThat(expected.isPresent());

            assertEquals(book.getAuthor(),expected.get().getAuthor());
      }

      @Test
      public void findAllBook(){

            when(bookRepo.findAll()).thenReturn(Arrays.asList(book));

            List<Book> expected = bookService.findAllBook();
            assertEquals(book.getAuthor(),expected.get(0).getAuthor());
      }

      @Test
      public void deleteByIdTest() {
                  // Arrange
                  int bookId = 1;
                  doNothing().when(bookRepo).deleteById(bookId);

                  // Act
                  String result = bookService.deleteBookById(bookId);

                  // Assert
                  Mockito.verify(bookRepo).deleteById(bookId);
      }


      @Test
      public void exceptionMethod(){
            Integer id = 10;
            when(bookRepo.findById(id)).thenThrow(
                   new RuntimeException("User not found with user id "+id)
            );


            RuntimeException re = assertThrows(RuntimeException.class,()->{
                  bookService.findById(id);
            });


           assertThat(re.getMessage(),is("User not found with user id "+id));
           assertThat(re.getMessage(),is(not("User found")));

      }






}
