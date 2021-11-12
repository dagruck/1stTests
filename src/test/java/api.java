import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class api {
    @Test
    public void getMorty(){



        RequestSpecification request = given();
        request.header("Content-Type", "application/json");

        Response response = request.get("https://rickandmortyapi.com/api/character/2");
        int statuCode = response.statusCode();
        String boddy = response.getBody().asString();
        System.out.println(statuCode);
        System.out.println(boddy);


        // или
                Response response2 = given()
                .baseUri("https://rickandmortyapi.com/api/character/2")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().response();
        String resp = response2.getBody().asString();
        System.out.println(resp);
    }


    @Test
    public void testGet() {
        Response response1 = given()
                .baseUri("https://petstore.swagger.io/v2")
                .when().get("/pet/findByStatus?status=available")
                .then()
                .statusCode(200)
                .extract().response();


        String nam = new JSONArray(response1.body().asString()).getJSONObject(0).get("name").toString();
        Assertions.assertTrue(new JSONArray(response1.body().asString()).getJSONObject(0).get("name").toString() != null);
        System.out.println("$$$$$$$" + nam);


        JSONArray JSONResponseBody = new JSONArray(response1.body().asString());
        String name = JSONResponseBody.getJSONObject(0).getJSONObject("category").get("name").toString();
        System.out.println("$$$$$$$" + name);
    }


    @Test
    public void testGet2() {
        Response response1 = given()

                .baseUri("https://petstore.swagger.io/v2")
                .when().get("/pet/2")
                .then()
                .statusCode(200)
                .extract().response();
        String resp = response1.getBody().asString();
        System.out.println(resp);
        String name = new JSONObject(response1.getBody().asString()).get("name").toString();
        System.out.println("---------------------     " + name);
        String name2 = new JSONObject(response1.getBody().asString()).getJSONObject("category").get("name").toString();
        System.out.println("---------------------     " + name2);
    }


    @Test
    public void testGetw() throws IOException {
        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/2.json"))));
        System.out.println(body);
        Response response1 = given()
                .header("Content-Type", "application/json")
                .baseUri("https://reqres.in/api")
                .when()
                .body(body.toString())
                .post("/users")
                .then()
                .statusCode(201)
                .log().all()
                .extract().response();
//        String resp = (response1.getBody().asString()).;
//        System.out.println(resp);

    }


}
