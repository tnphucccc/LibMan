package com.example.backend.service.borrowers;

import com.example.backend.dto.BorrowerDTO;

import java.util.List;

public interface IBorrowerService {
    List<BorrowerDTO.BorrowerSummaryDTO> getAllBorrowers();

    BorrowerDTO getBorrowerById(Long borrowerID);

    BorrowerDTO createBorrower(BorrowerDTO.BorrowerSummaryDTO borrowerDTO);

    BorrowerDTO updateBorrower(Long borrowerID, BorrowerDTO borrowerDTO);

    void deleteBorrower(Long borrowerDTO);
}