package Abhinandan_Project.UI.Test;

import Abhinandan_Project.Constants.Browser;
import Abhinandan_Project.UI.Pages.HomePage;
import Abhinandan_Project.Utility.BrowserUtility;
import Abhinandan_Project.Utility.LambdaTestUtility;
import Abhinandan_Project.Utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static Abhinandan_Project.Constants.Browser.CHROME;

public class TestBase {


    protected HomePage homePage;
    Logger logger = LoggerUtility.getogger(this.getClass());
    private boolean isLambdaTest;



    @Parameters({"browser","isLambdaTest","isHeadless"})
    @BeforeMethod(description = "Load the HomePge of the website")
    public void setup(String browser,boolean isLambdaTest,boolean isHeadless, ITestResult result) {

       this.isLambdaTest= isLambdaTest;
        WebDriver lambdaDriver;
        if(isLambdaTest){

            lambdaDriver = LambdaTestUtility.InitializeLambdaTestSession(browser, result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);
        }else {


            logger.info("Load the HomePge of the website");
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
        }
    }
    public BrowserUtility getInstance(){

        return homePage;
    }
    @AfterMethod(description = "Tear Down The Browser")
    public void tearDown(){
        if(isLambdaTest){
            LambdaTestUtility.quitSeesion();
        }else{
            homePage.quit();
        }
    }
}
