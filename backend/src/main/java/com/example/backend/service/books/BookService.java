package com.example.backend.service.books;

import com.example.backend.dto.AuthorDTO;
import com.example.backend.dto.BookDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.mapper.LibraryMapper;
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

    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public List<BookDTO> getAllBooks() {
        logger.info("Fetching all books from the database");
        return bookRepository.findAll().stream()
                .map(book -> {
                    BookDTO bookDTO = libraryMapper.toBookDTO(book);
                    List<Author> authors = bookRepository.findAuthorsByBookId(book.getBookId());
                    bookDTO.setAuthors(authors.stream()
                            .map(libraryMapper::toAuthorSummaryDTO)
                            .collect(Collectors.toSet()));
                    return bookDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long bookId) {
        logger.info("Fetching book with id: {}", bookId);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));
        BookDTO bookDTO = libraryMapper.toBookDTO(book);
        List<Author> authors = bookRepository.findAuthorsByBookId(book.getBookId());
        bookDTO.setAuthors(authors.stream()
                .map(libraryMapper::toAuthorSummaryDTO)
                .collect(Collectors.toSet()));
        return bookDTO;
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        logger.info("Creating a new book");
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setIsbn(bookDTO.getIsbn());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setStatus(Book.BookStatus.valueOf(bookDTO.getStatus()));

        Set<Author> authors = getPersistedAuthors(bookDTO.getAuthors());
        book.setAuthors(authors);

        Book savedBook = bookRepository.save(book);
        logger.info("Book created successfully with id: {}", savedBook.getBookId());
        return libraryMapper.toBookDTO(savedBook);
    }

    @Override
    public BookDTO updateBook(Long bookId, BookDTO bookDTO) {
        logger.info("Updating book with id: {}", bookId);
        Book existingBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));

        if (bookDTO.getTitle() != null) {
            existingBook.setTitle(bookDTO.getTitle());
        }
        if (bookDTO.getIsbn() != null) {
            existingBook.setIsbn(bookDTO.getIsbn());
        }
        if (bookDTO.getPublicationYear() != null) {
            existingBook.setPublicationYear(bookDTO.getPublicationYear());
        }

        if (bookDTO.getAuthors() != null && !bookDTO.getAuthors().isEmpty()) {
            Set<Author> authors = getPersistedAuthors(bookDTO.getAuthors());
            existingBook.setAuthors(authors);
        }

        if (bookDTO.getStatus() != null) {
            existingBook.setStatus(Book.BookStatus.valueOf(bookDTO.getStatus()));
        }
        Book updatedBook = bookRepository.save(existingBook);
        logger.info("Book updated successfully with id: {}", updatedBook.getBookId());
        return libraryMapper.toBookDTO(updatedBook);
    }

    @Override
    public void deleteBook(Long bookId) {
        logger.info("Deleting book with id: {}", bookId);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));
        bookRepository.delete(book);
        logger.info("Book deleted successfully with id: {}", bookId);
    }

    private Set<Author> getPersistedAuthors(Set<AuthorDTO.AuthorSummaryDTO> authorDTOs) {
        Set<Author> persistedAuthors = new HashSet<>();
        for (AuthorDTO.AuthorSummaryDTO authorDTO : authorDTOs) {
            Optional<Author> existingAuthor = authorRepository.findByName(authorDTO.getName());
            if (existingAuthor.isPresent()) {
                persistedAuthors.add(existingAuthor.get());
            } else {
                Author newAuthor = new Author();
                newAuthor.setName(authorDTO.getName());
                newAuthor.setNationality(authorDTO.getNationality());
                persistedAuthors.add(authorRepository.save(newAuthor));
            }
        }
        return persistedAuthors;
    }
}