package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

/**
 * DeleteProductTest - Test class for TC-003: Delete an existing product.
 * Requirement: BR-018
 * Preconditions: Admin user is logged in and at least one product exists.
 */
public class DeleteProductTest extends BaseTest {

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
     * TC-003: Delete an existing product.
     * Description: Verify that an admin can successfully delete a product.
     * Type: Functional – Positive
     *
     * Test Steps:
     * 1. Navigate to Admin Panel > Products.
     * 2. Click Delete on an existing product.
     * 3. Confirm deletion.
     *
     * Expected Results:
     * - Product is deleted successfully.
     * - A confirmation message is displayed.
     * - Product no longer appears in the product listing.
     */
    @Test(description = "TC-003: Verify admin can delete an existing product")
    public void testDeleteExistingProduct() {
        logger.info("TC-003: Starting test - Delete an existing product");

        // Get initial product count
        int initialCount = productPage.getProductCount();

        // Step 2: Click Delete on an existing product
        productPage.clickDeleteProduct();

        // Step 3: Confirm deletion
        productPage.confirmDelete();

        // Assertions - Expected Results
        // Verify confirmation message is displayed
        Assert.assertTrue(productPage.isSuccessMessageDisplayed(),
                "Success message should be displayed after deleting product");

        // Verify product count decreased
        int newCount = productPage.getProductCount();
        Assert.assertEquals(newCount, initialCount - 1,
                "Product count should decrease by 1 after deletion");

        logger.info("TC-003: Test completed successfully - Product deleted");
    }
}
