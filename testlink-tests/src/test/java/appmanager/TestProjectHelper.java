package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestProjectHelper extends HelperBase {

    public TestProjectHelper(WebDriver wd) {
        super(wd);
    }

    private void initProjectCreation() {
        switchToDefaultContent();
        switchToMainFrame();
        click(By.cssSelector("#create"));
    }

    public void create() {
        initProjectCreation();
    }
}
