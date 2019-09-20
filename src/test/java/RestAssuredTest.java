import com.fasterxml.jackson.core.type.TypeReference;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.filter.log.LogDetail;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.http.ContentType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.http.HttpRequest;
import org.junit.Before;
import org.junit.Test;
import com.jayway.restassured.RestAssured;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.endsWith;

public class RestAssuredTest {
    private RequestSpecification request;

    @Before
    public void setUp(){
        RestAssured.baseURI = "http://127.0.0.1:3000/";

        request = new RequestSpecBuilder()
                .addFilter(new ResponseLoggingFilter())
                .build()
                .when();


    }


    @Test
    public void restAssuredTestExample() throws IOException {
        given().accept(ContentType.JSON)
                .when().get("/posts")
                .then()
                .statusCode(200)
                .and().contentType(ContentType.JSON);

        String body = get("posts")
                .then()
                .extract()
                .body().asString();

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Post> posts = mapper.readValue(body, new TypeReference<List<Post>>(){});
    }

    @Test
    public void verifyCommentsCharset(){
        given().accept(ContentType.JSON)
                .when().get("/comments")
                .then()
                .header("Content-Type", endsWith("utf-8"));
    }

    @Test
    public void verifyAlbums(){
        Response response = request.get("/albums");
    }

}
