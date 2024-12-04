package com.example.backend.service.borrowers;

import com.example.backend.dto.BorrowerDTO;
import com.example.backend.dto.BorrowingDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.mapper.LibraryMapper;
import com.example.backend.model.Borrower;
import com.example.backend.model.Borrowing;
import com.example.backend.repository.BorrowerRepository;
import com.example.backend.repository.BorrowingRepository;
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
public class BorrowerService implements IBorrowerService {
    private static final Logger logger = LoggerFactory.getLogger(BorrowerService.class);

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public List<BorrowerDTO> getAllBorrowers() {
        logger.info("Fetching all borrowers from the database");
        return borrowerRepository.findAll().stream()
                .map(borrower -> {
                    BorrowerDTO borrowerDTO = libraryMapper.toBorrowerDTO(borrower);
                    List<Borrowing> borrowings = borrowerRepository.findBorrowingByBorrowerId(borrower.getBorrowerId());
                    borrowerDTO.setBorrowings(borrowings.stream()
                            .map(libraryMapper::toBorrowingDTO)
                            .collect(Collectors.toSet()));
                    return borrowerDTO;
                }).
                collect(Collectors.toList());
    }

    @Override
    public BorrowerDTO getBorrowerById(Long borrowerID) {
        logger.info("Fetching borrower with id: {}", borrowerID);
        Borrower borrower = borrowerRepository.findById(borrowerID)
                .orElseThrow(() -> new ResourceNotFoundException("Borrower not found with id: " + borrowerID));
        BorrowerDTO borrowerDTO = libraryMapper.toBorrowerDTO(borrower);
        List<Borrowing> borrowings = borrowerRepository.findBorrowingByBorrowerId(borrower.getBorrowerId());
        borrowerDTO.setBorrowings(borrowings.stream()
                .map(libraryMapper::toBorrowingDTO)
                .collect(Collectors.toSet()));
        return borrowerDTO;
    }

    @Override
    public BorrowerDTO createBorrower(BorrowerDTO borrowerDTO) {
        logger.info("Creating a new borrower");
        Borrower borrower = new Borrower();
        borrower.setPhone(borrowerDTO.getPhone());
        borrower.setName(borrowerDTO.getName());
        borrower.setCreatedAt(borrowerDTO.getCreatedAt());
        borrower.setUpdatedAt(borrowerDTO.getUpdatedAt());
        borrower.setAddress(borrowerDTO.getAddress());
        borrower.setEmail(borrowerDTO.getEmail());
        borrower.setStatus(Borrower.BorrowerStatus.valueOf(borrowerDTO.getStatus()));

        Set<Borrowing> borrowings = getPersistedBorrowings(borrowerDTO.getBorrowings());
        borrower.setBorrowings(borrowings);

        Borrower savedBorrower = borrowerRepository.save(borrower);
        logger.info("Borrower created successfully with id: {}", savedBorrower.getBorrowerId());
        return libraryMapper.toBorrowerDTO(savedBorrower);
    }

    private Set<Borrowing> getPersistedBorrowings(Set<BorrowingDTO> borrowingDTOs) {
        Set<Borrowing> persistedBorrowings = new HashSet<>();

        for (BorrowingDTO borrowingDTO : borrowingDTOs) {
            Optional<Borrowing> existingBorrowing = borrowingRepository.findById(borrowingDTO.getBorrowingId());

            if (existingBorrowing.isPresent()) {
                persistedBorrowings.add(existingBorrowing.get());
            } else {
                Borrowing newBorrowing = new Borrowing();
                newBorrowing.getBook().setBookId(borrowingDTO.getBookId());
                newBorrowing.setStatus(Borrowing.BorrowingStatus.valueOf(borrowingDTO.getStatus()));
                newBorrowing.setBorrowedDate(borrowingDTO.getBorrowedDate());
                newBorrowing.setDueDate(borrowingDTO.getDueDate());
                newBorrowing.setUpdatedAt(borrowingDTO.getUpdatedAt());
                newBorrowing.setCreatedAt(borrowingDTO.getCreatedAt());
                persistedBorrowings.add(borrowingRepository.save(newBorrowing));
            }
        }
        return persistedBorrowings;
    }


    @Override
    public BorrowerDTO updateBorrower(Long borrowerID, BorrowerDTO borrowerDTO) {
        logger.info("Updating borrower with id: {}", borrowerID);
        Borrower existingBorrower = borrowerRepository.findById(borrowerID)
                .orElseThrow(() -> new ResourceNotFoundException("Borrower not found with id: " + borrowerID));

        if (borrowerDTO.getName() != null) {
            existingBorrower.setName(borrowerDTO.getName());
        }

        if (borrowerDTO.getPhone() != null) {
            existingBorrower.setPhone(borrowerDTO.getPhone());
        }

        if (borrowerDTO.getAddress() != null) {
            existingBorrower.setAddress(borrowerDTO.getAddress());
        }

        if (borrowerDTO.getEmail() != null) {
            existingBorrower.setEmail(borrowerDTO.getEmail());
        }

        if (borrowerDTO.getStatus() != null) {
            existingBorrower.setStatus(Borrower.BorrowerStatus.valueOf(borrowerDTO.getStatus()));
        }

        if (borrowerDTO.getBorrowings() != null && !borrowerDTO.getBorrowings().isEmpty()) {
            Set<Borrowing> borrowings = getPersistedBorrowings(borrowerDTO.getBorrowings());
            existingBorrower.setBorrowings(borrowings);
        }

        if (borrowerDTO.getCreatedAt() != null) {
            existingBorrower.setCreatedAt(borrowerDTO.getCreatedAt());
        }
        if (borrowerDTO.getUpdatedAt() != null) {
            existingBorrower.setUpdatedAt(borrowerDTO.getUpdatedAt());
        }

        Borrower updatedBorrower = borrowerRepository.save(existingBorrower);
        logger.info("Borrower updated successfully with id: {}", updatedBorrower.getBorrowerId());
        return libraryMapper.toBorrowerDTO(updatedBorrower);
    }

    @Override
    public void deleteBorrower(Long borrowerID) {
        logger.info("Deleting borrower with id: {}", borrowerID);
        Borrower borrower = borrowerRepository.findById(borrowerID)
                .orElseThrow(() -> new ResourceNotFoundException("Borrower not found with id: " + borrowerID));
        borrowerRepository.delete(borrower);
        logger.info("Borrower deleted successfully with id: {}", borrowerID);
    }
}