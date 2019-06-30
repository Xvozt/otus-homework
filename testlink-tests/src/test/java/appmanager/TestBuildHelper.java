package appmanager;

import data.BuildData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestBuildHelper extends HelperBase {

    public TestBuildHelper(WebDriver wd) {
        super(wd);
    }

    private void initBuildCreation() {
        switchToDefaultContent();
        switchToMainFrame();
        click(By.xpath("//input[@name='create_build_bottom']"));

    }

    private void fillBuildInfo(BuildData build) {
        switchToDefaultContent();
        switchToMainFrame();
        type(By.cssSelector("#build_name"), build.getTitle());
        switchToFirstTextInputField();
        type(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']"), build.getDescription());
    }

    private void submitBuildCreation() {
        switchToDefaultContent();
        switchToMainFrame();
        click(By.xpath("//input[@name='do_create']"));
    }

    public void create(BuildData build) {
        initBuildCreation();
        fillBuildInfo(build);
        submitBuildCreation();
    }
}
