package com.app.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.app.model.Book;

@Service
public class BookService {

    private Map<Integer, Book> bookMap = new HashMap<>();

    // GET ALL
    public List<Book> findAll() {
        return new ArrayList<>(bookMap.values());
    }

    // GET BY ID
    public Book findById(int id) {
        return bookMap.get(id);
    }

    // SAVE
    public Book save(Book book) {
        bookMap.put(book.getId(), book);
        return book;
    }

    // UPDATE
    public Book update(int id, Book book) {
        if (bookMap.containsKey(id)) {
            book.setId(id);
            bookMap.put(id, book);
            return book;
        }
        return null;
    }

    // DELETE
    public boolean delete(int id) {
        if (bookMap.containsKey(id)) {
            bookMap.remove(id);
            return true;
        }
        return false;
    }
}