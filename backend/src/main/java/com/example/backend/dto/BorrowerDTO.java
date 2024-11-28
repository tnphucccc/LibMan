package com.example.backend.dto;

import com.example.backend.model.Borrower;
import com.example.backend.model.Borrowing;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowerDTO {
    private Long borrowerId;

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must be less than 255 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Size(max = 50, message = "Phone number must be less than 50 characters")
    private String phone;

    @Size(max = 255, message = "Address must be less than 255 characters")
    private String address;

    @NotBlank(message = "Status is required")
    private String status;

    private Set<BorrowingDTO> borrowings;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BorrowerSummaryDTO {
        private Long id;
        private String name;
        private String email;
        private String status;
    }
}
