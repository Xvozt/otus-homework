package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCaseHelper extends TestSuiteHelper {

    public TestCaseHelper(WebDriver wd) {
        super(wd);
    }

    public void createTestCase() {
        selectCreatedTestSuite("Test testSuite name auto");
        switchToFrameByIndex(1);
        pressActionsButton();
        initTestCreation();
        fillTestCaseData();
        switchToParentFrame();
        submitTestCaseCreation();
    }

    private void submitTestCaseCreation() {
        click(By.xpath("//input[@id='do_create_button']"));
    }

    private void fillTestCaseData() {
        type(By.cssSelector("#testcase_name"), "test case auto");
        switchToFrameByIndex(0);
        type(By.cssSelector("body.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders:nth-child(2)"), "Test case details");

    }

    private void initTestCreation() {
        click(By.cssSelector("#create_tc"));
    }

}
