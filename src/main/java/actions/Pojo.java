package actions;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Pojo {
    private static final String TOKEN = "531bfd39b6da8832d0a0e51a2d39301170e69e45";
    private RequestSpecification requestSpecification;
    private Response responseSpecification;

    public static String getTOKEN() {
        return TOKEN;
    }
    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public Response getResponseSpecification() {
        return responseSpecification;
    }

    public void setRequestSpecification(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public void setResponseSpecification(Response responseSpecification) {
        this.responseSpecification = responseSpecification;
    }

    public void setToken(String TOKEN){
         TOKEN = "531bfd39b6da8832d0a0e51a2d39301170e69e45";
    }
}


