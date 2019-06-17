package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    protected void switchToByFrameName(String frameName) {
        wd.switchTo().frame(frameName);
    }

    protected void switchToByFrameIndex(int index) {
        wd.switchTo().frame(index);
    }

    protected void switchToParentFrame() {
        wd.switchTo().parentFrame();
    }

    protected void switchToDefaultContent() {
        wd.switchTo().defaultContent();
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
}
