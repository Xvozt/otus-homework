package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelperBase {
    private WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        findElement(locator).click();
    }

    protected WebElement findElement(By locator) {
        return wd.findElement(locator);
    }


    protected void switchToMainFrame() {
        wait(2);
        wd.switchTo().frame(findElement(By.xpath("//frame[@name='mainframe']")));
    }

    protected void switchToWorkFrame() {
        wait(2);
        wd.switchTo().frame(findElement(By.xpath("//frame[@name='workframe']")));
    }

    protected void switchToTreeFrame() {
        wait(2);
        wd.switchTo().frame(findElement(By.xpath("//frame[@name='treeframe']")));
    }

    protected void switchToTitleBarFrame() {
        wait(2);
        wd.switchTo().frame(findElement(By.xpath("//frame[@name='titlebar']")));
    }
    protected void switchToFrameByIndex(int index) {
        wd.switchTo().frame(index);
    }

    protected void switchToParentFrame() {
        wd.switchTo().parentFrame();
    }

    protected void switchToDefaultContent() {
        wd.switchTo().defaultContent();
    }


    protected void switchToFirstTextInputField() {
        wait(2);
        wd.switchTo().frame(findElement(By.xpath("//div[@id='cke_1_contents']//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]")));
    }

    protected void switchToSecondTextInputField() {
        wait(2);
        wd.switchTo().frame(findElement(By.xpath("//div[@id='cke_2_contents']//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]")));
    }

    protected List<WebElement> findElements(By locator) {
        return wd.findElements(locator);
    }

    public boolean isElementPresent(By locator) {
        try {
            findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void type(By locator, String text) {
        if (text != null) {
            String existingText = findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                WebElement element  = findElement(locator);
                element.clear();
                element.sendKeys(text);
            }
        }
    }

    protected void doubleClick(By locator) {
//        Actions actions = new Actions(wd);
//        actions.doubleClick(findElement(locator)).perform();
        Actions action = new Actions(wd);
        WebElement element = wd.findElement(locator);
        action.doubleClick(element).perform();

    }

    protected void wait(int timeout) {
        wd.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

}
