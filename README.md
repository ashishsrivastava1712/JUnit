# User Registration & Email Validator — JUnit 5 Test Suite

A comprehensive Java validation suite demonstrating robust input sanitization, regular expression patterns, and test-driven verification using JUnit 5.

---

## What Does This Project Do? (In Simple Terms)

Whenever you sign up for a new account on an app or website, the system checks whether the information you typed is valid before letting you in:
1. **First & Last Name:** Checks that names start with a capital letter and are at least 3 letters long.
2. **Email Address:** Checks that the email follows proper formatting (e.g. `username@domain.com` or `user.name@domain.co.in`) with no illegal characters or double dots.
3. **Mobile Number:** Ensures standard country code and 10-digit phone formatting (e.g. `91 9919819801`).
4. **Strong Password Security:** Confirms that the password is at least 8 characters long, contains at least one uppercase letter, at least one digit, and exactly one special symbol.

This repository bundles the **validation rules** together with **automated unit tests** to guarantee that every rule passes for valid inputs and catches invalid ones.

---

## Key Concepts Covered

- **Regular Expressions (Regex):** 
  Using pattern-matching rules to enforce strict formatting for names, emails, phone numbers, and security criteria.
- **Test-Driven Development (TDD) Mindset:** 
  Verifying code using both "Happy Paths" (cases that should pass) and "Sad Paths" (cases that should be rejected).
- **Parameterized Testing (`@ParameterizedTest` & `@CsvSource`):** 
  Running a single test method across dozens of real-world valid and invalid email scenarios in a clean, tabular format without writing repetitive code.
- **Modular Validation Structure:** 
  Breaking down a complex multi-factor rule (like password security) into small, individually testable methods (length check, uppercase check, digit check, special character count).
- **Branching & Git Workflow:** 
  Managing code evolution across `main`, `develop`, and `feature/JUnitTesting` branches.

---

## Validation Rules Matrix

| Field | Rule Specification | Example Valid Input | Example Invalid Input |
|:---|:---|:---|:---|
| **First Name** | Starts with capital letter; minimum 3 characters | `Ashish` | `as`, `ashish`, `12345` |
| **Last Name** | Starts with capital letter; minimum 3 characters | `Srivastava` | `srivastava`, `Sr`, `123` |
| **Email Address** | Standard username, `@`, domain name, and TLD | `abc.xyz@bl.co.in` | `abc`, `abc@.com`, `abc..2002@gmail.com` |
| **Mobile Number** | Country code + single space + 10 digits | `91 9919819801` | `9919819801`, `91-9919819801` |
| **Password** | Min 8 chars, $\ge 1$ uppercase, $\ge 1$ digit, exactly 1 special char | `Ashish@123` | `ashish123`, `Ashish@@123`, `Ash@1` |

---

## Project Structure

```text
├── pom.xml                                   # Maven dependencies (JUnit Jupiter 5)
├── README.md                                 # Project documentation & overview
└── src
    ├── main/java
    │   ├── EmailValidator.java               # Dedicated email format validator
    │   └── UserRegistration.java             # Core user registration validation engine
    └── test/java
        ├── EmailValidatorTest.java           # Parameterized test matrix for email cases
        └── UserRegistrationTest.java         # Happy-path and sad-path JUnit 5 test suite
```

---

## Branching Model

- **`main`** — Production-ready baseline documentation.
- **`develop`** — Configured Maven project structure.
- **`feature/JUnitTesting`** — Complete validator implementation and full JUnit 5 test suite.

---

## Technologies Used

- **Language:** Java 17
- **Testing Framework:** JUnit 5 (JUnit Jupiter)
- **Build System:** Apache Maven
- **Version Control:** Git & GitHub
