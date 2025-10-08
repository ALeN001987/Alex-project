
# 🛒 Playwright + Java Automation Test Suite

Automated test suite built with **Playwright (Java)** to demonstrate best practices in **test automation architecture**, CI integration, and reusable framework design.  
This project targets a **fictional e-commerce web application** — it is designed purely for **educational and demonstration purposes** (no real selectors or production data).

---

## 📦 Tech Stack
- Playwright (Java)  
- Java 21 Amazon Corretto  
- Maven  
- TestNG  
- GitHub Actions  
- IntelliJ IDEA (recommended)

---

## ⚙️ Project Structure
```
src  
 └── test  
     ├── java  
     │   ├── pages          # Page Object Model classes  
     │   ├── tests          # TestNG test classes  
     │   └── utils          # BaseTest and helpers  
     └── resources  
testng.xml                  # TestNG suite configuration  
pom.xml                     # Maven build file  
```

---

## 🔧 Setup Instructions
### ✅ Prerequisites
- Java 21 or higher  
- Maven installed (`mvn -v`)  
- IntelliJ or any preferred IDE  

### 🛠️ Build & Run
Install dependencies:  
```bash
mvn clean install
```
Install Playwright browsers (first time only):  
```bash
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```
Run tests:  
```bash
mvn test
```

---

## ✅ Test Scenarios
| Feature | Scenario |
|----------|-----------|
| Login | Valid / invalid login, empty fields |
| Product Search | Search known & unknown items |
| Add to Cart | Add, view, and remove products |
| Checkout | Fill address/payment, verify success |
| Smoke | Login → Add product → Checkout |
| End-to-End | Full purchase flow |

---

## 🔁 CI/CD Integration
Includes a **GitHub Actions** workflow that executes grouped tests (`smoke`, `endtoend`) in parallel upon push or pull request to `main`.

---

## 💡 Best Practices Highlighted
- Page Object Model (POM) structure  
- Clean, maintainable selectors  
- Parameterized test data & config reader  
- Parallel execution via TestNG  
- Retry analyzer for transient failures  
- Continuous integration with GitHub Actions  

---

## ⚠️ Disclaimer
This framework is intended **solely as a demonstration** of automation design and CI integration.  
All selectors and test data are fictional. The project can be easily adapted to real applications by updating locator definitions and configuration files.

---

### 📄 Author
**Alejandro Ulises Lerma Negrete**  
Senior QA Automation Engineer / SDET  

---

