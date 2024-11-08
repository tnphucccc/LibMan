package com.example.backend.dto;

import com.example.backend.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long bookId;

    @NotBlank(message = "Title is required")
    @Size(max = 255, message = "Title must be less than 255 characters")
    private String title;

    @NotBlank(message = "ISBN is required")
    @Size(min = 10, max = 13, message = "ISBN must be between 10 and 13 characters")
    private String isbn;

    @NotNull(message = "Publication year is required")
    @Min(value = 1000, message = "Publication year must be at least 1000")
    private Integer publicationYear;

    private Set<AuthorDTO.AuthorSummaryDTO> authors;
    private String status;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BookSummaryDTO {
        private Long id;
        private String title;
        private String isbn;
        private Book.BookStatus status;
    }
}