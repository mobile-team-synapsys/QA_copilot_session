# E-Commerce Automation Framework

## Overview
Selenium-based Java automation framework for E-Commerce platform testing using Page Object Model (POM) design pattern.

## Tech Stack
- **Language:** Java 11
- **Automation Tool:** Selenium WebDriver 4.27.0
- **Test Framework:** TestNG 7.10.2
- **Build Tool:** Maven
- **Design Pattern:** Page Object Model (POM)
- **Browser Management:** WebDriverManager 5.9.2
- **Logging:** Log4j2
- **Reporting:** TestNG Reports + Extent Reports

## Project Structure
```
src/
 ├── main/
 │    └── java/
 │         ├── pages/          # Page Object classes
 │         ├── utils/          # Utility classes (waits, screenshots, etc.)
 │         ├── base/           # Base classes (BaseTest, DriverFactory)
 │         └── config/         # Configuration reader
 │
 └── test/
      └── java/
      │    ├── tests/          # Test classes
      │    └── data/           # Test data classes
      └── resources/
           ├── config.properties    # Configuration file
           └── log4j2.xml          # Logging configuration
```

## Prerequisites
- Java 11 or higher
- Maven 3.6+
- Chrome browser installed

## Setup & Execution

### Install dependencies
```bash
mvn clean install -DskipTests
```

### Run all tests
```bash
mvn test
```

### Run specific test suite
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run specific test class
```bash
mvn test -Dtest=AddNewProductTest
```

## Configuration
Update `src/test/resources/config.properties` with your environment details:
- `base.url` - Application base URL
- `admin.url` - Admin panel URL
- `browser` - Browser to use (chrome/firefox/edge)
- `headless` - Run in headless mode (true/false)

## Test Cases Covered
| Test Case ID | Title | Requirement |
|---|---|---|
| TC-001 | Add a new product with all valid required fields | BR-018 |
| TC-002 | Edit an existing product | BR-018 |
| TC-003 | Delete an existing product | BR-018 |
| TC-004 | Register a new user with valid data | BR-001 |
| TC-005 | Register with duplicate email | BR-001 |
| TC-006 | Add product to shopping cart | BR-007 |
| TC-007 | Update product quantity in cart | BR-008 |
| TC-008 | Remove product from cart | BR-009 |
| TC-009 | Complete checkout with credit card | BR-011, BR-012, BR-013 |
| TC-010 | Apply valid coupon code | BR-021 |
| TC-011 | Search for product with valid keyword | BR-005 |
| TC-012 | Search with invalid keyword | BR-005 |
| TC-013 | Search with price filter | BR-005 |
| TC-014 | Browse products by category | BR-004 |

## Features
- Thread-safe WebDriver management for parallel execution
- Explicit waits (no Thread.sleep)
- Screenshot capture on failure
- Retry mechanism for flaky tests
- Configurable test data
- Cross-browser support (Chrome, Firefox, Edge)
- Log4j2 logging
- TestNG reporting
