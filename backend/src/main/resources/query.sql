INSERT INTO authors (name, nationality, portrait_url)
VALUES ('George Orwell', 'British', 'https://example.com/portraits/george_orwell.jpg'),
       ('Jane Austen', 'British', 'https://example.com/portraits/jane_austen.jpg'),
       ('Mark Twain', 'American', 'https://example.com/portraits/mark_twain.jpg'),
       ('J.K. Rowling', 'British', 'https://example.com/portraits/jk_rowling.jpg'),
       ('Gabriel García Márquez', 'Colombian', 'https://example.com/portraits/gabriel_marquez.jpg');

INSERT INTO books (title, isbn, publication_year, status, cover_image_url)
VALUES ('1984', '9780451524935', 1949, 'AVAILABLE', 'https://example.com/covers/1984.jpg'),
       ('Pride and Prejudice', '9780141199078', 1813, 'AVAILABLE', 'https://example.com/covers/pride_prejudice.jpg'),
       ('Adventures of Huckleberry Finn', '9780486280615', 1884, 'BORROWED',
        'https://example.com/covers/huckleberry_finn.jpg'),
       ('Harry Potter and the Sorcerer''s Stone', '9780590353427', 1997, 'AVAILABLE',
        'https://example.com/covers/harry_potter_1.jpg'),
       ('One Hundred Years of Solitude', '9780060883287', 1967, 'AVAILABLE', 'https://example.com/covers/solitude.jpg');

INSERT INTO book_authors (book_id, author_id)
VALUES (1, 1), -- '1984' by George Orwell
       (2, 2), -- 'Pride and Prejudice' by Jane Austen
       (3, 3), -- 'Adventures of Huckleberry Finn' by Mark Twain
       (4, 4), -- 'Harry Potter and the Sorcerer\'s Stone' by J.K. Rowling
       (5, 5); -- 'One Hundred Years of Solitude' by Gabriel García Márquez

INSERT INTO borrowers (name, email, phone, address, status)
VALUES ('John Doe', 'johndoe@example.com', '555-1234', '123 Elm Street, Springfield', 'ACTIVE'),
       ('Jane Smith', 'janesmith@example.com', '555-5678', '456 Oak Avenue, Shelbyville', 'ACTIVE'),
       ('Alice Johnson', 'alicej@example.com', '555-8765', '789 Pine Road, Capital City', 'SUSPENDED'),
       ('Bob Brown', 'bobbrown@example.com', '555-4321', '101 Maple Drive, Ogdenville', 'ACTIVE');

INSERT INTO borrowings (book_id, borrower_id, borrowed_date, due_date, returned_date, status)
VALUES (3, 1, '2024-11-01', '2024-11-15', NULL, 'BORROWED'), -- John Doe borrowed 'Adventures of Huckleberry Finn'
       (2, 2, '2024-10-20', '2024-11-05', '2024-11-03',
        'RETURNED'),                                         -- Jane Smith borrowed and returned 'Pride and Prejudice'
       (5, 4, '2024-10-10', '2024-10-25', NULL, 'OVERDUE'); -- Bob Brown borrowed 'One Hundred Years of Solitude'
