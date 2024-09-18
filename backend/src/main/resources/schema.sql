-- Create Users table for authentication
CREATE TABLE users
(
    user_id       SERIAL PRIMARY KEY,
    username      VARCHAR(50) UNIQUE  NOT NULL,
    email         VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255)        NOT NULL,
    is_admin      BOOLEAN DEFAULT FALSE
);

-- Create Authors table
CREATE TABLE authors
(
    author_id   SERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    nationality VARCHAR(50)
);

-- Create Books table with status field
CREATE TABLE books
(
    book_id          SERIAL PRIMARY KEY,
    title            VARCHAR(200) NOT NULL,
    isbn             VARCHAR(13) UNIQUE,
    publication_year INTEGER,
    author_id        INTEGER REFERENCES authors (author_id),
    status           VARCHAR(20) DEFAULT 'AVAILABLE' CHECK (status IN ('AVAILABLE', 'BORROWED'))
);

-- Modify Borrowers table to include status
CREATE TABLE borrowers
(
    borrower_id SERIAL PRIMARY KEY,
    user_id     INTEGER UNIQUE REFERENCES users (user_id),
    phone       VARCHAR(20),
    address     TEXT,
    status      VARCHAR(20) DEFAULT 'ACTIVE' CHECK (status IN ('ACTIVE', 'SUSPENDED'))
);

-- Create Borrowings table (not in the provided schema, but necessary for the system)
CREATE TABLE borrowings
(
    borrowing_id SERIAL PRIMARY KEY,
    book_id      INTEGER REFERENCES books (book_id),
    borrower_id  INTEGER REFERENCES borrowers (borrower_id),
    borrow_date  DATE        DEFAULT CURRENT_DATE,
    due_date     DATE NOT NULL,
    return_date  DATE,
    status       VARCHAR(20) DEFAULT 'BORROWED' CHECK (status IN ('BORROWED', 'RETURNED', 'OVERDUE'))
);

-- Add indexes for frequently queried columns
CREATE INDEX idx_books_title ON books (title);
CREATE INDEX idx_books_status ON books (status);
CREATE INDEX idx_users_username ON users (username);
CREATE INDEX idx_users_email ON users (email);
CREATE INDEX idx_borrowers_status ON borrowers (status);
CREATE INDEX idx_borrowings_due_date ON borrowings (due_date);
CREATE INDEX idx_borrowings_status ON borrowings (status);