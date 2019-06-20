package tests;

import org.testng.annotations.Test;

public class CreateTestProject extends TestBase {

    @Test
    public void createTestProject() {
        app.goTo().homePage();
        app.goTo().testProjectManagementPage();
        app.testProject().create("Homework4", "hw04", "Some test project for homework 04");
        app.goTo().homePage();
        app.goTo().testProjectManagementPage();
        //assert name, description, public flag
        app.testProject().delete("Homework4");
    }

}
