package Abhinandan_Project.UI.Pages;

import Abhinandan_Project.Utility.BrowserUtility;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BrowserUtility {

    private static final By USER_NAME = By.xpath("//a[@title='View my customer account']//span");
    public static final By SEARCH_TEXT_BOX_LOCATOR = By.id("search_query_top");
    private static final By ADD_NEW_ADDRESS_LINK_LOCATOR  = By.xpath("//a[@title='Add my first address']");

    public MyAccountPage(WebDriver driver) {

        super(driver);
    }
    public String getUserName(){
        return getVisibleTest(USER_NAME);
    }

    public searchResultPage searchForProduct(String itemName){
        enterText(SEARCH_TEXT_BOX_LOCATOR, itemName);
        enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
        searchResultPage searchResultPage = new searchResultPage(getDriver());
        return searchResultPage;

    }
    public AddressPage goTOAddAddressPage(){
        clickOn(ADD_NEW_ADDRESS_LINK_LOCATOR);

        AddressPage addressPage = new AddressPage(getDriver());
        return addressPage;
    }
}
