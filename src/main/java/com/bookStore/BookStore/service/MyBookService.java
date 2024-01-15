package com.bookStore.BookStore.service;

import com.bookStore.BookStore.entity.MyBookList;
import com.bookStore.BookStore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {

    @Autowired
    private MyBookRepository bRep;

    public void saveMyBooks(MyBookList book){
        bRep.save(book);
    }

    public List<MyBookList> getMyBooks(){
        return bRep.findAll();
    }

    public void deleteBookById (int id){
        bRep.deleteById(id);
    }
}
