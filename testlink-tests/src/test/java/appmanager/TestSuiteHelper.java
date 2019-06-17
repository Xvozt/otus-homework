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
        type(By.cssSelector("#name"), "Test suite name auto");
        switchToByFrameIndex(0);
        type(By.cssSelector("body.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders:nth-child(2)"), "Test suite details auto");
    }

    public void submitSuiteCreation() {
        click(By.cssSelector("input[name=add_testsuite_button]"));
    }

    public void selectCreatedTestSuite() {

    }



    public void create() {
        switchToByFrameIndex(1);
        pressActionsButton();
        initSuiteCreation();
        fillTestSuiteData();
        switchToParentFrame();
        submitSuiteCreation();
    }



    public void delete() {
    }
}
