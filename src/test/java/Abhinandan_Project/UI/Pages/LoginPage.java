package Abhinandan_Project.UI.Pages;

import Abhinandan_Project.Utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BrowserUtility {

    private static final By EMAIL_ID = By.id("email");
    private static final By PASSWORD= By.id("passwd");
    private static final By SUBMIT_BTN = By.id("SubmitLogin");
    private static final By ERROR_MESSAGE_LOCATOR= By.xpath("//div[contains(@class,'alert-danger')]/ol/li");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public MyAccountPage doLoginWith(String emailId, String password)
    {
        enterText(EMAIL_ID, emailId);
        enterText(PASSWORD, password);
        clickOn(SUBMIT_BTN);
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        return myAccountPage;

    }

    public LoginPage doLoginWithInvalidCredentials(String emailId, String password){
        enterText(EMAIL_ID, emailId);
        enterText(PASSWORD, password);
        clickOn(SUBMIT_BTN);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;

    }

    public String getErrorMessage(){
        return getVisibleTest(ERROR_MESSAGE_LOCATOR);
    }
}
