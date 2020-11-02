DROP DATABASE IF EXISTS spring_mvc_security_db;

CREATE DATABASE spring_mvc_security_db;

CREATE TABLE user (
	id INT PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(50),
	password VARCHAR(250)
);