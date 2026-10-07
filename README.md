
# saucedemo-automation

A Selenium WebDriver automation testing framework developed using Java, Selenium WebDriver, TestNG, and Maven to automate end-to-end test scenarios for the SauceDemo e-commerce application.



## 📌 Project Overview

This project is an end-to-end web automation testing framework developed for the **SauceDemo e-commerce application** using **Java, Selenium WebDriver, TestNG, and Maven**. The framework follows the **Page Object Model (POM)** design pattern to ensure clean, reusable, and maintainable automation code.

The project automates critical user workflows including **user authentication, product selection, shopping cart operations, and checkout**, while incorporating structured test execution and validation through TestNG assertions. The framework is designed with reusable components such as **BasePage and BaseTest**, providing a scalable foundation for expanding test coverage and integrating additional automation capabilities.
## 🎯 Objectives

- Develop a **maintainable and scalable Selenium automation framework** using Java, TestNG, and Maven.
- Implement the **Page Object Model (POM)** design pattern to improve code reusability and maintainability.
- Automate critical end-to-end user workflows of the SauceDemo e-commerce application.
- Validate application functionality using **TestNG assertions and structured test cases**.
- Implement reusable components for **WebDriver management, page interactions, and test setup/teardown**.
- Reduce repetitive manual testing by automating frequently executed functional and regression scenarios.
- Demonstrate practical knowledge of **Selenium WebDriver, TestNG, Maven, Java, and software testing practices**.
- Establish a foundation that can be extended with **data-driven testing, reporting, cross-browser testing, and CI/CD integration**.


## 🏗️ Framework Architecture

The framework follows a **Page Object Model (POM)** based architecture designed to provide better code organization, reusability, scalability, and maintainability. The framework separates test logic from page-specific elements and browser management, making the automation suite easier to maintain as test coverage grows.

### Architecture Flow

```text
                    ┌──────────────────────┐
                    │      TestNG Suite    │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │       BaseTest       │
                    │ WebDriver Setup/Cleanup│
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │       BasePage       │
                    │ Reusable Selenium    │
                    │ Interaction Methods  │
                    └──────────┬───────────┘
                               │
              ┌────────────────┼────────────────┐
              ▼                ▼                ▼
       ┌─────────────┐  ┌──────────────┐  ┌─────────────┐
       │  LoginPage  │  │ ProductsPage │  │   CartPage  │
       └─────────────┘  └──────────────┘  └─────────────┘
                                                │
                                                ▼
                                        ┌───────────────┐
                                        │ CheckoutPage  │
                                        └───────────────┘
                                                │
                                                ▼
                                      ┌──────────────────┐
                                      │    SauceDemo     │
                                      │ Web Application  │
                                      └──────────────────┘
```

### Core Components

#### 1. BaseTest

`BaseTest` acts as the foundation of the test execution layer. It manages the common browser lifecycle and test setup.

Responsibilities include:

- Initializing the Chrome WebDriver before test execution.
- Configuring the browser window.
- Launching the SauceDemo application.
- Providing the WebDriver instance to page objects.
- Performing browser cleanup after test execution.

This prevents browser setup and teardown code from being duplicated across individual test classes.

#### 2. BasePage

`BasePage` is the parent class for all page objects and contains reusable Selenium functionality.

It provides a common WebDriver reference that can be used by classes such as `LoginPage`, `ProductsPage`, `CartPage`, and `CheckoutPage`.

Typical responsibilities include:

- WebDriver management within page objects.
- Common element interaction methods.
- Navigation and page-level operations.
- Reusable Selenium utilities.

This follows the **DRY (Don't Repeat Yourself)** principle and keeps page classes focused on application-specific behavior.

#### 3. Page Objects

Each major page of the SauceDemo application is represented by an independent Page Object.

**LoginPage**
- Handles username and password input.
- Performs login operations.
- Validates login-related behavior.

**ProductsPage**
- Handles product interactions.
- Allows products to be selected and added to the cart.
- Performs product-related validations.

**CartPage**
- Handles shopping cart operations.
- Verifies selected products.
- Supports cart-related actions.

**CheckoutPage**
- Handles checkout information.
- Performs checkout operations.
- Validates the final order confirmation.

Separating each page into its own class makes the framework easier to understand and maintain when the application's UI changes.

#### 4. Test Classes

Test classes contain the actual **test scenarios and validations**.

The test layer is responsible for defining:

- Test conditions
- User workflows
- Expected results
- Assertions
- Test execution order where required

The test classes interact with Page Objects instead of directly interacting with Selenium locators. This keeps test cases readable and separates **test logic from UI implementation details**.

### 🔄 Execution Flow

A typical test execution follows this flow:

```text
TestNG
   ↓
BaseTest
   ↓
Initialize WebDriver
   ↓
Launch SauceDemo
   ↓
Create Page Objects
   ↓
Execute User Actions
   ↓
Perform Assertions
   ↓
Test Result
   ↓
Close Browser
```
## 📂 Project Structure

The project follows a modular structure that separates test cases, page objects, test configuration, and framework components. This organization improves readability, maintainability, and scalability as the automation suite grows.

```text
saucedemo-automation/
│
├── src/
│   │
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   └── BasePage.java
│   │   │   │
│   │   │   ├── pages/
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── ProductsPage.java
│   │   │   │   ├── CartPage.java
│   │   │   │   └── CheckoutPage.java
│   │   │   │
│   │   │   └── utils/
│   │   │       ├── ConfigReader.java
│   │   │       └── DriverFactory.java
│   │   │
│   │   └── resources/
│   │       └── config.properties
│   │
│   └── test/
│       │
│       ├── java/
│       │   ├── base/
│       │   │   └── BaseTest.java
│       │   │
│       │   └── tests/
│       │       ├── LoginTest.java
│       │       ├── ProductsTest.java
│       │       ├── CartTest.java
│       │       └── CheckoutTest.java
│       │
│       └── resources/
│
├── target/
├── test-output/
├── pom.xml
├── testng.xml
└── README.md
```

### 📁 Directory Responsibilities

**`pages/`**  
Contains Page Object classes representing individual pages of the SauceDemo application. Each class encapsulates page-specific locators and user interactions.

**`base/`**  
Contains reusable framework components such as `BasePage` and `BaseTest`, responsible for common Selenium operations and test lifecycle management.

**`tests/`**  
Contains TestNG test classes that define the actual test scenarios, workflows, and assertions.

**`pom.xml`**  
Manages project dependencies, plugins, and Maven build configuration.

**`testng.xml`**  
Defines the TestNG test suite and controls test execution.

**`README.md`**  
Provides project documentation, setup instructions, framework architecture, test coverage, and execution details.

## ⚙️ Tech Stack
- Java – Core programming language used to develop the automation framework, Page Objects, utilities, and test cases.
- Selenium WebDriver – Used for browser automation, web element interaction, and end-to-end validation of the SauceDemo application.
- TestNG – Used for test execution, assertions, test organization, and test lifecycle management.
- Maven – Used for dependency management, project build configuration, and automated test execution.
- Page Object Model (POM) – Design pattern used to separate page-specific interactions from test logic, improving code reusability and maintainability.
- ChromeDriver – Used to enable Selenium WebDriver automation with the Google Chrome browser.
- DriverFactory – Provides centralized WebDriver initialization and browser management within the framework.
- ConfigReader – Reads and manages external configuration values from the config.properties file.
- Git – Used for source code version control and tracking project changes.
- GitHub – Used for repository hosting, version management, and project collaboration.


## ⚙️ Setup and Test Execution

### Prerequisites

Make sure the following are installed:

- Java 17 or higher
- Maven 3.8 or higher
- Google Chrome
- Git

### Clone the Repository

```bash
git clone https://github.com/sanjay-gk/saucedemo-automation.git
cd saucedemo-automation
```

### Verify Java and Maven

Check that Java is installed correctly:

```bash
java -version
```

Check that Maven is installed correctly:

```bash
mvn -version
```

The project is configured to use Java 17 as the minimum Java version.

### Configuration

The SauceDemo application URL and login credentials are stored in:

```text
src/main/resources/config.properties
```

The configuration contains:

```properties
url=https://www.saucedemo.com
username=standard_user
password=secret_sauce
```

Keeping these values in a separate configuration file prevents them from being hard-coded inside the test classes.

### Run All Tests

To execute the complete TestNG test suite, run:

```bash
mvn clean test
```

This command will:

1. Clean previously generated build files.
2. Compile the Java source code.
3. Start the Chrome browser using Selenium WebDriver.
4. Execute all TestNG test cases.
5. Generate the test execution reports.

### Run Tests Without Cleaning

You can also run the tests directly using:

```bash
mvn test
```

This executes the test suite without first deleting the existing `target` directory.

### Expected Test Result

A successful execution should display:

```text
Tests run: 8, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

The project currently contains 8 automated test cases covering:

- Valid login
- Invalid login
- Empty login fields
- Product sorting by price
- Add product to cart
- Remove product from cart
- Complete checkout
- Logout

### Test Reports

After executing the tests, Maven Surefire generates test results inside:

```text
target/surefire-reports/
```

The directory contains the generated TestNG/Maven test execution reports.

### Running the Project from Eclipse

The tests can also be executed directly from Eclipse.

1. Import the project as an existing Maven project.
2. Wait for Maven dependencies to download.
3. Right-click the test class or test suite.
4. Select:

```text
Run As → TestNG Test
```

The test classes can be executed individually or as a complete TestNG suite.

### Browser Requirements

The tests use Google Chrome with Selenium WebDriver.

Make sure Google Chrome is installed on the system before running the tests.

Selenium Manager handles the browser driver setup automatically when the tests are executed.

### Troubleshooting

If Maven is not recognized, verify that Maven is installed and added to the system PATH:

```bash
mvn -version
```

If Java is not recognized, verify the Java installation:

```bash
java -version
```

If the tests fail because of a browser or driver issue, make sure Google Chrome is installed and up to date.

For a clean re-run, execute:

```bash
mvn clean test
```
## 🧪 Test Execution Results

| Test Module | Test Class | Status |
|---|---|---|
| 🔐 Login | `LoginTest.java` | ✅ Passed |
| 🛍️ Products | `ProductsTest.java` | ✅ Passed |
| 🛒 Cart | `CartTest.java` | ✅ Passed |
| 💳 Checkout | `CheckoutTest.java` | ✅ Passed |

### 📸 Test Execution Evidence

#### Eclipse Console

![Eclipse Console](https://github.com/user-attachments/assets/6fbf6e15-860e-4774-af82-c987f53f0912)

#### Maven Test Execution

![Maven Test Execution](https://github.com/user-attachments/assets/06daceb6-370d-4cd7-ace2-165cf326869d)

#### SauceDemo Application

![SauceDemo Application](https://github.com/user-attachments/assets/a3d6730e-286f-45b4-84f1-822bcc46b391)

### ✅ Result

The automation suite successfully executed all defined test scenarios with a **100% pass rate**, validating the core end-to-end workflows of the SauceDemo application.