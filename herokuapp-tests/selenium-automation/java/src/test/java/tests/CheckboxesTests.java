package tests;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckboxesTests extends BaseTests {

    @Test
    public void testCheckboxes() {
        var checkboxesPage = homePage.clickCheckboxes();
        checkboxesPage.setCheckbox1(true);
        checkboxesPage.setCheckbox2(false);

        assertTrue(checkboxesPage.isCheckbox1Checked(), "Checkbox 1 is not checked");
        assertFalse(checkboxesPage.isCheckbox2Checked(), "Checkbox 2 is checked");
    }
}
