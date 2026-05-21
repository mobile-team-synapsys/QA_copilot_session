package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ElementUtils;

import java.util.List;

/**
 * SearchPage - Page Object for Product Search and Browse functionality.
 * Handles product search with filters and category browsing (BR-004, BR-005, BR-006).
 */
public class SearchPage extends BasePage {

    // Locators
    // TODO: Update locators based on actual UI implementation
    private static final By SEARCH_INPUT = By.id("searchInput");
    private static final By SEARCH_BUTTON = By.id("searchBtn");
    private static final By SEARCH_RESULTS = By.cssSelector(".search-result-item");
    private static final By CATEGORY_LINKS = By.cssSelector(".category-link");
    private static final By FILTER_PRICE_MIN = By.id("priceMin");
    private static final By FILTER_PRICE_MAX = By.id("priceMax");
    private static final By APPLY_FILTER_BUTTON = By.id("applyFilter");
    private static final By SORT_DROPDOWN = By.id("sortBy");
    private static final By NO_RESULTS_MESSAGE = By.cssSelector(".no-results");
    private static final By PRODUCT_CARDS = By.cssSelector(".product-card");
    private static final By ADD_TO_CART_BUTTON = By.cssSelector(".add-to-cart-btn");
    private static final By PRODUCT_DETAIL_NAME = By.id("productDetailName");
    private static final By PRODUCT_DETAIL_PRICE = By.id("productDetailPrice");
    private static final By PRODUCT_DETAIL_DESCRIPTION = By.id("productDetailDescription");

    /**
     * Enter search term.
     */
    public SearchPage enterSearchTerm(String searchTerm) {
        ElementUtils.type(SEARCH_INPUT, searchTerm);
        return this;
    }

    /**
     * Click search button.
     */
    public SearchPage clickSearch() {
        ElementUtils.click(SEARCH_BUTTON);
        return this;
    }

    /**
     * Perform a product search.
     */
    public SearchPage searchProduct(String searchTerm) {
        enterSearchTerm(searchTerm);
        clickSearch();
        return this;
    }

    /**
     * Get number of search results.
     */
    public int getSearchResultsCount() {
        List<WebElement> results = ElementUtils.getElements(SEARCH_RESULTS);
        return results.size();
    }

    /**
     * Select a category from the category list.
     */
    public void selectCategory(String categoryName) {
        By categoryLocator = By.linkText(categoryName);
        ElementUtils.click(categoryLocator);
    }

    /**
     * Apply price filter.
     */
    public void applyPriceFilter(String minPrice, String maxPrice) {
        ElementUtils.type(FILTER_PRICE_MIN, minPrice);
        ElementUtils.type(FILTER_PRICE_MAX, maxPrice);
        ElementUtils.click(APPLY_FILTER_BUTTON);
    }

    /**
     * Sort results by a given option.
     */
    public void sortBy(String sortOption) {
        ElementUtils.selectByVisibleText(SORT_DROPDOWN, sortOption);
    }

    /**
     * Check if no results message is displayed.
     */
    public boolean isNoResultsDisplayed() {
        return ElementUtils.isDisplayed(NO_RESULTS_MESSAGE);
    }

    /**
     * Get count of product cards displayed.
     */
    public int getProductCardsCount() {
        List<WebElement> cards = ElementUtils.getElements(PRODUCT_CARDS);
        return cards.size();
    }

    /**
     * Click add to cart for first product.
     */
    public void clickAddToCart() {
        ElementUtils.click(ADD_TO_CART_BUTTON);
    }

    /**
     * Get product detail name.
     */
    public String getProductDetailName() {
        return ElementUtils.getText(PRODUCT_DETAIL_NAME);
    }

    /**
     * Get product detail price.
     */
    public String getProductDetailPrice() {
        return ElementUtils.getText(PRODUCT_DETAIL_PRICE);
    }

    /**
     * Get product detail description.
     */
    public String getProductDetailDescription() {
        return ElementUtils.getText(PRODUCT_DETAIL_DESCRIPTION);
    }
}
