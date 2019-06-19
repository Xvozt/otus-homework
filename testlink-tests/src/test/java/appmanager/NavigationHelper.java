package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void testSpecificationPage() {
        switchToTitleBarFrame();
        click(By.xpath("//div[@class='menu_bar']//a[@accesskey='t']"));
        switchToDefaultContent();
    }

    public void homePage() {
        switchToDefaultContent();
        switchToTitleBarFrame();
        click(By.xpath("//div[1]//a[1]"));
    }
}

