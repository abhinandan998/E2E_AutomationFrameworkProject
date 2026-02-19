package Abhinandan_Project.UI.Test;

import Abhinandan_Project.Constants.Browser;
import Abhinandan_Project.UI.Pages.HomePage;
import Abhinandan_Project.UI.Pages.LoginPage;
import org.testng.annotations.Test;


public class LoginTest {
    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(Browser.EDGE);
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.doLoginWith("basuabhinandan99@gmail.com", "Abhi@12345");























    }
}
