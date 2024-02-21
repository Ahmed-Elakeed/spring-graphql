package com.study.springgraphql.model;

import java.io.Serializable;

public class Book implements Serializable {
    private Integer id;
    private String name;
    private Integer pageCount;
    private Author author;


    public Book(Integer id, String name, Integer pageCount, Author author) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
