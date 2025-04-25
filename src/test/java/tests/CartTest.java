package tests;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.SearchPage;
import utils.BaseTest;

public class CartTest extends BaseTest {

    @Test
    public void userCanAddProductToCart() {
        SearchPage searchPage = new SearchPage(page);
        CartPage cartPage = new CartPage(page);

        page.navigate("https://fictionalstore.com");

        searchPage.searchProduct("Laptop");
        cartPage.addProductToCart("Laptop");

        assert cartPage.isCartUpdated();
    }

    @Test
    public void productIsDisplayedInCartAfterAdding() {
        SearchPage searchPage = new SearchPage(page);
        CartPage cartPage = new CartPage(page);

        page.navigate("https://fictionalstore.com");

        searchPage.searchProduct("Headphones");
        cartPage.addProductToCart("Headphones");
        cartPage.goToCart();

        assert page.locator("text=Headphones").isVisible();
    }

    @Test
    public void removingProductUpdatesCart() {
        SearchPage searchPage = new SearchPage(page);
        CartPage cartPage = new CartPage(page);

        page.navigate("https://fictionalstore.com");

        searchPage.searchProduct("Keyboard");
        cartPage.addProductToCart("Keyboard");
        cartPage.goToCart();

        page.click("button.remove-from-cart"); // replace with actual selector
        page.waitForSelector("text=Your cart is empty");

        assert page.locator("text=Your cart is empty").isVisible();
    }

}
