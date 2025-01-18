package ex02_RestAssuredPractice.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class POST_NonBDDStyle {

    RequestSpecification r;
    Response response1;
    ValidatableResponse vr;
    @Test
    public void test_POST_Non_BDD_Positive(){


        String payload ="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r = RestAssured.given();
                r.baseUri("https://restful-booker.herokuapp.com");
                r.basePath("/auth");
                r.contentType(ContentType.JSON);
                r.log().all().body(payload);

        response1 =r.when().log().all().post();

        vr = response1.then().log().all().statusCode(200);
        
    }
}
