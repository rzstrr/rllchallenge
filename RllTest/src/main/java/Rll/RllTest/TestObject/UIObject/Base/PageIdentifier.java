package Rll.RllTest.TestObject.UIObject.Base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class PageIdentifier extends BrowserDefinition {

    private WebDriver driver;
    private WebElement element;
    private boolean initialElementState = false;

    public PageIdentifier(WebDriver driverParam){
        this.driver = driverParam;
    }

    public WebElement getElementByXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getElementByCss(String css){
        return driver.findElement(By.cssSelector(css));
    }

    public void waitForPagetobeReady(){
        this.driver.manage().timeouts().pageLoadTimeout(600000, TimeUnit.MILLISECONDS);
    }

    public void implicitWait(){
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitElement() throws InterruptedException {
        Thread.sleep(3000);
    }

    public void checkClickable(String componentPath){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(componentPath)));
    }

    public boolean isPresent(String componentPath, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(componentPath)));
        String textPresentOnUI = driver.findElement(By.xpath(componentPath)).getText();
        return textPresentOnUI.contains(expectedText);

    }

    public void selectDropdown(String componentPath, String option){
        Select listLevel = new Select(getElementByXpath(componentPath));
        listLevel.selectByVisibleText(option);
    }

    public void selectDropdownByValue(String componentPath, String option){
        Select listLevel = new Select(getElementByXpath(componentPath));
        listLevel.selectByValue(option);
    }

    public boolean isWebElementExist(String componentPath){
        waitForPagetobeReady();
        element = getElementByXpath(componentPath);
        initialElementState = element.isDisplayed();
        if(!initialElementState){
            printLog("Web element is not found after waiting for 5 seconds ["+element+"]");
        }
        return initialElementState;
    }

    public boolean isWebElementEnabled(String componentPath){
        boolean check = true;
        element = getElementByXpath(componentPath);
        if(element.isDisplayed()){
            check = element.isEnabled();
        }else{
            return check = false;
        }
        return check;
    }

    public boolean isElementPresent(String componentPath){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(componentPath)));
        element = getElementByXpath(componentPath);
        initialElementState = element.isDisplayed();
        if(!initialElementState){
            printLog("Web element is not found after waiting for 5 seconds ["+element+"]");
        }
        return initialElementState;
    }

    public boolean isElementExist(String componentPath){
        waitForPagetobeReady();
        element = getElementByCss(componentPath);
        initialElementState = element.isDisplayed();
        if (!initialElementState) {
            printLog("Web element is not found after waiting for 5 seconds ["+element+"]");
        }
        return initialElementState;
    }

    public void clickWebElement(String componentPath){
        if(!isElementPresent(componentPath)){
            printLog("Web element can not be clicked or not found");
        }else{
            element = getElementByXpath(componentPath);
            element.click();
        }
    }

    public void clickElementByCss(String componentPath){
        if (!isElementExist(componentPath)){
            printLog("Web element can not be clicked or not found");
        } else {
            element = getElementByCss(componentPath);
            element.click();
        }
    }

    public void enterTextIntoWebElement(String componentPath, String text){
        if(!isElementPresent(componentPath)){
            printLog("Web element can not be texted or not found");
        }else{
            element = getElementByXpath(componentPath);
            element.sendKeys(text);
        }
    }

    public void pressEnterKey(String componentPath){
        if(!isElementPresent(componentPath)){
            printLog("Web element can not be texted or not found");
        } else {
            element = getElementByXpath(componentPath);
            element.sendKeys(Keys.ENTER);
        }
    }

    public void pageDown(){
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }

    public void actionClass(String componentPath){
        element = getElementByXpath(componentPath);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public void refreshPage(){
        this.driver.navigate().refresh();
    }

    public void switchFrame(String componentPath){
        element = getElementByXpath(componentPath);
        driver.switchTo().frame(element);
    }
    public void scrolltoXpath(String componentPath){
        element = driver.findElement(By.xpath(componentPath));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clearField(String componentPath){
        driver.findElement(By.xpath(componentPath)).clear();
    }

    public void popupChromeAccept(){
        driver.switchTo().alert().accept();
    }

    public void popupChromeDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public String getText(String componentPath){
        String text = getElementByXpath(componentPath).getText();
        printLog("Test is "+text);
        return text;
    }

    public boolean isTextPresent(String componentPath, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(componentPath)));
        String textPresentOnUI = driver.findElement(By.xpath(componentPath)).getText();
        return textPresentOnUI.contains(expectedText);
    }

    public void acceptPopUp(){
        driver.switchTo().alert().accept();
    }

    public void endScenario(){
        driver.close();
    }
}
