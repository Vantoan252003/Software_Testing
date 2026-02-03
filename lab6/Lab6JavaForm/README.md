# Lab 6 - Software Testing Application

Java Swing application for testing input validation with three forms sharing one MySQL database.

## Prerequisites

- Java 17 or higher
- MySQL Server
- Maven

## Database Setup

1. **Start MySQL Server**

2. **Create Database and Tables**
   
   Run the following SQL script (`database_setup.sql`):

   ```sql
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
   ```

3. **Database Configuration**
   
   The application is configured to connect to MySQL with:
   - Host: localhost:3306
   - Database: lab6_db
   - Username: root
   - Password: Vantoan@123
   
   If you need to change these settings, edit `src/main/java/org/example/util/DBConnection.java`

## Build and Run

1. **Compile the project:**
   ```bash
   mvn clean compile
   ```

2. **Run the application:**
   ```bash
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```

   Or build a JAR file:
   ```bash
   mvn clean package
   java -jar target/Lab6JavaForm-1.0-SNAPSHOT.jar
   ```

## Application Structure

### Main Menu
The application starts with a main menu containing three buttons:
- **Bài 4 – User Form**: Input validation test
- **Bài 5 – Add Job Title Form**: Boundary value analysis
- **Bài 6 – Employee Form**: Business rule validation

### Bài 4 - User Form
**Purpose:** Test input validation for user registration

**Test Cases:**
1. ❌ Username is EMPTY → show error message
2. ❌ Password length < 6 → show error message
3. ❌ Email format is INVALID → show error message
4. ✅ All inputs VALID → insert into users table and show PASS

**Fields:**
- Username (VARCHAR 50)
- Password (VARCHAR 255)
- Email (VARCHAR 100)

### Bài 5 - Add Job Title Form
**Purpose:** Apply boundary value analysis

**Test Cases:**
1. ❌ Job title EMPTY → error
2. ❌ Job title length > 100 → error
3. ❌ Description length > 400 → error
4. ❌ Note length > 400 → error
5. ✅ All fields VALID → insert into job_titles table and show PASS

**Fields:**
- Job Title (VARCHAR 100)
- Description (VARCHAR 400)
- Job Spec File (VARCHAR 255)
- Note (VARCHAR 400)

### Bài 6 - Employee Form
**Purpose:** Test business rule validation

**Test Cases:**
1. ❌ Full name EMPTY → error
2. ❌ Age < 18 → error
3. ❌ Salary <= 0 → error
4. ✅ All inputs VALID → insert into employees table and show PASS

**Fields:**
- Full Name (VARCHAR 100)
- Age (INT)
- Salary (DOUBLE)

## Project Structure

```
Lab6JavaForm/
├── pom.xml                          # Maven configuration
├── database_setup.sql               # Database schema
├── README.md                        # This file
└── src/main/java/org/example/
    ├── Main.java                    # Main entry point with menu
    ├── util/
    │   └── DBConnection.java        # Database connection utility
    └── forms/
        ├── Bai4UserForm.java        # User registration form
        ├── Bai5JobTitleForm.java    # Job title form
        └── Bai6EmployeeForm.java    # Employee form
```

## Features

- ✅ Clean Java Swing UI
- ✅ Real-time input validation
- ✅ Clear test result display
- ✅ Proper error handling
- ✅ MySQL database integration with JDBC
- ✅ PreparedStatement for SQL injection prevention
- ✅ Separate form classes for each test scenario

## Testing

Each form displays test results in a text area showing:
- Which test cases PASSED (✅)
- Which test cases FAILED (❌)
- Error messages for failed validations
- Success message when data is inserted into database

## Troubleshooting

**Connection Error:**
- Make sure MySQL server is running
- Verify database credentials in DBConnection.java
- Ensure lab6_db database exists

**Compilation Error:**
- Run `mvn clean install` to download dependencies
- Check Java version: `java -version` (should be 17+)

**Build Error:**
- Delete target folder and rebuild: `rm -rf target && mvn clean compile`

## License

This is an educational project for Lab 6 - Software Testing course.
