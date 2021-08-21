package Rll.RllTest.UITestCase2Answer;

import Rll.RllTest.TestObject.UIObject.Base.UITest;
import Rll.RllTest.TestObject.UIObject.Pages.RLLHomepage;
import Rll.RllTest.TestObject.UIObject.Pages.RLLLoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginTest extends UITest {

    @Test(priority = 0)
    public void openBrowser(){
        RLLHomepage homepage = PageFactory.initElements(webDriver,RLLHomepage.class);
        homepage.waitForPagetobeReady();
        String header = webDriver.getTitle();
        if(!header.contains("Wholesale")){
            terminateTestWithMessages("Your browser is not open correct homepage");
        }
    }

    @Test(priority = 1)
    public void directToLoginPage(){
        RLLHomepage homepage = PageFactory.initElements(webDriver,RLLHomepage.class);
        homepage.waitForPagetobeReady();
        homepage.clickPermission();
        homepage.clickLoginButton();
        String header = webDriver.getTitle();
        if(!header.contains("Login")){
            homepage.failureAssertion("You are not direct to Login Page");
        }
    }

    @Test(priority = 2)
    public void performLogin(){
        RLLLoginPage login = PageFactory.initElements(webDriver,RLLLoginPage.class);
        login.enterTxtUsername(login.username);
        login.clickNextButton();
        login.enterTxtPassword(login.password);
        login.clickSignIn();
        login.clickLinkAktif();
        login.closeModal();
    }

    @Test(priority = 3)
    public void verifyLogin(){
        RLLLoginPage login = PageFactory.initElements(webDriver,RLLLoginPage.class);
        login.assertStatement("You are not in account login page",true,login.verifyInboxLogin());
    }

    @Test(priority = 4)
    public void logoutToEndTesting(){
        RLLLoginPage login = PageFactory.initElements(webDriver,RLLLoginPage.class);
        login.clickHoverLogout(webDriver);
        login.waitForPagetobeReady();
        login.endScenario();
    }
}
