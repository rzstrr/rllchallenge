package Rll.RllTest.TestObject.UIObject.Pages;

import Rll.RllTest.TestObject.UIObject.Base.PageIdentifier;
import org.openqa.selenium.WebDriver;

public class RLLHomepage extends PageIdentifier {

    public String searchBar = "//div[contains(@class,'home-search')]//input";
    public String searchButton = "//button[contains(text(),'Search')]";
    public String searchID = "//button[contains(text(),'Cari')]";
    public String loginButton = "//a[contains(text(),'Login')]";
    public String popUpPermission = "//button[contains(@id,'allow')]";
    public String sortByLable = "//label[contains(text(),'Sort by')]";

    public RLLHomepage(WebDriver driverParam) {
        super(driverParam);
    }

    public void clickSearchButton(){
        clickWebElement(searchButton);
    }

    public void clickSearchButtonID(){
        clickWebElement(searchID);
    }

    public void enterSearchTextbox(String text){
        enterTextIntoWebElement(searchBar,text);
    }

    public void clickLoginButton(){
        clickWebElement(loginButton);
    }

    public boolean checkComponent(String component){
        boolean check = false;
        if(component.equals("search bar")){
            check = isElementExist(searchBar);
        }else if(component.equals("search button")){
            check = isElementExist(searchButton);
        }
        return check;
    }

    public String getSearchTextbox(){
        return getText(searchBar);
    }

    public void clickPermission(){
        waitForPagetobeReady();
        clickWebElement(popUpPermission);
    }

    public boolean checkLabel(){
        return isElementPresent(sortByLable);
    }
}
