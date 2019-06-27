package tests;

import data.PlanData;
import data.ProjectData;
import org.testng.annotations.Test;

public class TestRun extends TestBase {

    @Test
    public void runTests() throws InterruptedException {
        ProjectData projectInfoForCreation = new ProjectData().withName("Testproject")
                .withDescription("Some Description")
                .withPrefix("TP");

        PlanData planData = new PlanData().withName("Test Test Plan").withDescription("Some test test plan description");
        if (app.project().noProjectExists()) {
            app.project().straightCreate(projectInfoForCreation);
        } else {
            app.goTo().homePage();
            app.goTo().testProjectManagementPage();
            app.project().create(projectInfoForCreation);
        }
        app.goTo().homePage();
        app.goTo().testSpecificationPage();
        app.suite().create("Test suite name auto");
        app.testCase().createTestCase("Test suite name auto", "First");
        app.testCase().addSteps("First", "test actions",
                "test expected results", "Test suite name auto");
        app.goTo().homePage();
        app.goTo().testSpecificationPage();
        app.testCase().createTestCase("Test suite name auto", "Second");
        app.testCase().addSteps("Second", "test actions",
                "test expected results", "Test suite name auto");
        app.goTo().homePage();
        app.goTo().testPlanManagementPage();
        app.plan().create(planData);
        app.goTo().homePage();
        //app.project().findCreatedProject(projectInfoForCreation);
        //app.project().delete();
    }





}
