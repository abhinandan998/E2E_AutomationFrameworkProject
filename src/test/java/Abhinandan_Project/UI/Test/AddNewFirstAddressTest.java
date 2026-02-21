package Abhinandan_Project.UI.Test;

import Abhinandan_Project.UI.POJOS.AddressPOJO;
import Abhinandan_Project.UI.Pages.AddressPage;
import Abhinandan_Project.UI.Pages.MyAccountPage;
import Abhinandan_Project.Utility.FakeAddressUtility;
import org.apache.commons.math3.analysis.function.Add;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewFirstAddressTest extends TestBase{

    private MyAccountPage myAccountPage;
    private AddressPage addressPage;
    private AddressPOJO address;
    @BeforeMethod(description ="Valid First Time user logs into the application")
    public void setup(){
        myAccountPage = homePage.goToLoginPage().doLoginWith("basuabhinandan99@gmail.com","Abhi@12345");
        address = FakeAddressUtility.getFakeAddress();

    }
    @Test
    public void addNewAddress(){
        String newAddress = myAccountPage.goTOAddAddressPage().saveAddress(address);
        Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
    }
}
