package stepDef;

import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.create.*;
import models.update.UpdateIssueRequestBody;

import java.io.File;
import java.net.URI;

import static io.restassured.RestAssured.given;

public class JiraIssue {

    private String token;
    private RequestSpecification requestSpecification;
    private Response responseSpecification;
    private CreateIssueRequestBody issue;
    CreateIssueResponse createIssueResponse;

    @Given("^I hit the JIRA base API URL$")
    public void getBaseURI() {
        token = "Basic " + System.getenv("JIRAtoken");
        requestSpecification = given()
                .baseUri("https://jira6034.atlassian.net");
    }

    @When("^I send the path and valid body using HTTP method$")
    public void createIssue() {
        issue = new CreateIssueRequestBody(new Fields("Creating of an issue using project keys and issue type names using the REST API", new Issuetype("Task"), new Project("DESK"), "abcd"));
        responseSpecification = requestSpecification.body(issue)
                .when()
                .header("content-type", "application/json")
                .header("Authorization", token)
                .post(URI.create("/rest/api/2/issue/"));
    }

    @Then("^I validate issue created successfully with status code 201$")
    public void createIssueSuccess() {
        responseSpecification.then().statusCode(201);
        String createIssueResponseSerialized = responseSpecification.then().extract().body().asString();
        // deserialization - here createIssueResponseSerialized(serialized string ) is getting coverted into CreateIssueResponse (deserialized) object
        createIssueResponse = new Gson().fromJson(createIssueResponseSerialized, CreateIssueResponse.class);
    }

    @When("^I change body using HTTP method$")
    public void updateIssue() {
        UpdateIssueRequestBody updateIssueRequestBody = new UpdateIssueRequestBody(new models.update.Fields("d1", "s1"));
        // serialization - this is done just for understanding , it gets coverted to Json automatically internally
        String updatedBody = new Gson().toJson(updateIssueRequestBody);
        responseSpecification = requestSpecification.body(updatedBody)
                .when()
                .header("content-type", "application/json")
                .header("Authorization", token)
                .put("/rest/api/2/issue/" + createIssueResponse.getKey());
    }

    @Then("^I validate issue updated successfully with status code 204$")
    public void updateIssueSuccess() {
        responseSpecification.then().statusCode(204);
    }

    @When("^I try to fetch the issue$")
    public void fetchIssue() {
        responseSpecification = requestSpecification.when()
                .header(new Header("Authorization", token))
                .get("/rest/api/latest/issue/" + createIssueResponse.getKey());
    }

    @Then("^I validate issue fetched successfully with status code 200$")
    public void fetchIssueSuccess() {
        responseSpecification.then().statusCode(200);
    }

    @When("^I add an attachment to the issue$")
    public void createAttachementonExistingIssue() {
        responseSpecification = requestSpecification.when()
                .multiPart(new File("src/test/resources/baby.jpeg"))
                .header("content-type", "multipart/form-data; boundary=<calculated when request is sent>")
                .header("Authorization", token)
                .header("X-Atlassian-Token", "no-check")
                .post("/rest/api/3/issue/" + createIssueResponse.getKey() + "/attachments");
    }

    @Then("^I validate attachment added successfully$")
    public void createAttachementonSuccess() {
        responseSpecification.then().statusCode(200).extract().body().asString();
    }

    @When("^I delete the issue$")
    public void deleteIssue() {
        responseSpecification = requestSpecification.when()
                .header(new Header("Authorization", token))
                .get("/rest/api/3/issue/" + createIssueResponse.getKey());
    }

    @Then("^I validate issue deleted successfully$")
    public void issueDeleted() {
        responseSpecification.then().statusCode(200).extract().body().asString();
    }

//    @Test
//    public void createAttachementonExistingIssue1() {
//        String createIssueResponseSerialized = RestAssured.given()
//                .baseUri("https://jira6034.atlassian.net")
//                .when()
//                .multiPart(new File("src/test/resources/baby.jpeg"))
//                .header("content-type", "multipart/form-data; boundary=<calculated when request is sent>")
//                .header("Authorization", token)
//                .header("X-Atlassian-Token", "no-check")
//                .post("/rest/api/3/issue/DESK-12/attachments")
//                .then().statusCode(200).extract().body().asString();
//    }
}

