package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

/**
 * EditProductTest - Test class for TC-002: Edit an existing product.
 * Requirement: BR-018
 * Preconditions: Admin user is logged in and at least one product exists.
 */
public class EditProductTest extends BaseTest {

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
     * TC-002: Edit an existing product with valid data.
     * Description: Verify that an admin can successfully edit an existing product.
     * Type: Functional – Positive
     *
     * Test Steps:
     * 1. Navigate to Admin Panel > Products.
     * 2. Click Edit on an existing product.
     * 3. Modify the product name.
     * 4. Update the price.
     * 5. Click "Update Product".
     *
     * Expected Results:
     * - Product is updated successfully.
     * - A confirmation message is displayed.
     * - Product listing reflects the updated details.
     */
    @Test(description = "TC-002: Verify admin can edit an existing product")
    public void testEditExistingProduct() {
        logger.info("TC-002: Starting test - Edit an existing product");

        // Step 2: Click Edit on an existing product
        productPage.clickEditProduct();

        // Step 3: Modify product name
        productPage.enterProductName("Updated Wireless Headphones Pro");

        // Step 4: Update the price
        productPage.enterPrice("59.99");

        // Step 5: Click "Update Product"
        productPage.clickUpdateProduct();

        // Assertions - Expected Results
        // Verify confirmation message is displayed
        Assert.assertTrue(productPage.isSuccessMessageDisplayed(),
                "Success message should be displayed after updating product");

        // Verify the success message content
        String successMessage = productPage.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("updated") || successMessage.contains("success"),
                "Success message should confirm product update");

        logger.info("TC-002: Test completed successfully - Product edited");
    }
}
