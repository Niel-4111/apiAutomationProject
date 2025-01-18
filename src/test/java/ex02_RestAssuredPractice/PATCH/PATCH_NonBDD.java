package ex02_RestAssuredPractice.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PATCH_NonBDD {

    RequestSpecification r;
    Response response1;
    ValidatableResponse vr;
    @Test
    public void test_PATCH_Non_BDD_Positive(){

        String bookingid = "2479";
        String token ="28a106806836644";
        String payload ="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.log().all().body(payload);

        response1 =r.when().log().all().patch();

        vr = response1.then().log().all().statusCode(200);

    }


}
