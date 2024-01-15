package com.bookStore.BookStore.controller;

import com.bookStore.BookStore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookController {

    @Autowired
    private MyBookService service;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyBook(@PathVariable("id") int id){
        service.deleteBookById(id);
        return "redirect:/my_books";
    }
}
