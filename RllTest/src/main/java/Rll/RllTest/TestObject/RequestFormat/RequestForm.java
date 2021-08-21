package Rll.RllTest.TestObject.RequestFormat;

import Rll.RllTest.TestObject.Request.Request;

public class RequestForm {

    public Request getRequestPattern(String tittle, String body, int userId){
        Request rq = new Request();
        rq.setTittle(tittle);
        rq.setBody(body);
        rq.setUserId(userId);
        return rq;
    }

}
