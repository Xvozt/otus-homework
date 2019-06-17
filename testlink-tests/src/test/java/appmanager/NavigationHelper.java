package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void logInPage() {
        if (isElementPresent(By.xpath("//div[@class='menu_bar']"))) {
            return;
        }
        click(By.linkText("Test Plan Management"));
    }
}

