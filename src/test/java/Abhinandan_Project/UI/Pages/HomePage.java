package Abhinandan_Project.UI.Pages;//Page Class

import Abhinandan_Project.Constants.Browser;
import static Abhinandan_Project.Constants.Env.*;
import Abhinandan_Project.Utility.BrowserUtility;
import static Abhinandan_Project.Utility.PropertiesUTIL.*;

import Abhinandan_Project.Utility.JSONUtility;
import Abhinandan_Project.Utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BrowserUtility {
    Logger logger = LoggerUtility.getogger(this.getClass());
    private static final By SIGN_IN=  By.xpath("//a[contains(text(), 'Sign in')]");

    public HomePage(Browser browserName, boolean isHeadless) {
        super(browserName, isHeadless);
        goToWebsite(JSONUtility.readJSON(QA).getUrl());//To call the parent class constructor from the child constructor
    }

    public HomePage(WebDriver driver) {
        super(driver);
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
    }

    public LoginPage goToLoginPage(){ //Page Functions --> cannot use void
        logger.info("Trying to performing click to go to the sign in Page");
        clickOn(SIGN_IN);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;

    }


}
