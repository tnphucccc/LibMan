package com.example.backend.service.authors;

import com.example.backend.dto.AuthorDTO;

import java.util.List;

public interface IAuthorService {
    List<AuthorDTO> getAllAuthors();

    AuthorDTO getAuthorById(Long authorId);

    AuthorDTO createAuthor(AuthorDTO authorDTO);

    AuthorDTO updateAuthor(Long authorId, AuthorDTO authorDTO);

    void deleteAuthor(Long authorId);
}