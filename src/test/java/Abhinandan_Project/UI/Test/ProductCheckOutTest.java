package Abhinandan_Project.UI.Test;

import static Abhinandan_Project.Constants.Size.*;

import Abhinandan_Project.UI.Pages.searchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Abhinandan_Project.UI.Listeners.TestListeners.class)
public class ProductCheckOutTest extends TestBase {

        private static final String SEARCH_TERM = "Printed Summer Dress";

        private searchResultPage searchResultPage;

        @BeforeMethod(description = "User Logs into the application and searches for the product")
        public void loginSetup() {
                searchResultPage = homePage.goToLoginPage().doLoginWith("basuabhinandan99@gmail.com", "Abhi@12345")
                                .searchForProduct(SEARCH_TERM);
        }

        @Test(description = "Verify checkout shows shipping error", groups = { "e2e", "smoke", "sanity" })
        public void checkoutTest() {

                String errorMsg = searchResultPage
                                .clickOnTheProductAtIndex(0)
                                .changeSize(L)
                                .addProductToCart()
                                .proceedToCheckout()
                                .goToConformAddressPage()
                                .goToShipmentPage()
                                .acceptTerms()
                                .getShippingErrorMessage();

                Assert.assertEquals(
                                errorMsg,
                                "There are no carriers that deliver to the address you selected.");
        }
}
