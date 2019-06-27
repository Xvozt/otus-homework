package tests;

import data.ProjectData;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class CreateTestProject extends TestBase {
    private ProjectData projectInfoForCreation = new ProjectData().withName("Testproject")
            .withDescription("Some Description")
            .withPrefix("TP");

    @Test
    public void createTestProject() {
        if (app.project().noProjectExists()) {
            app.project().straightCreate(projectInfoForCreation);
        } else {
            app.goTo().homePage();
            app.goTo().testProjectManagementPage();
            app.project().create(projectInfoForCreation);
        }
        ProjectData projectInfoAfterCreation = app.project().projectInfoAfterCreation(projectInfoForCreation);
        assertThat(projectInfoAfterCreation, equalTo(projectInfoForCreation));
        assertTrue(app.project().isPublicImageExisting());
        app.project().delete();
    }

}
