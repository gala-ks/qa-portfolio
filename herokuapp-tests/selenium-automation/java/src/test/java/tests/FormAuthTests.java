package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FormAuthPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class FormAuthTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() {
        FormAuthPage formAuthPage = homePage.clickFormAuth();
        formAuthPage.setUsername("tomsmith");
        formAuthPage.setPassword("SuperSecretPassword!");

        SecureAreaPage secureAreaPage = formAuthPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText().contains(
                "You logged into a secure area!"),
                "Alert text is incorrect");
    }
}
