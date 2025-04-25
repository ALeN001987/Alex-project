package pages;

import com.microsoft.playwright.Page;

public class CartPage {

    private final Page page;

    // Locators
    private final String addToCartButton = "button.add-to-cart"; // Replace with real selector
    private final String cartIcon = "#cart-icon";

    public CartPage(Page page) {
        this.page = page;
    }

    public void addProductToCart(String productName) {
        page.click("text=" + productName); // Click on product
        page.click(addToCartButton);
        page.waitForSelector(cartIcon);
    }

    public boolean isCartUpdated() {
        return page.locator(cartIcon).innerText().matches("\\d+");
    }

    public void goToCart() {
        page.click(cartIcon);
        page.waitForLoadState();
    }
}
