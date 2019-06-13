package tests;

import appmanager.ApplicationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
        private static final Logger logger = LogManager.getLogger(tests.TestBase.class);
        protected static final ApplicationManager app = new ApplicationManager();

        @BeforeSuite
        public void setUp() throws Exception {
            app.init();
        }

        @AfterSuite (alwaysRun = true)
        public void tearDown() {
            app.stop();
        }


        @BeforeMethod
        public void logTestStart(Method m) {
            logger.info("Start test " + m.getName());
        }

        @AfterMethod
        public void logTestStop(Method m) {
            logger.info("Stop test " + m.getName());
        }
}
