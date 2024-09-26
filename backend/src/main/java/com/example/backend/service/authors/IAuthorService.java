package com.example.backend.service.authors;

import com.example.backend.dto.AuthorDTO;
import com.example.backend.model.Author;

import java.util.List;

public interface IAuthorService {
    List<AuthorDTO> getAllAuthors();

    AuthorDTO getAuthorById(Long authorId);

    Author createAuthor(Author author);

    Author updateAuthor(Long authorId, Author authorDetails);

    void deleteAuthor(Long authorId);
}
