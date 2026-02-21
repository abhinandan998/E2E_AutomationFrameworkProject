package Abhinandan_Project.Utility;

import Abhinandan_Project.Constants.Browser;
import freemarker.template.SimpleDate;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.SchemaDocumentImpl;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BrowserUtility {


    private static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();   //instance variable
    Logger logger = LoggerUtility.getogger(this.getClass());
    private WebDriverWait wait;

    private WebDriverWait getWait() {
        return new WebDriverWait(driver.get(), Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return driver.get();
    }
    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver);//initialize the instance variable driver
        getWait();
    }

    public BrowserUtility(String BrowserName)
    {
        logger.info("Launching Browser for: " +BrowserName);
        if(BrowserName.equalsIgnoreCase("chrome")){
            driver.set( new ChromeDriver());
            getWait();
        }
        else if(BrowserName.equalsIgnoreCase("edge")){
            driver.set( new EdgeDriver());
            getWait();
        }
        else {
            logger.error("Invalid Browser Name!!..... Please select chrome or edge");
            System.err.print("Invalid Browser Name!!..... Please select chrome or edge");
        }
    }
    public BrowserUtility(Browser BrowserName)
    {
        logger.info("Launching Browser for: " +BrowserName);
        if(BrowserName== Browser.CHROME){

            driver.set(new ChromeDriver());
           getWait();
        }
        else if(BrowserName == Browser.EDGE){
            driver.set(new EdgeDriver());
           getWait();
        }
        else if(BrowserName == Browser.FIREFOX){
            driver.set(new EdgeDriver());
            getWait();
        }
        else {
            logger.error("Invalid Browser Name!!..... Please select chrome or edge");
            System.err.print("Invalid Browser Name!!..... Please select chrome or edge");
        }
    }
    public BrowserUtility(Browser BrowserName, boolean isHeadless)
    {
        logger.info("Launching Browser for: " +BrowserName);
        if(BrowserName== Browser.CHROME ){

            if (isHeadless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=old");
                options.addArguments("--window-size=1920,1080");

                driver.set(new ChromeDriver(options));
                getWait();
            }
            else {
                driver.set(new ChromeDriver());
                getWait();
            }
        }
        else if(BrowserName == Browser.EDGE){
            if (isHeadless) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=old");
                options.addArguments("disable-gpu");

                driver.set(new EdgeDriver(options));
                getWait();
            }
            else {
                driver.set(new EdgeDriver());
                getWait();
            }
        }
        else if(BrowserName == Browser.FIREFOX){
            if (isHeadless) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless=old");


                driver.set(new FirefoxDriver(options));
                getWait();

            }else {
                driver.set(new EdgeDriver());
                getWait();
            }
        }
        else {
            logger.error("Invalid Browser Name!!..... Please select chrome or edge");
            System.err.print("Invalid Browser Name!!..... Please select chrome or edge");
        }
    }

    public void goToWebsite(String url){
        logger.info("Visiting the website " + url);
        driver.get().get(url);
    }
    public void  maximizeWindow(){

        logger.info("Maximizing the browser window");
        driver.get().manage().window().maximize();
    }
    public void clickOn(By locator)
    {
        logger.info("Finding Element with the locator "+locator);
        WebElement element = getWait().until(
                ExpectedConditions.elementToBeClickable(locator)
        );
        logger.info("Element Found and now performing click ");
        element.click();
        waitForPageToLoad();
    }
    public void clickOnCheckBox(By locator)
    {
        logger.info("Finding Element with the locator "+locator);
        WebElement element = getWait().until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
        logger.info("Element Found and now performing click ");
        element.click();
        waitForPageToLoad();
    }
    public void clickOn(WebElement element)
    {

        logger.info("Element Found and now performing click ");
        element.click();
    }
    public void enterText(By locator, String textToEnter){

        logger.info("Entering text into " + locator);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(driver -> {
            try {
                WebElement element = driver.findElement(locator);
                element.clear();
                element.sendKeys(textToEnter);
                return true;
            }
            catch (StaleElementReferenceException e){
                logger.warn("Stale element detected. Retrying...");
                return false;
            }
        });
    }



    public void selectStateFromUniform(String stateName) {

        logger.info("Selecting state from Uniform dropdown: " + stateName);

        // Click the visible wrapper
        By wrapper = By.id("uniform-id_state");
        clickOn(wrapper);

        // Click option by visible text
        By optionLocator = By.xpath("//select[@id='id_state']/option[text()='" + stateName + "']");
        WebElement option = getDriver().findElement(optionLocator);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].selected = true;", option);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));",
                getDriver().findElement(By.id("id_state")));
    }
    public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
        logger.info("Finding Element with the locator"+dropDownLocator);
        WebElement element = driver.get().findElement(dropDownLocator);
        Select select = new Select(element);
        logger.info("Selecting the options " + optionToSelect);
        select.selectByVisibleText(optionToSelect);
    }
    public void selectFromHiddenDropdown(By selectLocator, String visibleText) {

        logger.info("Selecting from hidden dropdown: " + visibleText);

        WebElement selectElement = getDriver().findElement(selectLocator);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        // Select the option by text using JS
        String script =
                "var select = arguments[0];" +
                        "for (var i = 0; i < select.options.length; i++) {" +
                        "  if (select.options[i].text === arguments[1]) {" +
                        "    select.selectedIndex = i;" +
                        "    select.dispatchEvent(new Event('change'));" +
                        "    break;" +
                        "  }" +
                        "}";

        js.executeScript(script, selectElement, visibleText);
    }
    public void clearText(By TextBoxLocator)
    {
        logger.info("Finding element with the locator " +TextBoxLocator);

        WebElement element = getWait().until(ExpectedConditions.visibilityOfElementLocated(TextBoxLocator));

        logger.info("Element Found and clearing the text Box field " );
        element.clear();
    }
    public void waitForPageToLoad() {
        logger.info("Waiting for page to fully load");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(driver ->
                ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }





    public void enterSpecialKey(By locator, Keys keyToEnter){

        logger.info("Finding Element with the locator "+locator);
        WebElement emailIdWebElement = getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Finding Element now and enter special key "+keyToEnter);
        emailIdWebElement.sendKeys(keyToEnter);

    }
    public String getVisibleTest(By locator){
        logger.info("Finding Element with the locator "+locator);
        WebElement element = getWait().until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
        logger.info("Finding Element and now returning the visible text "+ element.getText());
        return element.getText();
    }
    public String getVisibleTest(WebElement element){

        logger.info("Returning the visible Text"+ element.getText());
        return element.getText();
    }
    public List<String> getALLVisibleText(By locator){
            logger.info("Finding All Element with the locator "+locator);
            List<WebElement> elementList = driver.get().findElements(locator);

            logger.info("elements found and printing the List");
            List<String > visibleTextList = new ArrayList<String>();

            for(WebElement element: elementList){
                System.out.println(getVisibleTest(element));
                visibleTextList.add(getVisibleTest(element));
            }

    return visibleTextList;
    }
    public List<WebElement> getALLElements(By locator) {
        logger.info("Finding All Element with the locator " + locator);
        List<WebElement> elementList = driver.get().findElements(locator);

        logger.info("elements found and printing the List");
       return elementList;


    }

    public String takeScreenshot(String name)
    {
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File screenShotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);
//        String path = System.getProperty("user.dir")+"//screenshots//" + name + " - " + timeStamp +".png";
        String path = "./screenshots/"+name+" - "+timeStamp+ ".png";
        File screenShotFile = new File(path);
        try {
            FileUtils.copyFile(screenShotData, screenShotFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public void quit(){
        driver.get().quit();
    }
}

