package com.example.backend.repository;

import com.example.backend.model.Borrower;
import com.example.backend.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
}
