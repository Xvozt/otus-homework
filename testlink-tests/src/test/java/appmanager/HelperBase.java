package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelperBase {
    private WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        findElement(locator).click();
    }

    protected WebElement findElement(By locator) {
        return wd.findElement(locator);
    }


    protected void switchToMainFrame() {
       waitUntilFrameLoadedAndClick(By.xpath("//frame[@name='mainframe']"));
    }

    protected void switchToWorkFrame() {
        waitUntilFrameLoadedAndClick(By.xpath("//frame[@name='workframe']"));
    }

    protected void switchToTreeFrame() {
        waitUntilFrameLoadedAndClick(By.xpath("//frame[@name='treeframe']"));
    }

    protected void switchToTitleBarFrame() {
        waitUntilFrameLoadedAndClick(By.xpath("//frame[@name='titlebar']"));
    }

    protected void switchToParentFrame() {
        wd.switchTo().parentFrame();
    }

    protected void switchToDefaultContent() {
        wd.switchTo().defaultContent();
    }


    protected void switchToFirstTextInputField() {
        waitUntilFrameLoadedAndClick(By.xpath("//div[@id='cke_1_contents']//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]"));
    }

    protected void switchToSecondTextInputField() {
        waitUntilFrameLoadedAndClick(By.xpath("//div[@id='cke_2_contents']//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]"));
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
                WebDriverWait wait = new WebDriverWait(wd, 10);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.clear();
                element.sendKeys(text);
            }
        }
    }

    protected void doubleClick(By locator) {
        Actions action = new Actions(wd);
        action.doubleClick(findElement(locator)).perform();

    }

    private void waitUntilFrameLoadedAndClick(By locator) {
        WebDriverWait wait = new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

}
