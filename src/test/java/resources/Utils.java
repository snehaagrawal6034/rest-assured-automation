package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static io.restassured.RestAssured.given;

public class Utils {
    public static RequestSpecification req;
    public RequestSpecification requestSpecification() throws IOException {

        if (req == null) {
          req=given()
                  .baseUri("https://api.github.com/");
            return req;
        }
        return req;
    }

}
