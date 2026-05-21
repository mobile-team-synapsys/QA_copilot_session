package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.CartPage;

/**
 * UpdateCartQuantityTest - Test class for TC-007: Update product quantity in cart.
 * Requirement: BR-008
 * Preconditions: User is logged in and has items in the cart.
 */
public class UpdateCartQuantityTest extends BaseTest {

    private CartPage cartPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage();
        cartPage = new CartPage();

        // Precondition: User is logged in
        navigateToBaseUrl();
        loginPage.login(ConfigReader.getUserUsername(), ConfigReader.getUserPassword());

        // Navigate to cart (assuming items already exist)
        cartPage.clickCartIcon();
        logger.info("User logged in and navigated to cart.");
    }

    /**
     * TC-007: Update product quantity in the shopping cart.
     * Description: Verify that a user can update product quantity in the cart.
     * Type: Functional – Positive
     *
     * Test Steps:
     * 1. Navigate to the shopping cart.
     * 2. Update the quantity of a product.
     * 3. Verify the cart total is updated.
     *
     * Expected Results:
     * - Quantity is updated successfully.
     * - Cart total reflects the new quantity.
     * - Success message or UI update confirms the change.
     */
    @Test(description = "TC-007: Verify user can update product quantity in cart")
    public void testUpdateProductQuantityInCart() {
        logger.info("TC-007: Starting test - Update product quantity in cart");

        // Get initial cart total
        String initialTotal = cartPage.getCartTotal();

        // Step 2: Update quantity
        cartPage.updateQuantity("3");

        // Assertions - Expected Results
        // Verify cart total changed
        String updatedTotal = cartPage.getCartTotal();
        Assert.assertNotEquals(updatedTotal, initialTotal,
                "Cart total should change after quantity update");

        // Verify success indication
        Assert.assertTrue(cartPage.isSuccessMessageDisplayed(),
                "Success message should be displayed after updating quantity");

        logger.info("TC-007: Test completed successfully - Quantity updated");
    }
}
