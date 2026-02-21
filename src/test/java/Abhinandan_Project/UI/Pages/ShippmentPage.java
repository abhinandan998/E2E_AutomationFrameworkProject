package Abhinandan_Project.UI.Pages;

import Abhinandan_Project.Utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippmentPage extends BrowserUtility {
    private static final By ACCEPT_TERMS_CHECKBOX_LOCATOR = By.id("uniform-cgv");
    private static final By SHIPPING_ERROR =
            By.xpath("//div[contains(@class,'alert-danger')]//li");
    public ShippmentPage(WebDriver driver) {
        super(driver);
    }
    public ShippmentPage acceptTerms(){
        clickOnCheckBox(ACCEPT_TERMS_CHECKBOX_LOCATOR);
        return this;
    }

    public String getShippingErrorMessage(){
        return getVisibleTest(SHIPPING_ERROR);
    }
}
