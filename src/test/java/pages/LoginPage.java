package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    // Locators
    private final String usernameField = "#username";
    private final String passwordField = "#password";
    private final String loginButton = "button[type='submit']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigateToLogin() {
        page.navigate("https://fictionalstore.com/login");
    }

    public void login(String username, String password) {
        page.fill(usernameField, username);
        page.fill(passwordField, password);
        page.click(loginButton);
        page.waitForLoadState();
    }
}
