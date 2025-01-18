package ex02_RestAssuredPractice.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GET_NonBDD {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_Non_BDD_Positive(){
        String pincode = "560016";

        r = RestAssured.given();
                r.baseUri("https://api.zippopotam.us");
                r.basePath("/IN/" + pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);

    }

    @Test
    public void test_Non_BDD_Negative1(){
        String pincode = "-1";

        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);

    }
    //special character, null value, long variable, invalid URL
}
