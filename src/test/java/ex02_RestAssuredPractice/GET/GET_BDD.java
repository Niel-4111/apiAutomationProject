package ex02_RestAssuredPractice.GET;

import io.restassured.RestAssured;


public class GET_BDD {

    public static void main(String[] args) {

        String pincode = "560016";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);

        String pincodes = "-1";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincodes)
                .when().log().all().get()
                .then().log().all().statusCode(404);

    }
}

