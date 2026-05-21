package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ElementUtils;

import java.util.List;

/**
 * CartPage - Page Object for Shopping Cart page.
 * Handles add to cart, update quantity, and remove from cart operations (BR-007, BR-008, BR-009).
 */
public class CartPage extends BasePage {

    // Locators
    // TODO: Update locators based on actual UI implementation
    private static final By CART_ICON = By.id("cartIcon");
    private static final By CART_ITEMS = By.cssSelector(".cart-item");
    private static final By CART_ITEM_QUANTITY = By.cssSelector(".cart-item-quantity input");
    private static final By UPDATE_QUANTITY_BUTTON = By.cssSelector(".update-quantity-btn");
    private static final By REMOVE_ITEM_BUTTON = By.cssSelector(".remove-item-btn");
    private static final By CART_TOTAL = By.id("cartTotal");
    private static final By CHECKOUT_BUTTON = By.id("checkoutBtn");
    private static final By EMPTY_CART_MESSAGE = By.cssSelector(".empty-cart-message");
    private static final By CART_ITEM_NAME = By.cssSelector(".cart-item-name");
    private static final By CART_ITEM_PRICE = By.cssSelector(".cart-item-price");
    private static final By CART_BADGE = By.cssSelector(".cart-badge");
    private static final By SUCCESS_MESSAGE = By.cssSelector(".success-message");

    /**
     * Click on the cart icon to navigate to cart page.
     */
    public CartPage clickCartIcon() {
        ElementUtils.click(CART_ICON);
        return this;
    }

    /**
     * Get number of items in cart.
     */
    public int getCartItemCount() {
        List<WebElement> items = ElementUtils.getElements(CART_ITEMS);
        return items.size();
    }

    /**
     * Update item quantity.
     */
    public void updateQuantity(String quantity) {
        ElementUtils.type(CART_ITEM_QUANTITY, quantity);
        ElementUtils.click(UPDATE_QUANTITY_BUTTON);
    }

    /**
     * Remove an item from cart.
     */
    public void removeItem() {
        ElementUtils.click(REMOVE_ITEM_BUTTON);
    }

    /**
     * Get cart total amount.
     */
    public String getCartTotal() {
        return ElementUtils.getText(CART_TOTAL);
    }

    /**
     * Click checkout button.
     */
    public void clickCheckout() {
        ElementUtils.click(CHECKOUT_BUTTON);
    }

    /**
     * Check if cart is empty.
     */
    public boolean isCartEmpty() {
        return ElementUtils.isDisplayed(EMPTY_CART_MESSAGE);
    }

    /**
     * Get cart badge count.
     */
    public String getCartBadgeCount() {
        return ElementUtils.getText(CART_BADGE);
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
}
