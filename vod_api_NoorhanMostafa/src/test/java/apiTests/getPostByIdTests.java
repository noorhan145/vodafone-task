package apiTests;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class getPostByIdTests {
    @Test
    public void getPostByIdTest(){
        String endPoint = "https://jsonplaceholder.typicode.com/posts/1";
        ValidatableResponse validatableResponse =
                given().when().get(endPoint).then();
        //Assertions
        validatableResponse.statusCode(200);
        validatableResponse.body("userId",equalTo(1),
                "id",equalTo(1),
                "title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"),
                "body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
        }
}
