package appmanager;

import data.CaseData;
import data.SuiteData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestRunHelper extends HelperBase {

    public TestRunHelper(WebDriver wd) {
        super(wd);
    }

    private void expandTestSuite(SuiteData suite) {
        switchToDefaultContent();
        switchToMainFrame();
        switchToTreeFrame();
        doubleClick(By.xpath("//span[contains(text(), '"+ suite.getName() +"')]"));
        switchToDefaultContent();
    }


    public void clickOnTest(CaseData testCase, SuiteData suite){
        switchToMainFrame();
        switchToTreeFrame();
        if (isClickable(By.xpath("//span[contains(text(),'" + testCase.getName() + "')]"))) {
            click(By.xpath("//span[contains(text(),'" + testCase.getName() + "')]"));
        }
        else {
            expandTestSuite(suite);
            switchToMainFrame();
            switchToTreeFrame();
            click(By.xpath("//span[contains(text(),'" + testCase.getName() + "')]"));

        }

        switchToDefaultContent();
    }

    public void checkThatNotExecuted() {
        switchToDefaultContent();
        switchToMainFrame();
        switchToWorkFrame();
        String rgbResultColor = findElement(By.cssSelector("div.not_run")).getCssValue("background-color");
        String hexResultColor = toHex(rgbResultColor);
        Assert.assertEquals("#000000", hexResultColor);
        switchToDefaultContent();
    }

    public void passTestCase(){
        for (int i = 1; i < 4; i ++) {
            switchToDefaultContent();
            switchToMainFrame();
            switchToWorkFrame();
            select(By.xpath("//tr[@id='" + "step_row_" + i + "']/td[6]/select[@class='step_status']")).selectByVisibleText("Passed");
        }
        switchToDefaultContent();
        switchToMainFrame();
        switchToWorkFrame();
        click(By.cssSelector("img[src*='test_status_passed.png']"));
        switchToDefaultContent();
    }

    public void checkThatPassed(CaseData testCase) {
        switchToDefaultContent();
        switchToMainFrame();
        switchToWorkFrame();
        String rgbResultColor = findElement(By.cssSelector("td.passed")).getCssValue("background-color");
        String hexResultColor = toHex(rgbResultColor);
        Assert.assertEquals("#006400", hexResultColor);
        switchToDefaultContent();
        switchToMainFrame();
        switchToTreeFrame();
        String testCaseInTree = String.format("//span[contains(text(),'%s')]", testCase.getName());
        String rgbTestCaseInTreeColor = findElement(By.xpath(testCaseInTree)).getCssValue("background-color");
        String hexTestCaseInTreeColor = toHex(rgbTestCaseInTreeColor);
        Assert.assertEquals("#D5EED5", hexTestCaseInTreeColor);
    }

    public void failTestCase() {
        for (int i = 1; i < 4; i ++) {
            switchToDefaultContent();
            switchToMainFrame();
            switchToWorkFrame();
            select(By.xpath("//tr[@id='" + "step_row_" + i + "']/td[6]/select[@class='step_status']")).selectByVisibleText("Failed");
        }
        switchToDefaultContent();
        switchToMainFrame();
        switchToWorkFrame();
        click(By.cssSelector("img[src*='test_status_failed.png']"));
        switchToDefaultContent();
    }

    public void checkThatFailed(CaseData testCase) {
        switchToDefaultContent();
        switchToMainFrame();
        switchToWorkFrame();
        String rgbResultColor = findElement(By.cssSelector("td.failed")).getCssValue("background-color");
        String hexResultColor = toHex(rgbResultColor);
        Assert.assertEquals("#B22222", hexResultColor);
        switchToDefaultContent();
        switchToMainFrame();
        switchToTreeFrame();
        String testCaseInTree = String.format("//span[contains(text(),'%s')]", testCase.getName());
        String rgbTestCaseInTreeColor = findElement(By.xpath(testCaseInTree)).getCssValue("background-color");
        String hexTestCaseInTreeColor = toHex(rgbTestCaseInTreeColor);
        Assert.assertEquals("#EED5D5", hexTestCaseInTreeColor);
    }

}
