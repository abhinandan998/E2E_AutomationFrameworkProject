package Abhinandan_Project.UI.Test;

import static Abhinandan_Project.Constants.Browser.*;
import Abhinandan_Project.UI.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest1 {
    /*
     * 1. Test script small.
     * 2. You cannot have conditional statement, loops, try catch  in your test method
     * testScripts--> Test scripts
     * 3. reduce the use of local variables
     * 4. At least one assertion...

     */

    HomePage homePage;

    @BeforeMethod(description = "Load the HomePge of the website")
    public void setup(){
         homePage = new HomePage(CHROME);

    }

    @Test(description = "Verify if the valid user is able to login into the applications", groups = {"e2e","sanity"})
    public void loginTest() {

        String userName = homePage.goToLoginPage().doLoginWith("basuabhinandan99@gmail.com", "Abhi@12345").getUserName();

        Assert.assertEquals(userName,"Abhinandan Basu");
    }
}
