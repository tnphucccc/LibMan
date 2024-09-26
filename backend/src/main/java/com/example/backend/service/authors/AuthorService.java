package com.example.backend.service.authors;

import com.example.backend.dto.AuthorDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.Author;
import com.example.backend.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService implements IAuthorService {
    private static final Logger logger = LoggerFactory.getLogger(AuthorService.class);

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(this::convertToAuthorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDTO getAuthorById(Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));
        return convertToAuthorDTO(author);
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Long authorId, Author author) {
        Author existingAuthor = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));
        existingAuthor.setName(author.getName());
        existingAuthor.setNationality(author.getNationality());
        return authorRepository.save(existingAuthor);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));
        authorRepository.delete(author);
    }

    private AuthorDTO convertToAuthorDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setAuthorId(author.getAuthorId());
        authorDTO.setName(author.getName());
        authorDTO.setNationality(author.getNationality());
        return authorDTO;
    }
}
