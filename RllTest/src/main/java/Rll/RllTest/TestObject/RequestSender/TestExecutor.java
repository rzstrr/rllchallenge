package Rll.RllTest.TestObject.RequestSender;

import Rll.RllTest.BaseComponents.BaseTesting;
import Rll.RllTest.TestObject.RequestFormat.RequestForm;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestExecutor extends BaseTesting {

    private RequestForm reqForm = new RequestForm();

    public boolean verifyProperties(String properties){
        boolean check = true;
        if(getProperties(properties).isEmpty()){
            check = false;
        }
        return check;
    }

    public void executePOSTRequest(String url,String tittle,String body, int userID){

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        temporerRequest = formAJSON(reqForm.getRequestPattern(tittle,body,userID));
        try {
            httpPost.setEntity(new StringEntity(temporerRequest));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            finalResponse = EntityUtils.toString(httpResponse.getEntity());
            printLog("Final response is "+finalResponse);
        } catch (Exception e) {
            printLog("Something wrong while executing POST method [" + e.getStackTrace() + "]");
        }
    }

    public void executeGETJSON(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            finalResponse = EntityUtils.toString(httpResponse.getEntity());
            printLog("Final response is "+finalResponse);
        } catch (Exception e) {
            printLog("Something wrong while executing POST method [" + e.getStackTrace() + "]");
        }
    }
}
