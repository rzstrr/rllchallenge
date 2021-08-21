package Rll.RllTest.StepDefinition;

import Rll.RllTest.TestObject.RequestFormat.RequestII;
import Rll.RllTest.TestObject.RequestSender.TestExecutor;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONException;

public class CaseStepDefinition {

    private TestExecutor execute = new TestExecutor();

    @Given("I can read url in service properties")
    public void readURL(){
        execute.assertStatement("Properties verification is failed",true,execute.verifyProperties("rll.test.url"));
    }

    @When("I perform GET method through the service")
    public void hitService(){
        execute.executeGETJSON(execute.getProperties("rll.test.url"));
    }

    @When("I post payload with these attribute [{string},{string},{int}]")
    public void hitServiceWithAttribute(String tittle,String body, int userID){
        execute.executePOSTRequest(execute.getProperties("rll.test.url"),tittle,body,userID);
    }

    @Then("I can have {string} data type in all {string} response")
    public void getResponse(String dataType, String field) throws JSONException {
        Gson gg = new Gson();
        RequestII [] arrReq = gg.fromJson(execute.finalResponse,RequestII [].class);

        for(int b=0; b < arrReq.length; b++){
             if(field.equals("id")){
                 execute.assertStatement("Your value on ["+field+"-"+(b+1)+"] is not right",true,execute.checkValue(dataType,Integer.toString(arrReq[b].getId())));
             }else if(field.equals("userId")){
                 execute.assertStatement("Your value on ["+field+"-"+(b+1)+"] is not right",true,execute.checkValue(dataType,Integer.toString(arrReq[b].getUserid())));
             }else if(field.equals("title")){
                 execute.assertStatement("Your value on ["+field+"-"+(b+1)+"] is not right",true,execute.checkValue(dataType,arrReq[b].getTitle()));
             }else if(field.equals("body")){
                 execute.assertStatement("Your value on ["+field+"-"+(b+1)+"] is not right",true,execute.checkValue(dataType,arrReq[b].getBody()));
             }
        }
    }

    @Then("I should have the same response with sent payload")
    public void verResp(){
        execute.assertString("Response body did not match! Fail the test", execute.temporerRequest, execute.finalResponse);
    }
}
