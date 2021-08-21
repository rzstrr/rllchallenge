package Rll.RllTest.TestObject.RequestFormat;

public class RequestII   {

    int id;
    int userid;
    String title;
    String body;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString(){
        return "id = "+id+" | userId = "+userid+" | title = "+title+" | body ="+body.replace("\n","");
    }


}
