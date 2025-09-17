package tests;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DynamicLoadingTests extends BaseTests {

    @Test
    public void testWaitUntilHidden() {
        var exampl1Page = homePage.clickDynamicLoading().clickExample1();
        exampl1Page.clickStartButton();
        assertEquals(exampl1Page.getLoadedText(), "Hello World!", "Loaded text is incorrect");
    }

    @Test
    public void testWaitUntilVisible() {
        var exampl1Page = homePage.clickDynamicLoading().clickExample2();
        exampl1Page.clickStartButton();
        assertEquals(exampl1Page.getLoadedText(), "Hello World!", "Loaded text is incorrect");
    }
}
