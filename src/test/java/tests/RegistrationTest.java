package tests;

import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.BaseTest;

public class RegistrationTest extends BaseTest {
    @Test
    public void userCanRegister() {
        RegistrationPage register = new RegistrationPage(page);
        register.navigateToRegistration();
        register.register("testuser", "testemail@example.com", "Password321");
    }
}
