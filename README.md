# 🛒 Playwright + Java Automation Test Suite

Automated test suite built with Playwright for Java, designed to validate core functionalities of a fictional e-commerce web application including login, product search, cart management, and checkout.

---

## 📦 Tech Stack

- Playwright (Java)
- Java 21 Amazon Coretto
- Maven
- TestNG
- GitHub Actions
- IntelliJ IDEA (recommended)

---

## ⚙️ Project Structure

src  
 └── test  
     ├── java  
     │   ├── pages          # Page Object Model classes  
     │   ├── tests          # TestNG test classes  
     │   └── utils          # BaseTest and helpers  
     └── resources  
testng.xml                  # TestNG suite configuration  
pom.xml                     # Maven build file  

---

## 🔧 Setup Instructions

### ✅ Prerequisites

- Java 21 or higher
- Maven installed (`mvn -v`)
- IntelliJ or other IDE

---

### 🛠️ Install Dependencies

Run this once to build the project:

    mvn clean install

---

### 🌐 Install Playwright Browsers

First-time only:

    mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"

---

## 🚀 Running Tests

### Run all tests:

    mvn test

### Run a specific test class:

    mvn -Dtest=LoginTest test

### Run a test group:

    mvn test -Dgroups=smoke
    mvn test -Dgroups=endtoend

---

## ✅ Test Scenarios

| Feature                  | Scenario                                              |
|--------------------------|-------------------------------------------------------|
| Login                   | Valid and invalid login, empty field checks           |
| Product Search          | Search for known/unknown products                     |
| Add to Cart             | Add, view, and remove items from cart                 |
| Checkout                | Fill address/payment, place order, verify success     |
| Smoke Test              | Login → Add product → Access checkout page            |
| Regression (End-to-End) | Complete user journey from login to order confirmation|

---

## 🧱 Parallel Execution

Parallel test execution is enabled via TestNG:

- `<parallel>methods</parallel>`
- `<threadCount>4</threadCount>`

Edit `testng.xml` or `pom.xml` to tweak this behavior.

---

## 🔁 Retry Logic

Tests are retried automatically on transient failures using TestNG retry analyzer.

You can customize retry behavior in your `RetryAnalyzer` class or via the Maven Surefire plugin.

---

## 🧪 GitHub Actions – CI Pipeline

This project includes a GitHub Actions workflow to automatically run grouped tests.

### Workflow file:

    .github/workflows/execution.yml

### Runs these groups:

- `smoke`
- `endtoend`

### Triggered on:

- Push or pull request to `main`
- Manual run via GitHub Actions interface

### Parallel Execution in Matrix:

Each group runs in its own job for speed:

    strategy:
      matrix:
        group: [endtoend, smoke]

---

## 🏷 Test Grouping with @TestNG

Tests are tagged using `@Test(groups = {"name"})`, for example:

    @Test(groups = {"smoke"})
    public void basicSmokeTestFlow() {}

    @Test(groups = {"endtoend"})
    public void completePurchaseFlow() {}

Run using:

    mvn test -Dgroups=smoke

---

## 💡 Best Practices Applied

- Page Object Model (POM)
- Clean locators using stable selectors
- No hardcoded data
- Organized tests into groups: smoke, endtoend
- Retry logic for flakiness
- Parallel execution enabled
- GitHub CI for test automation

---
This test should be addapted to a real page, this is only for a fictional page 
The configreader for test data was addapted in smoke and endToEnd test 


---
