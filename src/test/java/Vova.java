import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Vova {


        @Test
        public void GetCharacter() {

            Response response1 = given()
                    .baseUri("https://rickandmortyapi.com/api")
                    .when().get("/character/2")
                    .then()
                    .extract().response();
            String resp = response1.getBody().asString();
            String name = new JSONObject(response1.body().asString()).get("name").toString();
            String location1 = new JSONObject(response1.body().asString()).getJSONObject("location").get("name").toString();
            String episode = new JSONObject(response1.body().asString()).getJSONArray("episode").get(25).toString();
//            Pattern episode = Pattern.compile(episode)
//            int value = Integer.parseInt(new JSONObject(response1.body().asString()).getJSONArray("episode").get(25).toString().replaceAll("[^0-9]", ""));
//            String numberOnly= new JSONObject(response1.body().asString()).getJSONArray("episode").get(25).toString().replaceAll("[^0-9]", "");
//            int lst = (new JSONObject(response1.body().asString()).getJSONArray("episode").length()-1);
            int value = Integer.parseInt(new JSONObject(response1.body().asString()).getJSONArray("episode").get((new JSONObject(response1.body().asString()).getJSONArray("episode").length()-1)).toString().replaceAll("[^0-9]", ""));
            String episo = new JSONObject(response1.body().asString()).getJSONArray("episode").get((new JSONObject(response1.body().asString()).getJSONArray("episode").length()-1)).toString();
//
//            String last = Iterables.getLast(lst);
//            String last = lst[lst-1];
//            System.out.println(lst);
            System.out.println(value);
            System.out.println(episo);
            System.out.println(location1);


  /*  }

//    @Test
//    public void GetEpisode() { */
////String vl = new String(value).toString()
            Response response2 = given()
                    .baseUri("https://rickandmortyapi.com/api")
                    .when().get("/episode/"+value)
                    .then()
                    .extract().response();
            String resp2 = response2.getBody().asString();
            System.out.println(response2.getBody().asString());
            String сhara = new JSONObject(response1.body().asString()).getJSONArray("characters").get((new JSONObject(response1.body().asString()).getJSONArray("characters").length()-1)).toString();
//
            String сharacter = new JSONObject(response2.body().asString()).getJSONArray("characters").get(2).toString();



            System.out.println(сhara);
            System.out.println(сharacter);
        }

        @Test
        public void GetLocation() {

            Response response3 = given()
                    .baseUri("https://rickandmortyapi.com/api")
                    .when().get("character/362")
                    .then()
                    .extract().response();
            String resp3 = response3.getBody().asString();
            String name = new JSONObject(response3.body().asString()).get("name").toString();
            String location2 = new JSONObject(response3.body().asString()).getJSONObject("location").get("name").toString();
            System.out.println(name);
            System.out.println(location2);
        }
    }