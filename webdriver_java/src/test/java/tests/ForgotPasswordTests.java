package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testSuccessfulPasswordRetrieve() {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmail("test@gmail.com");

        EmailSentPage emailSentPage = forgotPasswordPage.clickRetrieveButton();

        //todo Need to finish when this webpage is working.
    }
}
