package com.example.backend.service.borrowers;

import com.example.backend.dto.BorrowerDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.mapper.LibraryMapper;
import com.example.backend.model.Borrower;
import com.example.backend.repository.BorrowerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowerService implements IBorrowerService {
    private static final Logger logger = LoggerFactory.getLogger(BorrowerService.class);

    @Autowired
    private LibraryMapper libraryMapper;

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Override
    public List<BorrowerDTO> getAllBorrowers() {
        logger.info("Fetching all borrowers");
        return borrowerRepository.findAll().stream()
                .map(libraryMapper::toBorrowerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BorrowerDTO getBorrowerById(Long borrowerId) {
        logger.info("Fetching borrower with id {}", borrowerId);
        Borrower borrower = borrowerRepository.findById(borrowerId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrower not found" + borrowerId));
        return libraryMapper.toBorrowerDTO(borrower);
    }

    @Override
    public BorrowerDTO createBorrower(BorrowerDTO borrowerDTO) {
        logger.info("Creating borrower {}", borrowerDTO);
        Borrower borrower = libraryMapper.toBorrowerEntity(borrowerDTO);
        Borrower newBorrower = borrowerRepository.save(borrower);
        logger.info("Borrower created {}", newBorrower.getBorrowerId());
        return libraryMapper.toBorrowerDTO(newBorrower);
    }

    @Override
    public BorrowerDTO updateBorrower(Long borrowerId, BorrowerDTO borrowerDTO) {
        logger.info("Updating borrower {}", borrowerId);
        Borrower existingBorrower = borrowerRepository.findById(borrowerId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrower not found with id: " + borrowerId));

        if (borrowerDTO.getName() != null) {
            existingBorrower.setName(borrowerDTO.getName());
        }

        if (borrowerDTO.getAddress() != null) {
            existingBorrower.setAddress(borrowerDTO.getAddress());
        }

        if (borrowerDTO.getPhone() != null) {
            existingBorrower.setPhone(borrowerDTO.getPhone());
        }

        if (borrowerDTO.getEmail() != null) {
            existingBorrower.setEmail(borrowerDTO.getEmail());
        }

        Borrower updateBorrower = borrowerRepository.save(existingBorrower);
        logger.info("Borrower updated {}", updateBorrower.getBorrowerId());
        return libraryMapper.toBorrowerDTO(updateBorrower);
    }

    public void deleteBorrower(Long borrowerId) {
        logger.info("Deleting borrower {}", borrowerId);
        Borrower borrower = borrowerRepository.findById(borrowerId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrower not found with id: " + borrowerId));
        borrowerRepository.delete(borrower);
        logger.info("Borrower deleted {}", getBorrowerById(borrowerId));
    }
}
