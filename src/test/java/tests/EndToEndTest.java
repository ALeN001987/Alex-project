package tests;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.SearchPage;
import utils.BaseTest;

public class EndToEndTest extends BaseTest {

    @Test(groups = {"endtoend"})
    public void completePurchaseFlow() {
        LoginPage loginPage = new LoginPage(page);
        SearchPage searchPage = new SearchPage(page);
        CartPage cartPage = new CartPage(page);
        CheckOutPage checkoutPage = new CheckOutPage(page);

        // Step 1: Login
        page.navigate("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");

        // Step 2: Search and Select Product
        searchPage.searchProduct("Backpack"); // or use direct access on saucedemo

        // Step 3: Add to Cart
        cartPage.addProductToCart("Backpack");
        cartPage.goToCart();

        // Step 4: Proceed to Checkout
        checkoutPage.proceedToCheckout();

        // Step 5: Enter Address and Payment
        checkoutPage.enterPaymentDetails("123 Main St", "4111111111111111");

        // Step 6: Place Order
        checkoutPage.confirmOrder();

        // Assert order confirmation
        assert page.locator("text=THANK YOU FOR YOUR ORDER").isVisible();
    }
}
