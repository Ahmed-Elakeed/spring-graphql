package com.study.springgraphql.controller;

import com.study.springgraphql.model.Author;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @CacheEvict(value = "authors",key = "#author.id",allEntries = true)
    public Author createAuthor(@Argument Author author){
        authors.add(author);
        return author;
    }

    @QueryMapping
    @Cacheable(value = "authors")
    public List<Author> getAllAuthors() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Authors not cached");
        return authors;
    }

    @MutationMapping
    @CacheEvict(key = "#author.id",value = "authors",allEntries = true)
    public Author updateAuthor(@Argument Author author){
        authors = authors.stream().filter(authorValue -> !authorValue.getId().equals(author.getId()))
                .collect(Collectors.toList());
        authors.add(author);
        return author;
    }

    @QueryMapping
    @Cacheable(value = "author",key = "#id")
    public Author getAuthorById(@Argument Integer id){
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }
}
