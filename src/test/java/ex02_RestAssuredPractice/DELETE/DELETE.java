package ex02_RestAssuredPractice.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DELETE {


    RequestSpecification r;
    Response response1;
    ValidatableResponse vr;
    @Test
    public void test_PATCH_Non_BDD_Positive(){

        String bookingid = "3402";
        String token ="1e9af2e6fcffe02";


        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);

        response1 =r.when().log().all().delete();

        vr = response1.then().log().all().statusCode(201);

    }

}
