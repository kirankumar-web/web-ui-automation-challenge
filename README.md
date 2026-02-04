
# Web UI Automation Challenge 

![Java](https://img.shields.io/badge/Java-17-orange)
![Maven](https://img.shields.io/badge/Maven-3.8+-blue)
![TestNG](https://img.shields.io/badge/TestNG-Framework-green)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-brightgreen)
![Reports](https://img.shields.io/badge/Reports-Extent%20%7C%20Allure-purple)

A **Selenium UI automation framework** built using **Java, TestNG, and Maven**, with **Extent Reports** and **Allure Reports** integrated for rich test reporting.

The framework supports **parallel execution**, **screenshots on failure**, and **CLI execution via Maven**.

---

## 🛠 Tech Stack

- **Language:** Java 17  
- **Build Tool:** Maven  
- **Test Framework:** TestNG  
- **UI Automation:** Selenium WebDriver  
- **Driver Management:** WebDriverManager  
- **Reporting:**  
  - Extent Reports (HTML)  
  - Allure Reports (Interactive Dashboard)

---

## 📂 Project Structure

│ ├── pom.xml ├── README.md │ ├── src │ ├── main │ │ └── java │ │ └── com.kroll.Automation.Framework │ │ ├── Base │ │ ├── Driver │ │ ├── Pages │ │ ├── Listners │ │ │ └── TestListener.java │ │ └── Utils │ │ ├── ExtentManager.java │ │ └── ScreenshotUtils.java │ │ │ └── test │ ├── java │ │ └── com.kroll.Automation.tests │ │ └── DemoSiteUITests.java │ │ │ └── resources │ └── testng.xml │ ├── test-output │ └── ExtentReport.html │ ├── reports │ └── screenshots │ └── target └── allure-results


## ⚙️ Prerequisites

Ensure the following are installed:

- Java **17+**
- Maven **3.8+**
- Chrome / supported browser
- Allure CLI (optional, for viewing reports locally)

### Install Allure CLI (macOS)

```bash
brew install allure

▶️ How to Run Tests
Run all tests from the project root:

mvn clean test
This will:
* Launch the browser
* Execute TestNG tests
* Generate Extent Report
* Generate Allure results

📊 Reports
✅ Extent Report (HTML)
* Generated automatically after test execution
* Location:

test-output/ExtentReport.html
Open from terminal (macOS):

open test-output/ExtentReport.html

✅ Allure Report
After running the tests:

mvn allure:serve
This will:
* Generate the Allure report
* Open it in your default browser
Allure results directory:

target/allure-results

📸 Screenshots on Failure
* Screenshots are automatically captured on test failure
* Integrated into:
    * Extent Report (file-based screenshots)
    * Allure Report (byte attachments)
Screenshot location:

reports/screenshots/

 TestNG Listener
The framework uses a custom TestNG listener located in the main source set:
* TestListener
    * Handles:
        * Extent report logging
        * Screenshot capture
        * Allure attachments
        * Thread-safe reporting
        * Report flushing
Listeners are configured via testng.xml.

 Parallel Execution
Parallel execution is enabled using TestNG configuration:

<suite name="Suite" parallel="tests" thread-count="5">
Thread safety is achieved using:
* ThreadLocal<WebDriver>
* ThreadLocal<ExtentTest>

 Key Features
* Page Object Model (POM)
* Parallel test execution
* Automatic WebDriver management
* Extent + Allure reporting
* Screenshots on failure
* Maven CLI execution
* Clean and scalable architecture

 Future Enhancements
* Retry analyzer support
* Step-level logging in Allure
* Cross-browser execution
* CI/CD integration (Jenkins / GitHub Actions)
* Docker support

👤 Author
KiranKumar Yadav
SDET-II Engineer – UI & API Automation

