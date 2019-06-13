package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthHelper extends HelperBase {

    public AuthHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        type(By.cssSelector("input[id='tl_login']"), username);
        type(By.cssSelector("input[id='tl_password']"), password);
        click(By.cssSelector("input[type='submit']"));

    }
}
