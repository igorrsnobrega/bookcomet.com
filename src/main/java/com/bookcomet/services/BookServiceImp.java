package com.bookcomet.services;

import com.bookcomet.entities.Book;
import com.bookcomet.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp {

    public final BookRepository bookRepository;

    public BookServiceImp(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public Book insBook(Book book){
        book.setCreatedAt(new Date());
        return bookRepository.save(book);
    }

    public Book altBook(Book book){
        book.setUpdatedAt(new Date());
        return bookRepository.save(book);
    }

    public void delBook(Long id){
        bookRepository.deleteById(id);
    }

    public Iterable<Book> getBookByAuthor(String authors){
        return bookRepository.findByAuthorsContaining(authors);
    }

    public Iterable<Book> getBookByPublisher(String publisher){
        return bookRepository.findByPublisherContaining(publisher);
    }

    public Iterable<Book> getBookByName(String name){
        return bookRepository.findByNameContaining(name);
    }

}
