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

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtility {


    private static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();   //instance variable
    Logger logger = LoggerUtility.getogger(this.getClass());

    public WebDriver getDriver() {
        return driver.get();
    }
    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver); //initialize the instance variable driver
    }

    public BrowserUtility(String BrowserName)
    {
        logger.info("Launching Browser for: " +BrowserName);
        if(BrowserName.equalsIgnoreCase("chrome")){
            driver.set( new ChromeDriver());
        }
        else if(BrowserName.equalsIgnoreCase("edge")){
            driver.set( new EdgeDriver());
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
        }
        else if(BrowserName == Browser.EDGE){
            driver.set(new EdgeDriver());
        }
        else if(BrowserName == Browser.FIREFOX){
            driver.set(new EdgeDriver());
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
            }
            else {
                driver.set(new ChromeDriver());
            }
        }
        else if(BrowserName == Browser.EDGE){
            if (isHeadless) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=old");
                options.addArguments("disable-gpu");

                driver.set(new EdgeDriver(options));
            }
            else {
                driver.set(new EdgeDriver());
            }
        }
        else if(BrowserName == Browser.FIREFOX){
            if (isHeadless) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless=old");


                driver.set(new FirefoxDriver(options));

            }else {
                driver.set(new EdgeDriver());
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
        WebElement element = driver.get().findElement(locator);
        logger.info("Element Found and now performing click ");
        element.click();
    }
    public void enterText(By locator, String textToEnter){

        logger.info("Finding Element with the locator "+locator);
        WebElement emailIdWebElement = driver.get().findElement(locator);
        logger.info("Finding Element now and enter text "+textToEnter);
        emailIdWebElement.sendKeys(textToEnter);

    }
    public String getVisibleTest(By locator){
        logger.info("Finding Element with the locator "+locator);
        WebElement element = driver.get().findElement(locator);
        logger.info("Finding Element and now returning the visible text "+ element.getText());
        return element.getText();
    }

    public String takeScreenshot(String name)
    {
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File screenShotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);
        String path = System.getProperty("user.dir")+"//screenshots//" + name + " - " + timeStamp +".png";
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

