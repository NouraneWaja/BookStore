package com.bookStore.BookStore.service;

import com.bookStore.BookStore.entity.Book;
import com.bookStore.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bRep;

    public void save(Book b){

        bRep.save(b);
    }

    public List<Book> getAllBooks(){

        return bRep.findAll();
    }

    public Book getBookById(int id){

        return bRep.findById(id).get();
    }

    public void deleteBookById(int id){
        bRep.deleteById(id);
    }
}
