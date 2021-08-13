import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class api {
    @Test
//    @И("Тест Рика")
    public void getMorty(){

//        RequestSpecification request = RestAssured
//                .given()
//                .baseUri("https://rickandmortyapi.com/api/character/2")
//                .contentType(ContentType.JSON)
//                .log().all()
//                .when()
////                .queryParam("login", "Artem")
////                .queryParam("password", "123")
//                .get()
//                .then()
//                .statusCode(200)
//                .extract().response();
//                .log().all()
//                .and();



        RequestSpecification request = given();
        request.header("Content-Type", "application/json");

        Response response = request.get("https://rickandmortyapi.com/api/character/2");
        int statuCode = response.statusCode();
        String boddy = response.getBody().toString();
        System.out.println(statuCode);
        System.out.println(boddy);
                Response response2 = given()
                .baseUri("https://rickandmortyapi.com/api/character/2")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
//                .queryParam("login", "Artem")
//                .queryParam("password", "123")
                .get()
                .then()
//                .statusCode(200)
                .extract().response();
//                .log().all()
//                .and();
        String resp = response2.getBody().asString();
        System.out.println(resp);
    }


}
