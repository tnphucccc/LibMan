INSERT INTO authors (name, nationality, portrait_url)
VALUES ('George Orwell', 'British', 'https://example.com/portraits/george_orwell.jpg'),
       ('Jane Austen', 'British', 'https://example.com/portraits/jane_austen.jpg'),
       ('Mark Twain', 'American', 'https://example.com/portraits/mark_twain.jpg'),
       ('J.K. Rowling', 'British', 'https://example.com/portraits/jk_rowling.jpg'),
       ('Gabriel García Márquez', 'Colombian', 'https://example.com/portraits/gabriel_marquez.jpg'),
       ('F. Scott Fitzgerald', 'American', 'https://example.com/authors/fitzgerald.jpg'),
       ('Harper Lee', 'American', 'https://example.com/authors/lee.jpg'),
       ('J.D. Salinger', 'American', 'https://example.com/authors/salinger.jpg'),
       ('J.R.R. Tolkien', 'British', 'https://example.com/authors/tolkien.jpg'),
       ('Herman Melville', 'American', 'https://example.com/authors/melville.jpg'),
       ('Leo Tolstoy', 'Russian', 'https://example.com/authors/tolstoy.jpg'),
       ('Fyodor Dostoevsky', 'Russian', 'https://example.com/authors/dostoevsky.jpg'),
       ('Homer', 'Greek', 'https://example.com/authors/homer.jpg'),
       ('Charlotte Brontë', 'British', 'https://example.com/authors/bronte.jpg'),
       ('Aldous Huxley', 'British', 'https://example.com/authors/huxley.jpg'),
       ('Ray Bradbury', 'American', 'https://example.com/authors/bradbury.jpg'),
       ('Emily Brontë', 'British', 'https://example.com/authors/emily_bronte.jpg'),
       ('Oscar Wilde', 'Irish', 'https://example.com/authors/wilde.jpg'),
       ('Louisa May Alcott', 'American', 'https://example.com/authors/alcott.jpg'),
       ('Bram Stoker', 'Irish', 'https://example.com/authors/stoker.jpg'),
       ('Mary Shelley', 'British', 'https://example.com/authors/shelley.jpg'),
       ('Paulo Coelho', 'Brazilian', 'https://example.com/authors/coelho.jpg'),
       ('Dante Alighieri', 'Italian', 'https://example.com/authors/dante.jpg'),
       ('Victor Hugo', 'French', 'https://example.com/authors/hugo.jpg'),
       ('Miguel de Cervantes', 'Spanish', 'https://example.com/authors/cervantes.jpg'),
       ('Charles Dickens', 'British', 'https://example.com/authors/dickens.jpg'),
       ('Alexandre Dumas', 'French', 'https://example.com/authors/dumas.jpg');

INSERT INTO books (title, isbn, publication_year, status, cover_image_url)
VALUES ('1984', '9780451524935', 1949, 'AVAILABLE', 'https://i.ebayimg.com/images/g/u6wAAOSwwX1hN7xf/s-l1200.jpg'),
       ('Pride and Prejudice', '9780141199078', 1813, 'AVAILABLE', 'https://s3-ap-southeast-2.amazonaws.com/assets.allenandunwin.com/images/small/9780571337019.jpg'),
       ('Adventures of Huckleberry Finn', '9780486280615', 1884, 'BORROWED',
        'https://m.media-amazon.com/images/I/91Suc5Kql8L._AC_UF1000,1000_QL80_.jpg'),
       ('Harry Potter and the Sorcerer''s Stone', '9780590353427', 1997, 'AVAILABLE',
        'https://m.media-amazon.com/images/I/81q77Q39nEL._AC_UF1000,1000_QL80_.jpg'),
       ('One Hundred Years of Solitude', '9780060883287', 1967, 'AVAILABLE', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3r_kq5KFnYkYY-ggqayM1sjmZFQ3gWvuJLw&s'),
       ('The Great Gatsby', '9780743273565', 1925, 'AVAILABLE', 'https://m.media-amazon.com/images/I/81QuEGw8VPL._AC_UF1000,1000_QL80_.jpg'),
       ('To Kill a Mockingbird', '9780061120084', 1960, 'BORROWED',
        'https://m.media-amazon.com/images/I/81aY1lxk+9L._AC_UF1000,1000_QL80_.jpg'),
       ('The Catcher in the Rye', '9780316769488', 1951, 'AVAILABLE',
        'https://m.media-amazon.com/images/I/8125BDk3l9L.jpg'),
       ('The Lord of the Rings', '9780544003415', 1954, 'AVAILABLE',
        'https://m.media-amazon.com/images/I/7125+5E40JL._AC_UF1000,1000_QL80_.jpg'),
       ('Moby Dick', '9781503280786', 1851, 'AVAILABLE', 'https://m.media-amazon.com/images/I/51aV053NRjL._AC_UF1000,1000_QL80_.jpg'),
       ('War and Peace', '9780199232765', 1869, 'AVAILABLE', 'https://m.media-amazon.com/images/I/71lPZpwz0HL._AC_UF1000,1000_QL80_.jpg'),
       ('Crime and Punishment', '9780679734505', 1866, 'BORROWED',
        'https://m.media-amazon.com/images/I/71O2XIytdqL._AC_UF1000,1000_QL80_.jpg'),
       ('The Odyssey', '9780140268867', -700, 'AVAILABLE', 'https://m.media-amazon.com/images/I/81g0AATkO9L._AC_UF1000,1000_QL80_.jpg'),
       ('Jane Eyre', '9780141441146', 1847, 'BORROWED', 'https://m.media-amazon.com/images/I/61N-UOA0alL._UF1000,1000_QL80_.jpg'),
       ('Brave New World', '9780060850524', 1932, 'AVAILABLE', 'https://m.media-amazon.com/images/I/71GNqqXuN3L._AC_UF1000,1000_QL80_.jpg'),
       ('Fahrenheit 451', '9781451673319', 1953, 'BORROWED', 'https://m.media-amazon.com/images/I/61l8LHt4MeL._AC_UF1000,1000_QL80_.jpg'),
       ('Wuthering Heights', '9780141439556', 1847, 'AVAILABLE', 'https://m.media-amazon.com/images/I/81unikMK30L._AC_UF1000,1000_QL80_.jpg'),
       ('The Picture of Dorian Gray', '9780141439570', 1890, 'AVAILABLE', 'https://m.media-amazon.com/images/I/91uns-1GnQL._AC_UF1000,1000_QL80_.jpg'),
       ('The Hobbit', '9780547928227', 1937, 'AVAILABLE', 'https://m.media-amazon.com/images/I/712cDO7d73L.jpg'),
       ('Animal Farm', '9780451526342', 1945, 'AVAILABLE', 'https://m.media-amazon.com/images/I/91Lbhwt5RzL._AC_UF1000,1000_QL80_.jpg'),
       ('Little Women', '9780142408766', 1868, 'AVAILABLE', 'https://m.media-amazon.com/images/I/91j2nOoYm0L.jpg'),
       ('Dracula', '9780141439846', 1897, 'BORROWED', 'https://m.media-amazon.com/images/I/91wOUFZCE+L._UF1000,1000_QL80_.jpg'),
       ('Frankenstein', '9780486282114', 1818, 'AVAILABLE', 'https://m.media-amazon.com/images/I/81AuVq270jL._UF1000,1000_QL80_.jpg'),
       ('The Alchemist', '9780061122415', 1988, 'AVAILABLE', 'https://m.media-amazon.com/images/I/61HAE8zahLL._AC_UF1000,1000_QL80_.jpg'),
       ('The Divine Comedy', '9780140448955', 1320, 'AVAILABLE', 'https://m.media-amazon.com/images/I/51i-9SGWr-L._AC_UF1000,1000_QL80_.jpg'),
       ('Les Misérables', '9780451419439', 1862, 'AVAILABLE', 'https://m.media-amazon.com/images/I/91p594CxSpL.jpg'),
       ('Don Quixote', '9780060934347', 1605, 'AVAILABLE', 'https://m.media-amazon.com/images/I/61yifvabpVL._AC_UF1000,1000_QL80_.jpg'),
       ('A Tale of Two Cities', '9780486406516', 1859, 'BORROWED', 'https://m.media-amazon.com/images/I/91ptoYiDzeL.jpg'),
       ('The Brothers Karamazov', '9780374528379', 1880, 'AVAILABLE',
        'https://m.media-amazon.com/images/I/81TnYwmy65L._AC_UF1000,1000_QL80_.jpg'),
       ('The Count of Monte Cristo', '9780140449267', 1844, 'BORROWED',
        'https://m.media-amazon.com/images/I/71zcCb5PvuL._UF1000,1000_QL80_.jpg');

INSERT INTO book_authors (book_id, author_id)
VALUES (1, 1),   -- '1984' by George Orwell
       (2, 2),   -- 'Pride and Prejudice' by Jane Austen
       (3, 3),   -- 'Adventures of Huckleberry Finn' by Mark Twain
       (4, 4),   -- 'Harry Potter and the Sorcerer\'s Stone' by J.K. Rowling
       (5, 5),   -- 'One Hundred Years of Solitude' by Gabriel García Márquez
       (6, 6),   -- The Great Gatsby - F. Scott Fitzgerald
       (7, 7),   -- To Kill a Mockingbird - Harper Lee
       (8, 8),   -- The Catcher in the Rye - J.D. Salinger
       (9, 9),   -- The Lord of the Rings - J.R.R. Tolkien
       (10, 10), -- Moby Dick - Herman Melville
       (11, 11), -- War and Peace - Leo Tolstoy
       (12, 12), -- Crime and Punishment - Fyodor Dostoevsky
       (13, 13), -- The Odyssey - Homer
       (14, 14), -- Jane Eyre - Charlotte Brontë
       (15, 15), -- Brave New World - Aldous Huxley
       (16, 16), -- Fahrenheit 451 - Ray Bradbury
       (17, 17), -- Wuthering Heights - Emily Brontë
       (18, 18), -- The Picture of Dorian Gray - Oscar Wilde
       (19, 9),  -- The Hobbit - J.R.R. Tolkien
       (20, 1), -- Animal Farm - George Orwell
       (21, 19), -- Little Women - Louisa May Alcott
       (22, 20), -- Dracula - Bram Stoker
       (23, 21), -- Frankenstein - Mary Shelley
       (24, 22), -- The Alchemist - Paulo Coelho
       (25, 23), -- The Divine Comedy - Dante Alighieri
       (26, 24), -- Les Misérables - Victor Hugo
       (27, 25), -- Don Quixote - Miguel de Cervantes
       (28, 26), -- A Tale of Two Cities - Charles Dickens
       (29, 12), -- The Brothers Karamazov - Fyodor Dostoevsky
       (30, 27); -- The Count of Monte Cristo - Alexandre Dumas

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
