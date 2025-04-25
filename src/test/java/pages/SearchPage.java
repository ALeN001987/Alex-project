package pages;

import com.microsoft.playwright.Page;

public class SearchPage {

    private final Page page;

    // Locators
    private final String searchInput = "input[name='search']";
    private final String searchButton = "button[type='submit']";

    public SearchPage(Page page) {
        this.page = page;
    }

    public void searchProduct(String productName) {
        page.fill(searchInput, productName);
        page.click(searchButton);
        page.waitForSelector(".search-results"); // adjust based on your app
    }

    public boolean isProductVisible(String productName) {
        return page.locator("text=" + productName).isVisible();
    }
}
