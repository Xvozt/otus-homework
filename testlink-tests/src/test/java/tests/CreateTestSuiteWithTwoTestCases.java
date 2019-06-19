package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateTestSuiteWithTwoTestCases extends TestBase {

    @Test
    public void createTestSuite() {
        app.goTo().testSpecificationPage();
        app.testSuite().create("Test suite name auto");
        app.testSuite().delete("Test suite name auto");
    }

    @Test
    @Parameters
    public void createTestSuiteWithTestCase() {
        app.goTo().testSpecificationPage();
        app.testSuite().create("Test suite name auto");
        app.testCase().createTestCase("Test suite name auto");
        app.testCase().addSteps("test case auto1", "test actions", "test expected results", "");
//        app.testCase().createTestSuiteWithTestCase("Test suite name auto2");
//        app.testCase().addSteps("test case auto2", "test actions", "test expected results", "");
        app.testSuite().delete("Test suite name auto");
    }
}
