-- Code MySQL để tạo lại bảng Bài 4
-- Chạy trong MySQL Workbench hoặc terminal

USE lab6_db;

-- Xóa bảng cũ nếu có
DROP TABLE IF EXISTS organization_units;

-- Tạo bảng mới cho Bài 4 - Add Organization Unit
CREATE TABLE organization_units (
    id INT AUTO_INCREMENT PRIMARY KEY,
    unit_id VARCHAR(50),
    name VARCHAR(100) NOT NULL,
    description TEXT,
    organization VARCHAR(100) DEFAULT 'Organization',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Kiểm tra bảng đã tạo
DESCRIBE organization_units;

SELECT 'Bảng organization_units đã được tạo thành công!' AS status;
