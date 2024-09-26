package com.example.backend.service.books;

import com.example.backend.dto.BookDTO;

import java.util.List;

public interface IBookService {
    List<BookDTO> getAllBooks();

    BookDTO getBookById(Long bookId);

    BookDTO createBook(BookDTO bookDTO);

    BookDTO updateBook(Long bookId, BookDTO bookDTO);

    void deleteBook(Long bookId);
}
