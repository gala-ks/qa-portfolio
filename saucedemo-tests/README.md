# 🧪 SauceDemo Tests

## 📌 Project Overview

This project demonstrates **manual and automated QA testing** for the [SauceDemo](https://www.saucedemo.com/) e-commerce demo application.

---

## 📌 Project Scope

* **Manual Testing:** Functional test cases for login, add-to-cart, and checkout workflows
* **Automation:** Selenium WebDriver scripts in **Python** and **Java**
* **Test Coverage:**

   * A structured framework with the **Page Object Model (POM)** ???? LEAVE OR UPDATE TO HerokuApp Tests
   * ✅ Example of **regression suite vs. smoke suite** SAME?????

---

## 📂 Project Structure

```
saucedemo-tests/
├── .github/
│   └── workflows/
│        └── selenium-tests.yml     # GitHub Actions workflow for CI/CD:
│                                   # - Runs automated Selenium tests for both Python and Java
│                                   # - Installs dependencies (Python via requirements.txt, Java via Maven)
│                                   # - Executes test scripts and generates JUnit test reports
│                                   # - Uploads test artifacts for review
│                                   # - Displays test results in GitHub Actions UI
│                                   # - Sends Slack/email notifications if any tests fail
├── manual-tests/
│   └── test-cases.xlsx             # Written manual test cases for reference and validation
├── automation/
│   ├── python/
│   │   ├── pages/                  # Python Page Object Model classes
│   │   ├── tests/                  # Python test scripts
│   │   ├── conftest.py             # Pytest fixtures for setup/teardown and shared resources
│   │   └── requirements.txt        # Python dependencies
│   └── java/
│       ├── src/
│       │   ├── main/
│       │   │   └── java/
│       │   │       └── pages/      # Java Page Object Model classes (locators, page actions)
│       │   └── test/
│       │       └── java/
│       │           └── tests/      # Java test scripts (e.g., Selenium or JUnit/TestNG tests)
│       └── pom.xml                 # Maven configuration file (dependencies, build settings, plugins)
└── README.md                       # Project documentation and instructions
---

## 📝 Manual Test Cases

Example test case for login:

| Test ID | Test Scenario           | Steps                                                                                                       | Expected Result                         |
| ------- | ----------------------- | ----------------------------------------------------------------------------------------------------------- | --------------------------------------- |
| TC-001  | Login with valid user   | 1. Go to login page <br> 2. Enter username `standard_user` <br> 3. Enter valid password <br> 4. Click Login | User is redirected to the Products page |
| TC-002  | Login with invalid user | 1. Enter invalid username <br> 2. Enter any password <br> 3. Click Login                                    | Error message is displayed              |

---

## 🤖 Automated Tests (Selenium + Python)

Example: Login button validation

```python
from selenium import webdriver
from selenium.webdriver.common.by import By

def test_login_valid_user():
    driver = webdriver.Chrome()
    driver.get("https://www.saucedemo.com/")
    
    driver.find_element(By.ID, "user-name").send_keys("standard_user")
    driver.find_element(By.ID, "password").send_keys("secret_sauce")
    driver.find_element(By.ID, "login-button").click()
    
    assert "products" in driver.current_url
    driver.quit()
```

---

## 🚀 How to Run Tests

1. Clone this repo:

   ```bash
   git clone https://github.com/<your-username>/qa-portfolio.git
   cd qa-portfolio/saucedemo-tests/automation
   ```
2. Install dependencies:

   ```bash
   pip install -r requirements.txt
   ```
3. Run tests:

   ```bash
   pytest -v
   ```

---

## 🔮 Next Steps

* Add **HerokuApp tests** for handling UI components (dropdowns, alerts, file upload).
* Expand test coverage with **regression suite**.
* Integrate CI/CD with GitHub Actions to run tests automatically.

---

## 👤 About Me

I am a **QA Engineer in training** with hands-on experience in manual and automated testing.
This project showcases my ability to:

* Design test cases
* Write Selenium automation
* Organize code into frameworks
* Communicate test results clearly

---
