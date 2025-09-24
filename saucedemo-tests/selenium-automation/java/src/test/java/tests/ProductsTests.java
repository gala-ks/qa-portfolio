package tests;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ProductsTests extends BaseTests {

    @Override
    public void setupChildPage() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        productsPage = loginPage.clickLoginButtonSuccessfullFlow();
    }

    @Test
    public void testAddAndRemoveSingleProduct() {
        productsPage.addBackpackToCart();
        assertEquals(productsPage.getCartItemCount(), 1, "Bike Light was not added to the cart");

        productsPage.removeBackpackFromCart();
        assertNotEquals(productsPage.getCartItemCount(), 0, "Bike Light was not removed from the cart");
    }

    @Test
    public void testAddAndRemoveMultipleProducts() {
        productsPage.addBikeLightToCart();
        productsPage.addBackpackToCart();
        assertEquals(productsPage.getCartItemCount(), 2, "Cart item count is not 2 after adding two products");

        productsPage.removeBikeLightFromCart();
        productsPage.removeBackpackFromCart();
        assertEquals(productsPage.getCartItemCount(), 0, "Cart item count is not 0 after removing all products");
    }
}

