package pages;

import org.openqa.selenium.By;
import utils.ElementUtils;

/**
 * RegistrationPage - Page Object for the User Registration page.
 * Handles user registration functionality (BR-001).
 */
public class RegistrationPage extends BasePage {

    // Locators
    // TODO: Update locators based on actual UI implementation
    private static final By FIRST_NAME_INPUT = By.id("firstName");
    private static final By LAST_NAME_INPUT = By.id("lastName");
    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By CONFIRM_PASSWORD_INPUT = By.id("confirmPassword");
    private static final By PHONE_INPUT = By.id("phone");
    private static final By REGISTER_BUTTON = By.id("registerBtn");
    private static final By SUCCESS_MESSAGE = By.cssSelector(".success-message");
    private static final By ERROR_MESSAGE = By.cssSelector(".error-message");
    private static final By LOGIN_LINK = By.linkText("Already have an account? Login");

    /**
     * Enter first name.
     */
    public RegistrationPage enterFirstName(String firstName) {
        ElementUtils.type(FIRST_NAME_INPUT, firstName);
        return this;
    }

    /**
     * Enter last name.
     */
    public RegistrationPage enterLastName(String lastName) {
        ElementUtils.type(LAST_NAME_INPUT, lastName);
        return this;
    }

    /**
     * Enter email address.
     */
    public RegistrationPage enterEmail(String email) {
        ElementUtils.type(EMAIL_INPUT, email);
        return this;
    }

    /**
     * Enter password.
     */
    public RegistrationPage enterPassword(String password) {
        ElementUtils.type(PASSWORD_INPUT, password);
        return this;
    }

    /**
     * Enter confirm password.
     */
    public RegistrationPage enterConfirmPassword(String confirmPassword) {
        ElementUtils.type(CONFIRM_PASSWORD_INPUT, confirmPassword);
        return this;
    }

    /**
     * Enter phone number.
     */
    public RegistrationPage enterPhone(String phone) {
        ElementUtils.type(PHONE_INPUT, phone);
        return this;
    }

    /**
     * Click the register button.
     */
    public void clickRegister() {
        ElementUtils.click(REGISTER_BUTTON);
    }

    /**
     * Perform complete registration with all required fields.
     */
    public void registerUser(String firstName, String lastName, String email,
                             String password, String confirmPassword, String phone) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        enterPhone(phone);
        clickRegister();
    }

    /**
     * Check if success message is displayed.
     */
    public boolean isSuccessMessageDisplayed() {
        return ElementUtils.isDisplayed(SUCCESS_MESSAGE);
    }

    /**
     * Get success message text.
     */
    public String getSuccessMessage() {
        return ElementUtils.getText(SUCCESS_MESSAGE);
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
}
