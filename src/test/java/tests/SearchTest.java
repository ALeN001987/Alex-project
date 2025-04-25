package tests;

import org.testng.annotations.Test;
import pages.SearchPage;
import utils.BaseTest;

public class SearchTest extends BaseTest {

    @Test
    public void userCanSearchForProduct() {
        SearchPage searchPage = new SearchPage(page);
        page.navigate("https://fictionalstore.com");

        searchPage.searchProduct("Laptop");

        assert searchPage.isProductVisible("Laptop");
    }
    @Test
    public void searchingNonExistentProductShowsNoResults() {
        SearchPage searchPage = new SearchPage(page);
        page.navigate("https://fictionalstore.com");

        searchPage.searchProduct("nonexistentproduct123");

        assert page.locator("text=No results found").isVisible();
    }

    @Test
    public void searchFieldIsAccessible() {
        page.navigate("https://fictionalstore.com");
        assert page.locator("input[name='search']").isEnabled();
    }

}
