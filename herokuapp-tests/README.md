# 🌐 HerokuApp Tests

## 📌 Project Overview

This project demonstrates **manual, automated, and continuous integration of automated Selenium tests** in **Python and Java**, using **GitHub Actions**** for [The Internet – HerokuApp](https://the-internet.herokuapp.com/), a demo site with diverse UI components.

---

## 📌 Project Scope

* **Manual Testing:** Functional test cases for UI components (alerts, dropdowns, file uploads, dynamic elements)
* **Automation:** Selenium WebDriver scripts in **Python** and **Java**
* **Test Coverage:**

    * Alerts & confirmation dialogs
    * Dropdown selection
    * File upload & downloads
    * Dynamic controls & visibility

* **CI/CD Integration:** 
    * Run **Python + Java Selenium tests** automatically on push or pull requests
    * Generate **test reports** and optionally capture screenshots
    * Demonstrate **real-world QA workflow** with CI/CD

---

## 📂 Project Structure

```
herokuapp-tests/
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
```

---

## 🛠 Tech Stack

* **Python Automation:** Selenium, Pytest
* **Java Automation:** Selenium, JUnit/TestNG, Maven
* **Design Pattern:** Page Object Model (POM)
* **CI/CD:** GitHub Actions
* **Reporting:** pytest-html, Surefire reports

---

## 🚀 How to Run

### 🔹 Python Tests

```bash
cd automation/python
pip install -r requirements.txt
pytest -v
```

### 🔹 Java Tests

```bash
cd automation/java
mvn clean test
```

OR IT COULD BE THIS WAY:
* Python tests: `pytest python-tests/tests --html=report.html`
* Java tests: `mvn -f java-tests/pom.xml clean test`
* Workflow triggers automatically on GitHub Actions when code is pushed
---

## 🎯 Learning Goals

* Test diverse UI elements
* Write modular automation scripts
* Apply Page Object Model in multiple languages
* Document test cases professionally
* Integrate automated tests into CI/CD pipelines
* Run multi-language automation workflows
* Handle reporting and notifications
* Prepare for real-world QA environments

---
