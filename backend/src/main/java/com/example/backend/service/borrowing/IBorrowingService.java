package com.example.backend.service.borrowing;

import com.example.backend.dto.BorrowingDTO;

import java.util.List;

public interface IBorrowingService {
    List<BorrowingDTO> getAllBorrowings();

    BorrowingDTO getBorrowingById(Long borrowingId);

    BorrowingDTO createBorrowing(BorrowingDTO borrowingDTO);

    BorrowingDTO updateBorrowing(Long borrowingId, BorrowingDTO borrowingDTO);

    void deleteBorrowing(Long borrowingId);
}
