package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class PostResource {

        private String token;
        private RequestSpecification requestSpecification;
        private Response responseSpecification;

    @Given("^I hit the github base API URL for Post$")
    public void givenBaseURI() throws Exception {
        token = System.getProperty("TOKEN_NUMBER");
//        token = getToken();
        System.out.println(token);
        User user = new User("snehaagrawal6034", "testingPostUsingRestAssured", "yayyyy", true, false);
        requestSpecification = given()
                .baseUri("https://api.github.com/")
                .body(user);
//                .body(new File("src/test/resources/data/user-repos.json"));

    }

    @When("^I send the path and invalid body using HTTP method$")
    public void invalidInput() {
        RequestSpecification localRequest = requestSpecification.when()
                .header(new Header("Authorization", "token "+token))
                .header(new Header("Accept","application/json"));
        localRequest.log().all();
        responseSpecification = localRequest.post("/repos/snehaagrawal6034/tested/dispatches");
    }

    @Then("^I validate status code 422$")
    public void invalidResponseTime() {
        responseSpecification
                .then().statusCode(422);
    }

    @When("^I send the path and valid body using HTTP method$")
    public void validInput() {
        responseSpecification = requestSpecification.when()
                .header(new Header("Authorization", "token "+token))
                .header(new Header("Accept","application/vnd.github.baptiste-preview+json"))
                .redirects().follow(false)
                .post("/repos/snehaagrawal6034/cucumber_basics/generate");
    }

    @Then("^I validate record has been created$")
    public void validResponseTime() {
        String redirectUrl = responseSpecification.getHeader("Location");
        responseSpecification = given()
                .body(new File("src/test/resources/data/user-repos.json"))
                .header(new Header("Authorization", "token "+token))
                .header(new Header("Accept","application/vnd.github.baptiste-preview+json"))
                .post(redirectUrl);

        Response response = responseSpecification
                .then()
                .log().all()
                .statusCode(201)
                .header("Content-Length","6090")
                .header("Cache-Control",containsString("max-age=60"))
                .body("owner.login",is("snehaagrawal6034"))
                .body("owner.site_admin", isA(Boolean.class))
                .time(lessThan(50000L)).extract().response();
//        UserResponse userResponse = responseSpecification.as(UserResponse.class);
//        System.out.println(userResponse);
    }

    @When("^I delete the repo using HTTP method$")
    public void deleteRepo() {
        responseSpecification = requestSpecification.when()
                .header(new Header("Authorization", "token "+token))
                .header(new Header("Accept","application/vnd.github.baptiste-preview+json"))
                .delete("/repos/snehaagrawal6034/testingPostUsingRestAssured");
    }

    @Then("^I validate no record is present$")
    public void noRecordPresent() {
        responseSpecification
                .then().statusCode(204);
    }

    @When("^I dont send the token$")
    public void createRecordWithoutToken() {
        responseSpecification = requestSpecification.when()
                .header(new Header("Accept","application/vnd.github.baptiste-preview+json"))
                .post("/repos/snehaagrawal6034/cucumber_basics/generate");
    }

    @Then("^I validate unauthorized error$")
    public void unauthorized() {
        responseSpecification
                .then().statusCode(401);
    }

    @When("^I send get request using HTTP method$")
    public void getRequest() {
        responseSpecification = requestSpecification.when()
                .header(new Header("Authorization", "token "+token))
                .get("/repos/snehaagrawal6034/testingPostUsingRestAssured1");
    }

    @Then("^I validate successful creation of record$")
    public void validPositiveResponse() {
        responseSpecification.then().log().ifError();
        responseSpecification.then()
                .statusCode(200);
    }
}
