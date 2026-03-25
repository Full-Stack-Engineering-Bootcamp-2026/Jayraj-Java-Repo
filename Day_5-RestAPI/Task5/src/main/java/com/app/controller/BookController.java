package com.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Book;
import com.app.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = service.findById(id);

        if (book == null) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.ok(book);
    }

    // POST
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book saved = service.save(book);
        return ResponseEntity.status(201).body(saved);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        Book updated = service.update(id, book);

        if (updated == null) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        boolean deleted = service.delete(id);

        if (!deleted) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.noContent().build();
    }
}