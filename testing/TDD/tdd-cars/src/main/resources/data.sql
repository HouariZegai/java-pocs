USE test_db;

DROP TABLE IF EXISTS CAR;

CREATE TABLE CAR (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL
);

INSERT INTO CAR (name, type) VALUES
    ('duster', 'hybrid'),
    ('mercedes', 'automatic');