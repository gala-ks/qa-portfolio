package tests;

import base.BaseTests;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        var fileAbsPath = "C:\\Users\\wgali\\OneDrive\\Desktop\\QA-Portfolio\\workspace\\webdriver_java\\pom.xml";
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile(fileAbsPath);

        assertEquals(uploadPage.getUploadedFiles(), Paths.get(fileAbsPath).getFileName().toString(), "Upload failed");
    }
}
