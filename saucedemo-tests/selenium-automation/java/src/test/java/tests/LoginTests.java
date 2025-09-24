package tests;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests {

    @Test
    public void testLoginValid() {
        System.out.println("testLoginValid");
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        productsPage = loginPage.clickLoginButtonSuccessfullFlow();

        assertEquals(productsPage.getPageTitle(), "Products", "Did not land on the Products page after login");
    }

    @Test
    public void testLoginWithNoPassword() {
        System.out.println("testLoginWithNoPassword");
        loginPage.setUsername("standard_user");
        loginPage.clickLoginButtonFailedFlow();

        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required",
                "Password required error message not displayed");
    }

    @Test
    public void testLoginWithInvalidPassword() {
        System.out.println("testLoginWithInvalidPassword");
        loginPage.setUsername("standard_user");
        loginPage.setPassword("MySecretPassword");
        loginPage.clickLoginButtonFailedFlow();

        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service",
                "Password required error message not displayed");
    }

    @Test
    public void testLoginWithNoUsername() {
        System.out.println("testLoginWithNoUsername");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButtonFailedFlow();

        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required",
                "Username required error message not displayed");
    }

    @Test
    public void testLoginWithNoCredentials() {
        System.out.println("testLoginWithNoCredentials");
        loginPage.clickLoginButtonFailedFlow();

        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required",
                "Username and password do not match error message not displayed");
    }
}
