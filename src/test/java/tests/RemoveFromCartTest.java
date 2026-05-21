package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.CartPage;

/**
 * RemoveFromCartTest - Test class for TC-008: Remove product from shopping cart.
 * Requirement: BR-009
 * Preconditions: User is logged in and has items in the cart.
 */
public class RemoveFromCartTest extends BaseTest {

    private CartPage cartPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage();
        cartPage = new CartPage();

        // Precondition: User is logged in
        navigateToBaseUrl();
        loginPage.login(ConfigReader.getUserUsername(), ConfigReader.getUserPassword());

        // Navigate to cart
        cartPage.clickCartIcon();
        logger.info("User logged in and navigated to cart.");
    }

    /**
     * TC-008: Remove a product from the shopping cart.
     * Description: Verify that a user can remove a product from the cart.
     * Type: Functional – Positive
     *
     * Test Steps:
     * 1. Navigate to the shopping cart.
     * 2. Click "Remove" button for a product.
     *
     * Expected Results:
     * - Product is removed from the cart.
     * - Cart count is updated.
     * - If last item removed, empty cart message is displayed.
     */
    @Test(description = "TC-008: Verify user can remove product from cart")
    public void testRemoveProductFromCart() {
        logger.info("TC-008: Starting test - Remove product from cart");

        // Get initial item count
        int initialCount = cartPage.getCartItemCount();

        // Step 2: Remove item
        cartPage.removeItem();

        // Assertions - Expected Results
        if (initialCount == 1) {
            // If it was the last item, cart should be empty
            Assert.assertTrue(cartPage.isCartEmpty(),
                    "Cart should be empty after removing the last item");
        } else {
            // Cart count should decrease
            int newCount = cartPage.getCartItemCount();
            Assert.assertEquals(newCount, initialCount - 1,
                    "Cart item count should decrease by 1");
        }

        logger.info("TC-008: Test completed successfully - Product removed from cart");
    }
}
