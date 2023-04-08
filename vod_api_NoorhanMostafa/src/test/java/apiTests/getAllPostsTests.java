package apiTests;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class getAllPostsTests {

    @Test
    public void getAllPostsTest(){
        String endPoint = "https://jsonplaceholder.typicode.com/posts";
        ValidatableResponse validatableResponse =
                given().when().get(endPoint).then();
        //Assertions
        validatableResponse.statusCode(200);
    }
}
