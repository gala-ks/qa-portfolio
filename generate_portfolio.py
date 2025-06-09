import os

# Define the folder and file structure inside the current repo (qa-portfolio)
structure = {
    "ManualTesting": [
        "LoginTestCases.xlsx",
        "ShoppingCart_TestPlan.docx",
        "BugReport_OrangeHRM.pdf"
    ],
    "SeleniumAutomation_Java": [
        "LoginTest.java",
        "AddToCartTest.java",
        "pom.xml"
    ],
    "SeleniumAutomation_Python": [
        "login_test.py",
        "conftest.py",
        "requirements.txt"
    ],
    "APITesting_Postman": {
        "Collections": [
            "SampleAPI_Test.postman_collection.json"
        ],
        "Environment": [
            "TestEnvironment.postman_environment.json"
        ]
    },
    "Docs": [
        "Resume_QA.pdf"
    ],
    ".": [  # Files at the root of the repo
        "README.md"
    ]
}

# README content
readme_content = """# 🧪 QA Engineer Portfolio – [Galina W.](https://www.linkedin.com/in/galinaprofile)

Welcome to my software testing portfolio! I am a former Java Developer and Python Instructor transitioning into a Software Test Engineer role.  
This repository contains practical examples of manual testing, Selenium automation (Java & Python), and API testing using Postman.

## 📂 Manual Testing
- Test plans, bug reports, and test cases for sample web applications.

## 🤖 Automation Testing – Selenium
- Selenium WebDriver projects using Java with TestNG & Maven.
- Python automation projects with pytest framework.

## 🌐 API Testing – Postman
- REST API test collections with environments and sample test cases.

## 📄 Documents
- My QA-focused resume and project overviews.

## 📫 Contact
- 💼 Connect with me on [LinkedIn – Galina W.](https://www.linkedin.com/in/galinaprofile)
"""

def create_structure(base_path, structure):
    for name, content in structure.items():
        path = os.path.join(base_path, name)
        if isinstance(content, dict):
            os.makedirs(path, exist_ok=True)
            create_structure(path, content)
        elif isinstance(content, list):
            if name != ".":
                os.makedirs(path, exist_ok=True)
            else:
                path = base_path
            for file_name in content:
                file_path = os.path.join(path, file_name)
                if file_name == "README.md":
                    with open(file_path, 'w', encoding='utf-8') as f:
                        f.write(readme_content)
                else:
                    open(file_path, 'a').close()

# Create the structure starting from current directory (repo root)
create_structure('.', structure)
print("QA portfolio structure and README.md created with LinkedIn contact.")
