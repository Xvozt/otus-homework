package tests;

import helpers.ExecutionListener;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExecutionListener.class)
public class SampleTest extends TestBase {
    @Test(description =  "Removing cookie button after opening url")
    public void removeCookies() {
    wd.findElement(By.cssSelector("button[class='js-cookie-accept button button_blue4 button_full2']")).click();
    }

}
