package com.example.backend.service.borrowing;

import com.example.backend.dto.BorrowingDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.mapper.LibraryMapper;
import com.example.backend.model.Borrowing;
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
        return libraryMapper.toBorrowingDTO(borrowing);
    }

    @Override
    public BorrowingDTO createBorrowing(BorrowingDTO borrowingDTO) {
        logger.info("Creating a new borrowing");
        Borrowing borrowing = new Borrowing();
        borrowing.setBorrower(borrowingDTO.getBorrower());
        borrowing.setBook(borrowingDTO.getBook());
        borrowing.setBorrowedDate(LocalDate.now());
        borrowing.setDueDate(borrowingDTO.getDueDate());
        borrowing.setStatus(Borrowing.BorrowingStatus.valueOf("BORROWED"));

        Borrowing saveBorrowing = borrowingRepository.save(borrowing);
        logger.info("Borrowing created successfully with id: {}", saveBorrowing.getBorrowingId());
        return libraryMapper.toBorrowingDTO(saveBorrowing);

    }

    @Override
    public BorrowingDTO updateBorrowing(Long borrowingId, BorrowingDTO borrowingDTO) {
        logger.info("Updating borrowing with id: {}", borrowingId);
        Borrowing existingBorrowing = borrowingRepository.findById(borrowingId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing not found with id: " + borrowingId));

        if (borrowingDTO.getBorrower() != null) {
            existingBorrowing.setBorrower(borrowingDTO.getBorrower());
        }
        if (borrowingDTO.getBook() != null) {
            existingBorrowing.setBook(borrowingDTO.getBook());
        }
        if (borrowingDTO.getBorrowedDate() != null) {
            existingBorrowing.setBorrowedDate(borrowingDTO.getBorrowedDate());
        }
        if (borrowingDTO.getDueDate() != null) {
            existingBorrowing.setDueDate(borrowingDTO.getDueDate());
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
