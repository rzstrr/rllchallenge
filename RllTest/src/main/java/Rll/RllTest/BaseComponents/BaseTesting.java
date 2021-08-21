package Rll.RllTest.BaseComponents;

import Rll.RllTest.TestObject.Request.Request;
import com.google.gson.Gson;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class BaseTesting {

    protected final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static String finalResponse = "", temporerRequest="";
    public String preferredDriver="", driverSource="", driverBehaviour="", webProtocol="", webUrl="";

    public String getPropertiesFromCustomSource(String fileName, String value){
        ClassLoader loader =Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        String propertyName="";

        try {
            InputStream inputStream =loader.getResourceAsStream(fileName);
            if(inputStream==null){
                properties.load(new FileInputStream("src/main/resources/application.properties"));
                propertyName = properties.getProperty(value);
                printLog("Force to read properties..");
            }else{
                properties.load(inputStream);
                propertyName = properties.getProperty(value);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        if(propertyName.isEmpty()){
            printLog("Something went wrong while reading properties from source file! Terminate the process..");
            System.exit(0);
        }
        return propertyName;
    }

    public String getProperties(String propertiesName){
        String propertyVal = getPropertiesFromCustomSource("application.properties",propertiesName);
        if(propertyVal.isEmpty()){
            printLog("Terminate the process as your properties is not registered on the file yet..");
            System.exit(0);
        }
        printLog("Properties found!");
        return propertyVal;
    }

    public String formAJSON(Request rq){
        String finalJson="";
        Gson gson = new Gson();
        finalJson = gson.toJson(rq);
        return finalJson;
    }

    public void assertString(String messages,String expected, String actual){
        Assert.assertEquals(messages,expected,actual);
    }

    public void assertNumber(String messages, int expected, int actual){
        Assert.assertEquals(messages,expected,actual);
    }

    public void assertStatement(String messages, boolean expected, boolean actual){
        Assert.assertEquals(messages,expected,actual);
    }

    public boolean checkValue(String classType, String targetToBeCheck){
        boolean check = true;
        int limit = targetToBeCheck.length();

        if(classType.equals("Integer")){
            for(int b=0; b < limit ; b++){
                if(!Character.isDigit(targetToBeCheck.charAt(b))){
                    check=false;
                    break;
                }
            }
            printLog("Integer value was ["+targetToBeCheck+"] and checking statement is "+check);
        }else if(classType.equals("String")){
            for(int a=0; a < limit ; a++){
                if(Character.isDigit(targetToBeCheck.charAt(a))){
                    check=false;
                    printLog("Your string value contains numeric!");
                    break;
                }
            }
            printLog("successfully check ["+targetToBeCheck+"] as String");
        }else{
            failureAssertion("Fail to validate value.. Please check your parameters");
        }
        return check;
    }

    public void failureAssertion(String messages){
        Assert.fail(messages);
    }

    public void printLog(String msg){
        logger.info(msg);
    }
}
