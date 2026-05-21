package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;

/**
 * BrowseByCategoryTest - Test class for TC-014: Browse products by category.
 * Requirement: BR-004
 * Preconditions: User is on the home page and categories are available.
 */
public class BrowseByCategoryTest extends BaseTest {

    private SearchPage searchPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage();
        searchPage = new SearchPage();

        navigateToBaseUrl();
        loginPage.login(ConfigReader.getUserUsername(), ConfigReader.getUserPassword());
        logger.info("User logged in and on the home page.");
    }

    /**
     * TC-014: Browse products by category.
     * Description: Verify that users can browse products by selecting a category.
     * Type: Functional – Positive
     *
     * Test Steps:
     * 1. Navigate to the home page.
     * 2. Click on a product category (e.g., "Electronics").
     *
     * Expected Results:
     * - Products in the selected category are displayed.
     * - Page title or breadcrumb reflects the selected category.
     */
    @Test(description = "TC-014: Verify user can browse products by category")
    public void testBrowseProductsByCategory() {
        logger.info("TC-014: Starting test - Browse products by category");

        // Step 2: Click on a category
        searchPage.selectCategory("Electronics");

        // Assertions - Expected Results
        Assert.assertTrue(searchPage.getProductCardsCount() > 0,
                "Products should be displayed for the selected category");

        // Verify URL contains category reference
        String currentUrl = searchPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("category") || currentUrl.contains("electronics"),
                "URL should reflect the selected category");

        logger.info("TC-014: Test completed successfully - Category browsing works");
    }
}
