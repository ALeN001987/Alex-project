package tests;

import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.ConfigReader;

public class SmokeTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void basicSmokeTestFlow() {
        LoginPage loginPage = new LoginPage(page);
        SearchPage searchPage = new SearchPage(page);
        CartPage cartPage = new CartPage(page);
        CheckOutPage checkoutPage = new CheckOutPage(page);

        // Step 1: Login
        page.navigate(ConfigReader.get("base.url"));
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        // Step 2: Select Product and Add to Cart
        searchPage.searchProduct("Bike Light");  // Or pick a known item from the inventory
        cartPage.addProductToCart("Bike Light");

        // Step 3: Go to Cart and Checkout
        cartPage.goToCart();
        checkoutPage.proceedToCheckout();

        // Step 4: Smoke validation
        assert page.locator("input[id='first-name']").isVisible(); // Validate checkout step loaded
    }
}
