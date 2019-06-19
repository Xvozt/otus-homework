package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCaseHelper extends TestSuiteHelper {

    public TestCaseHelper(WebDriver wd) {
        super(wd);
    }

    public void createTestCase(String testSuiteName, String testCaseName) {
        selectCreatedTestSuite(testSuiteName);
        switchToWorkFrame();
        pressActionsButton();
        initTestCreation();
        fillTestCaseData(testCaseName);
        switchToParentFrame();
        submitTestCaseCreation();
    }

    private void submitTestCaseCreation() {
        click(By.xpath("//input[@id='do_create_button']"));
    }

    private void fillTestCaseData(String testCaseName) {
        type(By.cssSelector("#testcase_name"), testCaseName);
        switchToFirstTextInputField();
        type(By.cssSelector("body.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders:nth-child(2)"), "Test case details");

    }

    private void initTestCreation() {
        click(By.cssSelector("#create_tc"));
    }

    private void selectTestCase(String testCaseName) {
        switchToMainFrame();
        switchToTreeFrame();
        click(By.xpath("//span[contains(text(),'" + testCaseName + "')]"));
        switchToDefaultContent();
    }

    private void selectAddingSteps() {
        switchToMainFrame();
        switchToWorkFrame();
        click(By.xpath("//input[@name='create_step']"));
        switchToDefaultContent();
    }

    private void addStepsToTestCase(String actions, String expectedResult) {
        for (int i = 0; i < 3; i++) {
            switchToMainFrame();
            switchToWorkFrame();
            switchToFirstTextInputField();
            type(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']"), actions);
            switchToParentFrame();
            switchToSecondTextInputField();
            type(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']"), expectedResult);
            switchToParentFrame();
            if (i == 2) {
                click(By.cssSelector("#do_update_step_and_exit"));
            }
            else {
                click(By.cssSelector("#do_update_step"));
            }
            switchToParentFrame();
            switchToParentFrame();
        }

    }

    public void addSteps(String testCaseName, String actions, String expectedResults, String testSuiteName) {
        expandCreatedTestSuite(testSuiteName);
        selectTestCase(testCaseName);
        selectAddingSteps();
        addStepsToTestCase(actions, expectedResults);
    }

}
