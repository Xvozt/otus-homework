package appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum Browsers {
    CHROME {
        public WebDriver create() {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    },
    FIREFOX {
        public WebDriver create() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    },
    EDGE {
        public WebDriver create() {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
    },
    DEFAULT_CHROME  {
        public WebDriver create() {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    };

    public WebDriver create() {
        return null;
    }

    public static Browsers find(String name){
        switch (name) {
            case "chrome":
                return Browsers.CHROME;
            case "firefox":
                return Browsers.FIREFOX;
            case "edge":
                return Browsers.EDGE;
            default: return Browsers.DEFAULT_CHROME;
        }
    }
}
