package com.graphql.learn;

import com.graphql.learn.entities.Book;
import com.graphql.learn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphQlApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}

   @Autowired
   private BookService bookService;

	@Override
	public void run(String... args) throws Exception {
		Book b1 = new Book();
		b1.setAuthor("ABC");
		b1.setDesc("For learning java");
		b1.setPages(500);
		b1.setPrice(350);
		b1.setTitle("Zero to Hero");


		Book b2 = new Book();
		b2.setAuthor("BCD");
		b2.setDesc("For learning Spring");
		b2.setPages(300);
		b2.setPrice(699);
		b2.setTitle("HLD");

		Book b3 = new Book();
		b3.setAuthor("CDE");
		b3.setDesc("For learning HTML");
		b3.setPages(450);
		b3.setPrice(899);
		b3.setTitle("HTML is not a programming language");


		this.bookService.addBook(b1);
		this.bookService.addBook(b2);
		this.bookService.addBook(b3);

	}
}
