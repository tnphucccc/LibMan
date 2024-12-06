package com.example.backend.repository;

import com.example.backend.model.Borrower;
import com.example.backend.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
    @Query("SELECT br FROM Borrowing br WHERE br.borrower.borrowerId = :borrowerId")
    List<Borrowing> findBorrowingByBorrowerId(@Param("borrowerId") Long borrowerId);
}