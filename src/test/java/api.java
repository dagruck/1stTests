import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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


        String nam = new   JSONArray(response1.body().asString()).getJSONObject(0).get("name").toString();
        Assertions.assertTrue(new   JSONArray(response1.body().asString()).getJSONObject(0).get("name").toString() != null );

        System.out.println("$$$$$$$" + nam);


        JSONArray JSONResponseBody = new   JSONArray(response1.body().asString());
        String name = JSONResponseBody.getJSONObject(0).get("name").toString();
        System.out.println("$$$$$$$" + name);
        // Проверка на соответствие искомого имени
        Assertions.assertEquals(JSONResponseBody.getJSONObject(0).getString("name"), "cat");



        String obj = JSONResponseBody.getJSONObject(0).toString();
        System.out.println(obj);

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
//        JSONArray obj = new JSONArray(response1.getBody().asString());
        System.out.println(resp);
//        JSONObject obj = new JSONArray(response1.getBody()).getJSONObject(0);
        String name = new JSONObject(response1.getBody().asString()).get("name").toString();
//        String name = new JSONObject(obj.getJSONObject(0).getString("id").toString());
        System.out.println("---------------------     " + name);
        String name2 = new JSONObject(response1.getBody().asString()).getJSONObject("category").get("name").toString();
        System.out.println("---------------------     " + name2);
        //  Assertions.assertEquals("Jessie");
//        System.out.println(name);

    }


}
