-- Code MySQL để tạo lại bảng Bài 6
-- USER EDITION form

USE lab6_db;

-- Xóa bảng cũ nếu có
DROP TABLE IF EXISTS users;

-- Tạo bảng mới cho Bài 6 - User Edition
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    fullname VARCHAR(100),
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Kiểm tra bảng đã tạo
DESCRIBE users;

SELECT 'Bảng users đã được tạo thành công!' AS status;
