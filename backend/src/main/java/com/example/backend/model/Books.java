package com.example.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BookStatus status = BookStatus.AVAILABLE;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public enum BookStatus {
        AVAILABLE,
        BORROWED,
        LOST
    }
}
