package tests;

import org.testng.annotations.Test;

public class CreateTestSuiteWithTwoTestCases extends TestBase {

    @Test
    public void createTestSuiteWithTwoTestCases() {
        app.goTo().testSpecificationPage();
        app.suite().create();
//        app.suite().delete();
    }
}
