package tests;

import data.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RunCreatedTestCases extends TestBase {

    private SuiteData testSuite = new SuiteData()
            .withName("Test suite name auto")
            .withDetails("Test suite details auto");

    private CaseData firstTestCase = new CaseData()
            .withName("First")
            .withDetails("Test case details auto")
            .withActions("test actions")
            .withExpectedResults("test expected results");

    private CaseData secondTestCase = new CaseData()
            .withName("Second")
            .withDetails("Test case details auto")
            .withActions("test actions")
            .withExpectedResults("test expected results");

    private ProjectData testProject = new ProjectData()
            .withName("Testproject")
            .withDescription("Some Description")
            .withPrefix("TP");

    private PlanData testPlan = new PlanData()
            .withName("Test Test Plan")
            .withDescription("Some test test plan description");

    private BuildData testBuild = new BuildData()
            .withTitle("Test build")
            .withDescription("Some test build description");

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
        app.goTo().testBuildPage();
        app.build().create(testBuild);

    }

    @Test
    public void runCreatedTestCases() {
        app.goTo().homePage();
        app.goTo().testExecutionPage();
        app.testRun().clickOnTest(firstTestCase, testSuite);
        app.testRun().checkThatNotExecuted();
        app.testRun().passTestCase();
        app.testRun().checkThatPassed(firstTestCase);
        app.goTo().testExecutionPage();
        app.testRun().clickOnTest(secondTestCase, testSuite);
        app.testRun().checkThatNotExecuted();
        app.testRun().failTestCase();
        app.testRun().checkThatFailed(secondTestCase);
    }

    @AfterSuite
    public void deleteCreatedProject() {
        app.goTo().homePage();
        app.goTo().testProjectManagementPage();
        app.project().delete();
    }





}
