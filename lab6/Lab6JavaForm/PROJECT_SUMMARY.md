# Lab 6 - Software Testing Application
## Project Summary

### ✅ COMPLETED - All Requirements Implemented

---

## 📁 Project Structure

```
Lab6JavaForm/
├── README.md                           # Complete documentation
├── database_setup.sql                  # Database schema
├── run.sh                              # Quick run script
├── pom.xml                             # Maven configuration with MySQL dependency
└── src/main/java/org/example/
    ├── Main.java                       # Main menu with 3 buttons
    ├── util/
    │   └── DBConnection.java           # Database utility (MySQL connection)
    └── forms/
        ├── Bai4UserForm.java           # User Form (Input Validation)
        ├── Bai5JobTitleForm.java       # Job Title Form (Boundary Value)
        └── Bai6EmployeeForm.java       # Employee Form (Business Rules)
```

---

## 🗄️ Database Configuration

**Connection Details:**
- DBMS: MySQL
- Database: `lab6_db`
- Host: `localhost:3306`
- Username: `root`
- Password: `Vantoan@123`
- Driver: `com.mysql.cj.jdbc.Driver`

**Tables Created:**
1. `users` - for Bài 4
2. `job_titles` - for Bài 5
3. `employees` - for Bài 6

---

## 🎯 Form Implementations

### Bài 4 - User Form (Input Validation)
**Components:**
- ✅ JTextField txtUsername
- ✅ JPasswordField txtPassword
- ✅ JTextField txtEmail
- ✅ JButton btnSubmit
- ✅ JTextArea txtTestResult

**Test Cases Implemented:**
1. ✅ Username is EMPTY → error message
2. ✅ Password length < 6 → error message
3. ✅ Email format INVALID → error message
4. ✅ All valid → INSERT into users table

**Database Table: `users`**
- username VARCHAR(50)
- password VARCHAR(255)
- email VARCHAR(100)

---

### Bài 5 - Job Title Form (Boundary Value Analysis)
**Components:**
- ✅ JTextField txtJobTitle
- ✅ JTextArea txtDescription
- ✅ JTextField txtJobSpecFile
- ✅ JTextArea txtNote
- ✅ JButton btnSave
- ✅ JTextArea txtTestResult

**Test Cases Implemented:**
1. ✅ job_title EMPTY → error
2. ✅ job_title length > 100 → error
3. ✅ description length > 400 → error
4. ✅ note length > 400 → error
5. ✅ All valid → INSERT into job_titles table

**Database Table: `job_titles`**
- job_title VARCHAR(100)
- description VARCHAR(400)
- job_spec_file VARCHAR(255)
- note VARCHAR(400)

---

### Bài 6 - Employee Form (Business Rule Validation)
**Components:**
- ✅ JTextField txtFullName
- ✅ JTextField txtAge
- ✅ JTextField txtSalary
- ✅ JButton btnAdd
- ✅ JTextArea txtTestResult

**Test Cases Implemented:**
1. ✅ Full name EMPTY → error
2. ✅ Age < 18 → error
3. ✅ Salary <= 0 → error
4. ✅ All valid → INSERT into employees table

**Database Table: `employees`**
- full_name VARCHAR(100)
- age INT
- salary DOUBLE

---

## ⚙️ Technical Implementation

### ✅ Java Swing Components Used
- JFrame (main window and forms)
- JPanel (layout containers)
- JLabel (field labels)
- JTextField (text input)
- JPasswordField (password input)
- JTextArea (multi-line input and results)
- JButton (action buttons)
- JScrollPane (scrollable areas)
- GridBagLayout (flexible layout manager)

### ✅ Database Features
- JDBC connection with try-with-resources
- PreparedStatement for SQL injection prevention
- Connection pooling through DBConnection utility
- Proper SQLException handling
- Transaction management

### ✅ Code Quality
- Separate classes for each form
- Clean code structure
- Input validation with clear error messages
- Real-time test result display
- Proper resource management

---

## 🚀 How to Run

### Option 1: Using the run script
```bash
./run.sh
```

### Option 2: Using Maven
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="org.example.Main"
```

### Option 3: Build JAR and run
```bash
mvn clean package
java -jar target/Lab6JavaForm-1.0-SNAPSHOT.jar
```

---

## 📋 Setup Instructions

### 1. Database Setup
```sql
-- Run in MySQL
mysql -u root -p

-- Then execute
source database_setup.sql
```

Or manually:
```bash
mysql -u root -p < database_setup.sql
```

### 2. Verify MySQL Connection
Make sure:
- MySQL server is running on port 3306
- Database `lab6_db` exists
- User `root` has password `Vantoan@123`
- All three tables are created

### 3. Build Project
```bash
mvn clean install
```

### 4. Run Application
```bash
./run.sh
```

---

## 🧪 Testing Guide

### Bài 4 - User Form Tests
1. **Test Empty Username**
   - Username: (empty)
   - Password: password123
   - Email: test@email.com
   - Result: ❌ FAIL - Username is empty

2. **Test Short Password**
   - Username: john
   - Password: 123
   - Email: test@email.com
   - Result: ❌ FAIL - Password < 6

3. **Test Invalid Email**
   - Username: john
   - Password: password123
   - Email: invalid-email
   - Result: ❌ FAIL - Invalid email format

4. **Test Valid Input**
   - Username: john
   - Password: password123
   - Email: john@example.com
   - Result: ✅ PASS - Data inserted

### Bài 5 - Job Title Form Tests
1. **Test Empty Job Title**
   - Job Title: (empty)
   - Result: ❌ FAIL

2. **Test Long Job Title (>100 chars)**
   - Job Title: (101+ characters)
   - Result: ❌ FAIL

3. **Test Long Description (>400 chars)**
   - Description: (401+ characters)
   - Result: ❌ FAIL

4. **Test Long Note (>400 chars)**
   - Note: (401+ characters)
   - Result: ❌ FAIL

5. **Test Valid Input**
   - All fields within limits
   - Result: ✅ PASS - Data inserted

### Bài 6 - Employee Form Tests
1. **Test Empty Name**
   - Full Name: (empty)
   - Result: ❌ FAIL

2. **Test Age < 18**
   - Age: 16
   - Result: ❌ FAIL

3. **Test Salary <= 0**
   - Salary: -100 or 0
   - Result: ❌ FAIL

4. **Test Valid Input**
   - Full Name: John Doe
   - Age: 25
   - Salary: 5000
   - Result: ✅ PASS - Data inserted

---

## ✨ Features Implemented

- ✅ Main menu with 3 buttons
- ✅ Each button opens separate JFrame
- ✅ All forms have clear input fields
- ✅ Test case validation displayed in JTextArea
- ✅ Shared MySQL database (lab6_db)
- ✅ JDBC with PreparedStatement
- ✅ DBConnection utility class
- ✅ SQLException handling
- ✅ Clear test result messages (✅ PASS / ❌ FAIL)
- ✅ Input field clearing after success
- ✅ Real-time validation feedback
- ✅ Proper error messages

---

## 📝 Notes

- Project uses Java 17
- MySQL Connector/J 8.0.33
- Maven for dependency management
- GridBagLayout for flexible UI
- Try-with-resources for auto-close
- Lambda expressions for event handlers
- UTF-8 encoding throughout

---

## ✅ Checklist - All Requirements Met

- [x] 3 separate forms (Bài 4, 5, 6)
- [x] MainMenu with 3 buttons
- [x] Each button opens separate JFrame
- [x] Clear input fields in all forms
- [x] Test case validation implemented
- [x] Shared MySQL database
- [x] Database name: lab6_db
- [x] Username: root, Password: Vantoan@123
- [x] JDBC Driver: com.mysql.cj.jdbc.Driver
- [x] Bài 4: Input validation tests
- [x] Bài 5: Boundary value tests
- [x] Bài 6: Business rule tests
- [x] DBConnection utility class
- [x] PreparedStatement usage
- [x] SQLException handling
- [x] Code compiles successfully
- [x] All forms functional

---

## 🎓 Educational Value

This project demonstrates:
- Software testing concepts
- Input validation techniques
- Boundary value analysis
- Business rule validation
- GUI development with Swing
- Database integration with JDBC
- Error handling and user feedback
- Code organization and best practices

---

**Project Status: ✅ COMPLETE AND READY TO RUN**
