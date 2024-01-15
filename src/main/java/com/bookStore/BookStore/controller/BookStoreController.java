package com.bookStore.BookStore.controller;

import com.bookStore.BookStore.entity.Book;
import com.bookStore.BookStore.entity.MyBookList;
import com.bookStore.BookStore.service.BookService;
import com.bookStore.BookStore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookStoreController {

    @Autowired
    BookService service;

    @Autowired
    MyBookService myBookService;

    @GetMapping("/")
    public String Home(){
        return "Home";
    }

    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
        List<Book> books= service.getAllBooks();
        //ModelAndView m=new ModelAndView();
       // m.setViewName("availableBooks");
        //m.addObject("book",books);
        return new ModelAndView("availableBooks","book",books);
    }

    @GetMapping("/my_books")
    public String myBooks(Model model){
        List<MyBookList>list=myBookService.getMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }

    @PostMapping("/save")
    public String addBook (@ModelAttribute Book b){
    service.save(b);
    return "redirect:/available_books";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyBooks(@PathVariable("id") int id){
        Book b=service.getBookById(id);
        MyBookList mb= new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editbook/{id}")
    public String editBook(@PathVariable("id") int id,Model model){
        Book b=service.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }

    @RequestMapping("/deletebook/{id}")
    public String deleteBook (@PathVariable("id") int id){
        service.deleteBookById(id);
        return "redirect:/available_books";
    }
}
