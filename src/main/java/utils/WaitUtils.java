package utils;

import base.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.ConfigReader;

import java.time.Duration;
import java.util.List;

/**
 * WaitUtils - Provides explicit wait utility methods for Selenium WebDriver.
 * Avoids hardcoded Thread.sleep() calls.
 */
public class WaitUtils {

    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverFactory.getDriver(),
                Duration.ofSeconds(ConfigReader.getExplicitWait()));
    }

    private static WebDriverWait getWait(int timeoutSeconds) {
        return new WebDriverWait(DriverFactory.getDriver(),
                Duration.ofSeconds(timeoutSeconds));
    }

    /**
     * Wait for element to be visible.
     */
    public static WebElement waitForVisibility(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for element to be visible with custom timeout.
     */
    public static WebElement waitForVisibility(By locator, int timeoutSeconds) {
        return getWait(timeoutSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for element to be clickable.
     */
    public static WebElement waitForClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Wait for element to be present in DOM.
     */
    public static WebElement waitForPresence(By locator) {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Wait for element to disappear.
     */
    public static boolean waitForInvisibility(By locator) {
        return getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Wait for text to be present in element.
     */
    public static boolean waitForTextPresent(By locator, String text) {
        return getWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /**
     * Wait for URL to contain specific text.
     */
    public static boolean waitForUrlContains(String urlFragment) {
        return getWait().until(ExpectedConditions.urlContains(urlFragment));
    }

    /**
     * Wait for all elements to be visible.
     */
    public static List<WebElement> waitForAllVisible(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    /**
     * Wait for alert to be present and return it.
     */
    public static Alert waitForAlert() {
        return getWait().until(ExpectedConditions.alertIsPresent());
    }
}
