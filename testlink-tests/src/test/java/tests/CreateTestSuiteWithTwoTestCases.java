package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateTestSuiteWithTwoTestCases extends TestBase {

    @Test
    public void createTestSuite() {
        app.goTo().homePage();
        app.goTo().testSpecificationPage();
        app.suite().create("Test suite name auto");
        app.suite().delete("Test suite name auto");
    }

    @Test
    @Parameters
    public void createTestSuiteWithTestCase() throws InterruptedException {
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
        app.suite().delete("Test suite name auto");
    }
}
