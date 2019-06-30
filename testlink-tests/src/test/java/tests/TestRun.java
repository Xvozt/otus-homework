package tests;

import data.CaseData;
import data.PlanData;
import data.ProjectData;
import data.SuiteData;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestRun extends TestBase {

    private SuiteData testSuite = new SuiteData().withName("Test suite name auto").withDetails("Test suite details auto");

    private CaseData firstTestCase = new CaseData().withName("First")
            .withDetails("Test case details auto")
            .withActions("test actions")
            .withExpectedResults("test expected results");

    private CaseData secondTestCase = new CaseData().withName("Second")
            .withDetails("Test case details auto")
            .withActions("test actions")
            .withExpectedResults("test expected results");

    private ProjectData testProject = new ProjectData().withName("Testproject")
            .withDescription("Some Description")
            .withPrefix("TP");

    private PlanData testPlan = new PlanData().withName("Test Test Plan")
            .withDescription("Some test test plan description");

    @BeforeSuite
    public void preconditions() throws InterruptedException {
        if (app.project().noProjectExists()) {
            app.project().straightCreate(testProject);
        } else {
            app.goTo().homePage();
            app.goTo().testProjectManagementPage();
            app.project().create(testProject);
        }
        app.goTo().homePage();
        app.goTo().testSpecificationPage();
        app.suite().create(testSuite);
        app.testCase().createTestCase(testSuite, firstTestCase);
        app.testCase().addSteps(testSuite, firstTestCase);
        app.goTo().homePage();
        app.goTo().testSpecificationPage();
        app.testCase().createTestCase(testSuite, secondTestCase);
        app.testCase().addSteps(testSuite, secondTestCase);
        app.goTo().homePage();
        app.goTo().testPlanManagementPage();
        app.plan().create(testPlan);
        app.goTo().homePage();
        app.goTo().testAddingPage();
        app.adding().checkAndAddTestCases(testSuite);
        app.goTo().homePage();
    }

    @Test
    public void runTests() {
        /*
        * Here onlt test for runTests, all other staff in preconditions */
        app.goTo().homePage();
        app.goTo().testProjectManagementPage();
        //app.project().delete();
    }





}
