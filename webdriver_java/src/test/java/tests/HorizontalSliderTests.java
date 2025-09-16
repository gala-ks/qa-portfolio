package tests;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void testRange() {
        var sliderPage = homePage.clickHorizontalSlider();
        sliderPage.setSliderRange("4");

        assertEquals(sliderPage.getSliderValue(), "4");
    }
}
