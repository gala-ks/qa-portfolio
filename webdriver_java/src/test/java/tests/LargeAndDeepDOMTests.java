package tests;

import base.BaseTests;
import org.testng.annotations.Test;

public class LargeAndDeepDOMTests extends BaseTests {

    @Test
    public void testScrollToTable() {
        homePage.clickLargeAndDeepDOM().scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph() {
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
}
