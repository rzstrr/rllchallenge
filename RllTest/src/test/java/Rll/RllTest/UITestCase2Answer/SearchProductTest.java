package Rll.RllTest.UITestCase2Answer;

import Rll.RllTest.TestObject.UIObject.Base.UITest;
import Rll.RllTest.TestObject.UIObject.Pages.RLLHomepage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SearchProductTest extends UITest {

    private String targetedSearch = "iphone x";

    @Test(priority = 0)
    public void openBrowser(){
        String header = webDriver.getTitle();
        if(!header.contains("Wholesale")){
            terminateTestWithMessages("Your browser is not open correct homepage");
        }
    }

    @Test(priority = 1)
    public void enterSearchText(){
        RLLHomepage homepage = PageFactory.initElements(webDriver,RLLHomepage.class);
        homepage.waitForPagetobeReady();
        homepage.clickPermission();
        homepage.enterSearchTextbox(targetedSearch);
    }

    @Test(priority = 2)
    public void clickSearchButton(){
        RLLHomepage homepage = PageFactory.initElements(webDriver,RLLHomepage.class);
        homepage.clickSearchButton();
    }

      @Test(priority = 3)
      public void verifySearchResultByUIAndUrl(){
          RLLHomepage homepage = PageFactory.initElements(webDriver,RLLHomepage.class);

          // verify result by URL
          String url = webDriver.getCurrentUrl();
          if(!url.contains("iphone-x")){
                homepage.failureAssertion("Your search url is not correct with targeted word name ["+targetedSearch+"]");
          }

          // verify result by UI
          homepage.assertStatement("Your product search is wrong",true,homepage.checkLabel());
      }

      @Test(priority = 4)
      public void endTest(){
          RLLHomepage homepage = PageFactory.initElements(webDriver,RLLHomepage.class);
          homepage.endScenario();
      }

}
