-- Create Authors table
CREATE TABLE authors
(
    author_id    INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    name         VARCHAR(100) NOT NULL,
    nationality  VARCHAR(50),
    portrait_url VARCHAR(255),
    created_at   TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Create Books table
CREATE TABLE books
(
    book_id          INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    title            VARCHAR(200) NOT NULL,
    isbn             VARCHAR(13) UNIQUE,
    publication_year INTEGER,
    status           VARCHAR(20)              DEFAULT 'AVAILABLE' CHECK (status IN ('AVAILABLE', 'BORROWED')),
    cover_image_url  VARCHAR(255),
    created_at       TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Create the book_authors join table
CREATE TABLE book_authors
(
    book_id   INT NOT NULL,
    author_id INT NOT NULL,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books (book_id) ON DELETE CASCADE,
    FOREIGN KEY (author_id) REFERENCES authors (author_id) ON DELETE CASCADE
);

-- Create Borrowers table
CREATE TABLE borrowers
(
    borrower_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
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
    borrowing_id  INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    book_id       INTEGER REFERENCES books (book_id),
    borrower_id   INTEGER REFERENCES borrowers (borrower_id),
    borrowed_date DATE                     DEFAULT CURRENT_DATE,
    due_date      DATE NOT NULL,
    returned_date DATE,
    status        VARCHAR(20)              DEFAULT 'BORROWED' CHECK (status IN ('BORROWED', 'RETURNED', 'OVERDUE')),
    created_at    TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Create indexes for improved query performance
CREATE INDEX idx_books_author_id ON book_authors (author_id);
CREATE INDEX idx_borrowings_book_id ON borrowings (book_id);
CREATE INDEX idx_borrowings_borrower_id ON borrowings (borrower_id);