package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void testSpecificationPage() {
        switchToFrameByName("mainframe");
        click(By.xpath("//a[@class='list-group-item' and contains(@href,'?feature=editTc')]"));
    }
}

