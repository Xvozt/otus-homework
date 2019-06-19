package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestSuiteHelper extends HelperBase {
    public TestSuiteHelper (WebDriver wd) {
        super(wd);
    }

    protected void pressActionsButton() {
        click(By.cssSelector("img.clickable[title='Actions']"));
    }

    private void initSuiteCreation() {
        click(By.xpath("//input[@id='new_testsuite']"));
    }

    private void fillTestSuiteData(String testSuiteName) {
        type(By.cssSelector("#name"), testSuiteName);
        switchToFrameByIndex(0);
        type(By.cssSelector("body.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders:nth-child(2)"), "Test testSuite details auto");
    }

    private void submitSuiteCreation() {
        click(By.cssSelector("input[name=add_testsuite_button]"));
    }

    protected void selectCreatedTestSuite(String name) {
        switchToDefaultContent();
        switchToFrameByLocator(By.xpath("//frame[@name='mainframe']"));
        switchToFrameByLocator(By.xpath("//frame[@name='treeframe']"));
        click(By.xpath("//span[contains(text(), '"+name+"')]"));
        switchToParentFrame();
    }

    protected void doubleClickOnCreatedTestSuite(String name) {
        switchToParentFrame();
        switchToParentFrame();
        switchToFrameByIndex(0);
        doubleClick(By.xpath("//span[contains(text(), '"+name+"')]"));
        switchToParentFrame();
    }

    private void confirmSuiteDeletion() {
        click(By.xpath("//input[@name='delete_testsuite']"));
    }

    private void initSuiteDeletion() {
        click(By.xpath("//input[@id='delete_testsuite']"));
    }

    private void goToHomePage() {
        switchToDefaultContent();
        switchToFrameByIndex(0);
        click(By.xpath("//div[1]//a[1]"));
    }



    public void create(String testSuiteName) {
        switchToFrameByIndex(1);
        pressActionsButton();
        initSuiteCreation();
        fillTestSuiteData(testSuiteName);
        switchToParentFrame();
        submitSuiteCreation();
    }

    public void delete(String testSuiteName) {
        selectCreatedTestSuite(testSuiteName);
        switchToFrameByIndex(1);
        pressActionsButton();
        initSuiteDeletion();
        confirmSuiteDeletion();
        switchToParentFrame();
        goToHomePage();
    }


}
