package actions;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseClass {
    private static final String TOKEN = "531bfd39b6da8832d0a0e51a2d39301170e69e45";
    private RequestSpecification requestSpecification;
    private Response responseSpecification;

    public void givenBaseURI() {
        requestSpecification = given()
                .baseUri("https://api.github.com/");
        responseSpecification = requestSpecification.when().header(new Header("Authorization", "token " + TOKEN)).get("/user");
    }
}
