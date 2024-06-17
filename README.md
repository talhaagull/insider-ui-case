# Insider UI Case

## Overview

This repository contains an automated testing framework for verifying the functionality of the Insider website using Java, Selenium, Maven, and TestNG. The framework follows best practices such as the Page Object Model (POM) and Singleton design patterns to ensure scalability, maintainability, and efficiency.

## Features

- **Java & Selenium**: Core technologies for web automation.
- **Maven**: Dependency management.
- **TestNG**: Test execution and management.
- **ExtentReports**: Detailed and visually appealing test reports.

## Design Patterns

### Page Object Model (POM)
The POM design separates test code from the code that interacts with web elements, making tests more organized and maintainable.

### PageFactory
A design pattern that simplifies the creation of page objects, using annotations to map elements and actions.

### Singleton Driver
Ensures a single instance of the WebDriver is used across tests, improving efficiency and manageability.

### Utilities
Reusable utility classes are provided for common functionalities, reducing code duplication and enhancing test maintainability.


## Setup

1. **Clone the repository:**
    ```bash
    git clone https://github.com/talhaagull/insider-ui-case.git
    ```

2. **Update configuration:**
    - Edit `configuration.properties` to set the browser type (chrome/firefox).

3. **Run the tests:**
    - Navigate to project root directory and execute the `test.xml` file.
    ```xml
    <suite name="Insider Website Test">
        <test name="Test">
            <classes>
                <class name="tests.InsiderWebsiteTest"></class>
            </classes>
        </test>
    </suite>
    ```

## Key Components

### Common Methods
- Located in `utilities.CommonMethods`
- Contains reusable methods for browser interactions, waits, and more.

### Singleton Design Pattern
- Implemented in `utilities.Driver`
- Manages a single WebDriver instance across tests.

### Configuration Properties
- `configuration.properties` file allows setting browser type and other configurations.

### TestBase Class
- Found in `utilities.TestBase`
- Manages setup and teardown operations for tests.

### Screenshot on Failure
- Captures screenshots on test failures for debugging purposes.

### ExtentReports
- Generates detailed test reports.
- Reports can be viewed in the `test-output` directory.


## Test Scenarios

1. **Home Page Verification**
    - Visit [Insider](https://useinsider.com/) and check Insider home page is opened or not.
2. **Career Page Navigation**
    - Select the “Company” menu in the navigation bar, select “Careers” and check Career page, its Locations, Teams, and Life at Insider blocks are open or not.
3. **Quality Assurance Page Navigation and Jobs Presence Verification**
    - Go to [Quality Assurance Careers](https://useinsider.com/careers/quality-assurance/), click “See all QA jobs”, filter jobs by Location: “Istanbul, Turkey”, and Department: “Quality Assurance”, check the presence of the job list.
4. **Validate Jobs Position, Department And Location**
    - Check that all jobs’ Position contains “Quality Assurance”, Department contains “Quality Assurance”, and Location contains “Istanbul, Turkey”.
5. **Lever Application Form Page Navigation**
    - Click the “View Role” button and check that this action redirects us to the Lever Application form page.


## Reporting

- **ExtentReports**: Test results are generated and can be accessed from the `test-output` folder after test execution.


