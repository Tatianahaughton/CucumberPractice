package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropValue("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropValue("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        initializePageObjects();//define in a pageInitializer but calling it here in order to use this method as part of opening browser
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void sendText(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait=new WebDriverWait(driver,Constants.EXPLICIT_WAIT);
                return wait;
    }

    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    //this method will return JavascriptExecutor Object
    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return js;
    }
    //this function will perform click pn element using js executor
    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click()",element);
    }

    //Select the dropdown using text
    public static void selectDropdown(WebElement element,String text) {
        Select s=new Select(element);
        s.selectByVisibleText(text);
    }



}
