package com.example.backend.dto;

import com.example.backend.model.Book;
import com.example.backend.model.Borrower;
import com.example.backend.model.Borrowing;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowerDTO {
    private Long borrowerId;

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Title must be less than 255 characters")
    private String name;
    private String email;
    private String phone;
    private String address;
    private Borrower.BorrowerStatus status;
    private Set<Borrowing> borrowings;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BorrowerSummaryDTO {
        private Long borrowerId;
        private String name;
        private String email;
        private String phone;
        private String address;
        private Borrower.BorrowerStatus status;
        private Set<Borrowing> borrowings;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
