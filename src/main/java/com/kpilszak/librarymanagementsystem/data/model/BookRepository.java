package com.kpilszak.librarymanagementsystem.data.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findBook(String criteria, String type);
}
