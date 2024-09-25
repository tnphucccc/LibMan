package com.example.backend.service.books;

import com.example.backend.dto.BookDTO;
import com.example.backend.model.Book;

import java.util.List;

public interface IBookService {
    List<BookDTO> getAllBooks();

    BookDTO getBookById(Long bookId);

    Book createBook(Book book);

    Book updateBook(Long bookId, Book book);

    void deleteBook(Long bookId);
}
