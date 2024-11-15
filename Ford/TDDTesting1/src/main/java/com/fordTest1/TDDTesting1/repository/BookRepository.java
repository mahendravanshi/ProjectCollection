package com.fordTest1.TDDTesting1.repository;

import com.fordTest1.TDDTesting1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book,UUID> {

}
