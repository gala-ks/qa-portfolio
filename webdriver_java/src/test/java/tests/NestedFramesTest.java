package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FramesPage;

import static org.testng.Assert.assertEquals;

public class NestedFramesTest extends BaseTests {

    @Test
    public void testNestedFrames() {
        FramesPage framesPage = homePage.clickFrames();
        var nestedFramesPage = framesPage.clickNestedFrames();

        String leftFrameText = nestedFramesPage.getLeftFrameText();
        String bottomFrameText = nestedFramesPage.getBottomFrameText();

        assertEquals(leftFrameText, "LEFT", "Left frame text is incorrect");
        assertEquals(bottomFrameText, "BOTTOM", "Bottom frame text is incorrect");
    }
}
