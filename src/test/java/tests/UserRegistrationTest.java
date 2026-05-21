package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationPage;

/**
 * UserRegistrationTest - Test class for TC-004: User registration with valid data.
 * Requirement: BR-001
 * Preconditions: User is on the registration page.
 */
public class UserRegistrationTest extends BaseTest {

    private RegistrationPage registrationPage;

    @BeforeMethod
    public void setUpTest() {
        registrationPage = new RegistrationPage();
        navigateToBaseUrl();
        logger.info("Navigated to registration page.");
    }

    /**
     * TC-004: Register a new user with valid data.
     * Description: Verify that a new user can register with valid email and password.
     * Type: Functional – Positive
     *
     * Test Steps:
     * 1. Navigate to the registration page.
     * 2. Enter valid first name.
     * 3. Enter valid last name.
     * 4. Enter valid email address.
     * 5. Enter valid password.
     * 6. Confirm password.
     * 7. Enter phone number.
     * 8. Click "Register".
     *
     * Expected Results:
     * - User account is created successfully.
     * - A success/confirmation message is displayed.
     * - User is redirected to login page or dashboard.
     */
    @Test(description = "TC-004: Verify new user registration with valid data")
    public void testUserRegistrationWithValidData() {
        logger.info("TC-004: Starting test - User registration with valid data");

        // Steps 2-7: Enter all registration details
        registrationPage.enterFirstName("John");
        registrationPage.enterLastName("Doe");
        registrationPage.enterEmail("john.doe" + System.currentTimeMillis() + "@test.com");
        registrationPage.enterPassword("SecurePass@123");
        registrationPage.enterConfirmPassword("SecurePass@123");
        registrationPage.enterPhone("1234567890");

        // Step 8: Click Register
        registrationPage.clickRegister();

        // Assertions - Expected Results
        // Verify success message is displayed
        Assert.assertTrue(registrationPage.isSuccessMessageDisplayed(),
                "Success message should be displayed after registration");

        String successMessage = registrationPage.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("success") || successMessage.contains("registered") || successMessage.contains("created"),
                "Success message should confirm registration");

        logger.info("TC-004: Test completed successfully - User registered");
    }

    /**
     * TC-005: Register a user with an already existing email.
     * Description: Verify that registration fails with duplicate email.
     * Type: Functional – Negative
     *
     * Test Steps:
     * 1. Navigate to the registration page.
     * 2. Enter an email that is already registered.
     * 3. Fill in all other fields with valid data.
     * 4. Click "Register".
     *
     * Expected Results:
     * - Registration fails.
     * - An error message about duplicate email is displayed.
     */
    @Test(description = "TC-005: Verify registration fails with duplicate email")
    public void testUserRegistrationWithDuplicateEmail() {
        logger.info("TC-005: Starting test - User registration with duplicate email");

        // Use a known registered email
        registrationPage.enterFirstName("Jane");
        registrationPage.enterLastName("Doe");
        registrationPage.enterEmail("user@ecommerce.com"); // Already registered email
        registrationPage.enterPassword("SecurePass@123");
        registrationPage.enterConfirmPassword("SecurePass@123");
        registrationPage.enterPhone("9876543210");

        registrationPage.clickRegister();

        // Assertions - Expected Results
        // Verify error message is displayed
        Assert.assertTrue(registrationPage.isErrorMessageDisplayed(),
                "Error message should be displayed for duplicate email");

        String errorMessage = registrationPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("already") || errorMessage.contains("exists") || errorMessage.contains("duplicate"),
                "Error message should indicate email already exists");

        logger.info("TC-005: Test completed successfully - Duplicate email rejected");
    }
}
