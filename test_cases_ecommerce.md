# E-Commerce Platform – Test Cases

## Document Information

| Field | Value |
|-------|-------|
| Project | E-Commerce Platform |
| Document Type | Test Cases |
| Based On | Business Requirements Document (BRD) |
| Created Date | 2026-05-21 |
| Author | QA Engineering Team |

---

## 1. Product Adding (Admin)

### TC-001: Add a new product with valid details

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-001 |
| **Title** | Add a new product with all valid required fields |
| **Description** | Verify that an admin can successfully add a new product with all required fields filled correctly. |
| **Requirement ID** | BR-018 |
| **Type** | Functional – Positive |
| **Preconditions** | Admin user is logged in and on the product management panel. |
| **Test Steps** | 1. Navigate to Admin Panel > Products > Add New Product.<br>2. Enter valid product name (e.g., "Wireless Headphones").<br>3. Enter valid description.<br>4. Enter price (e.g., 49.99).<br>5. Select a category.<br>6. Upload a product image.<br>7. Set stock quantity (e.g., 100).<br>8. Click "Save Product". |
| **Expected Results** | Product is created successfully. A confirmation message is displayed. Product appears in the product listing with correct details. |

### TC-002: Add a product with missing required fields

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-002 |
| **Title** | Attempt to add a product with missing required fields |
| **Description** | Verify that the system prevents adding a product when required fields are empty. |
| **Requirement ID** | BR-018 |
| **Type** | Functional – Negative |
| **Preconditions** | Admin user is logged in and on the Add Product page. |
| **Test Steps** | 1. Navigate to Admin Panel > Products > Add New Product.<br>2. Leave the product name field empty.<br>3. Leave the price field empty.<br>4. Click "Save Product". |
| **Expected Results** | Product is NOT created. Validation error messages are displayed for each required field (e.g., "Product name is required", "Price is required"). |

### TC-003: Add a product with price boundary value zero

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-003 |
| **Title** | Add a product with price set to 0 |
| **Description** | Verify system behavior when admin attempts to add a product with a price of zero. |
| **Requirement ID** | BR-018 |
| **Type** | Boundary/Edge Case |
| **Preconditions** | Admin user is logged in and on the Add Product page. |
| **Test Steps** | 1. Navigate to Admin Panel > Products > Add New Product.<br>2. Enter valid product name.<br>3. Enter price as "0".<br>4. Fill all other required fields.<br>5. Click "Save Product". |
| **Expected Results** | System either rejects the product with a validation error ("Price must be greater than 0") or saves it as a free product depending on business rules. |

### TC-004: Add a product with negative price

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-004 |
| **Title** | Add a product with a negative price value |
| **Description** | Verify that the system rejects a product with a negative price. |
| **Requirement ID** | BR-018 |
| **Type** | Boundary/Edge Case – Negative |
| **Preconditions** | Admin user is logged in and on the Add Product page. |
| **Test Steps** | 1. Navigate to Admin Panel > Products > Add New Product.<br>2. Enter valid product name.<br>3. Enter price as "-10.00".<br>4. Fill all other required fields.<br>5. Click "Save Product". |
| **Expected Results** | Product is NOT created. Validation error is displayed: "Price must be a positive value". |

### TC-005: Add a product with maximum allowed name length

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-005 |
| **Title** | Add a product with maximum character limit for product name |
| **Description** | Verify that the system handles maximum character length for product name field. |
| **Requirement ID** | BR-018 |
| **Type** | Boundary/Edge Case |
| **Preconditions** | Admin user is logged in and on the Add Product page. |
| **Test Steps** | 1. Navigate to Admin Panel > Products > Add New Product.<br>2. Enter a product name with 255 characters (maximum allowed).<br>3. Fill all other required fields with valid data.<br>4. Click "Save Product". |
| **Expected Results** | Product is created successfully with the full name stored and displayed correctly. |

---

## 2. Item Remove/Add (Shopping Cart)

### TC-006: Add a single product to shopping cart

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-006 |
| **Title** | Add a product to the shopping cart |
| **Description** | Verify that a user can add a product to the shopping cart from the product details page. |
| **Requirement ID** | BR-007 |
| **Type** | Functional – Positive |
| **Preconditions** | User is on a product details page. Product is in stock. |
| **Test Steps** | 1. Navigate to a product details page.<br>2. Verify the "Add to Cart" button is visible and enabled.<br>3. Click "Add to Cart".<br>4. Navigate to the shopping cart page. |
| **Expected Results** | Product is added to the cart. Cart icon updates to show item count. Product appears in cart with correct name, price, and quantity of 1. |

### TC-007: Update product quantity in cart

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-007 |
| **Title** | Update product quantity in the shopping cart |
| **Description** | Verify that a user can increase or decrease the quantity of a product in the cart. |
| **Requirement ID** | BR-008 |
| **Type** | Functional – Positive |
| **Preconditions** | User has at least one product in the shopping cart. |
| **Test Steps** | 1. Navigate to the shopping cart.<br>2. Locate the product in the cart.<br>3. Change quantity from 1 to 3.<br>4. Click "Update" or confirm the quantity change. |
| **Expected Results** | Quantity updates to 3. Subtotal recalculates correctly (unit price × 3). Cart total updates accordingly. |

### TC-008: Remove a product from shopping cart

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-008 |
| **Title** | Remove a product from the shopping cart |
| **Description** | Verify that a user can remove a product from the shopping cart. |
| **Requirement ID** | BR-009 |
| **Type** | Functional – Positive |
| **Preconditions** | User has at least one product in the shopping cart. |
| **Test Steps** | 1. Navigate to the shopping cart.<br>2. Locate the product to remove.<br>3. Click "Remove" or the delete icon next to the product. |
| **Expected Results** | Product is removed from the cart. Cart total recalculates. If cart is empty, a message "Your cart is empty" is displayed. |

### TC-009: Add product quantity exceeding available stock

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-009 |
| **Title** | Attempt to add quantity exceeding available stock |
| **Description** | Verify that the system prevents users from adding more items than available in stock. |
| **Requirement ID** | BR-008 |
| **Type** | Boundary/Edge Case – Negative |
| **Preconditions** | User is on a product page. Product has limited stock (e.g., 5 units). |
| **Test Steps** | 1. Navigate to product details page (stock = 5).<br>2. Set quantity to 10.<br>3. Click "Add to Cart". |
| **Expected Results** | System displays an error message: "Only 5 items available in stock" or limits the quantity to maximum available stock. Product is not added with the invalid quantity. |

### TC-010: Set cart item quantity to zero

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-010 |
| **Title** | Set product quantity to zero in cart |
| **Description** | Verify system behavior when user sets product quantity to zero in the cart. |
| **Requirement ID** | BR-008, BR-009 |
| **Type** | Boundary/Edge Case |
| **Preconditions** | User has a product in the cart with quantity 1. |
| **Test Steps** | 1. Navigate to shopping cart.<br>2. Change product quantity to 0.<br>3. Click "Update". |
| **Expected Results** | Product is removed from the cart or system displays validation error "Quantity must be at least 1". |

### TC-011: Add product to cart when out of stock

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-011 |
| **Title** | Attempt to add an out-of-stock product to cart |
| **Description** | Verify that out-of-stock products cannot be added to the shopping cart. |
| **Requirement ID** | BR-007 |
| **Type** | Functional – Negative |
| **Preconditions** | User is viewing a product that is out of stock. |
| **Test Steps** | 1. Navigate to an out-of-stock product page.<br>2. Verify the "Add to Cart" button state. |
| **Expected Results** | "Add to Cart" button is either disabled or hidden. An "Out of Stock" label is displayed. User cannot add the product to the cart. |

---

## 3. Product Searching

### TC-012: Search for a product by exact name

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-012 |
| **Title** | Search for a product by its exact name |
| **Description** | Verify that the search functionality returns correct results when searching by exact product name. |
| **Requirement ID** | BR-005 |
| **Type** | Functional – Positive |
| **Preconditions** | Products exist in the system. User is on any page with the search bar visible. |
| **Test Steps** | 1. Click on the search bar.<br>2. Type "Wireless Headphones".<br>3. Press Enter or click the search icon. |
| **Expected Results** | Search results page displays the matching product(s). "Wireless Headphones" appears in the results with correct image, name, and price. |

### TC-013: Search for a product by partial keyword

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-013 |
| **Title** | Search for a product using a partial keyword |
| **Description** | Verify that the search returns relevant results when a partial keyword is entered. |
| **Requirement ID** | BR-005 |
| **Type** | Functional – Positive |
| **Preconditions** | Products exist in the system (e.g., "Wireless Headphones", "Wireless Mouse"). |
| **Test Steps** | 1. Click on the search bar.<br>2. Type "Wireless".<br>3. Press Enter or click the search icon. |
| **Expected Results** | Search results display all products containing "Wireless" in their name or description. Results are relevant and properly paginated. |

### TC-014: Search with no matching results

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-014 |
| **Title** | Search for a product that does not exist |
| **Description** | Verify system behavior when search returns no results. |
| **Requirement ID** | BR-005 |
| **Type** | Functional – Negative |
| **Preconditions** | User is on any page with the search bar visible. |
| **Test Steps** | 1. Click on the search bar.<br>2. Type "xyznonexistentproduct123".<br>3. Press Enter or click the search icon. |
| **Expected Results** | Search results page displays a "No products found" message. Suggested categories or popular products may be shown. |

### TC-015: Search with special characters

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-015 |
| **Title** | Search using special characters |
| **Description** | Verify that the system handles special characters in search without errors. |
| **Requirement ID** | BR-005 |
| **Type** | Boundary/Edge Case – Negative |
| **Preconditions** | User is on any page with the search bar visible. |
| **Test Steps** | 1. Click on the search bar.<br>2. Type "<script>alert('xss')</script>".<br>3. Press Enter or click the search icon. |
| **Expected Results** | System sanitizes input. No script execution occurs. Either "No results found" is displayed or the special characters are safely escaped. No application error occurs. |

### TC-016: Filter search results by category

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-016 |
| **Title** | Filter products by category |
| **Description** | Verify that users can browse and filter products by category. |
| **Requirement ID** | BR-004, BR-005 |
| **Type** | Functional – Positive |
| **Preconditions** | Multiple products exist across different categories. |
| **Test Steps** | 1. Navigate to the product listing page.<br>2. Select "Electronics" category from the filter/sidebar.<br>3. Observe the results. |
| **Expected Results** | Only products belonging to the "Electronics" category are displayed. Product count updates to reflect filtered results. |

### TC-017: Search with empty query

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-017 |
| **Title** | Submit search with empty search field |
| **Description** | Verify system behavior when user submits a search with no query. |
| **Requirement ID** | BR-005 |
| **Type** | Boundary/Edge Case |
| **Preconditions** | User is on any page with the search bar visible. |
| **Test Steps** | 1. Click on the search bar.<br>2. Leave it empty.<br>3. Press Enter or click the search icon. |
| **Expected Results** | System either displays all products, shows a validation message "Please enter a search term", or remains on the current page without error. |

---

## 4. Checkout Flows

### TC-018: Guest checkout – complete purchase without registration

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-018 |
| **Title** | Complete checkout as a guest user |
| **Description** | Verify that a guest user can complete a purchase without creating an account. |
| **Requirement ID** | BR-011 |
| **Type** | Functional – Positive |
| **Preconditions** | Guest user has items in the shopping cart. |
| **Test Steps** | 1. Navigate to shopping cart.<br>2. Click "Proceed to Checkout".<br>3. Select "Continue as Guest".<br>4. Enter shipping information (name, address, city, zip, country).<br>5. Enter contact email.<br>6. Select shipping method.<br>7. Enter payment details (valid credit card).<br>8. Review order summary.<br>9. Click "Place Order". |
| **Expected Results** | Order is placed successfully. Order confirmation page is displayed with order number. Confirmation email is sent to the guest email address. |

### TC-019: Registered user checkout

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-019 |
| **Title** | Complete checkout as a registered user |
| **Description** | Verify that a registered user can complete a purchase with saved details. |
| **Requirement ID** | BR-011, BR-001 |
| **Type** | Functional – Positive |
| **Preconditions** | User is registered, logged in, and has items in the cart. User has a saved shipping address. |
| **Test Steps** | 1. Navigate to shopping cart.<br>2. Click "Proceed to Checkout".<br>3. Verify saved shipping address is pre-filled.<br>4. Select shipping method.<br>5. Enter payment details or select saved payment method.<br>6. Review order summary.<br>7. Click "Place Order". |
| **Expected Results** | Order is placed successfully. Order confirmation page displays order number. Order appears in user's order history. Confirmation email is sent. |

### TC-020: Checkout with empty cart

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-020 |
| **Title** | Attempt checkout with an empty cart |
| **Description** | Verify that the system prevents checkout when the cart is empty. |
| **Requirement ID** | BR-011 |
| **Type** | Functional – Negative |
| **Preconditions** | User is logged in. Shopping cart is empty. |
| **Test Steps** | 1. Navigate to shopping cart (empty).<br>2. Attempt to click "Proceed to Checkout". |
| **Expected Results** | "Proceed to Checkout" button is disabled or hidden. Message "Your cart is empty" is displayed with a link to continue shopping. |

### TC-021: Checkout with invalid shipping address

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-021 |
| **Title** | Attempt checkout with invalid shipping address |
| **Description** | Verify that the system validates shipping address during checkout. |
| **Requirement ID** | BR-011 |
| **Type** | Functional – Negative |
| **Preconditions** | User has items in cart and is on the checkout page. |
| **Test Steps** | 1. Navigate to checkout.<br>2. Leave the shipping address fields empty or enter invalid data (e.g., invalid zip code format).<br>3. Click "Continue to Payment". |
| **Expected Results** | System displays validation errors for invalid/missing fields. User cannot proceed to payment step until valid address is provided. |

### TC-022: User registration during checkout

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-022 |
| **Title** | Register a new account during checkout process |
| **Description** | Verify that a guest user can create an account during checkout. |
| **Requirement ID** | BR-001, BR-011 |
| **Type** | Functional – Positive |
| **Preconditions** | Guest user has items in cart and is on the checkout page. |
| **Test Steps** | 1. Navigate to checkout.<br>2. Select "Create an Account" option.<br>3. Enter email, password, and confirm password.<br>4. Fill shipping information.<br>5. Complete payment.<br>6. Click "Place Order". |
| **Expected Results** | Order is placed successfully. New user account is created. User is logged in automatically. Order is saved in the new account's order history. Welcome and order confirmation emails are sent. |

### TC-023: Apply valid coupon code during checkout

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-023 |
| **Title** | Apply a valid coupon code during checkout |
| **Description** | Verify that a valid coupon code applies the correct discount during checkout. |
| **Requirement ID** | BR-021 |
| **Type** | Functional – Positive |
| **Preconditions** | User has items in cart. A valid coupon code "SAVE10" exists (10% discount). |
| **Test Steps** | 1. Navigate to checkout or cart page.<br>2. Enter coupon code "SAVE10" in the coupon field.<br>3. Click "Apply". |
| **Expected Results** | Coupon is applied successfully. 10% discount is calculated and reflected in the order total. Success message "Coupon applied" is displayed. |

### TC-024: Apply invalid/expired coupon code

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-024 |
| **Title** | Apply an invalid or expired coupon code |
| **Description** | Verify that the system rejects invalid or expired coupon codes. |
| **Requirement ID** | BR-021 |
| **Type** | Functional – Negative |
| **Preconditions** | User has items in cart and is on the checkout page. |
| **Test Steps** | 1. Navigate to checkout or cart page.<br>2. Enter coupon code "EXPIRED2025" in the coupon field.<br>3. Click "Apply". |
| **Expected Results** | Coupon is rejected. Error message "Invalid or expired coupon code" is displayed. Order total remains unchanged. |

---

## 5. Payment Gateway Integration

### TC-025: Successful payment with valid credit card

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-025 |
| **Title** | Complete payment with a valid credit card |
| **Description** | Verify that the payment gateway processes a valid credit card payment successfully. |
| **Requirement ID** | BR-012, BR-029 |
| **Type** | Functional – Positive |
| **Preconditions** | User is on the payment step of checkout. Cart has items. |
| **Test Steps** | 1. Select "Credit Card" as payment method.<br>2. Enter valid card number (e.g., 4111 1111 1111 1111).<br>3. Enter valid expiry date (future date).<br>4. Enter valid CVV (e.g., 123).<br>5. Enter cardholder name.<br>6. Click "Pay Now". |
| **Expected Results** | Payment is processed successfully. Order confirmation page is displayed. Transaction ID is generated. Payment status shows "Paid". |

### TC-026: Payment with declined credit card

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-026 |
| **Title** | Attempt payment with a declined credit card |
| **Description** | Verify system behavior when the payment gateway declines a credit card. |
| **Requirement ID** | BR-012, BR-029 |
| **Type** | Functional – Negative |
| **Preconditions** | User is on the payment step of checkout. |
| **Test Steps** | 1. Select "Credit Card" as payment method.<br>2. Enter a test card number that triggers decline (e.g., 4000 0000 0000 0002).<br>3. Enter valid expiry and CVV.<br>4. Click "Pay Now". |
| **Expected Results** | Payment is declined. Error message "Payment declined. Please try another payment method" is displayed. Order is NOT placed. User remains on payment page to retry. |

### TC-027: Payment with expired credit card

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-027 |
| **Title** | Attempt payment with an expired credit card |
| **Description** | Verify that the system rejects payment with an expired credit card. |
| **Requirement ID** | BR-012, BR-029 |
| **Type** | Functional – Negative |
| **Preconditions** | User is on the payment step of checkout. |
| **Test Steps** | 1. Select "Credit Card" as payment method.<br>2. Enter valid card number.<br>3. Enter expiry date in the past (e.g., 01/2020).<br>4. Enter valid CVV.<br>5. Click "Pay Now". |
| **Expected Results** | Validation error is displayed: "Card has expired. Please use a valid card." Payment is not processed. |

### TC-028: Payment via PayPal

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-028 |
| **Title** | Complete payment using PayPal |
| **Description** | Verify that users can complete payment via PayPal gateway. |
| **Requirement ID** | BR-012, BR-029 |
| **Type** | Data-Driven Variation |
| **Preconditions** | User is on the payment step of checkout. PayPal integration is configured. |
| **Test Steps** | 1. Select "PayPal" as payment method.<br>2. Click "Pay with PayPal".<br>3. Log in to PayPal sandbox account.<br>4. Confirm payment on PayPal page.<br>5. User is redirected back to the e-commerce site. |
| **Expected Results** | Payment is processed successfully via PayPal. Order confirmation page is displayed. Payment method shows "PayPal" in order details. |

### TC-029: Payment via debit card

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-029 |
| **Title** | Complete payment using a debit card |
| **Description** | Verify that users can complete payment using a debit card. |
| **Requirement ID** | BR-012, BR-029 |
| **Type** | Data-Driven Variation |
| **Preconditions** | User is on the payment step of checkout. |
| **Test Steps** | 1. Select "Debit Card" as payment method.<br>2. Enter valid debit card number.<br>3. Enter valid expiry date.<br>4. Enter valid CVV.<br>5. Click "Pay Now". |
| **Expected Results** | Payment is processed successfully. Order confirmation page is displayed. Transaction is recorded with "Debit Card" as payment method. |

### TC-030: Payment with insufficient funds

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-030 |
| **Title** | Attempt payment with insufficient funds |
| **Description** | Verify system behavior when payment fails due to insufficient funds. |
| **Requirement ID** | BR-012, BR-029 |
| **Type** | Functional – Negative |
| **Preconditions** | User is on the payment step of checkout. |
| **Test Steps** | 1. Select "Credit Card" as payment method.<br>2. Enter a test card that triggers insufficient funds (e.g., 4000 0000 0000 9995).<br>3. Enter valid expiry and CVV.<br>4. Click "Pay Now". |
| **Expected Results** | Payment fails. Error message "Insufficient funds. Please try another card or payment method" is displayed. Order is not placed. |

### TC-031: Payment data encryption verification

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-031 |
| **Title** | Verify payment data is transmitted securely |
| **Description** | Verify that all payment information is encrypted during transmission (HTTPS/TLS). |
| **Requirement ID** | BR-028, BR-029 |
| **Type** | Security |
| **Preconditions** | User is on the payment page. Browser developer tools are accessible. |
| **Test Steps** | 1. Navigate to the payment page.<br>2. Open browser developer tools > Network tab.<br>3. Enter payment details.<br>4. Submit payment.<br>5. Inspect the network request containing payment data. |
| **Expected Results** | All requests to the payment endpoint use HTTPS (TLS 1.2 or higher). No payment data (card number, CVV) is visible in plain text in request headers or URL parameters. Sensitive data is tokenized before transmission to the server. |

---

## 6. Order Confirmation and Email Notifications

### TC-032: Order confirmation page after successful purchase

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-032 |
| **Title** | Verify order confirmation page content |
| **Description** | Verify that the order confirmation page displays all required order details after a successful purchase. |
| **Requirement ID** | BR-013 |
| **Type** | Functional – Positive |
| **Preconditions** | User has completed a successful checkout. |
| **Test Steps** | 1. Complete a purchase (checkout with valid payment).<br>2. Observe the order confirmation page. |
| **Expected Results** | Order confirmation page displays: Order number, ordered items with quantities and prices, shipping address, selected shipping method, payment method (masked), order total (subtotal + tax + shipping), estimated delivery date. |

### TC-033: Order confirmation email sent to registered user

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-033 |
| **Title** | Verify order confirmation email for registered user |
| **Description** | Verify that a confirmation email is sent to the registered user after a successful order. |
| **Requirement ID** | BR-013, BR-015 |
| **Type** | Functional – Positive |
| **Preconditions** | Registered user has completed a successful purchase. |
| **Test Steps** | 1. Complete a purchase as a registered user.<br>2. Check the email inbox for the registered email address.<br>3. Open the order confirmation email. |
| **Expected Results** | Email is received within 5 minutes. Email contains: Order number, items ordered, total amount, shipping address, estimated delivery, link to track order. Email subject includes "Order Confirmation" and order number. |

### TC-034: Order confirmation email sent to guest user

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-034 |
| **Title** | Verify order confirmation email for guest checkout |
| **Description** | Verify that a confirmation email is sent to the guest email address provided during checkout. |
| **Requirement ID** | BR-013, BR-015 |
| **Type** | Functional – Positive |
| **Preconditions** | Guest user has completed checkout with a valid email. |
| **Test Steps** | 1. Complete a guest checkout providing email "guest@example.com".<br>2. Check the inbox for "guest@example.com".<br>3. Open the order confirmation email. |
| **Expected Results** | Email is received at the guest email address within 5 minutes. Email contains order details including order number, items, total, and shipping info. |

### TC-035: Order status update notification

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-035 |
| **Title** | Verify email notification on order status change |
| **Description** | Verify that users receive email notifications when order status changes (e.g., shipped). |
| **Requirement ID** | BR-014, BR-015 |
| **Type** | Functional – Positive |
| **Preconditions** | A completed order exists. Admin updates the order status. |
| **Test Steps** | 1. Admin navigates to order management.<br>2. Admin updates order status from "Processing" to "Shipped".<br>3. Admin enters tracking number.<br>4. Admin saves the update.<br>5. Check customer's email inbox. |
| **Expected Results** | Customer receives an email notification: "Your order has been shipped". Email includes tracking number and carrier link. Order status is updated in user's order history. |

### TC-036: Order tracking functionality

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-036 |
| **Title** | Verify order tracking page displays correct status |
| **Description** | Verify that users can track their order and see current status. |
| **Requirement ID** | BR-014 |
| **Type** | Functional – Positive |
| **Preconditions** | User has a placed order with a valid order number. |
| **Test Steps** | 1. Log in to user account.<br>2. Navigate to "My Orders".<br>3. Click on a specific order.<br>4. View order tracking details. |
| **Expected Results** | Order tracking page shows: Current status (e.g., Processing, Shipped, Delivered), status history timeline, tracking number (when shipped), estimated delivery date. |

---

## 7. User Registration and Authentication

### TC-037: Successful user registration

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-037 |
| **Title** | Register a new user with valid information |
| **Description** | Verify that a new user can register successfully with valid email and password. |
| **Requirement ID** | BR-001 |
| **Type** | Functional – Positive |
| **Preconditions** | User is on the registration page. |
| **Test Steps** | 1. Navigate to the registration page.<br>2. Enter a valid email (e.g., "newuser@example.com").<br>3. Enter a valid password (min 8 chars, with uppercase, lowercase, number, special char).<br>4. Confirm password.<br>5. Enter first name and last name.<br>6. Click "Register". |
| **Expected Results** | Account is created successfully. User is redirected to the homepage or account dashboard. Welcome email is sent. User can log in with the new credentials. |

### TC-038: Registration with existing email

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-038 |
| **Title** | Attempt registration with an already registered email |
| **Description** | Verify that the system prevents registration with a duplicate email address. |
| **Requirement ID** | BR-001 |
| **Type** | Functional – Negative |
| **Preconditions** | Email "existing@example.com" is already registered. |
| **Test Steps** | 1. Navigate to the registration page.<br>2. Enter "existing@example.com" as email.<br>3. Fill all other fields with valid data.<br>4. Click "Register". |
| **Expected Results** | Registration fails. Error message "An account with this email already exists" is displayed. User is not created. |

### TC-039: Password reset via email

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-039 |
| **Title** | Reset password via email verification |
| **Description** | Verify that a user can reset their password using the email verification process. |
| **Requirement ID** | BR-003 |
| **Type** | Functional – Positive |
| **Preconditions** | User has an existing account with a verified email. |
| **Test Steps** | 1. Navigate to login page.<br>2. Click "Forgot Password".<br>3. Enter registered email address.<br>4. Click "Send Reset Link".<br>5. Check email inbox for the reset link.<br>6. Click the reset link.<br>7. Enter new password and confirm.<br>8. Click "Reset Password". |
| **Expected Results** | Reset link email is received within 5 minutes. Link redirects to password reset page. New password is saved successfully. User can log in with the new password. Old password no longer works. |

### TC-040: Login with valid credentials

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-040 |
| **Title** | Login with valid email and password |
| **Description** | Verify that a registered user can log in with correct credentials. |
| **Requirement ID** | BR-002 |
| **Type** | Functional – Positive |
| **Preconditions** | User has a registered account. |
| **Test Steps** | 1. Navigate to the login page.<br>2. Enter valid email.<br>3. Enter valid password.<br>4. Click "Login". |
| **Expected Results** | User is logged in successfully. User is redirected to the homepage or dashboard. User name/greeting is displayed in the header. Session is created. |

### TC-041: Login with invalid credentials

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-041 |
| **Title** | Attempt login with incorrect password |
| **Description** | Verify that the system rejects login with an incorrect password. |
| **Requirement ID** | BR-002 |
| **Type** | Functional – Negative |
| **Preconditions** | User has a registered account. |
| **Test Steps** | 1. Navigate to the login page.<br>2. Enter valid email.<br>3. Enter incorrect password.<br>4. Click "Login". |
| **Expected Results** | Login fails. Error message "Invalid email or password" is displayed (generic to prevent enumeration). User remains on the login page. |

### TC-042: Logout functionality

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-042 |
| **Title** | Verify user logout |
| **Description** | Verify that a logged-in user can successfully log out. |
| **Requirement ID** | BR-002 |
| **Type** | Functional – Positive |
| **Preconditions** | User is logged in. |
| **Test Steps** | 1. Click on the user profile/account icon.<br>2. Click "Logout". |
| **Expected Results** | User is logged out. Session is terminated. User is redirected to the homepage or login page. Protected pages are no longer accessible without re-login. |

---

## 8. UX/UI Validation

### TC-043: Responsive design – Mobile viewport

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-043 |
| **Title** | Verify responsive layout on mobile devices |
| **Description** | Verify that the website displays correctly and is fully functional on mobile viewport (375px width). |
| **Requirement ID** | BR-027 |
| **Type** | UX/UI Validation |
| **Preconditions** | Application is accessible. Browser is set to mobile viewport (375 × 667 px). |
| **Test Steps** | 1. Open the application on a mobile viewport (375px width).<br>2. Navigate to the homepage.<br>3. Verify navigation menu collapses to hamburger icon.<br>4. Browse products.<br>5. Add a product to cart.<br>6. Navigate to cart and checkout. |
| **Expected Results** | All elements are properly stacked/adapted for mobile. No horizontal scrolling occurs. Text is readable without zooming. Buttons and links are easily tappable (min 44px touch target). Images scale appropriately. Navigation works via hamburger menu. |

### TC-044: Responsive design – Tablet viewport

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-044 |
| **Title** | Verify responsive layout on tablet devices |
| **Description** | Verify that the website displays correctly on a tablet viewport (768px width). |
| **Requirement ID** | BR-027 |
| **Type** | UX/UI Validation |
| **Preconditions** | Application is accessible. Browser is set to tablet viewport (768 × 1024 px). |
| **Test Steps** | 1. Open the application on a tablet viewport (768px width).<br>2. Navigate through homepage, product listings, product detail, cart, and checkout.<br>3. Verify layout adapts appropriately. |
| **Expected Results** | Product grid adjusts to 2-3 columns. All functionality is accessible. Forms are properly sized. No layout breakage or overlapping elements. |

### TC-045: Responsive design – Desktop viewport

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-045 |
| **Title** | Verify layout on desktop viewport |
| **Description** | Verify that the website displays correctly on a standard desktop viewport (1920px width). |
| **Requirement ID** | BR-027 |
| **Type** | UX/UI Validation |
| **Preconditions** | Application is accessible. Browser is set to desktop viewport (1920 × 1080 px). |
| **Test Steps** | 1. Open the application on a desktop viewport (1920px width).<br>2. Navigate through all major pages.<br>3. Verify content is properly centered/contained and not stretched. |
| **Expected Results** | Layout uses full width appropriately with proper max-width containers. Product grid shows 4+ columns. Navigation is horizontal. All elements are properly aligned and spaced. |

### TC-046: Product image loading and display

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-046 |
| **Title** | Verify product images load correctly |
| **Description** | Verify that product images load properly and are optimized for display. |
| **Requirement ID** | BR-006, BR-027 |
| **Type** | UX/UI Validation |
| **Preconditions** | Products with images exist in the system. |
| **Test Steps** | 1. Navigate to product listing page.<br>2. Observe product thumbnail images loading.<br>3. Click on a product to view detail page.<br>4. Observe main product image and any gallery images. |
| **Expected Results** | Images load without broken image icons. Images have appropriate alt text. Images are properly sized/cropped for their containers. Loading states (skeleton/spinner) are shown while images load. |

### TC-047: Form validation UI feedback

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-047 |
| **Title** | Verify form validation provides clear visual feedback |
| **Description** | Verify that form validation errors are clearly communicated to users with appropriate visual cues. |
| **Requirement ID** | BR-027 |
| **Type** | UX/UI Validation |
| **Preconditions** | User is on a form page (registration, checkout, etc.). |
| **Test Steps** | 1. Navigate to the registration form.<br>2. Submit the form with all fields empty.<br>3. Observe error messages and field highlighting. |
| **Expected Results** | Invalid fields are highlighted (red border or similar visual indicator). Error messages appear near the relevant field. Error messages are descriptive and helpful. Focus moves to the first error field. Screen readers can identify errors (ARIA attributes). |

### TC-048: Page load performance

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-048 |
| **Title** | Verify page load time is within acceptable limits |
| **Description** | Verify that key pages load within acceptable performance thresholds. |
| **Requirement ID** | BR-027 |
| **Type** | UX/UI Validation – Performance |
| **Preconditions** | Application is deployed and accessible. Standard network conditions. |
| **Test Steps** | 1. Open browser developer tools > Performance/Network tab.<br>2. Navigate to the homepage and record load time.<br>3. Navigate to product listing page and record load time.<br>4. Navigate to product detail page and record load time.<br>5. Navigate to checkout page and record load time. |
| **Expected Results** | Homepage loads within 3 seconds. Product listing loads within 3 seconds. Product detail page loads within 2 seconds. Checkout page loads within 2 seconds. First Contentful Paint (FCP) < 1.5 seconds. |

---

## 9. Additional Functional Test Cases

### TC-049: Add product to wishlist

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-049 |
| **Title** | Add a product to the wishlist |
| **Description** | Verify that a registered user can add a product to their wishlist. |
| **Requirement ID** | BR-010 |
| **Type** | Functional – Positive |
| **Preconditions** | User is registered and logged in. |
| **Test Steps** | 1. Navigate to a product detail page.<br>2. Click the "Add to Wishlist" button/icon.<br>3. Navigate to "My Wishlist" page. |
| **Expected Results** | Product is added to the wishlist. Wishlist icon updates (e.g., turns solid/filled). Product appears in "My Wishlist" page with correct details. |

### TC-050: Product reviews and ratings

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-050 |
| **Title** | Submit a product review and rating |
| **Description** | Verify that a logged-in user can submit a review and rating for a purchased product. |
| **Requirement ID** | BR-016 |
| **Type** | Functional – Positive |
| **Preconditions** | User is logged in and has purchased the product. |
| **Test Steps** | 1. Navigate to the purchased product's detail page.<br>2. Scroll to the reviews section.<br>3. Select a rating (e.g., 4 out of 5 stars).<br>4. Enter review text "Great product, fast delivery!".<br>5. Click "Submit Review". |
| **Expected Results** | Review is submitted successfully. Confirmation message is displayed. Review appears on the product page (may require moderation). Average rating updates accordingly. |

### TC-051: Tax and shipping calculation

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-051 |
| **Title** | Verify automatic tax and shipping calculation |
| **Description** | Verify that tax and shipping costs are calculated automatically based on the shipping address. |
| **Requirement ID** | BR-022 |
| **Type** | Functional – Positive |
| **Preconditions** | User has items in cart and is at the checkout shipping step. |
| **Test Steps** | 1. Navigate to checkout.<br>2. Enter shipping address (e.g., California, USA).<br>3. Select a shipping method (e.g., Standard Shipping).<br>4. Observe the order summary. |
| **Expected Results** | Tax is calculated based on the destination state/country. Shipping cost is displayed based on selected method. Order total = Subtotal + Tax + Shipping. All calculations are correct. |

### TC-052: Multiple shipping methods selection

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-052 |
| **Title** | Verify availability of multiple shipping methods |
| **Description** | Verify that users can select from multiple shipping methods during checkout. |
| **Requirement ID** | BR-023 |
| **Type** | Functional – Positive |
| **Preconditions** | User has items in cart and is at the shipping step of checkout. |
| **Test Steps** | 1. Navigate to checkout shipping step.<br>2. Enter valid shipping address.<br>3. Observe available shipping options. |
| **Expected Results** | Multiple shipping options are displayed (e.g., Standard, Express, Overnight). Each option shows estimated delivery time and cost. Selecting different options updates the order total accordingly. |

### TC-053: Order history for registered users

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-053 |
| **Title** | Verify order history displays all past orders |
| **Description** | Verify that a registered user can view their complete order history. |
| **Requirement ID** | BR-024 |
| **Type** | Functional – Positive |
| **Preconditions** | Registered user has placed multiple orders. |
| **Test Steps** | 1. Log in to user account.<br>2. Navigate to "My Orders" or "Order History".<br>3. View the list of past orders. |
| **Expected Results** | All past orders are displayed in reverse chronological order. Each order shows: order number, date, total amount, status. User can click on an order to view full details. |

### TC-054: Admin manages categories and inventory

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-054 |
| **Title** | Admin adds and manages product categories |
| **Description** | Verify that an admin can create, edit, and organize product categories. |
| **Requirement ID** | BR-019 |
| **Type** | Functional – Positive |
| **Preconditions** | Admin user is logged in to the admin panel. |
| **Test Steps** | 1. Navigate to Admin Panel > Categories.<br>2. Click "Add New Category".<br>3. Enter category name (e.g., "Smart Home").<br>4. Add a category description.<br>5. Click "Save".<br>6. Assign products to the new category. |
| **Expected Results** | Category is created successfully. Category appears in the category list and on the storefront. Products can be assigned to the category. Category navigation updates accordingly. |

### TC-055: Low inventory notification

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-055 |
| **Title** | Verify low inventory notification for admin |
| **Description** | Verify that the system sends notifications when product inventory falls below threshold. |
| **Requirement ID** | BR-020 |
| **Type** | Functional – Positive |
| **Preconditions** | Product inventory threshold is set to 5 units. |
| **Test Steps** | 1. A product's stock level drops to 4 (below threshold of 5).<br>2. Check admin notifications/email. |
| **Expected Results** | Admin receives a notification (email or in-app) alerting that the product inventory is low. Notification includes product name and current stock level. |

---

## 10. Security Test Cases

### TC-056: SQL injection prevention in search

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-056 |
| **Title** | Verify search input is protected against SQL injection |
| **Description** | Verify that the search functionality sanitizes input to prevent SQL injection attacks. |
| **Requirement ID** | BR-028 |
| **Type** | Security – Negative |
| **Preconditions** | Application is accessible. |
| **Test Steps** | 1. Navigate to the search bar.<br>2. Enter "'; DROP TABLE products; --".<br>3. Submit the search. |
| **Expected Results** | Application handles the input safely. No database error or unexpected behavior occurs. "No results found" or similar safe response is returned. Database remains intact. |

### TC-057: Session timeout and security

| Field | Details |
|-------|---------|
| **Test Case ID** | TC-057 |
| **Title** | Verify session expires after inactivity |
| **Description** | Verify that user sessions expire after a configured period of inactivity. |
| **Requirement ID** | BR-028 |
| **Type** | Security |
| **Preconditions** | User is logged in. Session timeout is configured (e.g., 30 minutes). |
| **Test Steps** | 1. Log in to the application.<br>2. Wait for the session timeout period (30 minutes) without any activity.<br>3. Attempt to access a protected page (e.g., "My Account"). |
| **Expected Results** | User session has expired. User is redirected to the login page. A message "Session expired. Please log in again" is displayed. |

---

## Traceability Matrix

| Test Case ID | Requirement ID | Category |
|---|---|---|
| TC-001 | BR-018 | Product Adding |
| TC-002 | BR-018 | Product Adding |
| TC-003 | BR-018 | Product Adding |
| TC-004 | BR-018 | Product Adding |
| TC-005 | BR-018 | Product Adding |
| TC-006 | BR-007 | Shopping Cart |
| TC-007 | BR-008 | Shopping Cart |
| TC-008 | BR-009 | Shopping Cart |
| TC-009 | BR-008 | Shopping Cart |
| TC-010 | BR-008, BR-009 | Shopping Cart |
| TC-011 | BR-007 | Shopping Cart |
| TC-012 | BR-005 | Product Search |
| TC-013 | BR-005 | Product Search |
| TC-014 | BR-005 | Product Search |
| TC-015 | BR-005 | Product Search |
| TC-016 | BR-004, BR-005 | Product Search |
| TC-017 | BR-005 | Product Search |
| TC-018 | BR-011 | Checkout |
| TC-019 | BR-011, BR-001 | Checkout |
| TC-020 | BR-011 | Checkout |
| TC-021 | BR-011 | Checkout |
| TC-022 | BR-001, BR-011 | Checkout |
| TC-023 | BR-021 | Checkout |
| TC-024 | BR-021 | Checkout |
| TC-025 | BR-012, BR-029 | Payment |
| TC-026 | BR-012, BR-029 | Payment |
| TC-027 | BR-012, BR-029 | Payment |
| TC-028 | BR-012, BR-029 | Payment |
| TC-029 | BR-012, BR-029 | Payment |
| TC-030 | BR-012, BR-029 | Payment |
| TC-031 | BR-028, BR-029 | Payment |
| TC-032 | BR-013 | Order Confirmation |
| TC-033 | BR-013, BR-015 | Order Confirmation |
| TC-034 | BR-013, BR-015 | Order Confirmation |
| TC-035 | BR-014, BR-015 | Order Confirmation |
| TC-036 | BR-014 | Order Confirmation |
| TC-037 | BR-001 | User Registration |
| TC-038 | BR-001 | User Registration |
| TC-039 | BR-003 | User Registration |
| TC-040 | BR-002 | User Registration |
| TC-041 | BR-002 | User Registration |
| TC-042 | BR-002 | User Registration |
| TC-043 | BR-027 | UX/UI |
| TC-044 | BR-027 | UX/UI |
| TC-045 | BR-027 | UX/UI |
| TC-046 | BR-006, BR-027 | UX/UI |
| TC-047 | BR-027 | UX/UI |
| TC-048 | BR-027 | UX/UI |
| TC-049 | BR-010 | Additional |
| TC-050 | BR-016 | Additional |
| TC-051 | BR-022 | Additional |
| TC-052 | BR-023 | Additional |
| TC-053 | BR-024 | Additional |
| TC-054 | BR-019 | Additional |
| TC-055 | BR-020 | Additional |
| TC-056 | BR-028 | Security |
| TC-057 | BR-028 | Security |
