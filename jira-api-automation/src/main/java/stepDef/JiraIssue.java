package stepDef;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.models.create.*;
import models.models.update.UpdateIssueRequestBody;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URI;

import static io.restassured.RestAssured.given;

public class JiraIssue {

    private String token = "Basic c25laGEuYWdyYXdhbDYwMzRAZ21haWwuY29tOkRqTHBVZURValNoVzhaeUFBSXRkMUQxMQ==";
    private RequestSpecification requestSpecification;
    private Response responseSpecification;


    @Test
    public void createAndUpdateIssue() {
        String token = "Basic " + System.getenv("JIRAtoken");
        CreateIssueRequestBody issue = new CreateIssueRequestBody(new Fields("Creating of an issue using project keys and issue type names using the REST API", new Issuetype("Task"), new Project("DESK"), "abcd"));
        String createIssueResponseSerialized = given()
                .baseUri("https://jira6034.atlassian.net")
                .body(issue)
                .when()
                .header("content-type", "application/json")
                .header("Authorization", token)
                .post(URI.create("/rest/api/2/issue/")).then().statusCode(201).extract().body().asString();

        // deserialization - here createIssueResponseSerialized(serialized string ) is getting coverted into CreateIssueResponse (deserialized) object
        CreateIssueResponse createIssueResponse = new Gson().fromJson(createIssueResponseSerialized, CreateIssueResponse.class);
        UpdateIssueRequestBody updateIssueRequestBody = new UpdateIssueRequestBody(new models.models.update.Fields("d1", "s1"));

        // serialization
        String body = new Gson().toJson(updateIssueRequestBody);
        System.out.println(body);
        given()
                .baseUri("https://jira6034.atlassian.net")
                .body(body)
                .when()
                .header("content-type", "application/json")
                .header("Authorization", token)
                .put(URI.create("/rest/api/2/issue/" + createIssueResponse.getKey())).then().statusCode(204);
    }

    @Test
    public void fetchIssue() {
        String token = "Basic " + System.getenv("JIRAtoken");
        System.out.println(token);
        requestSpecification = given()
                .baseUri("https://jira6034.atlassian.net/");
        responseSpecification = requestSpecification.when()
                .header(new Header("Authorization", token))
                .get("/rest/api/latest/issue/DESK-12");
        responseSpecification.then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void createAttachementonExistingIssue() {
        String token = "Basic " + System.getenv("JIRAtoken");
        String createIssueResponseSerialized = RestAssured.given()
                .baseUri("https://jira6034.atlassian.net")
                .when()
                .multiPart(new File("src/main/resources/baby.jpeg"))
                .header("content-type", "multipart/form-data; boundary=<calculated when request is sent>")
                .header("Authorization", token)
                .header("X-Atlassian-Token", "no-check")
                .post("/rest/api/3/issue/DESK-12/attachments")
                .then().statusCode(200).extract().body().asString();
    }
}

