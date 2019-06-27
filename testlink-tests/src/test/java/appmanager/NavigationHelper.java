package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void testSpecificationPage() {
        switchToDefaultContent();
        switchToTitleBarFrame();
        click(By.xpath("//div[@class='menu_bar']//a[@accesskey='t']"));
        switchToDefaultContent();
    }

    public void homePage() {
        switchToDefaultContent();
        switchToTitleBarFrame();
        click(By.xpath("//div[1]//a[1]"));
    }

    public void testProjectManagementPage()  {
        switchToDefaultContent();
        switchToMainFrame();
        click(By.xpath("//a[@class='list-group-item' and contains(@href,'projectView')]"));
    }

    public void testPlanManagementPage() {
        switchToDefaultContent();
        switchToMainFrame();
        click(By.xpath("//a[@class='list-group-item' and contains(@href, 'planView.php')]"));
    }

}

