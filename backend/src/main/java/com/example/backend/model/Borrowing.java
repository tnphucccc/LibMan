package com.example.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "borrowings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowing_id")
    private Long borrowingId;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "borrower_id", nullable = false)
    private Borrower borrower;

    @Column(name = "borrowed_date", nullable = false)
    private LocalDate borrowedDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "returned_date")
    private LocalDate returnedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BorrowingStatus status = BorrowingStatus.BORROWED;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt;

    public enum BorrowingStatus {
        BORROWED,
        RETURNED,
        OVERDUE
    }

    @Override
    public int hashCode() {
        return Objects.hash(borrowingId);
    }
}
