package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;
import pages.CartPage;

/**
 * AddToCartTest - Test class for TC-006: Add product to shopping cart.
 * Requirement: BR-007
 * Preconditions: User is logged in and products are available.
 */
public class AddToCartTest extends BaseTest {

    private SearchPage searchPage;
    private CartPage cartPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage();
        searchPage = new SearchPage();
        cartPage = new CartPage();

        // Precondition: User is logged in
        navigateToBaseUrl();
        loginPage.login(ConfigReader.getUserUsername(), ConfigReader.getUserPassword());
        logger.info("User logged in successfully.");
    }

    /**
     * TC-006: Add a product to the shopping cart.
     * Description: Verify that a logged-in user can add a product to the cart.
     * Type: Functional – Positive
     *
     * Test Steps:
     * 1. Browse or search for a product.
     * 2. Click "Add to Cart" button.
     * 3. Navigate to the shopping cart.
     *
     * Expected Results:
     * - Product is added to the cart.
     * - Cart badge/count is updated.
     * - Product details are visible in the cart.
     */
    @Test(description = "TC-006: Verify user can add a product to shopping cart")
    public void testAddProductToCart() {
        logger.info("TC-006: Starting test - Add product to shopping cart");

        // Step 1: Search for a product
        searchPage.searchProduct("Wireless Headphones");

        // Verify search results exist
        Assert.assertTrue(searchPage.getSearchResultsCount() > 0,
                "Search results should be available");

        // Step 2: Click Add to Cart
        searchPage.clickAddToCart();

        // Step 3: Navigate to shopping cart
        cartPage.clickCartIcon();

        // Assertions - Expected Results
        // Verify cart is not empty
        Assert.assertFalse(cartPage.isCartEmpty(),
                "Cart should not be empty after adding a product");

        // Verify cart item count
        Assert.assertTrue(cartPage.getCartItemCount() > 0,
                "Cart should have at least one item");

        logger.info("TC-006: Test completed successfully - Product added to cart");
    }
}
