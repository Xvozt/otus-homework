package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateTestSuiteWithTwoTestCases extends TestBase {

    @Test
    public void createTestSuite() {
        app.goTo().homePage();
        app.goTo().testSpecificationPage();
        app.testSuite().create("Test suite name auto");
        app.testSuite().delete("Test suite name auto");
    }

    @Test
    @Parameters
    public void createTestSuiteWithTestCase() {
        app.goTo().homePage();
        app.goTo().testSpecificationPage();
        app.testSuite().create("Test suite name auto");
        app.testCase().createTestCase("Test suite name auto", "test case auto");
        app.testCase().addSteps("test case auto", "test actions",
                                "test expected results", "Test suite name auto");
        app.goTo().homePage();
        app.goTo().testSpecificationPage();
        app.testCase().createTestCase("Test suite name auto", "test case auto2");
        app.testCase().addSteps("test case auto2", "test actions",
                                "test expected results", "Test suite name auto");
        app.testSuite().delete("Test suite name auto");
    }
}
