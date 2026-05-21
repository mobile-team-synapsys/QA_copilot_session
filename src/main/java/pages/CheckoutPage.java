package pages;

import org.openqa.selenium.By;
import utils.ElementUtils;

/**
 * CheckoutPage - Page Object for the Checkout process.
 * Handles secure checkout, payment method selection, and order confirmation (BR-011, BR-012, BR-013).
 */
public class CheckoutPage extends BasePage {

    // Locators
    // TODO: Update locators based on actual UI implementation
    private static final By SHIPPING_ADDRESS_INPUT = By.id("shippingAddress");
    private static final By SHIPPING_CITY_INPUT = By.id("shippingCity");
    private static final By SHIPPING_ZIP_INPUT = By.id("shippingZip");
    private static final By SHIPPING_COUNTRY_DROPDOWN = By.id("shippingCountry");
    private static final By SHIPPING_METHOD_DROPDOWN = By.id("shippingMethod");
    private static final By PAYMENT_METHOD_CREDIT_CARD = By.id("paymentCreditCard");
    private static final By PAYMENT_METHOD_PAYPAL = By.id("paymentPaypal");
    private static final By CARD_NUMBER_INPUT = By.id("cardNumber");
    private static final By CARD_EXPIRY_INPUT = By.id("cardExpiry");
    private static final By CARD_CVV_INPUT = By.id("cardCvv");
    private static final By PLACE_ORDER_BUTTON = By.id("placeOrder");
    private static final By ORDER_CONFIRMATION_MESSAGE = By.cssSelector(".order-confirmation");
    private static final By ORDER_NUMBER = By.id("orderNumber");
    private static final By ORDER_TOTAL = By.id("orderTotal");
    private static final By TAX_AMOUNT = By.id("taxAmount");
    private static final By SHIPPING_COST = By.id("shippingCost");
    private static final By COUPON_INPUT = By.id("couponCode");
    private static final By APPLY_COUPON_BUTTON = By.id("applyCoupon");
    private static final By COUPON_SUCCESS_MESSAGE = By.cssSelector(".coupon-success");
    private static final By COUPON_ERROR_MESSAGE = By.cssSelector(".coupon-error");

    /**
     * Enter shipping address.
     */
    public CheckoutPage enterShippingAddress(String address) {
        ElementUtils.type(SHIPPING_ADDRESS_INPUT, address);
        return this;
    }

    /**
     * Enter shipping city.
     */
    public CheckoutPage enterShippingCity(String city) {
        ElementUtils.type(SHIPPING_CITY_INPUT, city);
        return this;
    }

    /**
     * Enter shipping zip code.
     */
    public CheckoutPage enterShippingZip(String zip) {
        ElementUtils.type(SHIPPING_ZIP_INPUT, zip);
        return this;
    }

    /**
     * Select shipping country.
     */
    public CheckoutPage selectShippingCountry(String country) {
        ElementUtils.selectByVisibleText(SHIPPING_COUNTRY_DROPDOWN, country);
        return this;
    }

    /**
     * Select shipping method.
     */
    public CheckoutPage selectShippingMethod(String method) {
        ElementUtils.selectByVisibleText(SHIPPING_METHOD_DROPDOWN, method);
        return this;
    }

    /**
     * Select credit card as payment method.
     */
    public CheckoutPage selectCreditCardPayment() {
        ElementUtils.click(PAYMENT_METHOD_CREDIT_CARD);
        return this;
    }

    /**
     * Select PayPal as payment method.
     */
    public CheckoutPage selectPayPalPayment() {
        ElementUtils.click(PAYMENT_METHOD_PAYPAL);
        return this;
    }

    /**
     * Enter credit card details.
     */
    public CheckoutPage enterCardDetails(String cardNumber, String expiry, String cvv) {
        ElementUtils.type(CARD_NUMBER_INPUT, cardNumber);
        ElementUtils.type(CARD_EXPIRY_INPUT, expiry);
        ElementUtils.type(CARD_CVV_INPUT, cvv);
        return this;
    }

    /**
     * Click Place Order button.
     */
    public void clickPlaceOrder() {
        ElementUtils.click(PLACE_ORDER_BUTTON);
    }

    /**
     * Check if order confirmation is displayed.
     */
    public boolean isOrderConfirmationDisplayed() {
        return ElementUtils.isDisplayed(ORDER_CONFIRMATION_MESSAGE);
    }

    /**
     * Get order number.
     */
    public String getOrderNumber() {
        return ElementUtils.getText(ORDER_NUMBER);
    }

    /**
     * Get order total.
     */
    public String getOrderTotal() {
        return ElementUtils.getText(ORDER_TOTAL);
    }

    /**
     * Get tax amount.
     */
    public String getTaxAmount() {
        return ElementUtils.getText(TAX_AMOUNT);
    }

    /**
     * Get shipping cost.
     */
    public String getShippingCost() {
        return ElementUtils.getText(SHIPPING_COST);
    }

    /**
     * Apply coupon code.
     */
    public void applyCoupon(String couponCode) {
        ElementUtils.type(COUPON_INPUT, couponCode);
        ElementUtils.click(APPLY_COUPON_BUTTON);
    }

    /**
     * Check if coupon is applied successfully.
     */
    public boolean isCouponApplied() {
        return ElementUtils.isDisplayed(COUPON_SUCCESS_MESSAGE);
    }

    /**
     * Complete checkout with credit card.
     */
    public void completeCheckoutWithCard(String address, String city, String zip,
                                         String country, String cardNumber, String expiry, String cvv) {
        enterShippingAddress(address);
        enterShippingCity(city);
        enterShippingZip(zip);
        selectShippingCountry(country);
        selectCreditCardPayment();
        enterCardDetails(cardNumber, expiry, cvv);
        clickPlaceOrder();
    }
}
