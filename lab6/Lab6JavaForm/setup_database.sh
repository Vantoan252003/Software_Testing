#!/bin/bash
# Database Setup Script for Lab 6

echo "========================================="
echo "Lab 6 Database Setup"
echo "========================================="
echo ""

# Check if MySQL is running
if ! command -v mysql &> /dev/null; then
    echo "❌ MySQL is not installed or not in PATH"
    exit 1
fi

echo "Setting up database lab6_db..."
echo ""
echo "You will be prompted for MySQL root password: Vantoan@123"
echo ""

# Execute the SQL script
mysql -u root -p <<EOF
CREATE DATABASE IF NOT EXISTS lab6_db;
USE lab6_db;

-- Table for Bài 4 - User Form
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for Bài 5 - Job Title Form
CREATE TABLE IF NOT EXISTS job_titles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    job_title VARCHAR(100) NOT NULL,
    description VARCHAR(400),
    job_spec_file VARCHAR(255),
    note VARCHAR(400),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for Bài 6 - Employee Form
CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    salary DOUBLE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Show tables
SHOW TABLES;

-- Show structure
DESCRIBE users;
DESCRIBE job_titles;
DESCRIBE employees;

EOF

if [ $? -eq 0 ]; then
    echo ""
    echo "========================================="
    echo "✅ Database setup completed successfully!"
    echo "========================================="
    echo ""
    echo "Database: lab6_db"
    echo "Tables: users, job_titles, employees"
    echo ""
    echo "You can now run the application with:"
    echo "  ./run.sh"
    echo ""
else
    echo ""
    echo "❌ Database setup failed!"
    echo "Please check your MySQL installation and credentials."
fi
