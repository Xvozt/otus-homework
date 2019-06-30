package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    protected void safeClick(By locator) {
        WebElement element = findElement(locator);
        Actions actions = new Actions(wd);
        actions.moveToElement(element).click().build().perform();
    }

    protected WebElement findElement(By locator) {
        return wd.findElement(locator);
    }

    protected List<WebElement> findElements(By locator) {
        return wd.findElements(locator);
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

    public void checkBoxActivate(By locator) {
        if (!findElement(locator).isSelected()) {
            click(locator);
        }
    }

    public void checkBoxDeactivate(By locator) {
        if (findElement(locator).isSelected()) {
            click(locator);
        }
    }


    protected Select select(By locator) {
        Select select = new Select(findElement(locator));
        return select;
    }



    protected void doubleClick(By locator) {
        Actions action = new Actions(wd);
        action.doubleClick(findElement(locator)).perform();

    }

    private void waitUntilFrameLoadedAndClick(By locator) {
        WebDriverWait wait = new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }


    protected boolean isClickable(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(wd, 1);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        }
        catch (TimeoutException t) {
            return false;
        }
    }

    protected String toHex(String rgbColor) {
        String[] rgb = rgbColor.replace("rgba(", "").replace(")", "").split(",");
        int r = Integer.parseInt(rgb[0].trim());
        int g = Integer.parseInt(rgb[1].trim());
        int b = Integer.parseInt(rgb[2].trim());
        return String.format("#%02X%02X%02X", r, g, b);
    }
}
