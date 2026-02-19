package Abhinandan_Project.UI.Test;

import static Abhinandan_Project.Constants.Browser.*;

import Abhinandan_Project.UI.POJOS.user;
import Abhinandan_Project.UI.Pages.HomePage;
import Abhinandan_Project.Utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Abhinandan_Project.UI.Listeners.TestListeners.class)
public class LoginTest extends TestBase {
    /*
     * 1. Test script small.
     * 2. You cannot have conditional statement, loops, try catch  in your test method
     * testScripts--> Test scripts
     * 3. reduce the use of local variables
     * 4. At least one assertion...

     */


    Logger logger = LoggerUtility.getogger(this.getClass());

    @Test(description = "Verify if the valid user is able to login into the applications", groups = {"e2e","sanity"}, dataProviderClass = Abhinandan_Project.UI.DataProviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
    public void loginTest(user user) {

        Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmail_id(),user.getPassword()).getUserName(), "Abhinandan Basu");


    }
    @Test(description = "Verify if the valid user is able to login into the applications", groups = {"e2e","sanity"}, dataProviderClass = Abhinandan_Project.UI.DataProviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
    public void loginCSVTest(user user) {

        Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmail_id(),user.getPassword()).getUserName(), "Abhinandan Basu");


    }
    @Test(description = "Verify if the valid user is able to login into the applications", groups = {"e2e","sanity"}, dataProviderClass = Abhinandan_Project.UI.DataProviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider",
    retryAnalyzer = Abhinandan_Project.UI.Listeners.MyRetryAnalyzer.class)
    public void loginExcelTest(user user) {



        Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmail_id(),user.getPassword()).getUserName(), "Abhinandan Basu");


    }
}
