package com.study.springgraphql.controller;

import com.study.springgraphql.model.Author;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AuthorController {

    private static List<Author> authors = new ArrayList<>();


    @MutationMapping
    public Author createAuthor(@Argument Author author){
        authors.add(author);
        return author;
    }

    @QueryMapping
    public List<Author> getAllAuthors(){
        return authors;
    }

    @MutationMapping
    public Author updateAuthor(@Argument Author author){
        authors = authors.stream().filter(authorValue -> !authorValue.getId().equals(author.getId()))
                .collect(Collectors.toList());
        authors.add(author);
        return author;
    }
}
