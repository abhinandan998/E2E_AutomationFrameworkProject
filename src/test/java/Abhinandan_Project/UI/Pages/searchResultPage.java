package Abhinandan_Project.UI.Pages;

import Abhinandan_Project.Utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class searchResultPage extends BrowserUtility {

    private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
    private static final By PRODUCT_LISTS_NAME = By.xpath("//h5[@itemprop=\"name\"]/a");

    public searchResultPage(WebDriver driver) {
        super(driver);
        // Wait for the search results page to fully load before any interaction
        waitForPageToLoad();
    }

    public String getSearchResultTitle() {
        return getVisibleTest(PRODUCT_LISTING_TITLE_LOCATOR);
    }

    public boolean isSearchTermPresentInProductList(String searchTerm) {
        // Wait up to 10s for at least one product element to appear
        try {
            new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_LISTS_NAME));
        } catch (Exception e) {
            // Search returned no results — return false immediately
            return false;
        }
        List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
        List<String> productNamesList = getALLVisibleText(PRODUCT_LISTS_NAME);
        return productNamesList.stream()
                .anyMatch(name -> keywords.stream().anyMatch(name.toLowerCase()::contains));
    }

    public ProductDetailPage clickOnTheProductAtIndex(int index) {
        // Wait up to 15s for the product list to fully render before accessing by index
        new WebDriverWait(getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_LISTS_NAME));
        clickOn(getALLElements(PRODUCT_LISTS_NAME).get(index));
        return new ProductDetailPage(getDriver());
    }
}
