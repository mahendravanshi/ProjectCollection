package com.graphql.learn.repository;


import com.graphql.learn.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {

    Optional<Book> findByAuthor(String author);

}
