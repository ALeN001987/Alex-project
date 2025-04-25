package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void userCanLoginSuccessfully() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLogin();
        loginPage.login("testuser", "Password321");

        // Add an assert based on post-login element
        assert page.locator("text=Welcome, testuser").isVisible();
    }

    @Test
    public void loginWithInvalidCredentialsShowsError() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLogin();
        loginPage.login("wronguser", "wrongpass");

        assert page.locator("text=Invalid username or password").isVisible();
    }

    @Test
    public void loginWithEmptyFieldsShowsValidation() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLogin();
        loginPage.login("", "");

        assert page.locator("#username:invalid").isVisible(); // example for form validation
    }
}
