package com.example.backend.repository;

import com.example.backend.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
    Optional<Borrower> findByName(String name);
    List<Borrower> findBorrowerById(@Param("borrowerId") Long borrowerId);
}
