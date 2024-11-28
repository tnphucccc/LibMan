package com.example.backend.dto;

import com.example.backend.model.Book;
import com.example.backend.model.Borrower;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingDTO {
    private Long borrowingId;

    private Book book;

    private Borrower borrower;

    @Size(min = 10, message = "Borrowed date must be in the format yyyy-MM-dd")
    private LocalDate borrowedDate;

    @Size(min = 10, message = "Due date must be in the format yyyy-MM-dd")
    private LocalDate dueDate;

    private LocalDate createdAt;
    private LocalDate updatedAt;

    private String status;
}
