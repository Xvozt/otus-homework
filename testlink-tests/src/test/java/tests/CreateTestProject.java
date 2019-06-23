package tests;

import data.ProjectData;
import org.testng.annotations.Test;

public class CreateTestProject extends TestBase {

    @Test
    public void createTestProject() {
        ProjectData projectInfoForCreation = new ProjectData().withName("Testproject")
                .withDescription("Some Description")
                .withPrefix("TP");
        app.goTo().homePage();
        app.goTo().testProjectManagementPage();
        app.project().create(projectInfoForCreation);
        app.goTo().homePage();
        app.goTo().testProjectManagementPage();
        //ProjectData projectInfoAfterCreation = app.project().projectInfoAfterCreation();
        //assertThat(projectInfoAfterCreation, equalTo(projectInfoForCreation));
        //assertTrue(app.project().isPublicImageExisting());
        //app.project().delete(projectData); //поменять передаваемый в параметрах объект в методах
    }

}
