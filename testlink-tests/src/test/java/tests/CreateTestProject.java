package tests;

import org.testng.annotations.Test;

public class CreateTestProject extends TestBase {

    @Test
    public void createTestProject() {
        app.goTo().homePage();
        app.goTo().testProjectManagementPage();
        app.testProject().create();
    }

}
