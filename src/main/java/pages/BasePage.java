package pages;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;
import utils.WaitUtils;

/**
 * BasePage - Base class for all Page Objects.
 * Contains common methods shared across all pages.
 */
public abstract class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * Get the page title.
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Get the current URL.
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Navigate to a specific URL.
     */
    public void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Check if element is displayed.
     */
    protected boolean isElementDisplayed(By locator) {
        return ElementUtils.isDisplayed(locator);
    }

    /**
     * Get success/confirmation message text.
     */
    protected String getMessageText(By locator) {
        return ElementUtils.getText(locator);
    }
}
