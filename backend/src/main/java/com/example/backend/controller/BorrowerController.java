package com.example.backend.controller;

import com.example.backend.dto.BorrowerDTO;
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

    @GetMapping({"", "/"})
    public List<BorrowerDTO.BorrowerSummaryDTO> getAllBorrowers() {
        return borrowerService.getAllBorrowers();
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<BorrowerDTO> getBorrowerById(@PathVariable Long id) {
        BorrowerDTO borrower = borrowerService.getBorrowerById(id);
        return ResponseEntity.ok(borrower);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<BorrowerDTO> createBorrower(@RequestBody BorrowerDTO.BorrowerSummaryDTO borrowerDTO) {
        BorrowerDTO newBorrower = borrowerService.createBorrower(borrowerDTO);
        return ResponseEntity.ok(newBorrower);
    }

    @PatchMapping({"/{id}", "/{id}/"})
    public ResponseEntity<BorrowerDTO> updateAuthor(@PathVariable Long id, @RequestBody BorrowerDTO borrowerDTO) {
        BorrowerDTO updatedBorrower = borrowerService.updateBorrower(id, borrowerDTO);
        return ResponseEntity.ok(updatedBorrower);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        borrowerService.deleteBorrower(id);
        return ResponseEntity.noContent().build();
    }
}