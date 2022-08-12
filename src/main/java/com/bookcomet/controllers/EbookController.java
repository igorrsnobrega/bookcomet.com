package com.bookcomet.controllers;

import com.bookcomet.entities.Book;
import com.bookcomet.services.BookServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    public  final BookServiceImp bookServiceImp;

    public BookController(BookServiceImp bookServiceImp){
        this.bookServiceImp = bookServiceImp;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookServiceImp.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(bookServiceImp.getBookById(id));
    }

    @PostMapping
    public ResponseEntity<Book> insPessoa(@RequestBody @Valid Book book){
        bookServiceImp.insBook(book);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PutMapping
    public ResponseEntity<Book> altPessoa(@RequestBody @Valid Book book){
        bookServiceImp.altBook(book);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @DeleteMapping("/{id}")
    public void delPessoa(@PathVariable Long id){
        bookServiceImp.delBook(id);
    }

    @GetMapping("/author/{author}")
    public Iterable<Book> getBookByAuthor(@PathVariable String author){
        return bookServiceImp.getBookByAuthor(author);
    }

    @GetMapping("/publisher/{publisher}")
    public Iterable<Book> getBookByPublisher(@PathVariable String publisher){
        return bookServiceImp.getBookByPublisher(publisher);
    }

    @GetMapping("/name/{name}")
    public Iterable<Book> getBookByName(@PathVariable String name){
        return bookServiceImp.getBookByName(name);
    }
}
