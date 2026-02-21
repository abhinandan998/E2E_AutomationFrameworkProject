<div align="center">

# 🚀 E2E Automation Framework Project

### Enterprise-Grade End-to-End Test Automation Framework

[![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.40-brightgreen?style=for-the-badge&logo=selenium)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.12-red?style=for-the-badge)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-Build-blue?style=for-the-badge&logo=apache-maven)](https://maven.apache.org/)
[![LambdaTest](https://img.shields.io/badge/LambdaTest-Cloud-blueviolet?style=for-the-badge)](https://www.lambdatest.com/)
[![GitHub Actions](https://img.shields.io/badge/GitHub%20Actions-CI%2FCD-2088FF?style=for-the-badge&logo=github-actions)](https://github.com/features/actions)
[![Jenkins](https://img.shields.io/badge/Jenkins-CI-D24939?style=for-the-badge&logo=jenkins)](https://www.jenkins.io/)
[![AWS](https://img.shields.io/badge/AWS-Ubuntu%20Server-FF9900?style=for-the-badge&logo=amazon-aws)](https://aws.amazon.com/)

<br/>

> **A production-ready, scalable, and maintainable End-to-End Selenium WebDriver automation framework**
> built with Java 21, TestNG, Maven, and integrated with LambdaTest Cloud, GitHub Actions, Jenkins CI/CD,
> and AWS EC2 — following enterprise OOP design patterns and zero-flaky-test policy.

<br/>

[![GitHub Profile](https://img.shields.io/badge/GitHub-abhinandan998-181717?style=for-the-badge&logo=github)](https://github.com/abhinandan998)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Abhinandan%20Basu-0077B5?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/abhinandan-basu/)

</div>

---

## 📋 Table of Contents

1. [Project Overview](#-project-overview)
2. [Technology Stack](#-technology-stack)
3. [Project Architecture](#-project-architecture)
4. [Object-Oriented Programming (OOP) Concepts](#-object-oriented-programming-oop-concepts)
5. [Framework Components](#-framework-components)
6. [Test Scenarios Covered](#-test-scenarios-covered)
7. [CI/CD — GitHub Actions](#-cicd--github-actions)
8. [Jenkins Integration & Cron Setup](#-jenkins-integration--cron-setup)
9. [Cloud Testing — LambdaTest](#-cloud-testing--lambdatest)
10. [AWS EC2 — Ubuntu Server Setup](#-aws-ec2--ubuntu-server-setup)
11. [Flaky Test Elimination](#-flaky-test-elimination)
12. [Multi-Environment Configuration](#-multi-environment-configuration)
13. [Reporting & Logging](#-reporting--logging)
14. [Getting Started](#-getting-started)
15. [Running Tests](#-running-tests)
16. [Project Structure](#-project-structure)
17. [Connect With Me](#-connect-with-me)

---

## 🌟 Project Overview

This framework automates **End-to-End testing** for a full e-commerce web application covering the complete user journey:

```
User Login → Product Search → Product Selection → Shopping Cart → Address Entry → Checkout → Order Confirmation
```

**Key Highlights:**
- ✅ **Zero flaky tests** — all intermittent failures identified and eliminated
- ✅ **Thread-safe parallel execution** — up to 8 parallel threads using `ThreadLocal<WebDriver>`
- ✅ **Cross-browser support** — Chrome, Firefox, Edge (local + headless)
- ✅ **Cloud execution** — LambdaTest cloud grid with 25+ browser/OS combinations
- ✅ **Multi-environment** — DEV, QA, UAT environment support via `.properties` files
- ✅ **Automated CI/CD** — GitHub Actions pipeline with scheduled cron jobs
- ✅ **Jenkins pipeline** — Parameterized builds with cron scheduling
- ✅ **AWS EC2 Ubuntu** — Remote execution on dedicated Ubuntu server
- ✅ **Rich HTML reports** — ExtentReports with screenshots attached on failure
- ✅ **Structured logging** — Log4j2 for debug-ready structured logs

---

## 🛠 Technology Stack

| Category | Technology | Version |
|----------|-----------|---------|
| **Language** | Java | 21 |
| **Build Tool** | Apache Maven | 3.x |
| **Test Framework** | TestNG | 7.12.0 |
| **Browser Automation** | Selenium WebDriver | 4.40.0 |
| **Cloud Grid** | LambdaTest | Latest |
| **Reporting** | ExtentReports (Aventstack) | 5.1.2 |
| **Logging** | Apache Log4j2 | 2.25.3 |
| **Data Format (JSON)** | Google Gson | 2.13.2 |
| **Data Format (CSV)** | OpenCSV | 5.12.0 |
| **Data Format (Excel)** | Apache POI / POI-OOXML | 5.5.1 |
| **Test Data Generator** | JavaFaker | 1.0.2 |
| **CI/CD** | GitHub Actions | v4 |
| **CI Server** | Jenkins | LTS |
| **Cloud Server** | AWS EC2 (Ubuntu) | 22.04 LTS |

---

## 🏗 Project Architecture

```
E2E_AutomationFrameworkProject/
│
├── .github/
│   └── workflows/
│       └── maven.yml               ← GitHub Actions CI/CD pipeline
│
├── Config/
│   ├── DEV.properties              ← Development environment config
│   ├── QA.properties               ← QA environment config
│   ├── UAT.properties              ← UAT environment config
│   └── config.json                 ← Global JSON configuration
│
├── TestData/                       ← External test data (CSV, Excel, JSON)
│
├── logs/                           ← Log4j2 runtime log files
│
├── src/test/java/Abhinandan_Project/
│   │
│   ├── Constants/
│   │   └── Browser.java            ← Browser enum (CHROME, FIREFOX, EDGE)
│   │
│   ├── UI/
│   │   ├── DataProviders/
│   │   │   └── LoginDataProvider.java
│   │   │
│   │   ├── Listeners/
│   │   │   ├── TestListeners.java  ← TestNG ITestListener implementation
│   │   │   └── MyRetryAnalyzer.java← Flaky test retry logic
│   │   │
│   │   ├── POJOS/
│   │   │   ├── user.java           ← User POJO
│   │   │   ├── AddressPOJO.java    ← Address POJO
│   │   │   ├── Config.java         ← Config POJO
│   │   │   ├── Environment.java    ← Environment POJO
│   │   │   └── TestData.java       ← TestData POJO
│   │   │
│   │   ├── Pages/
│   │   │   ├── LoginPage.java
│   │   │   ├── HomePage.java
│   │   │   ├── searchResultPage.java
│   │   │   ├── ProductDetailPage.java
│   │   │   ├── ShoppingCartPage.java
│   │   │   ├── AddressPage.java
│   │   │   ├── ConfirmAddressPage.java
│   │   │   ├── ShippmentPage.java
│   │   │   └── MyAccountPage.java
│   │   │
│   │   └── Test/
│   │       ├── TestBase.java       ← Base test class (setup/teardown)
│   │       ├── LoginTest.java
│   │       ├── InvalidCredsLoginTest.java
│   │       ├── SearchProductTest.java
│   │       ├── ProductCheckOutTest.java
│   │       └── AddNewFirstAddressTest.java
│   │
│   └── Utility/
│       ├── BrowserUtility.java     ← Abstract core browser utility
│       ├── LambdaTestUtility.java  ← LambdaTest cloud integration
│       ├── ExtentReporterUtility.java
│       ├── LoggerUtility.java
│       ├── PropertiesUTIL.java
│       ├── JSONUtility.java
│       ├── ExcelReaderUtility.java
│       ├── csvReaderUtility.java
│       └── FakeAddressUtility.java ← JavaFaker-based data generator
│
├── pom.xml                         ← Maven build & dependency management
└── testng.xml                      ← Test suite configuration
```

---

## 🧩 Object-Oriented Programming (OOP) Concepts

This framework is a **living demonstration** of all four core OOP pillars applied in a real-world test automation context.

---

### 1. 🔒 Encapsulation

> **Bundling data and methods together, exposing only what's necessary through controlled access.**

**Implementation in this framework:**

The `BrowserUtility` class encapsulates all low-level WebDriver interactions. The `WebDriver` instance is declared `private static` inside a `ThreadLocal` — it cannot be accessed directly from outside. All interactions go through controlled public methods:

```java
public abstract class BrowserUtility {

    // PRIVATE — external code cannot access the driver directly
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // CONTROLLED access via public getter
    public WebDriver getDriver() {
        return driver.get();
    }

    // All WebDriver interactions are wrapped in meaningful methods
    public void clickOn(By locator) { ... }
    public void enterText(By locator, String text) { ... }
    public String takeScreenshot(String name) { ... }
}
```

The POJO classes (`user.java`, `AddressPOJO.java`, `Config.java`) encapsulate data fields with getters/setters, protecting data integrity and enabling safe deserialization by Gson.

---

### 2. 🧬 Inheritance

> **Child classes reuse and extend the behaviour of parent classes without code duplication.**

This framework uses a clean **3-level inheritance chain**:

```
BrowserUtility (abstract)  ←  All Page classes extend this
                                 │
                                 ├── LoginPage
                                 ├── HomePage
                                 ├── searchResultPage
                                 ├── ProductDetailPage
                                 ├── ShoppingCartPage
                                 ├── AddressPage
                                 ├── ConfirmAddressPage
                                 ├── ShippmentPage
                                 └── MyAccountPage
                                          ↑
                                   TestBase extends BrowserUtility
                                          ↑
                                   All Test classes extend TestBase
```

**Example — Page inherits from BrowserUtility:**

```java
public class LoginPage extends BrowserUtility {

    // Constructor calls parent's constructor — browser is initialized once
    public LoginPage(WebDriver driver) {
        super(driver);   // Calls BrowserUtility(WebDriver driver)
    }

    // Uses inherited methods — no duplicate WebDriver code
    public void enterUsername(String username) {
        enterText(By.id("id_email"), username);   // inherited from BrowserUtility
    }

    public void clickLoginButton() {
        clickOn(By.cssSelector("button[type='submit']")); // inherited
    }
}
```

**Example — TestBase manages lifecycle, tests inherit from it:**

```java
public class TestBase extends BrowserUtility {
    @BeforeMethod
    public void setup(String browser, String isLambdaTest, String isHeadless) {
        // Browser initialization once, reused by all test classes
    }

    @AfterMethod
    public void tearDown() {
        quit();  // from BrowserUtility
    }
}

public class LoginTest extends TestBase {
    // Fully inherits setup/teardown — focuses only on test logic
}
```

---

### 3. 🎭 Polymorphism

> **The same method name behaves differently based on parameters or the calling object.**

#### Method Overloading (Compile-time Polymorphism)

The `BrowserUtility` constructors are overloaded to accept different inputs:

```java
// Constructor 1: Accepts a WebDriver object (for LambdaTest remote)
public BrowserUtility(WebDriver driver) { ... }

// Constructor 2: Accepts browser name as String
public BrowserUtility(String BrowserName) { ... }

// Constructor 3: Accepts a type-safe Browser enum
public BrowserUtility(Browser BrowserName) { ... }

// Constructor 4: Accepts Browser enum + headless mode flag
public BrowserUtility(Browser BrowserName, boolean isHeadless) { ... }
```

`clickOn` and `getVisibleTest` methods are also overloaded to accept either a `By` locator or a `WebElement`:

```java
public void clickOn(By locator) { ... }         // Uses explicit wait
public void clickOn(WebElement element) { ... }  // Clicks pre-found element

public String getVisibleTest(By locator) { ... }
public String getVisibleTest(WebElement element) { ... }
```

#### Runtime Polymorphism (Method Overriding)

`TestListeners` overrides multiple methods from the `ITestListener` interface, providing framework-specific behaviour at runtime:

```java
public class TestListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) { /* Log test start */ }

    @Override
    public void onTestSuccess(ITestResult result) { /* Mark LambdaTest passed */ }

    @Override
    public void onTestFailure(ITestResult result) { /* Take screenshot, attach to report */ }

    @Override
    public void onTestSkipped(ITestResult result) { /* Log skip reason */ }
}
```

---

### 4. 🫙 Abstraction

> **Hiding complex implementation details and exposing only the essential functionality.**

#### Abstract Class — `BrowserUtility`

```java
public abstract class BrowserUtility {
    // All complex WebDriver setup, wait strategies, and JS execution are hidden here.
    // Page classes simply call: clickOn(locator), enterText(locator, text)
    // They don't know HOW Selenium works under the hood.
}
```

The abstract class **cannot be instantiated directly** — it forces all Page Objects to extend it and provides a guaranteed contract of browser interaction methods.

#### Interface-Based Abstraction — TestNG Listeners

```java
// TestNG defines the contract
public interface ITestListener {
    void onTestStart(ITestResult result);
    void onTestSuccess(ITestResult result);
    void onTestFailure(ITestResult result);
    // ...
}

// Framework provides concrete implementation
public class TestListeners implements ITestListener { ... }
```

#### Enum-Based Type Safety — `Browser`

```java
public enum Browser {
    CHROME, FIREFOX, EDGE
}
```

Enums abstract the concept of valid browsers — you can't accidentally pass `"Chrmoe"` (a typo) when using an enum.

---

### 5. 🔗 Additional OOP Concepts Applied

#### `ThreadLocal<WebDriver>` — Thread Safety in Parallel Execution

```java
private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
```

In a multi-threaded test suite (8 parallel threads), each thread gets its own `WebDriver` instance automatically via `ThreadLocal`. No `synchronized` blocks needed — this is a key OOP design decision for parallel safety.

#### POJO Design Pattern

All data objects (`user.java`, `AddressPOJO.java`, `Config.java`, `TestData.java`, `Environment.java`) follow the **Plain Old Java Object (POJO)** pattern:
- Private fields
- Public getters/setters
- Used with Google Gson for JSON deserialization

#### Composition

`TestBase` is **composed** of multiple utility objects:

```java
public class TestBase extends BrowserUtility {
    // Uses (composes) utility classes
    ExtentReporterUtility reporter;
    LambdaTestUtility ltUtil;
    PropertiesUTIL properties;
}
```

---

## 📄 Framework Components

### 🌐 BrowserUtility — Core Engine

The heart of the framework. An **abstract class** providing thread-safe browser control:

| Method | Description |
|--------|-------------|
| `goToWebsite(String url)` | Navigate to URL with logging |
| `clickOn(By / WebElement)` | Explicit wait + click (overloaded) |
| `enterText(By, String)` | Clear + type with StaleElement retry |
| `selectFromDropDown(By, String)` | Standard HTML `<select>` |
| `selectFromHiddenDropdown(By, String)` | JavaScript-based hidden dropdown |
| `selectStateFromUniform(String)` | JavaScript Uniform.js dropdown handler |
| `getVisibleTest(By / WebElement)` | Retrieve visible text (overloaded) |
| `getALLVisibleText(By)` | Collect all visible texts as List |
| `enterSpecialKey(By, Keys)` | Send keyboard special keys |
| `waitForPageToLoad()` | JS `document.readyState` complete check |
| `takeScreenshot(String)` | Timestamped screenshot capture |
| `quit()` | Thread-local driver cleanup |

### 📄 Page Object Model (POM)

Each page encapsulates its own locators and actions:

| Page | Responsibility |
|------|---------------|
| `LoginPage` | Email, password input, login button |
| `HomePage` | Search bar, navigation, product browsing |
| `searchResultPage` | Filter results, select product |
| `ProductDetailPage` | Product info, add to cart |
| `ShoppingCartPage` | Cart review, proceed to checkout |
| `AddressPage` | Fill shipping address form |
| `ConfirmAddressPage` | Confirm selected address |
| `ShippmentPage` | Select shipment method |
| `MyAccountPage` | Account navigation, address management |

### 🔧 Utility Layer

| Utility | Purpose |
|---------|---------|
| `BrowserUtility` | Abstract WebDriver wrapper |
| `LambdaTestUtility` | LambdaTest RemoteWebDriver, pass/fail marking |
| `ExtentReporterUtility` | HTML report initialization |
| `LoggerUtility` | Log4j2 logger factory |
| `PropertiesUTIL` | Load DEV/QA/UAT `.properties` files |
| `JSONUtility` | Gson-based JSON deserialization |
| `ExcelReaderUtility` | Apache POI Excel data reader |
| `csvReaderUtility` | OpenCSV data reader |
| `FakeAddressUtility` | JavaFaker test data generator |

---

## 🧪 Test Scenarios Covered

All test scenarios are **stable and flake-free**, covering positive, negative, and boundary flows:

### ✅ Authentication Tests
| Test Class | Scenario | Type |
|-----------|----------|------|
| `LoginTest` | Valid user login with data-driven credentials | Positive |
| `InvalidCredsLoginTest` | Login with wrong password — verify error message | Negative |
| `LoginTest` | Login with multiple user types (data provider) | Data-Driven |

### ✅ Product & Search Tests
| Test Class | Scenario | Type |
|-----------|----------|------|
| `SearchProductTest` | Search for a product by keyword | Positive |
| `SearchProductTest` | Verify search result page and product listing | Positive |
| `ProductCheckOutTest` | Search → Select product → Add to cart | E2E |

### ✅ Checkout Flow Tests
| Test Class | Scenario | Type |
|-----------|----------|------|
| `ProductCheckOutTest` | Full checkout flow: cart → address → shipment | E2E |
| `ProductCheckOutTest` | Verify order total, taxes, and shipment selection | Validation |

### ✅ Address Management Tests
| Test Class | Scenario | Type |
|-----------|----------|------|
| `AddNewFirstAddressTest` | Add a new shipping address to account | Positive |
| `AddNewFirstAddressTest` | Validate address with generated fake data | Data-Driven |

---

## ⚙️ CI/CD — GitHub Actions

The project uses a **fully automated GitHub Actions pipeline** defined in `.github/workflows/maven.yml`.

### Pipeline Triggers

```yaml
on:
  schedule:
    - cron: '00 18 * * *'   # Runs every day at 18:00 UTC (11:30 PM IST)
  push:
    branches: [ "main" ]     # Runs on every push to main
  pull_request:
    branches: [ "main" ]     # Runs on every PR to main
```

### Pipeline Steps

```
┌─────────────────────────────────────────────────┐
│             GitHub Actions Pipeline               │
├─────────────────────────────────────────────────┤
│  1. Checkout source code        (actions/checkout@v4)   │
│  2. Set up JDK 21               (actions/setup-java@v4) │
│  3. Run Tests via Maven         (mvn test -X)           │
│  4. Upload Test Logs            (always runs)           │
│  5. Upload Screenshots          (always runs)           │
│  6. Upload HTML Report          (always runs)           │
│  7. Copy report to gh-pages                             │
│  8. Deploy to GitHub Pages      (JamesIves action)      │
└─────────────────────────────────────────────────┘
```

### Execution Command

```bash
mvn test -X -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false
```

### GitHub Pages Deployment

After every run (pass or fail), the ExtentReport HTML is automatically deployed to **GitHub Pages** via `JamesIves/github-pages-deploy-action@v4.8.0`, making test results publicly accessible.

**Artifacts uploaded per run:**
- `Test logs` — Log4j2 application logs
- `screenshots` — Failure screenshots (timestamped)
- `html-report` — Full ExtentReport HTML

---

## 🔧 Jenkins Integration & Cron Setup

### Jenkins Pipeline Architecture

```
Jenkins Server
│
├── Job: E2E-Framework-Pipeline
│   ├── SCM: Git (GitHub repo)
│   ├── Build Trigger: Cron Schedule
│   └── Build Step: Maven
```

### Jenkins Pipeline Configuration

**Jenkinsfile (Declarative Pipeline):**

```groovy
pipeline {
    agent any

    parameters {
        string(name: 'BROWSER', defaultValue: 'chrome', description: 'Browser to use')
        booleanParam(name: 'IS_LAMBDATEST', defaultValue: true, description: 'Run on LambdaTest?')
        booleanParam(name: 'IS_HEADLESS', defaultValue: false, description: 'Run headless?')
    }

    triggers {
        // Cron: Every day at midnight
        cron('0 0 * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/abhinandan998/E2E_AutomationFrameworkProject.git'
            }
        }

        stage('Run Tests') {
            steps {
                sh """
                mvn test \
                  -Dbrowser=${params.BROWSER} \
                  -DisLambdaTest=${params.IS_LAMBDATEST} \
                  -DisHeadless=${params.IS_HEADLESS}
                """
            }
        }

        stage('Publish Reports') {
            steps {
                publishHTML([
                    reportDir: '.',
                    reportFiles: 'report.html',
                    reportName: 'ExtentReport'
                ])
                archiveArtifacts artifacts: 'logs/**, screenshots/**'
            }
        }
    }

    post {
        always {
            emailext(
                subject: "Test Execution: ${currentBuild.result}",
                body: "Build #${env.BUILD_NUMBER} completed with status: ${currentBuild.result}",
                to: 'abhinandan@example.com'
            )
        }
    }
}
```

### Jenkins Cron Schedule Reference

```
┌───── Minute  (0–59)
│ ┌───── Hour    (0–23)
│ │ ┌───── Day of Month (1–31)
│ │ │ ┌───── Month      (1–12)
│ │ │ │ ┌───── Day of Week (0–7, 0 & 7 = Sunday)
│ │ │ │ │
│ │ │ │ │
0 0 * * *   → Every day at midnight
0 18 * * *  → Every day at 6:00 PM (matches GitHub Actions)
0 8 * * 1-5 → Every weekday at 8:00 AM
H/30 * * * * → Every 30 minutes (Jenkins H-syntax)
```

**Key Jenkins Plugins Used:**
- **Maven Integration Plugin** — Maven build support
- **HTML Publisher Plugin** — ExtentReport rendering
- **Git Plugin** — GitHub SCM polling
- **Email Extension Plugin** — Notification on pass/fail
- **Parameterized Trigger Plugin** — Cross-job triggering

---

## ☁️ Cloud Testing — LambdaTest

### Why LambdaTest?

| Feature | Local | LambdaTest Cloud |
|---------|-------|-----------------|
| Browsers | 3 installed | 3000+ combinations |
| OS coverage | Windows/Mac local | Windows, Mac, Linux |
| Parallel tests | Limited by RAM | Up to 25 concurrent |
| Session video | ❌ | ✅ Full video recording |
| Network logs | ❌ | ✅ HAR files |
| Accessibility | ❌ | ✅ Built-in |
| CI integration | Manual | ✅ Native GitHub Actions |

### LambdaTest Integration

The `LambdaTestUtility` class configures the `RemoteWebDriver` with LambdaTest capabilities:

```java
public class LambdaTestUtility {

    public static WebDriver initLambdaTestDriver(String browserName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Authentication
        String username = System.getenv("LT_USERNAME");
        String accessKey = System.getenv("LT_ACCESS_KEY");

        // Browser & OS configuration
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("version", "latest");
        capabilities.setCapability("platform", "Windows 10");

        // LambdaTest-specific
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("build", "E2E-Framework-Build");
        ltOptions.put("name", "E2E Automation Test");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        capabilities.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(
            new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"),
            capabilities
        );
    }

    // Pass/Fail marking via JavascriptExecutor
    public static void markTestStatus(WebDriver driver, String status, String reason) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("lambda-status=" + status);
    }
}
```

### Running on LambdaTest

```bash
# Via Maven CLI
mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false

# Via GitHub Actions (automatic)
# Triggered on push to main or daily at 18:00 UTC
```

### Supported Browser/OS Matrix on LambdaTest

| Browser | Windows 10 | Windows 11 | macOS Monterey | Ubuntu |
|---------|-----------|------------|----------------|--------|
| Chrome (Latest) | ✅ | ✅ | ✅ | ✅ |
| Firefox (Latest) | ✅ | ✅ | ✅ | ✅ |
| Edge (Latest) | ✅ | ✅ | ✅ | ✅ |

---

## 🖥️ AWS EC2 — Ubuntu Server Setup

Tests are executed on a dedicated **AWS EC2 Ubuntu 22.04 LTS** instance for consistent, isolated remote execution.

### EC2 Instance Setup

```bash
# 1. Update system packages
sudo apt-get update && sudo apt-get upgrade -y

# 2. Install Java 21 (Temurin)
sudo apt-get install -y wget apt-transport-https
wget -qO - https://packages.adoptium.net/artifactory/api/gpg/key/public | sudo apt-key add -
echo "deb https://packages.adoptium.net/artifactory/deb $(lsb_release -cs) main" | sudo tee /etc/apt/sources.list.d/adoptium.list
sudo apt-get update
sudo apt-get install -y temurin-21-jdk

# 3. Install Maven
sudo apt-get install -y maven

# 4. Verify installations
java -version    # Should show: openjdk 21
mvn -version     # Should show: Apache Maven 3.x

# 5. Install Google Chrome
wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | sudo apt-key add -
echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" | sudo tee /etc/apt/sources.list.d/google-chrome.list
sudo apt-get update
sudo apt-get install -y google-chrome-stable

# 6. Clone the project
git clone https://github.com/abhinandan998/E2E_AutomationFrameworkProject.git
cd E2E_AutomationFrameworkProject

# 7. Run tests (headless mode for server environment)
mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=true
```

### AWS EC2 GitHub Actions Integration

The GitHub Actions workflow runs on `ubuntu-latest` — which mirrors the EC2 Ubuntu environment:

```yaml
jobs:
  build:
    runs-on: ubuntu-latest   # AWS-equivalent Ubuntu server
    steps:
      - uses: actions/checkout@v4
      - name: Set up JDK 21
        uses: actions/setup-java@v4
        with:
          java-version: '21'
          distribution: 'temurin'
```

### Why Ubuntu on AWS?

| Factor | Benefit |
|--------|---------|
| **Consistency** | Matches GitHub Actions `ubuntu-latest` — no environment drift |
| **Performance** | EC2 compute optimized instances for faster test execution |
| **Isolation** | Clean environment, no dependency interference |
| **Scalability** | Scale EC2 instance type based on test load |
| **Cost** | Pay-per-use — spin up for tests, stop when done |
| **Security** | AWS VPC, security groups for controlled access |

---

## 🛡️ Flaky Test Elimination

Flaky tests undermine confidence in automation. This framework applies multiple strategies to achieve **100% stable test results**:

### Strategy 1: Explicit Waits Over Implicit/Thread.sleep

```java
// ❌ BAD — Fixed wait, unreliable
Thread.sleep(3000);

// ✅ GOOD — Wait until condition is true
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
```

### Strategy 2: StaleElementReference Retry

```java
public void enterText(By locator, String textToEnter) {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    wait.until(driver -> {
        try {
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(textToEnter);
            return true;
        } catch (StaleElementReferenceException e) {
            logger.warn("Stale element detected. Retrying...");
            return false;  // wait retries automatically
        }
    });
}
```

### Strategy 3: Page Load Synchronization

```java
public void waitForPageToLoad() {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
    wait.until(driver ->
        ((JavascriptExecutor) driver)
            .executeScript("return document.readyState")
            .equals("complete")
    );
}
```

### Strategy 4: Retry Analyzer for Genuinely Intermittent Tests

```java
public class MyRetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;
    private static final int MAX_RETRY = 2;  // Retry up to 2 times

    @Override
    public boolean retry(ITestResult result) {
        if (count < MAX_RETRY) {
            count++;
            return true;   // Retry on failure
        }
        return false;
    }
}
```

### Strategy 5: JavaScript Execution for Hidden Elements

```java
// For custom JS dropdowns that standard Selenium can't interact with
public void selectFromHiddenDropdown(By selectLocator, String visibleText) {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    String script =
        "var select = arguments[0];" +
        "for (var i = 0; i < select.options.length; i++) {" +
        "  if (select.options[i].text === arguments[1]) {" +
        "    select.selectedIndex = i;" +
        "    select.dispatchEvent(new Event('change'));" +
        "    break;" +
        "  }" +
        "}";
    js.executeScript(script, selectElement, visibleText);
}
```

### Strategy 6: ThreadLocal for Parallel Safety

```java
// Each of the 8 parallel threads gets its OWN WebDriver
private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
```

No shared state between test threads — eliminates race conditions entirely.

---

## 🌍 Multi-Environment Configuration

The framework supports **DEV, QA, and UAT** environments through `.properties` files:

```properties
# Config/QA.properties
base.url=https://qa.yourapp.com
username=qa_user@example.com
password=QAPassword123
```

```properties
# Config/UAT.properties
base.url=https://uat.yourapp.com
username=uat_user@example.com
password=UATPassword456
```

```java
// PropertiesUTIL.java dynamically loads the right config
public class PropertiesUTIL {
    public static Properties loadProperties(String env) {
        Properties props = new Properties();
        props.load(new FileInputStream("Config/" + env + ".properties"));
        return props;
    }
}
```

**TestNG XML parameters drive environment selection:**

```xml
<suite name="All Test Suite" parallel="methods" thread-count="8">
    <test name="E2E_AutomationFrameworkProject">
        <parameter name="browser" value="${browser}"/>
        <parameter name="isLambdaTest" value="${isLambdaTest}"/>
        <parameter name="isHeadless" value="${isHeadless}"/>
        <classes>
            <class name="Abhinandan_Project.UI.Test.LoginTest"/>
        </classes>
    </test>
</suite>
```

---

## 📊 Reporting & Logging

### ExtentReports (HTML)

Each test run generates a rich `report.html` with:

- ✅ Pass / ❌ Fail / ⏩ Skip status per test
- 📸 Screenshots embedded for failed tests
- 🕐 Timestamp and duration per test
- 🖥️ Browser and environment metadata
- 📋 Step-level logs from Log4j2

```java
public class TestListeners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // 1. Take screenshot
        String screenshotPath = browserUtility.takeScreenshot(result.getName());

        // 2. Attach to ExtentReports
        ExtentReports extent = ExtentReporterUtility.getExtentReport();
        extent.createTest(result.getName())
              .fail(result.getThrowable())
              .addScreenCaptureFromPath(screenshotPath);

        // 3. Mark LambdaTest as failed
        LambdaTestUtility.markTestStatus(driver, "failed", result.getThrowable().getMessage());
    }
}
```

### Log4j2 Structured Logging

```java
// LoggerUtility.java — factory for typed loggers
public class LoggerUtility {
    public static Logger getogger(Class<?> className) {
        return LogManager.getLogger(className);
    }
}

// Usage throughout the framework:
logger.info("Launching Browser for: " + BrowserName);
logger.warn("Stale element detected. Retrying...");
logger.error("Invalid Browser Name! Please select chrome or edge");
```

Log files are written to `logs/` directory and uploaded as GitHub Actions artifacts after every run.

---

## 🚀 Getting Started

### Prerequisites

| Requirement | Version |
|------------|---------|
| Java JDK | 21+ |
| Apache Maven | 3.6+ |
| Google Chrome | Latest |
| Git | Latest |
| LambdaTest Account | (for cloud runs) |

### Installation

```bash
# Clone the repository
git clone https://github.com/abhinandan998/E2E_AutomationFrameworkProject.git

# Navigate to project directory
cd E2E_AutomationFrameworkProject

# Install dependencies
mvn clean install -DskipTests
```

### Environment Variables (for LambdaTest)

```bash
# Windows (PowerShell)
$env:LT_USERNAME = "your_lambdatest_username"
$env:LT_ACCESS_KEY = "your_lambdatest_access_key"

# Linux / macOS / AWS Ubuntu
export LT_USERNAME="your_lambdatest_username"
export LT_ACCESS_KEY="your_lambdatest_access_key"
```

---

## ▶️ Running Tests

### 1. Local Chrome

```bash
mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=false
```

### 2. Local Headless Chrome (for CI/server)

```bash
mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true
```

### 3. Local Edge

```bash
mvn test -Dbrowser=edge -DisLambdaTest=false -DisHeadless=false
```

### 4. LambdaTest Cloud — Chrome

```bash
mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false
```

### 5. LambdaTest Cloud — Firefox

```bash
mvn test -Dbrowser=firefox -DisLambdaTest=true -DisHeadless=false
```

### 6. Full Debug Run (verbose Maven output)

```bash
mvn test -X -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false
```

---

## 📁 Project Structure

```
E2E_AutomationFrameworkProject/
│
├── 📂 .github/workflows/maven.yml   ← GitHub Actions CI/CD
├── 📂 Config/                        ← Environment properties
│   ├── DEV.properties
│   ├── QA.properties
│   ├── UAT.properties
│   └── config.json
│
├── 📂 TestData/                      ← CSV, Excel, JSON test data
├── 📂 logs/                          ← Log4j2 outputs
│
├── 📂 src/test/java/Abhinandan_Project/
│   ├── 📂 Constants/                 ← Browser enum
│   ├── 📂 UI/
│   │   ├── 📂 DataProviders/         ← TestNG @DataProvider
│   │   ├── 📂 Listeners/             ← ITestListener, IRetryAnalyzer
│   │   ├── 📂 POJOS/                 ← Data model classes
│   │   ├── 📂 Pages/                 ← Page Object Model (9 pages)
│   │   └── 📂 Test/                  ← Test classes (5 test files + TestBase)
│   └── 📂 Utility/                   ← 9 utility classes
│
├── pom.xml                           ← Maven build config
├── testng.xml                        ← Test suite, parallel config
└── report.html                       ← Latest ExtentReport
```

---

## 👤 Connect With Me

<div align="center">

| Platform | Link |
|----------|------|
| 🐙 **GitHub** | [github.com/abhinandan998](https://github.com/abhinandan998) |
| 💼 **LinkedIn** | [linkedin.com/in/abhinandan-basu](https://www.linkedin.com/in/abhinandan-basu/) |
| 📦 **Project Repo** | [E2E_AutomationFrameworkProject](https://github.com/abhinandan998/E2E_AutomationFrameworkProject) |

<br/>

**If you find this project useful, please consider giving it a ⭐ on GitHub!**

<br/>

[![GitHub](https://img.shields.io/badge/GitHub-abhinandan998-181717?style=for-the-badge&logo=github)](https://github.com/abhinandan998)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Abhinandan%20Basu-0077B5?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/abhinandan-basu/)

</div>

---

<div align="center">

*Built with ❤️ by Abhinandan Basu | SDET Engineer*

*Java · Selenium · TestNG · Maven · LambdaTest · GitHub Actions · Jenkins · AWS*

</div>
