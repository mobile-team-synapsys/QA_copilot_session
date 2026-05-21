package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;

/**
 * ProductSearchTest - Test class for TC-011: Search for products.
 * Requirement: BR-005
 * Preconditions: User is on the product listing or home page.
 */
public class ProductSearchTest extends BaseTest {

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
     * TC-011: Search for a product with valid keyword.
     * Description: Verify that product search returns relevant results.
     * Type: Functional – Positive
     *
     * Test Steps:
     * 1. Enter a valid search term in the search bar.
     * 2. Click search or press Enter.
     *
     * Expected Results:
     * - Search results are displayed.
     * - Results contain products matching the search term.
     */
    @Test(description = "TC-011: Verify product search with valid keyword returns results")
    public void testProductSearchWithValidKeyword() {
        logger.info("TC-011: Starting test - Product search with valid keyword");

        // Steps 1-2: Search for a product
        searchPage.searchProduct("Headphones");

        // Assertions - Expected Results
        Assert.assertTrue(searchPage.getSearchResultsCount() > 0,
                "Search results should be returned for valid keyword");

        Assert.assertFalse(searchPage.isNoResultsDisplayed(),
                "No results message should not be displayed for valid search");

        logger.info("TC-011: Test completed successfully - Search returned results");
    }

    /**
     * TC-012: Search for a product with invalid keyword.
     * Description: Verify that search with non-existing term shows no results.
     * Type: Functional – Negative
     *
     * Test Steps:
     * 1. Enter a non-existing product name in the search bar.
     * 2. Click search.
     *
     * Expected Results:
     * - No search results are displayed.
     * - A "No results found" message is shown.
     */
    @Test(description = "TC-012: Verify product search with invalid keyword shows no results")
    public void testProductSearchWithInvalidKeyword() {
        logger.info("TC-012: Starting test - Product search with invalid keyword");

        // Steps 1-2: Search with invalid term
        searchPage.searchProduct("xyznonexistentproduct12345");

        // Assertions - Expected Results
        Assert.assertTrue(searchPage.isNoResultsDisplayed(),
                "No results message should be displayed for invalid search");

        logger.info("TC-012: Test completed successfully - No results for invalid keyword");
    }

    /**
     * TC-013: Search with price filter.
     * Description: Verify product search with price range filter.
     * Type: Functional – Positive
     *
     * Test Steps:
     * 1. Search for a product.
     * 2. Apply price range filter (min and max).
     *
     * Expected Results:
     * - Only products within the price range are displayed.
     */
    @Test(description = "TC-013: Verify product search with price filter")
    public void testProductSearchWithPriceFilter() {
        logger.info("TC-013: Starting test - Product search with price filter");

        // Step 1: Search
        searchPage.searchProduct("Electronics");

        // Step 2: Apply price filter
        searchPage.applyPriceFilter("10", "100");

        // Assertions - Expected Results
        Assert.assertTrue(searchPage.getProductCardsCount() > 0,
                "Filtered results should be displayed");

        logger.info("TC-013: Test completed successfully - Price filter applied");
    }
}
