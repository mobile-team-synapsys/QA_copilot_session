# Test Cases - E-Commerce Platform

## TC-001: Add a new product with all valid required fields
- **Title:** Add a new product with all valid required fields
- **Description:** Verify that an admin can successfully add a new product with all required fields filled correctly.
- **Requirement ID:** BR-018
- **Type:** Functional – Positive
- **Preconditions:** Admin user is logged in and on the product management panel.

**Test Steps:**
1. Navigate to Admin Panel > Products > Add New Product.
2. Enter valid product name (e.g., "Wireless Headphones").
3. Enter valid description.
4. Enter price (e.g., 49.99).
5. Select a category.
6. Upload a product image.
7. Set stock quantity (e.g., 100).
8. Click "Save Product".

**Expected Results:**
- Product is created successfully.
- A confirmation message is displayed.
- Product appears in the product listing with correct details.

---

## TC-002: Edit an existing product
- **Title:** Edit an existing product with valid data
- **Description:** Verify that an admin can successfully edit an existing product.
- **Requirement ID:** BR-018
- **Type:** Functional – Positive
- **Preconditions:** Admin user is logged in and at least one product exists.

**Test Steps:**
1. Navigate to Admin Panel > Products.
2. Click Edit on an existing product.
3. Modify the product name.
4. Update the price.
5. Click "Update Product".

**Expected Results:**
- Product is updated successfully.
- A confirmation message is displayed.
- Product listing reflects the updated details.

---

## TC-003: Delete an existing product
- **Title:** Delete an existing product
- **Description:** Verify that an admin can successfully delete a product.
- **Requirement ID:** BR-018
- **Type:** Functional – Positive
- **Preconditions:** Admin user is logged in and at least one product exists.

**Test Steps:**
1. Navigate to Admin Panel > Products.
2. Click Delete on an existing product.
3. Confirm deletion.

**Expected Results:**
- Product is deleted successfully.
- A confirmation message is displayed.
- Product no longer appears in the product listing.

---

## TC-004: Register a new user with valid data
- **Title:** Register a new user with valid data
- **Description:** Verify that a new user can register with valid email and password.
- **Requirement ID:** BR-001
- **Type:** Functional – Positive
- **Preconditions:** User is on the registration page.

**Test Steps:**
1. Navigate to the registration page.
2. Enter valid first name.
3. Enter valid last name.
4. Enter valid email address.
5. Enter valid password.
6. Confirm password.
7. Enter phone number.
8. Click "Register".

**Expected Results:**
- User account is created successfully.
- A success/confirmation message is displayed.
- User is redirected to login page or dashboard.

---

## TC-005: Register with duplicate email
- **Title:** Register a user with an already existing email
- **Description:** Verify that registration fails with duplicate email.
- **Requirement ID:** BR-001
- **Type:** Functional – Negative
- **Preconditions:** User is on the registration page and an account with the email already exists.

**Test Steps:**
1. Navigate to the registration page.
2. Enter an email that is already registered.
3. Fill in all other fields with valid data.
4. Click "Register".

**Expected Results:**
- Registration fails.
- An error message about duplicate email is displayed.

---

## TC-006: Add product to shopping cart
- **Title:** Add a product to the shopping cart
- **Description:** Verify that a logged-in user can add a product to the cart.
- **Requirement ID:** BR-007
- **Type:** Functional – Positive
- **Preconditions:** User is logged in and products are available.

**Test Steps:**
1. Browse or search for a product.
2. Click "Add to Cart" button.
3. Navigate to the shopping cart.

**Expected Results:**
- Product is added to the cart.
- Cart badge/count is updated.
- Product details are visible in the cart.

---

## TC-007: Update product quantity in cart
- **Title:** Update product quantity in the shopping cart
- **Description:** Verify that a user can update product quantity in the cart.
- **Requirement ID:** BR-008
- **Type:** Functional – Positive
- **Preconditions:** User is logged in and has items in the cart.

**Test Steps:**
1. Navigate to the shopping cart.
2. Update the quantity of a product.
3. Verify the cart total is updated.

**Expected Results:**
- Quantity is updated successfully.
- Cart total reflects the new quantity.
- Success message or UI update confirms the change.

---

## TC-008: Remove product from cart
- **Title:** Remove a product from the shopping cart
- **Description:** Verify that a user can remove a product from the cart.
- **Requirement ID:** BR-009
- **Type:** Functional – Positive
- **Preconditions:** User is logged in and has items in the cart.

**Test Steps:**
1. Navigate to the shopping cart.
2. Click "Remove" button for a product.

**Expected Results:**
- Product is removed from the cart.
- Cart count is updated.
- If last item removed, empty cart message is displayed.

---

## TC-009: Complete checkout with credit card
- **Title:** Complete checkout with credit card payment
- **Description:** Verify that a user can complete the checkout process with a credit card.
- **Requirement ID:** BR-011, BR-012, BR-013
- **Type:** Functional – Positive
- **Preconditions:** User is logged in and has items in the cart.

**Test Steps:**
1. Navigate to checkout.
2. Enter shipping address details.
3. Select credit card as payment method.
4. Enter card details.
5. Click "Place Order".

**Expected Results:**
- Order is placed successfully.
- Order confirmation is displayed.
- Order number is generated.
- Tax and shipping are calculated correctly.

---

## TC-010: Apply valid coupon code
- **Title:** Apply a valid coupon code during checkout
- **Description:** Verify that a valid coupon code applies a discount.
- **Requirement ID:** BR-021
- **Type:** Functional – Positive
- **Preconditions:** User is on the checkout page.

**Test Steps:**
1. Navigate to checkout.
2. Enter a valid coupon code.
3. Click "Apply Coupon".

**Expected Results:**
- Coupon is applied successfully.
- Discount is reflected in the order total.

---

## TC-011: Search for product with valid keyword
- **Title:** Search for a product with valid keyword
- **Description:** Verify that product search returns relevant results.
- **Requirement ID:** BR-005
- **Type:** Functional – Positive
- **Preconditions:** User is on the product listing or home page.

**Test Steps:**
1. Enter a valid search term in the search bar.
2. Click search or press Enter.

**Expected Results:**
- Search results are displayed.
- Results contain products matching the search term.

---

## TC-012: Search with invalid keyword
- **Title:** Search for a product with invalid keyword
- **Description:** Verify that search with non-existing term shows no results.
- **Requirement ID:** BR-005
- **Type:** Functional – Negative
- **Preconditions:** User is on the home page.

**Test Steps:**
1. Enter a non-existing product name in the search bar.
2. Click search.

**Expected Results:**
- No search results are displayed.
- A "No results found" message is shown.

---

## TC-013: Search with price filter
- **Title:** Search products with price range filter
- **Description:** Verify product search with price range filter.
- **Requirement ID:** BR-005
- **Type:** Functional – Positive
- **Preconditions:** User is on the search/browse page.

**Test Steps:**
1. Search for a product.
2. Apply price range filter (min and max).

**Expected Results:**
- Only products within the price range are displayed.

---

## TC-014: Browse products by category
- **Title:** Browse products by category
- **Description:** Verify that users can browse products by selecting a category.
- **Requirement ID:** BR-004
- **Type:** Functional – Positive
- **Preconditions:** User is on the home page and categories are available.

**Test Steps:**
1. Navigate to the home page.
2. Click on a product category (e.g., "Electronics").

**Expected Results:**
- Products in the selected category are displayed.
- Page title or breadcrumb reflects the selected category.
