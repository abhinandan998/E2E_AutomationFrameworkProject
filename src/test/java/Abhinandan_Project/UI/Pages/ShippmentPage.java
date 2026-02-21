package Abhinandan_Project.UI.Pages;

import Abhinandan_Project.Utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippmentPage extends BrowserUtility {
    private static final By ACCEPT_TERMS_CHECKBOX_LOCATOR = By.id("uniform-cgv");
    public ShippmentPage(WebDriver driver) {
        super(driver);
    }
    public void goToPaymentPage(){
        clickOnCheckBox(ACCEPT_TERMS_CHECKBOX_LOCATOR);
    }
}
