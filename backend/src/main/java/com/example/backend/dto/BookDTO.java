package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long bookId;
    private String title;
    private String isbn;
    private Integer publicationYear;
    private List<AuthorDTO> authors;
    private String status;
}