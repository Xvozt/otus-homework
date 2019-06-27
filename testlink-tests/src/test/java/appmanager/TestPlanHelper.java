package appmanager;

import data.PlanData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPlanHelper extends HelperBase {

    public TestPlanHelper(WebDriver wd) {
        super(wd);
    }

    public void create(PlanData planData) {
        initTestPlanCreation();
        fillTestPlanInfo(planData);
        submitTestPlanCreation();
    }

    public void initTestPlanCreation() {
        switchToDefaultContent();
        switchToMainFrame();
        click(By.cssSelector("input[name='create_testplan']"));
    }

    public void fillTestPlanInfo(PlanData planData) {
        switchToDefaultContent();
        switchToMainFrame();
        type(By.cssSelector("input[name='testplan_name']"), planData.getName());
        switchToFirstTextInputField();
        type(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']"), planData.getDescription());
        switchToParentFrame();
        checkBoxActivate(By.cssSelector("input[name='active']"));
        checkBoxActivate(By.cssSelector("input[name='is_public']"));
    }

    public void submitTestPlanCreation() {
        switchToDefaultContent();
        switchToMainFrame();
        click(By.xpath("//input[@name='do_create']"));
    }
}
