package appmanager;

import data.SuiteData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestAddingHelper extends HelperBase {

    public TestAddingHelper(WebDriver wd) {
        super(wd);
    }

    public void checkAndAddTestCases(SuiteData suite) {
        chooseSuite(suite);
        checkAllCases();
        addSelected();
    }

    private void checkAllCases() {
        switchToMainFrame();
        switchToWorkFrame();
        click(By.xpath("//button[contains(text(),'adding')]"));
        switchToDefaultContent();
    }

    private void addSelected() {
        switchToMainFrame();
        switchToWorkFrame();
        click(By.xpath("//input[@name='doAddRemove']"));
    }

    private void chooseSuite(SuiteData suite) {
        switchToDefaultContent();
        switchToMainFrame();
        switchToTreeFrame();
        click(By.xpath("//span[contains(text(), '"+ suite.getName() +"')]"));
        switchToDefaultContent();
    }
}
