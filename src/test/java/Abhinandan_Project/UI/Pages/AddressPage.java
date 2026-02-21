package Abhinandan_Project.UI.Pages;

import Abhinandan_Project.UI.POJOS.AddressPOJO;
import Abhinandan_Project.Utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AddressPage extends BrowserUtility {

    private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
    private static final By ADDRESS1_TEXTBOX_LOCATOR = By.id("address1");
    private static final By ADDRESS2_TEXTBOX_LOCATOR = By.id("address2");
    private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
    private static final By POSTCODE_TEXTBOX_LOCATOR = By.id("postcode");
    private static final By HOMEPHONE_TEXTBOX_LOCATOR = By.id("phone");
    private static final By MOBILEPHONE_TEXTBOX_LOCATOR = By.id("phone_mobile");
    private static final By OTHER_INFO_TEXTBOX_LOCATOR = By.id("other");
    private static final By ADDRESS_ALIAS_TEXTBOX_LOCATOR = By.id("alias");
    //private static final By COUNTRY_DROPDOWN_LOCATOR = By.id("id_country");
    private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
    private static final By SAVE_ADDRESS_LOCATOR = By.id("submitAddress");
    private static final By ADDRESS_HEADING = By.tagName("h3");


    public AddressPage(WebDriver driver) {
        super(driver);
    }
    public String saveAddress(AddressPOJO addressPOJO){

        enterText(COMPANY_TEXTBOX_LOCATOR,addressPOJO.getCompany());
        enterText(ADDRESS1_TEXTBOX_LOCATOR, addressPOJO.getAddressLine1());
        enterText(ADDRESS2_TEXTBOX_LOCATOR, addressPOJO.getAddressLine2());
        enterText(CITY_TEXTBOX_LOCATOR, addressPOJO.getCity());

        enterText(POSTCODE_TEXTBOX_LOCATOR, addressPOJO.getPostcode());


        enterText(HOMEPHONE_TEXTBOX_LOCATOR, addressPOJO.getHomePhone());
        enterText(MOBILEPHONE_TEXTBOX_LOCATOR,addressPOJO.getMobilePhone());
        enterText(OTHER_INFO_TEXTBOX_LOCATOR, addressPOJO.getOtherInfo() );

        clearText(ADDRESS_ALIAS_TEXTBOX_LOCATOR);
        enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR,addressPOJO.getAddressAlias());

        selectStateFromUniform(addressPOJO.getState());
        clickOn(SAVE_ADDRESS_LOCATOR);

        String newAddress = getVisibleTest(ADDRESS_HEADING);
        return newAddress;

    }
}
