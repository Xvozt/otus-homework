package appmanager;

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

    private void fillTestSuiteData(String testSuiteName) {
        type(By.cssSelector("#name"), testSuiteName);
        switchToFirstTextInputField();
        type(By.cssSelector("body.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders:nth-child(2)"), "Test testSuite details auto");
    }

    private void submitSuiteCreation() {
        click(By.cssSelector("input[name=add_testsuite_button]"));
    }

    protected void selectCreatedTestSuite(String name) {
        switchToDefaultContent();
        switchToMainFrame();
        switchToTreeFrame();
        click(By.xpath("//span[contains(text(), '" + name + "')]"));
    }

    protected void expandCreatedTestSuite(String name) {
        switchToDefaultContent();
        switchToMainFrame();
        switchToTreeFrame();
        doubleClick(By.xpath("//span[contains(text(), '"+name+"')]"));
        switchToDefaultContent();
    }

    private void confirmSuiteDeletion() {
        click(By.xpath("//input[@name='delete_testsuite']"));
    }

    private void initSuiteDeletion() {
        click(By.xpath("//input[@id='delete_testsuite']"));
    }





    public void create(String testSuiteName) {
        switchToMainFrame();
        switchToWorkFrame();
        pressActionsButton();
        initSuiteCreation();
        fillTestSuiteData(testSuiteName);
        switchToParentFrame();
        submitSuiteCreation();
    }

    public void delete(String testSuiteName) {
        selectCreatedTestSuite(testSuiteName);
        pressActionsButton();
        initSuiteDeletion();
        confirmSuiteDeletion();
        //switchToParentFrame();
        //homePage();
    }


}
