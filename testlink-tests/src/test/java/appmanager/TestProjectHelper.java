package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestProjectHelper extends HelperBase {

    public TestProjectHelper(WebDriver wd) {
        super(wd);
    }

    private void initProjectCreation() {
        switchToDefaultContent();
        switchToMainFrame();
        click(By.cssSelector("#create"));
    }

    private void fillTestProjectInfo(String projectName, String projectPrefix, String projectDescription) {
        switchToDefaultContent();
        switchToMainFrame();
        type(By.xpath("//input[@name='tprojectName']"), projectName);
        type(By.xpath("//input[@name='tcasePrefix']"), projectPrefix);
        switchToFirstTextInputField();
        type(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']"), projectDescription);
    }

    private void submitTestProjectCreation() {
        switchToParentFrame();
        click(By.xpath("//input[@name='doActionButton']"));
    }

    public void create(String projectName, String projectPrefix, String projectDescription) {
        initProjectCreation();
        fillTestProjectInfo(projectName, projectPrefix, projectDescription);
        submitTestProjectCreation();
    }

    public void delete(String projectName) {
        switchToDefaultContent();
        switchToMainFrame();
        //click on button
        //switch to alert window
        //press yes

    }
}
