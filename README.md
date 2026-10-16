# 🏦 Virtual Banking Terminal

A Java-based banking simulation that demonstrates the fundamental operations of a real-world banking system through a simple, menu-driven console application.

## 📌 Project Information

- **Project Name:** Virtual Banking Terminal
- **Project Code:** KLHB_FED_2026-27_T11_VIRTUAL_BANKING_TERMINAL
- **Team Number:** KLH/PSPJAVA/S10/T11
- **Supervisor:** Dr. Madhavi Karumudi

### 👥 Team Members

| S. No. | Name | Student ID |
|--------|------|------------|
| 1 | Mokshit Reddy Alikepalli | 2620030124 |
| 2 | D. Veda Chandra | 2620030606 |
| 3 | Vaideesh Duggirala | 2620030110 |

---

## 📖 Abstract

The Virtual Banking Terminal is a Java-based application designed to simulate the basic operations of a real-world banking system in a simple and user-friendly environment. The system allows users to access their accounts using an account ID and PIN and perform essential banking operations such as checking account balances, depositing money, withdrawing money, and viewing transaction statements.

The project is developed using core Java concepts, including classes and objects, encapsulation, methods, conditional statements, loops, switch-case, arrays, recursion, exception handling, collections, streams, and file handling.

The application follows a menu-driven approach, allowing users to select the required banking operation from the available options. Input validation and exception handling help manage incorrect PINs, invalid amounts, insufficient balances, and other invalid inputs.

The system also demonstrates recursive future-value calculation using an assumed annual interest rate of 5%, denomination-wise cash breakdown, transaction summaries, and persistent account balances through file handling.

The primary objective is to demonstrate how Java programming concepts can be applied to develop a practical banking simulation while strengthening problem-solving, modular programming, control flow, and user interaction.

**Note:** This project is an educational simulation. It does not connect to an actual bank or process real financial transactions.

---

## ✨ Features

### 🔐 1. Account Authentication
- Login using an account ID and PIN.
- Allows up to three login attempts.
- Displays an error message for incorrect credentials.
- Terminates the login process after three failed attempts.

### 💰 2. Balance Enquiry
- Displays the current account balance.
- Provides a simple way to check available funds.

### 💵 3. Deposit Money
- Accepts a deposit amount from the user.
- Validates that the amount is positive.
- Updates the account balance.
- Records the deposit in the transaction history.

### 🏧 4. Withdraw Money
- Accepts the withdrawal amount.
- Checks whether the amount is positive.
- Prevents withdrawals exceeding the available balance.
- Displays a denomination-wise cash breakdown using ₹500, ₹200, ₹100, and ₹50 notes.

### 📄 5. Transaction Statement
- Displays the current session's transaction history.
- Calculates the total amount deposited.
- Calculates the total amount withdrawn.
- Displays account names ranked by balance, from highest to lowest.

### 📈 6. Future Value Calculation
- Estimates the future value of the current balance.
- Uses an assumed annual interest rate of 5%.
- Demonstrates recursion through repeated yearly calculations.

For example, the calculation for three years is:

Future Value = Principal × (1.05)^3

The displayed result is an illustrative calculation, not an actual bank interest calculation.

### 💾 7. File Handling
- Loads account information from `accounts.txt`.
- Saves account information when the application exits.
- Creates default accounts if the account file cannot be opened.

### ⚠️ 8. Exception Handling
The program handles several common errors:

- Invalid numeric input.
- Negative or zero transaction amounts.
- Insufficient account balance.
- Incorrect login credentials.

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Core programming language |
| Java Collections Framework | Stores and manages accounts and transaction history |
| HashMap | Maps account IDs to account objects |
| ArrayList | Stores transaction history |
| Arrays | Stores available currency denominations |
| Recursion | Calculates future account value |
| Exception Handling | Handles invalid inputs and transaction errors |
| File I/O | Loads and saves account information |
| Java Streams | Filters, processes, and summarizes transactions |
| Lambda Expressions | Simplifies collection processing |

---

## 🧠 Java Concepts Demonstrated

This project combines several Java programming concepts.

### 1. Computational Thinking and Java Foundations
The application uses variables, data types, operators, and user input to process banking transactions.

### 2. Control Flow: Selection and Iteration
`if` statements, `switch-case`, and loops control login attempts, menu selection, and banking operations.

### 3. Methods, Recursion, and Arrays
Methods divide the program into manageable operations. Recursion calculates future value, while arrays store currency denominations.

### 4. Object-Oriented Programming
The `Account` class encapsulates account information and provides methods for deposits, withdrawals, and PIN validation.

### 5. Exception Handling
Custom and built-in exceptions handle insufficient funds, invalid amounts, and incorrect numeric input.

### 6. Strings and File Handling
String operations process account records, while file handling stores account information between program runs.

### 7. Collections and Streams
`HashMap`, `ArrayList`, and Java Streams organize accounts, maintain transaction history, calculate totals, and rank accounts by balance.

---

## 📂 Project Structure

```text
Virtual-Banking-Terminal/
│
├── Bank.java
├── accounts.txt
└── README.md
