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
    private static final String TOKEN = " d7baa0775dd8186b8a976680d960b1e93c0faed7";
    private RequestSpecification requestSpecification;
    private Response responseSpecification;

    @Given("^I hit the github base API URL$")
    public void givenBaseURI() {
        requestSpecification = given()
                .baseUri("https://api.github.com/");

    }

    @When("^I send the path using HTTP method$")
    public void validInput() {
        responseSpecification = requestSpecification.when()
                .header(new Header("Authorization", "token "+TOKEN))
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
                requestSpecification.when().header(new Header("Authorization", "token "+TOKEN))
                        .queryParam("sort","created").get("user/repos");
    }

    @Then("^I validate the response$")
    public void validOptParamResponse() {
        responseSpecification.then().log().all();
    }

}
