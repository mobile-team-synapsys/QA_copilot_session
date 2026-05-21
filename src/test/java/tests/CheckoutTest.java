package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.CartPage;
import pages.CheckoutPage;

/**
 * CheckoutTest - Test class for TC-009: Complete checkout process.
 * Requirement: BR-011, BR-012, BR-013
 * Preconditions: User is logged in and has items in the cart.
 */
public class CheckoutTest extends BaseTest {

    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();

        // Precondition: User is logged in
        navigateToBaseUrl();
        loginPage.login(ConfigReader.getUserUsername(), ConfigReader.getUserPassword());

        // Navigate to cart and proceed to checkout
        cartPage.clickCartIcon();
        cartPage.clickCheckout();
        logger.info("User logged in and navigated to checkout.");
    }

    /**
     * TC-009: Complete checkout with credit card payment.
     * Description: Verify that a user can complete the checkout process with a credit card.
     * Type: Functional – Positive
     *
     * Test Steps:
     * 1. Navigate to checkout.
     * 2. Enter shipping address details.
     * 3. Select credit card as payment method.
     * 4. Enter card details.
     * 5. Click "Place Order".
     *
     * Expected Results:
     * - Order is placed successfully.
     * - Order confirmation is displayed.
     * - Order number is generated.
     * - Tax and shipping are calculated correctly.
     */
    @Test(description = "TC-009: Verify user can complete checkout with credit card")
    public void testCheckoutWithCreditCard() {
        logger.info("TC-009: Starting test - Complete checkout with credit card");

        // Steps 2-5: Complete checkout
        checkoutPage.completeCheckoutWithCard(
                "123 Main Street",
                "New York",
                "10001",
                "United States",
                "4111111111111111",
                "12/28",
                "123"
        );

        // Assertions - Expected Results
        // Verify order confirmation is displayed
        Assert.assertTrue(checkoutPage.isOrderConfirmationDisplayed(),
                "Order confirmation should be displayed");

        // Verify order number is generated
        String orderNumber = checkoutPage.getOrderNumber();
        Assert.assertNotNull(orderNumber, "Order number should be generated");
        Assert.assertFalse(orderNumber.isEmpty(), "Order number should not be empty");

        // Verify tax is calculated
        String taxAmount = checkoutPage.getTaxAmount();
        Assert.assertNotNull(taxAmount, "Tax amount should be displayed");

        // Verify shipping cost is shown
        String shippingCost = checkoutPage.getShippingCost();
        Assert.assertNotNull(shippingCost, "Shipping cost should be displayed");

        logger.info("TC-009: Test completed successfully - Checkout completed");
    }

    /**
     * TC-010: Apply a valid coupon code during checkout.
     * Description: Verify that a valid coupon code applies a discount.
     * Type: Functional – Positive
     * Requirement: BR-021
     *
     * Test Steps:
     * 1. Navigate to checkout.
     * 2. Enter a valid coupon code.
     * 3. Click "Apply Coupon".
     *
     * Expected Results:
     * - Coupon is applied successfully.
     * - Discount is reflected in the order total.
     */
    @Test(description = "TC-010: Verify valid coupon code applies discount")
    public void testApplyValidCouponCode() {
        logger.info("TC-010: Starting test - Apply valid coupon code");

        // Get initial total
        String initialTotal = checkoutPage.getOrderTotal();

        // Step 2-3: Apply coupon
        checkoutPage.applyCoupon("SAVE10");

        // Assertions - Expected Results
        Assert.assertTrue(checkoutPage.isCouponApplied(),
                "Coupon should be applied successfully");

        // Verify total changed (discount applied)
        String discountedTotal = checkoutPage.getOrderTotal();
        Assert.assertNotEquals(discountedTotal, initialTotal,
                "Order total should change after applying coupon");

        logger.info("TC-010: Test completed successfully - Coupon applied");
    }
}
