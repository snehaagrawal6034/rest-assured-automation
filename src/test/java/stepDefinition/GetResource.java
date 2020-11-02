package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

public class GetResource {
    private String token;
    private RequestSpecification requestSpecification;
    private Response responseSpecification;


    @Given("^I hit the github base API URL$")
    public void givenBaseURI() {
        token = System.getProperty("TOKEN_NUMBER");
        System.out.println(token);
        requestSpecification = given()
                .baseUri("https://api.github.com/");

    }

    @When("^I send the path using HTTP method$")
    public void validInput() {
        responseSpecification = requestSpecification.when()
                .header(new Header("Authorization", "token "+token))
                .queryParam("url","dad").get("/user");
    }

    @Then("^I validate the positive response$")
    public void validAuthResponse() {
        System.out.println(hashCode());
        responseSpecification.then()
                .header("Content-Type", "application/json; charset=utf-8")
                .statusCode(200)
                .body("plan.name", is("free")).header("X-Powered-By",nullValue());
    }
    @When("^I send the path using HTTP method without authentication$")
    public void invalidInput() {
        responseSpecification = requestSpecification.when().get("/user");
    }

    @Then("^I validate the negative response$")
    public void invalidAuthResponse() {
        System.out.println(hashCode());
        Assert.assertEquals(401, responseSpecification.statusCode());
    }
    @When("^I send the valid optional parameters$")
    public void validOptParamInput() {
        responseSpecification =
                requestSpecification.when().header(new Header("Authorization", "token "+token))
                        .queryParam("sort","created").get("user/repos");
    }

    @Then("^I validate the response$")
    public void validOptParamResponse() {
        responseSpecification.then().log().all();
    }

}
