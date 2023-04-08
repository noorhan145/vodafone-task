package apiTests;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class createPostTests {

    @Test
    public void createPostTest(){
        String endPoint = "https://jsonplaceholder.typicode.com/posts";
        String body = """
                {
                	"title": "foo",
                    "body": "bar",
                    "userId": 1
                }""";
        ValidatableResponse validatableResponse =
                given().body(body).header("Content-Type","application/json")
                        .when().post(endPoint).then();

        //Assertions
        validatableResponse.statusCode(201);
        validatableResponse.body("title",equalTo("foo"),
                "body", equalTo("bar"),
                "userId", equalTo(1),
                "id", equalTo(101));
        validatableResponse.header("Content-Type",equalTo("application/json; charset=utf-8"));

    }
}
