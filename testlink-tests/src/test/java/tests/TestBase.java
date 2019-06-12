package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {
        private static final Logger logger = LogManager.getLogger(tests.TestBase.class);
        ChromeDriver wd;

        @BeforeClass
        public static void setupClass() {
            WebDriverManager.chromedriver().setup();

        }

        @BeforeMethod
        public void setupTest() {
            wd = new ChromeDriver();
            wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            wd.get("http://localhost/index.php");
            wd.findElement(By.cssSelector("input[id='tl_login']")).sendKeys("user");
            wd.findElement(By.cssSelector("input[id='tl_password']")).sendKeys("bitnami");
            wd.findElement(By.cssSelector("input[type='submit']")).click();
        }

        @BeforeMethod
        public void logTestStart(Method m) {
            logger.info("Start test " + m.getName());
        }


        @AfterMethod
        public void teardown() {
            if (wd != null) {
                wd.quit();
            }
        }


        @AfterMethod
        public void logTestStop(Method m) {
            logger.info("Stop test " + m.getName());
        }
}
