[![Java](https://img.shields.io/badge/Java-21-blue?logo=java&logoColor=white)](https://www.java.com/)
[![Maven](https://img.shields.io/badge/Maven-3.9.2-red?logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![Selenium](https://img.shields.io/badge/Selenium-4.25.0-green?logo=selenium&logoColor=white)](https://www.selenium.dev/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.20.1-brightgreen?logo=cucumber&logoColor=white)](https://cucumber.io/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
# 🧪 Automation Test Framework

A Java-based automation testing framework built using **Selenium**, **Cucumber (BDD)**, and **Maven**. It follows the **Page Object Model (POM)** design pattern for maintainability and scalability.

---

## 📚 Table of Contents
- [🧩 Project Overview](#-project-overview)
- [🧰 Tech Stack](#-tech-stack)
- [📂 Project Structure](#-project-structure)
- [🚀 How to Run Tests](#-how-to-run-tests)
- [📈 Reports](#-reports)
- [💻 About Me](#-about-me)
- [👩‍💻 Author](#-author)
- [⚖️ License](#-license)

---

## 🧩 Project Overview
This framework was originally built using a **Hybrid Test Automation approach** (Page Object Model + Data-Driven Testing) and later enhanced with **BDD (Cucumber)** for improved readability, collaboration, and behavior-driven testing.

It currently focuses on **UI automation testing using Selenium WebDriver**,  
with plans to **extend support for API testing and other automation layers** in future updates.


---

## 🧰 Tech Stack
**Language:** Java  
**Build Tool:** Maven  
**Testing Framework:** Cucumber  
**Design Pattern:** Page Object Model (POM)  
**Browser Automation:** Selenium WebDriver

---
## 📂 Project Structure
```
src
├── main
│   └── java
│       ├── base           # Base test setup
│       ├── pages          # Page classes
│       └── utils          # ConfigReader, DriverFactory, etc.
├── test
│   └── java
│       ├── hooks          # Hooks for setup/teardown
│       ├── runners        # Cucumber TestRunner
│       ├── stepDefinitions# Step definitions
│       └── tests          # Test classes
├── resources
│   ├── features          # Feature files
│   └── testing.xml        # TestNG runner config (if applicable)
└── target                # Compiled classes and reports
```
---
## 🚀 How to Run Tests

### 1️⃣ Clone the repository
```bash
  git clone https://github.com/ReshmaAK2810/qa-automation-framework.git
```
### 2️⃣ Navigate to the project directory
```bash
  cd <your-local-folder-name>   # replace with the folder where you cloned the repo
```
### 3️⃣ Run tests using Maven
```bash
  mvn test
```

### 4️⃣ View the HTML report in:

target/cucumber-reports.html

---
## 📈 Reports

Currently, the framework generates a **basic HTML report**.  
**Allure** and **Extent Reports** integration will be added in upcoming updates.

---
## 💻 About Me
I’m a **QA Engineer with 8.6 years of experience** in manual and automation testing. I hold **ISTQB-CTFL** and **Agile Tester** certifications and have strong expertise in **functional and regression testing**, **Selenium**, and **Cucumber**. This framework is part of my journey to strengthen my automation skills and build reusable frameworks for real-world testing projects.

I’m currently open to **freelancing and part-time QA opportunities**, where I can contribute to building and improving automation frameworks.

---
## 👩‍💻 Author
**Reshma Chenthamarai**

🌐 [LinkedIn](https://www.linkedin.com/in/reshma-chenthamara-95966b18b/)

📧 reshmaak2810@outlook.com

---

## ⚖️ License

This project is licensed under the [MIT License](LICENSE) © 2025 **Reshma Chenthamarai**.

---
✨ *“Every great test begins with curiosity and ends with confidence.”* ✨
