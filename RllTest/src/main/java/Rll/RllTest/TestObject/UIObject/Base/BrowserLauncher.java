package Rll.RllTest.TestObject.UIObject.Base;

import Rll.RllTest.TestObject.UIObject.Base.BrowserDefinition;
import org.openqa.selenium.WebDriver;

public class BrowserLauncher extends BrowserDefinition {

    public String goToDefaultUrl(){
        String validUrl="";
        webProtocol = getProperties("rll.test.web.protocol");
        webUrl = getProperties("rll.test.web.url");

        if(webProtocol.isEmpty() && webUrl.isEmpty()){
            printLog("Empty Variables are ["+preferredDriver+","+driverSource+"]");
        }else{
            validUrl = webProtocol+"://"+webUrl;
            printLog("Has been successfully retireve url ["+validUrl+"]");
        }
        return validUrl;
    }

    public WebDriver enforceMyBrowsers(){
        WebDriver drivers = getWebDriverFromGeneric("Chrome");
        return drivers;
    }
}
