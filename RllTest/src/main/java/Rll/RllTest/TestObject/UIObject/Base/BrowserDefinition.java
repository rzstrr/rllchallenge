package Rll.RllTest.TestObject.UIObject.Base;

import Rll.RllTest.TestObject.RequestSender.TestExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserDefinition extends TestExecutor {

    protected WebDriver driver;
    protected WebElement element;

    public WebDriver getWebDriverFromGeneric(String driverOption) {

        preferredDriver = getProperties("rll.test.driver");
        driverSource = getProperties("rll.test.driver.source");
        driverBehaviour = getProperties("rll.test.driver.behavior");

        if(driverOption.equalsIgnoreCase("Chrome")){
            if(preferredDriver.isEmpty() && driverSource.isEmpty()){
                printLog("failure while retrieving driver preferred driver or driver source for Chrome driver");
            }else{
                System.setProperty(preferredDriver,driverSource);
                System.setProperty("webdriver.chrome.verboseLogging","true");
                ChromeOptions options = new ChromeOptions();
                if(driverBehaviour.isEmpty()){
                    printLog("failure while retrieving driver behavior for Chrome driver");
                }
                options.addArguments(driverBehaviour);
                driver = new ChromeDriver(options);
            }
        }else if(driverOption.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }else if(driverOption.equalsIgnoreCase("Explorer")){
            driver = new InternetExplorerDriver();
        }
        return driver;
    }

    public WebElement getWebElementFromGenericByXpath(String driverOption,String xpaths){
        element = getWebDriverFromGeneric(driverOption).findElement(By.xpath(xpaths));
        return element;
    }

    public WebElement getWebElementFromGenericByName(String driverOption,String name){
        element = getWebDriverFromGeneric(driverOption).findElement(By.xpath(name));
        return element;
    }

    public WebElement getWebElementFromGenericById(String driverOption,String elementId){
        element = getWebDriverFromGeneric(driverOption).findElement(By.id(elementId));
        return element;
    }

    public WebElement getWebElementFromGenericByTagName(String driverOption,String tagName){
        element = getWebDriverFromGeneric(driverOption).findElement(By.tagName(tagName));
        return element;
    }
}
