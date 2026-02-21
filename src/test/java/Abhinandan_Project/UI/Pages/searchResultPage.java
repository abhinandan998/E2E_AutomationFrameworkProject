package Abhinandan_Project.UI.Pages;

import Abhinandan_Project.Utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class searchResultPage extends BrowserUtility {

    private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
    private static final By PRODUCT_LISTS_NAME= By.xpath("//h5[@itemprop=\"name\"]/a");

    public searchResultPage(WebDriver driver) {
        super(driver);
    }
    public String getSearchResultTitle(){
        return getVisibleTest(PRODUCT_LISTING_TITLE_LOCATOR);
    }

    public boolean isSearchTermPresentInProductList(String searchTerm){
        List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
        List<String> productNamesList = getALLVisibleText(PRODUCT_LISTS_NAME);
        boolean result = productNamesList.stream()
                .anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
        return result;
    }

    public  ProductDetailPage clickOnTheProductAtIndex(int index){

       clickOn(getALLElements(PRODUCT_LISTS_NAME).get(index));
       ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
       return productDetailPage;
    }
}
