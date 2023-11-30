package project;
import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.CoreMatchers.*;
import java.util.HashMap;
import java.util.Map;

public class GitHub_RestAssured_Project {
    String sshKey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIMEXRx+KanFcMO+pIhKCA1X5JYzEOkDD9oANQYpsrDO2";
    int sshkeyID;
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    @BeforeClass
    public void setUp() {
        // Create request specification
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","token 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")
                .setBaseUri("https://api.github.com/user/keys")
                .build();

        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectBody("key",equalTo(sshKey))
                .expectBody("title",equalTo("TestAPIKey"))
                .build();
    }


    @Test(priority=1)
    public void postTest() {
        Map<String,String> reqBody=new HashMap<>();
        reqBody.put("title","TestAPIKey");
        reqBody.put("key",sshKey);

        Response response = given().spec(requestSpec).body(reqBody).when().post();
        sshkeyID=response.then().extract().path("id");
        response.then().statusCode(201).spec(responseSpec);

    }

    @Test(priority=2)
    public void getTest() {
        given().spec(requestSpec).pathParam("keyId",sshkeyID)
                .when().get("/{keyId}")
                .then().statusCode(200).spec(responseSpec);

    }

    @Test(priority=3)
    public void deleteTest() {
        given().spec(requestSpec).pathParam("keyId",sshkeyID)
                .when().delete("/{keyId}")
                .then().statusCode(anyOf(is(200),is(204)));

    }





}