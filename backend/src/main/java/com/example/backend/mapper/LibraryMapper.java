package com.example.backend.mapper;

import com.example.backend.dto.AuthorDTO;
import com.example.backend.dto.BookDTO;
import com.example.backend.dto.BorrowerDTO;
import com.example.backend.dto.BorrowingDTO;
import com.example.backend.model.Author;
import com.example.backend.model.Book;
import com.example.backend.model.Borrower;
import com.example.backend.model.Borrowing;

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
                    .map(this::toAuthorSummaryDTO)
                    .collect(Collectors.toSet()));
        }

        bookDTO.setStatus(book.getStatus().name());
        bookDTO.setCoverImageUrl(book.getCoverImageUrl());
        return bookDTO;
    }

    public BookDTO.BookSummaryDTO toBookSummaryDTO(Book book) {
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
        authorDTO.setPortraitUrl(author.getPortraitUrl());

        if (author.getBooks() != null) {
            authorDTO.setBooks(author.getBooks().stream()
                    .map(this::toBookSummaryDTO)
                    .collect(Collectors.toSet()));
        }

        return authorDTO;
    }

    public AuthorDTO.AuthorSummaryDTO toAuthorSummaryDTO(Author author) {
        return new AuthorDTO.AuthorSummaryDTO(
                author.getAuthorId(),
                author.getName(),
                author.getNationality(),
                author.getPortraitUrl()
        );
    }

    public Author toAuthorEntity(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setNationality(authorDTO.getNationality());
        author.setPortraitUrl(authorDTO.getPortraitUrl());
        return author;
    }

    public BorrowingDTO toBorrowingDTO(Borrowing borrowing) {
        BorrowingDTO borrowingDTO = new BorrowingDTO();
        borrowingDTO.setBorrowingId(borrowing.getBorrowingId());
        borrowingDTO.setBook(borrowing.getBook());
        borrowingDTO.setBorrower(borrowing.getBorrower());
        borrowingDTO.setBorrowedDate(borrowing.getBorrowedDate());
        borrowingDTO.setDueDate(borrowing.getDueDate());
        borrowingDTO.setStatus(borrowing.getStatus().name());
        return borrowingDTO;
    }


    public BorrowerDTO toBorrowerDTO(Borrower borrower) {
        BorrowerDTO borrowerDTO = new BorrowerDTO();
        borrowerDTO.setBorrowerId(borrower.getBorrowerId());
        borrowerDTO.setName(borrower.getName());
        borrowerDTO.setEmail(borrower.getEmail());
        borrowerDTO.setPhone(borrower.getPhone());
        borrowerDTO.setAddress(borrower.getAddress());
        return borrowerDTO;
    }

    public Borrower toBorrowerEntity(BorrowerDTO borrowerDTO) {
        Borrower borrower = new Borrower();
        borrower.setName(borrowerDTO.getName());
        borrower.setEmail(borrowerDTO.getEmail());
        borrower.setPhone(borrowerDTO.getPhone());
        borrower.setAddress(borrowerDTO.getAddress());
        return borrower;
    }

    public BorrowerDTO.BorrowerSummaryDTO toBorrowerSummaryDTO(Borrower borrower) {
        return new BorrowerDTO.BorrowerSummaryDTO(
                borrower.getBorrowerId(),
                borrower.getName(),
                borrower.getEmail(),
                borrower.getAddress()
        );
    }
}
