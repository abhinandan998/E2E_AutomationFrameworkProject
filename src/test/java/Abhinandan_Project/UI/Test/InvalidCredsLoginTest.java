package Abhinandan_Project.UI.Test;

import Abhinandan_Project.Utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Abhinandan_Project.UI.Listeners.TestListeners.class)
public class InvalidCredsLoginTest extends TestBase {

    Logger logger = LoggerUtility.getogger(this.getClass());
    private static final String INVALID_EMAIL_ID = "basuabhinandan98@gmail.com";
    private static final String INVALID_PASSWORD = "Abhi@123456";

    @Test(description = "Verify if the proper error message is shown for the user when they enter invalid credentials", groups = {
            "e2e", "sanity", "smoke" })
    public void loginTest() {

        Assert.assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ID, INVALID_PASSWORD)
                .getErrorMessage(), "Authentication failed.");

    }

}
