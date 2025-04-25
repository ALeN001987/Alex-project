package pages;

import com.microsoft.playwright.Page;

public class CheckOutPage {

    private final Page page;

    // Locators
    private final String checkoutButton = "#checkout";
    private final String addressInput = "#address";
    private final String cardNumberInput = "#card-number";
    private final String placeOrderButton = "#place-order";

    public CheckOutPage(Page page) {
        this.page = page;
    }

    public void proceedToCheckout() {
        page.click(checkoutButton);
        page.waitForSelector(addressInput);
    }

    public void enterPaymentDetails(String address, String cardNumber) {
        page.fill(addressInput, address);
        page.fill(cardNumberInput, cardNumber);
    }

    public void confirmOrder() {
        page.click(placeOrderButton);
        page.waitForSelector("text=Order Confirmation");
    }

    public boolean isOrderConfirmed() {
        return page.locator("text=Order Confirmation").isVisible();
    }
}
