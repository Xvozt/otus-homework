package appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager{
    private final Properties properties;
    WebDriver wd;

    private AuthHelper authHelper;
    private NavigationHelper navigationHelper;
    private TestSuiteHelper testSuiteHelper;
    private TestCaseHelper testCaseHelper;
    private TestProjectHelper testProjectHelper;
    private TestAddingHelper testAddingHelper;
    private TestBuildHelper testBuildHelper;
    private TestPlanHelper testPlanHelper;
    private TestRunHelper testRunHelper;


    public ApplicationManager() {
        properties = new Properties();
        WebDriverManager.chromedriver().setup();
    }

    public void init() throws IOException {
        properties.load(new FileInputStream("src/test/resources/local.properties"));
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get(properties.getProperty("web.BaseUrl"));
        authHelper = new AuthHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        testSuiteHelper = new TestSuiteHelper(wd);
        testCaseHelper = new TestCaseHelper(wd);
        testProjectHelper = new TestProjectHelper(wd);
        testAddingHelper = new TestAddingHelper(wd);
        testBuildHelper = new TestBuildHelper(wd);
        testPlanHelper = new TestPlanHelper(wd);
        testRunHelper = new TestRunHelper(wd);
        authHelper.login(properties.getProperty("web.Login"), properties.getProperty("web.Password"));
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public TestSuiteHelper suite() {
        return testSuiteHelper;
    }

    public TestCaseHelper testCase() {
        return testCaseHelper;
    }

    public TestProjectHelper project() {
        return testProjectHelper;
    }

    public TestAddingHelper adding() {
        return testAddingHelper;
    }

    public TestBuildHelper build() {
        return testBuildHelper;
    }

    public TestPlanHelper plan() {
        return testPlanHelper;
    }

    public TestRunHelper testRun() {
        return testRunHelper;
    }

    public void stop() {
        if (wd != null) {
            wd.quit();
        }
    }
}
