package tests.util;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigation() {
        homePage.clickDynamicLoading().clickExample1();
        getWindowNavigator().goBack();
        getWindowNavigator().refreshPage();
        getWindowNavigator().goForward();
        getWindowNavigator().goTo("https://google.com");
    }

    @Test
    public void testWindowTabs() {
        var buttonPage = homePage.clickDynamicLoading().rightClickOnExample2Link();
        getWindowNavigator().switchToNewTab();
        assertTrue(buttonPage.isStartButtonDisplayed(), "Start button is not displayed");
    }
}
