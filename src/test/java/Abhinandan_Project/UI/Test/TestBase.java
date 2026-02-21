package Abhinandan_Project.UI.Test;

import Abhinandan_Project.Constants.Browser;
import Abhinandan_Project.UI.Pages.HomePage;
import Abhinandan_Project.Utility.BrowserUtility;
import Abhinandan_Project.Utility.LambdaTestUtility;
import Abhinandan_Project.Utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {

    protected HomePage homePage;
    Logger logger = LoggerUtility.getogger(this.getClass());
    private boolean isLambdaTest;

    @BeforeMethod(description = "Load the HomePage of the website")
    public void setup(Method method) {

        // Reads Maven -D flags: -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=true
        // Falls back to safe defaults when run directly from IDE / TestNG XML
        String browser = System.getProperty("browser", "chrome");
        boolean lambdaTest = Boolean.parseBoolean(System.getProperty("isLambdaTest", "false"));
        boolean headless = Boolean.parseBoolean(System.getProperty("isHeadless", "false"));

        this.isLambdaTest = lambdaTest;

        if (lambdaTest) {
            logger.info("Initializing LambdaTest session for: " + method.getName());
            WebDriver lambdaDriver = LambdaTestUtility.InitializeLambdaTestSession(browser, method.getName());
            homePage = new HomePage(lambdaDriver);
        } else {
            logger.info("Launching local browser: " + browser + " | headless: " + headless);
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), headless);
        }
    }

    public BrowserUtility getInstance() {
        return homePage;
    }

    @AfterMethod(description = "Tear Down The Browser", alwaysRun = true)
    public void tearDown() {
        if (isLambdaTest) {
            LambdaTestUtility.quitSeesion();
        } else {
            homePage.quit();
        }
    }
}
