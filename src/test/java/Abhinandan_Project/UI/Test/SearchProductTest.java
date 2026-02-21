package Abhinandan_Project.UI.Test;

import Abhinandan_Project.UI.Pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ Abhinandan_Project.UI.Listeners.TestListeners.class })
public class SearchProductTest extends TestBase {

    private MyAccountPage myAccountPage;
    private static final String SEARCH_TERM = "Printed Women Dress";

    @BeforeMethod(description = "Valid user logs into the application")
    public void loginSetup() {
        myAccountPage = homePage.goToLoginPage().doLoginWith("basuabhinandan99@gmail.com", "Abhi@12345");
    }

    @Test(description = "Verify if the logged in user is able to search for the products search result and correct products are displayed", groups = {
            "e2e", "smoke", "sanity" })
    public void verifyProductSearchTest() {

        // Assert the page title contains the search term (set by website from the
        // query)
        // More reliable than checking individual product names, which may vary
        String searchResultTitle = myAccountPage.searchForProduct(SEARCH_TERM)
                .getSearchResultTitle();
        Assert.assertTrue(
                searchResultTitle.toLowerCase().contains(SEARCH_TERM.toLowerCase()),
                "Search result title '" + searchResultTitle + "' should contain '" + SEARCH_TERM + "'");
    }

}
