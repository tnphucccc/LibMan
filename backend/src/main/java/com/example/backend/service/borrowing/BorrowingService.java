package com.example.backend.service.borrowing;

import com.example.backend.dto.BorrowingDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.mapper.LibraryMapper;
import com.example.backend.model.Book;
import com.example.backend.model.Borrower;
import com.example.backend.model.Borrowing;
import com.example.backend.repository.BookRepository;
import com.example.backend.repository.BorrowerRepository;
import com.example.backend.repository.BorrowingRepository;
import com.example.backend.service.authors.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowingService implements IBorrowingService {

    private static final Logger logger = LoggerFactory.getLogger(AuthorService.class);

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public List<BorrowingDTO> getAllBorrowings() {
        logger.info("Fetching all borrowings from the database");
        return borrowingRepository.findAll().stream()
                .map(libraryMapper::toBorrowingDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BorrowingDTO getBorrowingById(Long borrowingId) {
        logger.info("Fetching borrowing with id: {}", borrowingId);
        Borrowing borrowing = borrowingRepository.findById(borrowingId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing not found with id: " + borrowingId));
        BorrowingDTO borrowingDTO = libraryMapper.toBorrowingDTO(borrowing);
        return borrowingDTO;
    }

    @Override
    public BorrowingDTO createBorrowing(BorrowingDTO borrowingDTO) {
        logger.info("Creating a new borrowing");
        Borrowing borrowing = new Borrowing();
        borrowing.setBorrowedDate(LocalDate.now());
        borrowing.setDueDate(borrowingDTO.getDueDate());
        borrowing.setStatus(Borrowing.BorrowingStatus.valueOf("BORROWED"));

        Book book = bookRepository.findById(borrowingDTO.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + borrowingDTO.getBookId()));
        book.setStatus(Book.BookStatus.BORROWED);
        bookRepository.save(book);

        Borrower borrower = borrowerRepository.findById(borrowingDTO.getBorrowerId())
                .orElseThrow(() -> new ResourceNotFoundException("Borrower not found with id: " + borrowingDTO.getBorrowerId()));
        borrowing.setBorrower(borrower);
        borrowing.setBook(book);

        Borrowing saveBorrowing = borrowingRepository.save(borrowing);
        logger.info("Borrowing created successfully with id: {}", saveBorrowing.getBorrowingId());
        return libraryMapper.toBorrowingDTO(saveBorrowing);
    }

    @Override
    public BorrowingDTO updateBorrowing(Long borrowingId, BorrowingDTO borrowingDTO) {
        logger.info("Updating borrowing with id: {}", borrowingId);
        Borrowing existingBorrowing = borrowingRepository.findById(borrowingId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing not found with id: " + borrowingId));

        if (borrowingDTO.getBorrowerId() != null) {
            Borrower borrower = borrowerRepository.findById(borrowingDTO.getBorrowerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Borrower not found with id: " + borrowingDTO.getBorrowerId()));
            existingBorrowing.setBorrower(borrower);
        }
        if (borrowingDTO.getBookId() != null) {
            Book book = bookRepository.findById(borrowingDTO.getBookId())
                    .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + borrowingDTO.getBookId()));
            existingBorrowing.setBook(book);
        }
        if (borrowingDTO.getBorrowedDate() != null) {
            existingBorrowing.setBorrowedDate(borrowingDTO.getBorrowedDate());
        }
        if (borrowingDTO.getDueDate() != null) {
            existingBorrowing.setDueDate(borrowingDTO.getDueDate());
        }

        if (borrowingDTO.getReturnedDate() != null) {
            existingBorrowing.setReturnedDate(borrowingDTO.getReturnedDate());
        }

        Borrowing updateBorrowing = borrowingRepository.save(existingBorrowing);
        logger.info("Borrowing updated successfully with id: {}", updateBorrowing.getBorrowingId());
        return libraryMapper.toBorrowingDTO(updateBorrowing);
    }

    @Override
    public void deleteBorrowing(Long borrowingId) {
        logger.info("Deleting borrowing with id: {}", borrowingId);
        Borrowing borrowing = borrowingRepository.findById(borrowingId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing not found with id: " + borrowingId));
        borrowingRepository.delete(borrowing);
        logger.info("Borrowing deleted successfully with id: {}", borrowingId);
    }
}
