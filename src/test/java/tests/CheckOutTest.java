package tests;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.SearchPage;
import utils.BaseTest;

public class CheckOutTest extends BaseTest {

    @Test
    public void userCanCheckoutSuccessfully() {
        SearchPage searchPage = new SearchPage(page);
        CartPage cartPage = new CartPage(page);
        CheckOutPage checkoutPage = new CheckOutPage(page);

        page.navigate("https://fictionalstore.com");

        searchPage.searchProduct("Laptop");
        cartPage.addProductToCart("Laptop");
        cartPage.goToCart();

        checkoutPage.proceedToCheckout();
        checkoutPage.enterPaymentDetails("123 Main St", "4111111111111111");
        checkoutPage.confirmOrder();

        assert checkoutPage.isOrderConfirmed();
    }

    @Test
    public void enteringInvalidCardShowsError() {
        SearchPage searchPage = new SearchPage(page);
        CartPage cartPage = new CartPage(page);
        CheckOutPage checkoutPage = new CheckOutPage(page);

        page.navigate("https://fictionalstore.com");

        searchPage.searchProduct("Tablet");
        cartPage.addProductToCart("Tablet");
        cartPage.goToCart();

        checkoutPage.proceedToCheckout();
        checkoutPage.enterPaymentDetails("456 Elm St", "123456");
        checkoutPage.confirmOrder();

        assert page.locator("text=Invalid card number").isVisible();
    }

    @Test
    public void requiredFieldsValidationDuringCheckout() {
        SearchPage searchPage = new SearchPage(page);
        CartPage cartPage = new CartPage(page);
        CheckOutPage checkoutPage = new CheckOutPage(page);

        page.navigate("https://fictionalstore.com");

        searchPage.searchProduct("Monitor");
        cartPage.addProductToCart("Monitor");
        cartPage.goToCart();

        checkoutPage.proceedToCheckout();
        checkoutPage.enterPaymentDetails("", "");
        checkoutPage.confirmOrder();

        assert page.locator("#address:invalid").isVisible();
        assert page.locator("#card-number:invalid").isVisible();
    }

}
