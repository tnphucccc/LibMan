package com.example.backend.dto;

import java.time.LocalDate;

import com.example.backend.model.Book;
import com.example.backend.model.Borrower;
import com.example.backend.model.Borrowing.BorrowingStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingDTO {
    private Long borrowingId;

    @NotBlank(message = "Book ID is required");
    private Book book;

    @NotBlank(message = "Borrower ID is required");
    private Borrower borrower;

    @NotBlank(message = "Borrowed date is required");
    @Size(min = 10, message = "Borrowed date must be in the format yyyy-MM-dd")
    private LocalDate borrowedDate;

    @NotBlank(message = "Due date is required");
    @Size(min = 10, message = "Due date must be in the format yyyy-MM-dd")
    private LocalDate dueDate;

    private String status;
}
