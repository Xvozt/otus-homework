package tests;

import data.CaseData;
import data.ProjectData;
import data.SuiteData;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateTestSuiteWithTwoTestCases extends TestBase {
    private SuiteData testSuite = new SuiteData().withName("Test suite name auto").withDetails("Test suite details auto");

    private ProjectData projectInfoForCreation = new ProjectData().withName("Testproject")
            .withDescription("Some Description")
            .withPrefix("TP");

    private CaseData firstTestCase = new CaseData().withName("First")
            .withDetails("Test case details")
            .withActions("test actions")
            .withExpectedResults("test expected results");

    private CaseData secondTestCase = new CaseData().withName("Second")
            .withDetails("Test case details")
            .withActions("test actions")
            .withExpectedResults("test expected results");

    @BeforeSuite
    public void precontidions() {
        if (app.project().noProjectExists()) {
            app.project().straightCreate(projectInfoForCreation);
        } else {
            app.goTo().homePage();
            app.goTo().testProjectManagementPage();
            app.project().create(projectInfoForCreation);
        }
    }

    @Test
    public void createTestSuite() {

        app.goTo().homePage();
        app.goTo().testSpecificationPage();
        app.suite().create(testSuite);
        app.suite().delete(testSuite);
        app.goTo().homePage();
    }

    @Test
    public void createTestSuiteWithTestCase() throws InterruptedException {
        app.goTo().homePage();
        app.goTo().testSpecificationPage();
        app.suite().create(testSuite);
        app.testCase().createTestCase(testSuite, firstTestCase);
        app.testCase().addSteps(testSuite, firstTestCase);
        app.goTo().homePage();
        app.goTo().testSpecificationPage();
        app.testCase().createTestCase(testSuite, secondTestCase);
        app.testCase().addSteps(testSuite, secondTestCase);
        app.suite().delete(testSuite);
        app.goTo().homePage();
        app.goTo().testProjectManagementPage();
        app.project().delete();
    }
}
