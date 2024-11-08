package com.example.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    private Long authorId;

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must be less than 255 characters")
    private String name;

    @Size(max = 50, message = "Nationality must be less than 50 characters")
    private String nationality;

    private Set<BookDTO.BookSummaryDTO> books;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthorSummaryDTO {
        private Long id;
        private String name;
        private String nationality;
    }
}
