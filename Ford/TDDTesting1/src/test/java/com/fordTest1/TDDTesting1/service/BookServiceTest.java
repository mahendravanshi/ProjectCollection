package com.fordTest1.TDDTesting1.service;


import com.fordTest1.TDDTesting1.exception.CustomException;
import com.fordTest1.TDDTesting1.model.Book;
import com.fordTest1.TDDTesting1.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BookServiceTest {

      @Mock
      private BookRepository bookRepository;

      @InjectMocks
      private BookService bookService;

      private Book book;

      private List<Book> books;
      private List<Book> singleList;

    @BeforeEach
    public void initSetup() {
        // Mocking the Book objects
        book = Mockito.mock(Book.class);
        Book book1 = Mockito.mock(Book.class);
        Book book2 = Mockito.mock(Book.class);

        // Defining behavior for the mocked Book objects
        UUID bookId = UUID.randomUUID();
        UUID book1Id = UUID.randomUUID();
        UUID book2Id = UUID.randomUUID();

        Mockito.when(book.getId()).thenReturn(bookId);
        Mockito.when(book.getBookName()).thenReturn("Book1");
        Mockito.when(book.getAuthor()).thenReturn("Author1");

        Mockito.when(book1.getId()).thenReturn(book1Id);
        Mockito.when(book1.getBookName()).thenReturn("Book2");
        Mockito.when(book1.getAuthor()).thenReturn("Author2");

        Mockito.when(book2.getId()).thenReturn(book2Id);
        Mockito.when(book2.getBookName()).thenReturn("Book3");
        Mockito.when(book2.getAuthor()).thenReturn("Author3");

        // Creating lists and adding the mocked Book objects
        books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        books.add(book2);

        singleList = new ArrayList<>();
        singleList.add(book2);
    }


      @Test
      public void addBook_returnsBook(){

            Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(book);

            Book expected = bookService.addBook(book);

            Assertions.assertEquals(expected,book);
            assertThat(expected).isNotNull();
            assertThat(expected.getId()).isNotNull();
            Assertions.assertEquals(expected.getBookName(),expected.getBookName());

      }


      @Test
      public void addBook_throwsException(){

             Assertions.assertThrows(CustomException.class,()->bookService.addBook(null),"Cannot add null book");
      }

      @Test
      public void findById_returnsBook(){

           Mockito.when(bookRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.ofNullable(book));

           Book expected = bookService.getBookById(UUID.randomUUID());

           Assertions.assertEquals(expected,book);
           Assertions.assertEquals(expected.getBookName(),book.getBookName());
          assertThat(expected).isNotNull();

      }

      @Test
     public void findById_throwsException(){

          Mockito.when(bookRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.empty());
           CustomException ce =  Assertions.assertThrows(CustomException.class,()->bookService.getBookById(UUID.randomUUID()),"Book not found with UUID");
           assertThat(ce.getMessage()).isEqualTo("Book not found with UUID");

      }


      @Test
      public void getAllBooks_returnListOfBooks(){

             Mockito.when(bookRepository.findAll()).thenReturn(books);

             List<Book> returned = bookRepository.findAll();
             List<Book> expected = bookService.getAll();

             Assertions.assertEquals(returned,expected);
             Assertions.assertEquals(returned.get(0),expected.get(0));
             Assertions.assertEquals(returned.size(),returned.size());
             Assertions.assertEquals(returned.get(0).getAuthor(),expected.get(0).getAuthor());
             assertThat(expected.get(0).getId()).isNotNull();
             assertThat(returned.get(0).getAuthor()).isEqualTo("Author1");
            assertThat(expected.get(0).getBookName()).isEqualTo("Book1");
            assertThat(expected.size()).isEqualTo(3);



      }


      @Test
      public void getAllBooks_returnsSingleResult(){

            Mockito.when(bookRepository.findAll()).thenReturn(Collections.singletonList(book));

            List<Book> expected = bookService.getAll();
            List<Book> actual = bookRepository.findAll();

            Assertions.assertEquals(expected.size(),actual.size());
            Assertions.assertEquals(expected.get(0).getBookName(),expected.get(0).getBookName());
            assertThat(expected.get(0).getId()).isNotNull();
            assertThat(expected.get(0).getAuthor()).isEqualTo("Author1");
            assertThat(expected.get(0).getBookName()).isEqualTo("Book1");

      }



      @Test
      public void getAllBooks_throwsException(){
          Mockito.when(bookRepository.findAll()).thenThrow(new CustomException("No book found in repository"));
             CustomException ce =  Assertions.assertThrows(CustomException.class,()->bookService.getAll(),"No book found in repository");

              assertThat(ce.getMessage()).isEqualTo("No book found in repository");

      }



}

