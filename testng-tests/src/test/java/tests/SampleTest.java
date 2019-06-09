package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SampleTest extends TestBase {
    @Test
    public void removeCookies() {
    wd.findElement(By.cssSelector("button[class='js-cookie-accept button button_blue4 button_full2']")).click();

    }

}
