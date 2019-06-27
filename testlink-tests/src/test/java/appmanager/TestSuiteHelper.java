package appmanager;

import data.SuiteData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestSuiteHelper extends HelperBase {
    public TestSuiteHelper (WebDriver wd) {
        super(wd);
    }

    protected void pressActionsButton() {
        switchToDefaultContent();
        switchToMainFrame();
        switchToWorkFrame();
        click(By.cssSelector("img.clickable[title='Actions']"));
    }

    private void initSuiteCreation() {
        click(By.xpath("//input[@id='new_testsuite']"));
    }

    private void fillTestSuiteData(SuiteData suiteData) {
        type(By.cssSelector("#name"), suiteData.getName());
        switchToFirstTextInputField();
        type(By.cssSelector("body.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders:nth-child(2)"), suiteData.getDetails());
    }

    private void submitSuiteCreation() {
        click(By.cssSelector("input[name=add_testsuite_button]"));
    }

    protected void selectCreatedTestSuite(SuiteData suiteData) {
        switchToDefaultContent();
        switchToMainFrame();
        switchToTreeFrame();
        click(By.xpath("//span[contains(text(), '" + suiteData.getName() + "')]"));
    }

    protected void expandCreatedTestSuite(SuiteData suiteData) {
        switchToDefaultContent();
        switchToMainFrame();
        switchToTreeFrame();
        doubleClick(By.xpath("//span[contains(text(), '"+ suiteData.getName() +"')]"));
        switchToDefaultContent();
    }

    private void confirmSuiteDeletion() {
        click(By.xpath("//input[@name='delete_testsuite']"));
    }

    private void initSuiteDeletion() {
        click(By.xpath("//input[@id='delete_testsuite']"));
    }





    public void create(SuiteData suiteData) {
        switchToMainFrame();
        switchToWorkFrame();
        pressActionsButton();
        initSuiteCreation();
        fillTestSuiteData(suiteData);
        switchToParentFrame();
        submitSuiteCreation();
    }

    public void delete(SuiteData suiteData) {
        selectCreatedTestSuite(suiteData);
        pressActionsButton();
        initSuiteDeletion();
        confirmSuiteDeletion();
    }


}
