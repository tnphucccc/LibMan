package com.example.backend.service.authors;

import com.example.backend.model.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> getAllAuthors();

    Author getAuthorById(Long authorId);

    Author createAuthor(Author author);

    Author updateAuthor(Long authorId, Author author);

    void deleteAuthor(Long authorId);
}
