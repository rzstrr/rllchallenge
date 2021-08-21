package Rll.RllTest.TestObject.UIObject.Pages;

import Rll.RllTest.TestObject.UIObject.Base.PageIdentifier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RLLChartPage extends PageIdentifier {

    private String fullHover = "//div[contains(@class,'item-list-cards')]//div[1]//item[1]//div//article//figure//a//img";
    private String buttonBeli = "//button[contains(text(),'Beli Sekarang')]";
    private String buttonLanjut = "//div[contains(@class,'hidden')]//button[contains(text(),'Lanjutkan Berbelanja')]";
    private String iconCart = "//span[contains(@class,'cart')]";
    private String cartNotif = "//li[contains(@ng-class,'cart')]/div[contains(text(),'1')]";
    public String accountHover = "//ul[contains(@class,'header')]//span[contains(@class,'account')]";
    public String logout = "//a[contains(@class,'btnHomeLogout')]";

    public RLLChartPage(WebDriver driverParam) {
        super(driverParam);
    }

    public void hoverProduct(WebDriver driver){
        Actions builder = new Actions(driver);
        builder.moveToElement(getElementByXpath(fullHover)).perform();
    }

    public void hoverAccount(WebDriver driver){
        Actions builder = new Actions(driver);
        builder.moveToElement(getElementByXpath(accountHover)).perform();
        builder.moveToElement(getElementByXpath(logout)).perform();
    }

    public void addProduct(){
        clickWebElement(buttonBeli);
    }

    public void clickContinue(){
        clickWebElement(buttonLanjut);
    }

    public boolean checkCart(){
        return isElementPresent(cartNotif);
    }

}
