package pages;

import org.openqa.selenium.By;
import utils.ElementUtils;

/**
 * LoginPage - Page Object for the Login page.
 * Handles login functionality for both admin and regular users.
 */
public class LoginPage extends BasePage {

    // Locators
    // TODO: Update locators based on actual UI implementation
    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("loginBtn");
    private static final By ERROR_MESSAGE = By.cssSelector(".error-message");
    private static final By FORGOT_PASSWORD_LINK = By.linkText("Forgot Password?");

    /**
     * Enter email address.
     */
    public LoginPage enterEmail(String email) {
        ElementUtils.type(EMAIL_INPUT, email);
        return this;
    }

    /**
     * Enter password.
     */
    public LoginPage enterPassword(String password) {
        ElementUtils.type(PASSWORD_INPUT, password);
        return this;
    }

    /**
     * Click the login button.
     */
    public void clickLogin() {
        ElementUtils.click(LOGIN_BUTTON);
    }

    /**
     * Perform complete login operation.
     */
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    /**
     * Check if error message is displayed.
     */
    public boolean isErrorMessageDisplayed() {
        return ElementUtils.isDisplayed(ERROR_MESSAGE);
    }

    /**
     * Get error message text.
     */
    public String getErrorMessage() {
        return ElementUtils.getText(ERROR_MESSAGE);
    }

    /**
     * Click forgot password link.
     */
    public void clickForgotPassword() {
        ElementUtils.click(FORGOT_PASSWORD_LINK);
    }
}
