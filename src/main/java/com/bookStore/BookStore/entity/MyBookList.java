package com.bookStore.BookStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "myBooks")
public class MyBookList {
    @Id
    private int id;
    private String name;
    private String author;
    private float price;

    public MyBookList() {
    }

    public MyBookList(int id, String name, String author, float price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
