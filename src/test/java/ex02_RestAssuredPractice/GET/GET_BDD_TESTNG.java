package ex02_RestAssuredPractice.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GET_BDD_TESTNG {

    @Test
    public void test_GET_Req_Positive() {

        String pincode = "560016";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }

    @Test
    public void test_GET_Req_Negative() {
        String pincodes = "-1";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincodes)
                .when().log().all().get()
                .then().log().all().statusCode(404);

    }

}
