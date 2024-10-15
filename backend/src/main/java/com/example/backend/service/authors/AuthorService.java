package com.example.backend.service.authors;

import com.example.backend.dto.AuthorDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.mapper.LibraryMapper;
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

    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(libraryMapper::toAuthorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDTO getAuthorById(Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));
        return libraryMapper.toAuthorDTO(author);
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = libraryMapper.toAuthorEntity(authorDTO);
        Author newAuthor = authorRepository.save(author);
        return libraryMapper.toAuthorDTO(newAuthor);
    }

    @Override
    public AuthorDTO updateAuthor(Long authorId, AuthorDTO authorDTO) {
        Author existingAuthor = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));

        if (authorDTO.getName() != null) {
            existingAuthor.setName(authorDTO.getName());
        }
        if (authorDTO.getNationality() != null) {
            existingAuthor.setNationality(authorDTO.getNationality());
        }

        Author updatedAuthor = authorRepository.save(existingAuthor);
        return libraryMapper.toAuthorDTO(updatedAuthor);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));
        authorRepository.delete(author);
    }
}