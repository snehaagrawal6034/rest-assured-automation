package stepDefinition;

import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.RandomData;
import org.junit.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class GetResource {
    private String token;
    private RequestSpecification requestSpecification;
    private Response responseSpecification;

    /** Get a particular System property given its key **/
//    public String getToken()throws Exception{
//        FileReader reader=new FileReader("src/test/resources/system.properties");
//
//        Properties p=new Properties();
//        p.load(reader);
//
//        System.out.println(p.getProperty("accessToken"));
//        return p.getProperty("accessToken");
//    }

    @Given("^I hit the github base API URL$")
    public void givenBaseURI() throws Exception {
        token = System.getProperty("TOKEN_NUMBER");
//        token = getToken();
        System.out.println(token);
        requestSpecification = given()
                .baseUri("https://api.github.com/");
    }

    @When("^I send the path using HTTP method$")
    public void validInput() {
        responseSpecification = requestSpecification.when()
                .header(new Header("Authorization", "token "+token))
                .get("/user");
    }

    @Then("^I validate the positive response$")
    public void aavalidAuthResponse(List<RandomData> randomData) {
        JsonObject jsonObject  = new JsonObject();
        // gson, moshi, jackson - serialization, deserialization
        // serialization - object to json string
        // deseraizalition - json string to object
        // network call - you get json string in response, then you deserialize in object
        // object - convert it into json string and send it as body.
//        given().body()
        System.out.println(randomData);
        System.out.println(hashCode());
        responseSpecification.then()
                .log()
                .all()
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Cache-Control", containsString("max-age=60"))
                .statusCode(200)
                .body("plan.name", is("free")).header("X-Powered-By",nullValue());
    }

    @When("^I send the path using HTTP method without authentication$")
    public void invalidInput() {
        responseSpecification = requestSpecification.when().get("/user");
    }

    @Then("^I validate the unauthentication response$")
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
//        responseSpecification.then().log().all();
    }

    @When("^I send the response with token without permission$")
    public void withoutReadPermission() {
        responseSpecification = requestSpecification.when()
                .header(new Header("Authorization", "token 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"))
                .get("/user");
    }

    @Then("^I validate the forbidden access")
    public void validForbiddenResponse() {
        responseSpecification
                .then()
                .log()
                .all()
                .statusCode(200); //TODO - how to test 403
    }

    @When("^I send the products path$")
    public void productPath() {
        responseSpecification = requestSpecification.when().
                header(new Header("Authorization", "token " + token))
                .get("/user");
    }

    @Then("^I validate the products schema$")
    public void productSchemaResponse() {
        responseSpecification
                .then().assertThat()
                .log().all()
                .body(matchesJsonSchema(new File("src/test/resources/data/schema_validation.json")));
    }

    @Then("^I validate the response time$")
    public void validResponseTime() {
        responseSpecification
                .then().time(lessThan(2000L));
    }

    private List<RandomData> response = new ArrayList<>();
    @When("I test the datatable")
    public void datatable(List<RandomData> randomData) {

        response = apiToBeTested(randomData);
    }

    private List<RandomData> apiToBeTested(List<RandomData> randomData) {
        return randomData.stream().map(randomData1 -> new RandomData(randomData1.arbit+"9", randomData1.value)).collect(Collectors.toList());
    }

    @Then("I see the following")
    public void assertEquals(List<RandomData> expected) {
        Assert.assertEquals(expected, response);
    }
}
