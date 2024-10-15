package com.example.backend.mapper;

import com.example.backend.dto.AuthorDTO;
import com.example.backend.dto.BookDTO;
import com.example.backend.model.Author;
import com.example.backend.model.Book;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class LibraryMapper {
    public BookDTO toBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookId(book.getBookId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setPublicationYear(book.getPublicationYear());

        if (book.getAuthors() != null) {
            bookDTO.setAuthors(book.getAuthors().stream()
                    .map(this::toAuthorDTO)
                    .collect(Collectors.toSet()));
        }

        bookDTO.setStatus(book.getStatus().name());
        return bookDTO;
    }

    private BookDTO.BookSummaryDTO toBookSummaryDTO(Book book) {
        return new BookDTO.BookSummaryDTO(
                book.getBookId(),
                book.getTitle(),
                book.getIsbn(),
                book.getStatus()
        );
    }

    public AuthorDTO toAuthorDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setAuthorId(author.getAuthorId());
        authorDTO.setName(author.getName());
        authorDTO.setNationality(author.getNationality());

        if (author.getBooks() != null) {
            authorDTO.setBooks(author.getBooks().stream()
                    .map(this::toBookSummaryDTO)
                    .collect(Collectors.toSet()));
        }

        return authorDTO;
    }

    private AuthorDTO.AuthorSummaryDTO toAuthorSummaryDTO(Author author) {
        return new AuthorDTO.AuthorSummaryDTO(
                author.getAuthorId(),
                author.getName(),
                author.getNationality()
        );
    }

    public Author toAuthorEntity(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setNationality(authorDTO.getNationality());
        return author;
    }
}
