package base;

import config.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * BaseTest - Base class for all test classes.
 * Handles WebDriver setup and teardown for each test method.
 */
public class BaseTest {

    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        logger.info("Initializing WebDriver...");
        driver = DriverFactory.initDriver();
        logger.info("WebDriver initialized. Browser: " + ConfigReader.getBrowser());
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Closing WebDriver...");
        DriverFactory.quitDriver();
        logger.info("WebDriver closed.");
    }

    /**
     * Navigate to the base URL of the application.
     */
    protected void navigateToBaseUrl() {
        driver.get(ConfigReader.getBaseUrl());
        logger.info("Navigated to: " + ConfigReader.getBaseUrl());
    }

    /**
     * Navigate to the admin panel URL.
     */
    protected void navigateToAdminUrl() {
        driver.get(ConfigReader.getAdminUrl());
        logger.info("Navigated to Admin URL: " + ConfigReader.getAdminUrl());
    }
}
