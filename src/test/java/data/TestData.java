package data;

/**
 * TestData - Contains test data constants for automation tests.
 * Centralizes test data to avoid hardcoding in test classes.
 */
public class TestData {

    // Product Test Data
    public static final String PRODUCT_NAME = "Wireless Headphones";
    public static final String PRODUCT_DESCRIPTION = "High-quality wireless headphones with noise cancellation";
    public static final String PRODUCT_PRICE = "49.99";
    public static final String PRODUCT_CATEGORY = "Electronics";
    public static final String PRODUCT_STOCK = "100";
    public static final String UPDATED_PRODUCT_NAME = "Updated Wireless Headphones Pro";
    public static final String UPDATED_PRODUCT_PRICE = "59.99";

    // User Registration Test Data
    public static final String REG_FIRST_NAME = "John";
    public static final String REG_LAST_NAME = "Doe";
    public static final String REG_PASSWORD = "SecurePass@123";
    public static final String REG_PHONE = "1234567890";

    // Checkout Test Data
    public static final String SHIPPING_ADDRESS = "123 Main Street";
    public static final String SHIPPING_CITY = "New York";
    public static final String SHIPPING_ZIP = "10001";
    public static final String SHIPPING_COUNTRY = "United States";
    public static final String CARD_NUMBER = "4111111111111111";
    public static final String CARD_EXPIRY = "12/28";
    public static final String CARD_CVV = "123";

    // Search Test Data
    public static final String VALID_SEARCH_TERM = "Headphones";
    public static final String INVALID_SEARCH_TERM = "xyznonexistentproduct12345";

    // Coupon Test Data
    public static final String VALID_COUPON = "SAVE10";
    public static final String INVALID_COUPON = "INVALIDCOUPON";

    /**
     * Generate a unique email for registration tests.
     */
    public static String generateUniqueEmail() {
        return "testuser" + System.currentTimeMillis() + "@test.com";
    }
}
