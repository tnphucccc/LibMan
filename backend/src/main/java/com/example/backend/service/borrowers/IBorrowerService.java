package com.example.backend.service.borrowers;

import com.example.backend.dto.BorrowerDTO;
import com.example.backend.model.Borrower;

import java.util.List;

public interface IBorrowerService {
    List<BorrowerDTO> getAllBorrowers();

    BorrowerDTO getBorrowerById(Long borrowerId);

    BorrowerDTO createBorrower(BorrowerDTO borrowerDTO);

    BorrowerDTO updateBorrower(Long borrowerId, BorrowerDTO borrowerDTO);

    void deleteBorrower(Long borrowerId);
}
