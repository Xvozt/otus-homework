package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestSuiteHelper extends HelperBase {
    public TestSuiteHelper (WebDriver wd) {
        super(wd);
    }

    public void pressActionsButton() {
        click(By.cssSelector("img.clickable[title='Actions']"));
    }

    public void initSuiteCreation() {
        click(By.xpath("//input[@id='new_testsuite']"));
    }

    public void fillTestSuiteData() {
        type(By.cssSelector("#name"), "Test testSuite name auto");
        switchToFrameByIndex(0);
        type(By.cssSelector("body.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders:nth-child(2)"), "Test testSuite details auto");
    }

    public void submitSuiteCreation() {
        click(By.cssSelector("input[name=add_testsuite_button]"));
    }

    public void selectCreatedTestSuite(String name) {
        switchToParentFrame();
        switchToFrameByIndex(0);
        click(By.xpath("//span[contains(text(), '"+name+"')]"));
        switchToParentFrame();
    }

    private void confirmSuiteDeletion() {
        click(By.xpath("//input[@name='delete_testsuite']"));
    }

    private void initSuiteDeletion() {
        click(By.xpath("//input[@id='delete_testsuite']"));
    }



    public void create() {
        switchToFrameByIndex(1);
        pressActionsButton();
        initSuiteCreation();
        fillTestSuiteData();
        switchToParentFrame();
        submitSuiteCreation();
    }

    public void delete() {
        selectCreatedTestSuite("Test testSuite name auto");
        switchToFrameByIndex(1);
        pressActionsButton();
        initSuiteDeletion();
        confirmSuiteDeletion();
    }


}
