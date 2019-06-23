package appmanager;

import data.ProjectData;
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

    private void fillTestProjectInfo(ProjectData testProjectData) {
        switchToDefaultContent();
        switchToMainFrame();
        type(By.xpath("//input[@name='tprojectName']"), testProjectData.getName());
        type(By.xpath("//input[@name='tcasePrefix']"), testProjectData.getPrefix());
        switchToFirstTextInputField();
        type(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']"),
                        testProjectData.getDescription());
    }

    private void submitTestProjectCreation() {
        switchToParentFrame();
        click(By.xpath("//input[@name='doActionButton']"));
    }

    public ProjectData projectInfoAfterCreation() {
        //заполнить локаторы
        String name = findElement(By.xpath("//tr[1]/td[1]//a[contains(@href, 'doAction=edit')]")).getText();
        String description = findElement(By.xpath("")).getAttribute("value");
        String prefix = findElement(By.xpath("")).getAttribute("value");
        return new ProjectData().withName(name).withDescription(description).withPrefix(prefix);
    }

    public void create(ProjectData testProjectData) {
        initProjectCreation();
        fillTestProjectInfo(testProjectData);
        submitTestProjectCreation();
    }

    public void delete(ProjectData testProjectData) {
        switchToDefaultContent();
        switchToMainFrame();
        //click on button
        //switch to alert window
        //press yes

    }
}
