CREATE TABLE author
(
    id   INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE book
(
    id           INTEGER NOT NULL PRIMARY KEY,
    author_id    INTEGER,
    title        VARCHAR(400),
    published_in INTEGER,
    language_id  INTEGER,
    CONSTRAINT fk_book_author FOREIGN KEY (author_id) REFERENCES author (id)
);