package appmanager;

import data.CaseData;
import data.SuiteData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCaseHelper extends TestSuiteHelper {

    public TestCaseHelper(WebDriver wd) {
        super(wd);
    }

    public void createTestCase(SuiteData suiteData, CaseData caseData) {
        selectCreatedTestSuite(suiteData);
        pressActionsButton();
        initTestCreation();
        fillTestCaseData(caseData);
        switchToParentFrame();
        submitTestCaseCreation();
    }

    private void submitTestCaseCreation() {
        click(By.xpath("//input[@id='do_create_button']"));
    }

    private void fillTestCaseData(CaseData caseData) {
        type(By.cssSelector("#testcase_name"), caseData.getName());
        switchToFirstTextInputField();
        type(By.cssSelector("body.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders:nth-child(2)"), caseData.getDetails());

    }

    private void initTestCreation() {
        click(By.cssSelector("#create_tc"));
    }

    private void selectTestCase(CaseData caseData, SuiteData suiteData) throws InterruptedException {
        Thread.sleep(500);
        switchToMainFrame();
        switchToTreeFrame();
        if (isClickable(By.xpath("//span[contains(text(),'" + caseData.getName() + "')]"))) {
            click(By.xpath("//span[contains(text(),'" + caseData.getName() + "')]"));
        }
        else {
            expandCreatedTestSuite(suiteData);
            Thread.sleep(500);
            switchToMainFrame();
            switchToTreeFrame();
            click(By.xpath("//span[contains(text(),'" + caseData.getName() + "')]"));

        }

        switchToDefaultContent();
    }

    private void selectAddingSteps(){
        switchToMainFrame();
        switchToWorkFrame();
        click(By.xpath("//input[@name='create_step']"));
        switchToDefaultContent();
    }

    private void addStepsToTestCase(CaseData caseData) {
        for (int i = 0; i < 3; i++) {
            switchToMainFrame();
            switchToWorkFrame();
            switchToFirstTextInputField();
            type(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']"), caseData.getActions());
            switchToParentFrame();
            switchToSecondTextInputField();
            type(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']"), caseData.getExpectedResults());
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

    public void addSteps(SuiteData suiteData, CaseData caseData) throws InterruptedException {
        expandCreatedTestSuite(suiteData);
        selectTestCase(caseData,  suiteData);
        selectAddingSteps();
        addStepsToTestCase(caseData);
        expandCreatedTestSuite(suiteData);

    }

}
