package com.bookcomet.repositories;

import com.bookcomet.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Iterable<Book> findByNameContaining(String name);
    Iterable<Book> findByAuthorsContaining(String author);
    Iterable<Book> findByPublisherContaining(String publisher);

}
