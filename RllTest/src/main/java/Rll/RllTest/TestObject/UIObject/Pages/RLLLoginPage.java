package Rll.RllTest.TestObject.UIObject.Pages;

import Rll.RllTest.TestObject.UIObject.Base.BrowserDefinition;
import Rll.RllTest.TestObject.UIObject.Base.PageIdentifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RLLLoginPage extends PageIdentifier {

    public String txtUsername = "//input[contains(@name,'email')]";
    public String txtPassword = "//input[contains(@name,'password')]";
    public String signIn = "//button[contains(text(),'Login')]";
    public String nextButton = "//div[contains(@class,'login')]//button[contains(text(),'Next')]";
    public String inboxChat = "//span[contains(@class,'inbox')]";
    public String accountHover = "//ul[contains(@class,'header')]//span[contains(@class,'account')]";
    public String linkActive = "//a[contains(text(),'Nanti')]";
    public String modalX = "//div[contains(text(),'×')]";
    public String logout = "//a[contains(@class,'btnHomeLogout')]";

    public String username = getProperties("rll.test.data.username");
    public String password = getProperties("rll.test.data.password");

    public RLLLoginPage(WebDriver driverParam) {
        super(driverParam);
    }

    public void clickNextButton(){
        clickWebElement(nextButton);
    }

    public void enterTxtUsername(String username){
        enterTextIntoWebElement(txtUsername,username);
    }

    public void enterTxtPassword(String password){
        enterTextIntoWebElement(txtPassword,password);
    }

    public void clickSignIn(){
        clickWebElement(signIn);
    }

    public boolean verifyInboxLogin(){
        return isElementPresent(inboxChat);
    }

    public void clickHoverLogout(WebDriver dr){
        clickWebElement(accountHover);
        Actions act = new Actions(dr);
        act.moveToElement(getElementByXpath(logout)).click();
    }

    public void clickLinkAktif(){
        clickWebElement(linkActive);
    }

    public void closeModal(){
        clickWebElement(modalX);
    }



}
