package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }
    public void specificationPage() {
//
//        if (isElementPresent(By.cssSelector("div[class='menu_bar']"))
//        && isElementPresent(By.cssSelector("a[accesskey='t']"))) {
//            return;
//        }
        click(By.cssSelector("a[accesskey='t']"));
    }
}

