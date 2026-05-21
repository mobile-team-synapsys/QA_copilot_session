package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ElementUtils;
import utils.WaitUtils;

import java.util.List;

/**
 * ProductPage - Page Object for Product Management (Admin Panel).
 * Handles add, edit, and delete product operations (BR-017, BR-018).
 */
public class ProductPage extends BasePage {

    // Locators
    // TODO: Update locators based on actual UI implementation
    private static final By ADD_NEW_PRODUCT_BUTTON = By.id("addNewProduct");
    private static final By PRODUCT_NAME_INPUT = By.id("productName");
    private static final By PRODUCT_DESCRIPTION_INPUT = By.id("productDescription");
    private static final By PRODUCT_PRICE_INPUT = By.id("productPrice");
    private static final By PRODUCT_CATEGORY_DROPDOWN = By.id("productCategory");
    private static final By PRODUCT_IMAGE_UPLOAD = By.id("productImage");
    private static final By STOCK_QUANTITY_INPUT = By.id("stockQuantity");
    private static final By SAVE_PRODUCT_BUTTON = By.id("saveProduct");
    private static final By UPDATE_PRODUCT_BUTTON = By.id("updateProduct");
    private static final By DELETE_PRODUCT_BUTTON = By.cssSelector(".delete-product-btn");
    private static final By CONFIRM_DELETE_BUTTON = By.id("confirmDelete");
    private static final By SUCCESS_MESSAGE = By.cssSelector(".success-message");
    private static final By PRODUCT_LIST_TABLE = By.id("productListTable");
    private static final By PRODUCT_LIST_ROWS = By.cssSelector("#productListTable tbody tr");
    private static final By EDIT_PRODUCT_BUTTON = By.cssSelector(".edit-product-btn");
    private static final By SEARCH_INPUT = By.id("productSearch");

    /**
     * Click Add New Product button.
     */
    public ProductPage clickAddNewProduct() {
        ElementUtils.click(ADD_NEW_PRODUCT_BUTTON);
        return this;
    }

    /**
     * Enter product name.
     */
    public ProductPage enterProductName(String name) {
        ElementUtils.type(PRODUCT_NAME_INPUT, name);
        return this;
    }

    /**
     * Enter product description.
     */
    public ProductPage enterDescription(String description) {
        ElementUtils.type(PRODUCT_DESCRIPTION_INPUT, description);
        return this;
    }

    /**
     * Enter product price.
     */
    public ProductPage enterPrice(String price) {
        ElementUtils.type(PRODUCT_PRICE_INPUT, price);
        return this;
    }

    /**
     * Select product category from dropdown.
     */
    public ProductPage selectCategory(String category) {
        ElementUtils.selectByVisibleText(PRODUCT_CATEGORY_DROPDOWN, category);
        return this;
    }

    /**
     * Upload product image.
     */
    public ProductPage uploadImage(String imagePath) {
        ElementUtils.uploadFile(PRODUCT_IMAGE_UPLOAD, imagePath);
        return this;
    }

    /**
     * Enter stock quantity.
     */
    public ProductPage enterStockQuantity(String quantity) {
        ElementUtils.type(STOCK_QUANTITY_INPUT, quantity);
        return this;
    }

    /**
     * Click Save Product button.
     */
    public void clickSaveProduct() {
        ElementUtils.click(SAVE_PRODUCT_BUTTON);
    }

    /**
     * Click Update Product button.
     */
    public void clickUpdateProduct() {
        ElementUtils.click(UPDATE_PRODUCT_BUTTON);
    }

    /**
     * Click Delete Product button for a specific product.
     */
    public void clickDeleteProduct() {
        ElementUtils.click(DELETE_PRODUCT_BUTTON);
    }

    /**
     * Confirm product deletion.
     */
    public void confirmDelete() {
        ElementUtils.click(CONFIRM_DELETE_BUTTON);
    }

    /**
     * Click Edit button for a specific product.
     */
    public void clickEditProduct() {
        ElementUtils.click(EDIT_PRODUCT_BUTTON);
    }

    /**
     * Check if success message is displayed.
     */
    public boolean isSuccessMessageDisplayed() {
        return ElementUtils.isDisplayed(SUCCESS_MESSAGE);
    }

    /**
     * Get success message text.
     */
    public String getSuccessMessage() {
        return ElementUtils.getText(SUCCESS_MESSAGE);
    }

    /**
     * Check if product list is visible.
     */
    public boolean isProductListVisible() {
        return ElementUtils.isDisplayed(PRODUCT_LIST_TABLE);
    }

    /**
     * Get number of products in listing.
     */
    public int getProductCount() {
        List<WebElement> rows = ElementUtils.getElements(PRODUCT_LIST_ROWS);
        return rows.size();
    }

    /**
     * Search for a product by name.
     */
    public void searchProduct(String productName) {
        ElementUtils.type(SEARCH_INPUT, productName);
    }

    /**
     * Add a new product with all required fields.
     */
    public void addProduct(String name, String description, String price,
                           String category, String imagePath, String stockQuantity) {
        clickAddNewProduct();
        enterProductName(name);
        enterDescription(description);
        enterPrice(price);
        selectCategory(category);
        uploadImage(imagePath);
        enterStockQuantity(stockQuantity);
        clickSaveProduct();
    }
}
