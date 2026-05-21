package utils;

import base.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * ElementUtils - Reusable utility methods for common Selenium operations.
 */
public class ElementUtils {

    private static final Logger logger = LogManager.getLogger(ElementUtils.class);

    /**
     * Click on an element after waiting for it to be clickable.
     */
    public static void click(By locator) {
        WebElement element = WaitUtils.waitForClickable(locator);
        element.click();
        logger.info("Clicked on element: " + locator);
    }

    /**
     * Type text into an input field after clearing it.
     */
    public static void type(By locator, String text) {
        WebElement element = WaitUtils.waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
        logger.info("Typed '" + text + "' into element: " + locator);
    }

    /**
     * Get text from an element.
     */
    public static String getText(By locator) {
        WebElement element = WaitUtils.waitForVisibility(locator);
        String text = element.getText();
        logger.info("Got text '" + text + "' from element: " + locator);
        return text;
    }

    /**
     * Check if an element is displayed.
     */
    public static boolean isDisplayed(By locator) {
        try {
            return WaitUtils.waitForVisibility(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Select option from dropdown by visible text.
     */
    public static void selectByVisibleText(By locator, String text) {
        WebElement element = WaitUtils.waitForVisibility(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
        logger.info("Selected '" + text + "' from dropdown: " + locator);
    }

    /**
     * Select option from dropdown by value.
     */
    public static void selectByValue(By locator, String value) {
        WebElement element = WaitUtils.waitForVisibility(locator);
        Select select = new Select(element);
        select.selectByValue(value);
        logger.info("Selected value '" + value + "' from dropdown: " + locator);
    }

    /**
     * Upload a file to a file input element.
     */
    public static void uploadFile(By locator, String filePath) {
        WebElement element = WaitUtils.waitForPresence(locator);
        element.sendKeys(filePath);
        logger.info("Uploaded file '" + filePath + "' to element: " + locator);
    }

    /**
     * Get attribute value of an element.
     */
    public static String getAttribute(By locator, String attribute) {
        WebElement element = WaitUtils.waitForVisibility(locator);
        return element.getAttribute(attribute);
    }

    /**
     * Scroll to element.
     */
    public static void scrollToElement(By locator) {
        WebElement element = WaitUtils.waitForPresence(locator);
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        logger.info("Scrolled to element: " + locator);
    }

    /**
     * Hover over an element.
     */
    public static void hoverOver(By locator) {
        WebElement element = WaitUtils.waitForVisibility(locator);
        Actions actions = new Actions(DriverFactory.getDriver());
        actions.moveToElement(element).perform();
        logger.info("Hovered over element: " + locator);
    }

    /**
     * Get all elements matching a locator.
     */
    public static List<WebElement> getElements(By locator) {
        return WaitUtils.waitForAllVisible(locator);
    }

    /**
     * Check if element contains specific text.
     */
    public static boolean containsText(By locator, String text) {
        String elementText = getText(locator);
        return elementText.contains(text);
    }

    /**
     * Get the current page title.
     */
    public static String getPageTitle() {
        return DriverFactory.getDriver().getTitle();
    }

    /**
     * Get the current URL.
     */
    public static String getCurrentUrl() {
        return DriverFactory.getDriver().getCurrentUrl();
    }
}
