package com.example.backend.service.borrowers;

import com.example.backend.dto.BorrowerDTO;
import com.example.backend.mapper.LibraryMapper;
import com.example.backend.model.Borrower;
import com.example.backend.service.books.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerService implements IBorrowerService {
    private static final Logger logger = LoggerFactory.getLogger(BorrowerService.class);

    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public List<Borrower> getAllBorrowers() {
        return List.of();
    }

    @Override
    public BorrowerDTO getBorrowerById(Long borrowerID) {
        return null;
    }

    @Override
    public BorrowerDTO createBorrower(BorrowerDTO borrowerDTO) {
        return null;
    }

    @Override
    public BorrowerDTO updateBorrower(Long borrowerID, BorrowerDTO borrowerDTO) {
        return null;
    }

    @Override
    public void deleteBorrower(Long borrowerDTO) {

    }
}