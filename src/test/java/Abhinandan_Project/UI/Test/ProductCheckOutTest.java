package Abhinandan_Project.UI.Test;

import static  Abhinandan_Project.Constants.Size.*;
import Abhinandan_Project.UI.Pages.searchResultPage;
import org.openqa.selenium.devtools.v142.dom.model.ShadowRootType;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductCheckOutTest extends TestBase{

private static final String SEARCH_TERM = "Printed Summer Dress";

private  searchResultPage searchResultPage;
    @BeforeMethod(description = "User Logs into the application and searches for the product")
    public void setup() {
        searchResultPage = homePage.goToLoginPage().doLoginWith("basuabhinandan99@gmail.com", "Abhi@12345")
                .searchForProduct(SEARCH_TERM);
    }

    @Test(description = "Verify if the logged in user is able to buy a dress", groups = {"e2e", "smoke", "sanity"})
    public void checkoutTest(){
        searchResultPage.clickOnTheProductAtIndex(1).changeSize(L).addProductToCart()
                .proceedToCheckout().goToConformAddressPage().goToShipmentPage().goToPaymentPage();

    }
}
