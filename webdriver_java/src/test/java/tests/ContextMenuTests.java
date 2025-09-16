package tests;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testGetContextMenuText() {
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickBox();
        String text = contextMenuPage.getContextMenuText();
        contextMenuPage.acceptContextMenu();

        assertEquals(text, "You selected a context menu");
    }
}
