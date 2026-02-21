package Abhinandan_Project.UI.Pages;

import Abhinandan_Project.Utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage  extends BrowserUtility {

    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//a[@title='Proceed to checkout' and contains(@class,'standard-checkout')]");
    private static final By SHIPPING_ERROR =
            By.xpath("//div[contains(@class,'alert-danger')]//li");
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmAddressPage goToConformAddressPage()
    {
        clickOn(PROCEED_TO_CHECKOUT_BUTTON);
        return new ConfirmAddressPage(getDriver());
    }
    public String getShippingErrorMessage() {
        return getVisibleTest(SHIPPING_ERROR);
    }
}
