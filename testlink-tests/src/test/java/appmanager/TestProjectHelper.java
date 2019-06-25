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
        switchToDefaultContent();
        switchToMainFrame();
        String name = findElement(By.xpath("//tr[1]/td[1]//a[contains(@href, 'doAction=edit')]")).getText();
        String description = findElement(By.xpath("//tr[1]/td[2]/p[1]")).getText();
        String prefix = findElement(By.xpath("//tr[1]/td[3]")).getText();
        return new ProjectData().withName(name).withDescription(description).withPrefix(prefix);
    }


    public boolean isPublicImageExisting() {
        return findElements(By.xpath("//tr[1]/td[8]/img[1]")).size() != 0;
    }

    public void create(ProjectData testProjectData) {
        initProjectCreation();
        fillTestProjectInfo(testProjectData);
        submitTestProjectCreation();
    }

    public void straightCreate(ProjectData testProjectData) {
        switchToDefaultContent();
        switchToMainFrame();
        fillTestProjectInfo(testProjectData);
        submitTestProjectCreation();
    }

    public void delete() {
        switchToDefaultContent();
        switchToMainFrame();
        click(By.xpath("//tr[1]//td[9]//img[1]"));
        click(By.cssSelector("#ext-gen20"));
    }

    public boolean noProjectExists() {
        switchToDefaultContent();
        switchToMainFrame();
        return findElements(By.xpath("//a[@class='list-group-item' and contains(@href,'projectView')]")).size() == 0;
    }
}
