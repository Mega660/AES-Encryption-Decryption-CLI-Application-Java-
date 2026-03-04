# AES Encryption & Decryption CLI Application (Java)

A secure Command-Line Interface (CLI) application built in Java that performs AES (Advanced Encryption Standard) encryption and decryption using user-provided secret keys.


## Features

* Encrypt plain text using AES algorithm
* Decrypt AES encrypted text
* Supports 128-bit, 192-bit, and 256-bit keys
* Base64 encoding for encrypted output
* Input validation for key length
* Exception handling for security errors
* Interactive CLI menu system

## Technologies Used

* Java
* Java Cryptography Architecture (JCA)
* AES (Advanced Encryption Standard)
* Base64 Encoding
* Scanner (User Input Handling)

## How It Works

1. User selects Encrypt or Decrypt.
2. User provides:

   * Text to process
   * Secret key (16, 24, or 32 characters)
3. Application:

   * Validates key length
   * Uses AES cipher
   * Returns encrypted Base64 output or decrypted text

## ▶ How to Run

### Compile:

bash
javac AESApp.java

### Run:
bash
java AESApp

## Example

=== AES Encryption App ===
1. Encrypt
2. Decrypt
3. Exit
Choose option: 1

Enter text: HelloWorld
Enter secret key (16/24/32 chars): 1234567890123456

Encrypted: m3k9YV9u0ZpF5X2Wz...

## Future Improvements

* Add GUI version (JavaFX or Swing)
* Add file encryption support
* Implement AES with CBC mode and IV
* Add password-based key derivation (PBKDF2)
* Store encrypted logs securely

Author
Developed by Amenyo Richard
Computer Science | Software Development | Security Enthusiast

## Why This Project Matters
This project demonstrates:

* Understanding of cryptography fundamentals
* Secure key handling
* Exception management
* Real-world security implementation in Java
