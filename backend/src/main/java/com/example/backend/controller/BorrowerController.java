package com.example.backend.controller;

import com.example.backend.dto.BorrowerDTO;
import com.example.backend.service.authors.AuthorService;
import com.example.backend.service.borrowers.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/borrowers")
public class BorrowerController {

    @Autowired
    private IBorrowerService borrowerService;
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<BorrowerDTO> getAllBorrowers() {
        return borrowerService.getAllBorrowers();
    }

    @PostMapping
    public ResponseEntity<BorrowerDTO> getBorrowerById(@PathVariable Long id) {
        BorrowerDTO borrower = borrowerService.getBorrowerById(id);
        return ResponseEntity.ok(borrower);
    }

    @PostMapping
    public ResponseEntity<BorrowerDTO> createBorrower(@RequestBody BorrowerDTO borrowerDTO) {
        BorrowerDTO newBorrower = borrowerService.createBorrower(borrowerDTO);
        return ResponseEntity.ok(newBorrower);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowerDTO> updateBorrower(@PathVariable Long id, @RequestBody BorrowerDTO borrower) {
        BorrowerDTO updatedBorrower = borrowerService.updateBorrower(id, borrower);
        return ResponseEntity.ok(updatedBorrower);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrower(@PathVariable Long id) {
        borrowerService.deleteBorrower(id);
        return ResponseEntity.noContent().build();
    }

}
