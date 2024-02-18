package com.study.springgraphql.controller;

import com.study.springgraphql.model.Author;
import com.study.springgraphql.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private static final List<Book> books;

    static {
        books=new ArrayList<>();
        books.add(new Book(1,"book1",100,new Author(1,"Ahmed","Elakeed")));
        books.add(new Book(2,"book2",200,new Author(1,"Mohamed","Ammar")));
        books.add(new Book(3,"book3",300,new Author(1,"Yahia","Moaz")));
        books.add(new Book(4,"book4",400,new Author(1,"Abdo","Ashraf")));
    }

    @GetMapping
    @QueryMapping
    public List<Book> getAllBooks(){
        return books;
    }

    @GetMapping(path = "/{id}")
    @QueryMapping
    public Book getBookById(@PathVariable(value = "id") @Argument Integer id){
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }
}
