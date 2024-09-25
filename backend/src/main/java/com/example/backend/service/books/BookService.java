package com.example.backend.service.books;

import com.example.backend.dto.BookDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.Author;
import com.example.backend.model.Book;
import com.example.backend.repository.AuthorRepository;
import com.example.backend.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::convertToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));
        return convertToBookDTO(book);
    }

    @Override
    public Book createBook(Book book) {
        try {
            Set<Author> authors = book.getAuthors();
            if (authors != null) {
                book.setAuthors(getPersistedAuthors(authors));
            }
            if (book.getTitle() == null || book.getIsbn() == null || book.getStatus() == null) {
                throw new IllegalArgumentException("Title, ISBN, and Status cannot be null");
            }
            return bookRepository.save(book);
        } catch (Exception e) {
            logger.error("An error occurred while creating the book: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public Book updateBook(Long bookId, Book bookDetails) {
        try {
            Book existingBook = bookRepository.findById(bookId)
                    .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));

            if (bookDetails.getTitle() != null) {
                existingBook.setTitle(bookDetails.getTitle());
            }
            if (bookDetails.getIsbn() != null) {
                existingBook.setIsbn(bookDetails.getIsbn());
            }
            if (bookDetails.getPublicationYear() != null) {
                existingBook.setPublicationYear(bookDetails.getPublicationYear());
            }
            if (bookDetails.getStatus() != null) {
                existingBook.setStatus(bookDetails.getStatus());
            }

            Set<Author> authors = bookDetails.getAuthors();
            if (authors != null) {
                existingBook.setAuthors(getPersistedAuthors(authors));
            }

            return bookRepository.save(existingBook);
        } catch (Exception e) {
            logger.error("An error occurred while updating the book: {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));
        bookRepository.delete(book);
    }

    private Set<Author> getPersistedAuthors(Set<Author> authors) {
        Set<Author> persistedAuthors = new HashSet<>();
        for (Author author : authors) {
            Optional<Author> existingAuthor = authorRepository.findByName(author.getName());
            if (existingAuthor.isPresent()) {
                persistedAuthors.add(existingAuthor.get());
            } else {
                persistedAuthors.add(authorRepository.save(author));
            }
        }
        return persistedAuthors;
    }

    private BookDTO convertToBookDTO(Book book) {
        List<String> authorNames = book.getAuthors().stream()
                .map(Author::getName)
                .collect(Collectors.toList());
        return new BookDTO(book.getBookId(), book.getTitle(), book.getIsbn(), book.getPublicationYear(), authorNames, book.getStatus().name());
    }
}