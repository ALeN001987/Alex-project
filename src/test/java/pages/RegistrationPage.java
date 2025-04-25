package pages;

import com.microsoft.playwright.Page;

public class RegistrationPage {
    private final Page page;

    public RegistrationPage(Page page) {
        this.page = page;
    }

    public void navigateToRegistration() {
        page.navigate("https://fictionalstore.com/register");
    }

    public void register(String username, String email, String password) {
        page.fill("#username", username);
        page.fill("#email", email);
        page.fill("#password", password);
        page.click("button[type='submit']");
    }
}
