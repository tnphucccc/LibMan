package com.example.backend.service.borrowers;

import com.example.backend.dto.BorrowerDTO;

import java.util.List;

public interface IBorrowerService {
    List<BorrowerDTO> getAllBorrowers();

    BorrowerDTO getBorrowerById(Long borrowerID);

    BorrowerDTO createBorrower(BorrowerDTO borrowerDTO);

    BorrowerDTO updateBorrower(Long borrowerID, BorrowerDTO borrowerDTO);

    void deleteBorrower(Long borrowerDTO);
}