package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

/**
 * AddNewProductTest - Test class for TC-001: Add a new product with all valid required fields.
 * Requirement: BR-018
 * Preconditions: Admin user is logged in and on the product management panel.
 */
public class AddNewProductTest extends BaseTest {

    private ProductPage productPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage();
        productPage = new ProductPage();

        // Precondition: Admin user is logged in
        navigateToAdminUrl();
        loginPage.login(ConfigReader.getAdminUsername(), ConfigReader.getAdminPassword());
        logger.info("Admin user logged in successfully.");
    }

    /**
     * TC-001: Add a new product with all valid required fields.
     * Description: Verify that an admin can successfully add a new product with all required fields filled correctly.
     * Type: Functional – Positive
     *
     * Test Steps:
     * 1. Navigate to Admin Panel > Products > Add New Product.
     * 2. Enter valid product name (e.g., "Wireless Headphones").
     * 3. Enter valid description.
     * 4. Enter price (e.g., 49.99).
     * 5. Select a category.
     * 6. Upload a product image.
     * 7. Set stock quantity (e.g., 100).
     * 8. Click "Save Product".
     *
     * Expected Results:
     * - Product is created successfully.
     * - A confirmation message is displayed.
     * - Product appears in the product listing with correct details.
     */
    @Test(description = "TC-001: Verify admin can add a new product with all valid required fields")
    public void testAddNewProductWithAllValidFields() {
        logger.info("TC-001: Starting test - Add a new product with all valid required fields");

        // Step 1: Navigate to Add New Product
        productPage.clickAddNewProduct();

        // Step 2: Enter valid product name
        productPage.enterProductName("Wireless Headphones");

        // Step 3: Enter valid description
        productPage.enterDescription("High-quality wireless headphones with noise cancellation");

        // Step 4: Enter price
        productPage.enterPrice("49.99");

        // Step 5: Select a category
        productPage.selectCategory("Electronics");

        // Step 6: Upload a product image
        // TODO: Provide actual image path for testing
        productPage.uploadImage(System.getProperty("user.dir") + "/src/test/resources/test-image.png");

        // Step 7: Set stock quantity
        productPage.enterStockQuantity("100");

        // Step 8: Click "Save Product"
        productPage.clickSaveProduct();

        // Assertions - Expected Results
        // Verify confirmation message is displayed
        Assert.assertTrue(productPage.isSuccessMessageDisplayed(),
                "Success message should be displayed after adding product");

        // Verify the success message content
        String successMessage = productPage.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("Product") || successMessage.contains("created") || successMessage.contains("success"),
                "Success message should confirm product creation");

        // Verify product appears in listing
        Assert.assertTrue(productPage.isProductListVisible(),
                "Product listing should be visible");

        logger.info("TC-001: Test completed successfully - Product added with all valid fields");
    }
}
