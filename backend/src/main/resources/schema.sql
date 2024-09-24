-- Create Authors table
CREATE TABLE authors
(
    author_id   SERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    nationality VARCHAR(50),
    created_at  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Create Books table
CREATE TABLE books
(
    book_id          SERIAL PRIMARY KEY,
    title            VARCHAR(200) NOT NULL,
    isbn             VARCHAR(13) UNIQUE,
    publication_year INTEGER,
    author_id        INTEGER REFERENCES authors (author_id),
    status           VARCHAR(20)              DEFAULT 'AVAILABLE' CHECK (status IN ('AVAILABLE', 'BORROWED')),
    created_at       TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Create Borrowers table
CREATE TABLE borrowers
(
    borrower_id SERIAL PRIMARY KEY,
    name        VARCHAR(100)        NOT NULL,
    email       VARCHAR(100) UNIQUE NOT NULL,
    phone       VARCHAR(20),
    address     TEXT,
    status      VARCHAR(20)              DEFAULT 'ACTIVE' CHECK (status IN ('ACTIVE', 'SUSPENDED')),
    created_at  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Create Borrowings table
CREATE TABLE borrowings
(
    borrowing_id SERIAL PRIMARY KEY,
    book_id      INTEGER REFERENCES books (book_id),
    borrower_id  INTEGER REFERENCES borrowers (borrower_id),
    borrow_date  DATE                     DEFAULT CURRENT_DATE,
    due_date     DATE NOT NULL,
    return_date  DATE,
    status       VARCHAR(20)              DEFAULT 'BORROWED' CHECK (status IN ('BORROWED', 'RETURNED', 'OVERDUE')),
    created_at   TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Create indexes for improved query performance
CREATE INDEX idx_books_author_id ON books (author_id);
CREATE INDEX idx_borrowings_book_id ON borrowings (book_id);
CREATE INDEX idx_borrowings_borrower_id ON borrowings (borrower_id);