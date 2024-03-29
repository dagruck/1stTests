import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Vova {




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
            value = Integer.parseInt(new JSONObject(response1.body().asString()).getJSONArray("episode").get((new JSONObject(response1.body().asString()).getJSONArray("episode").length()-1)).toString().replaceAll("[^0-9]", ""));
            System.out.println("   number    "  +  (new JSONObject(response1.body().asString()).getJSONArray("episode").length()-1));
            String episo = new JSONObject(response1.body().asString()).getJSONArray("episode").get((new JSONObject(response1.body().asString()).getJSONArray("episode").length()-1)).toString();
           System.out.println(value);
            System.out.println(episo);
            System.out.println(location1);


//            Response response2 = given()
//                    .baseUri("https://rickandmortyapi.com/api")
//                    .when().get("/episode/"+value)
//                    .then()
//                    .extract().response();
//            String resp2 = response2.getBody().asString();
//            System.out.println(response2.getBody().asString());
//            int ii = new JSONObject(response1.body().asString()).getJSONArray("characters").length()-1;
//            System.out.println(ii  );
//            String сhara = new JSONObject(response1.body().asString()).getJSONArray("characters").get((new JSONObject(response1.body().asString()).getJSONArray("characters").length()-1)).toString();
//            String сharacter = new JSONObject(response2.body().asString()).getJSONArray("characters").get(2).toString();
//            System.out.println(сhara);
//            System.out.println(сharacter);
        }


        public static class GetLocation {

            Response response3 = given()
                    .baseUri("https://rickandmortyapi.com/api")
                    .when().get("character/362")
                    .then()
                    .extract().response();
            String resp3 = response3.getBody().asString();
            String name = new JSONObject(response3.body().asString()).get("name").toString();


        }

    private Integer value;
    public void GetValueEpisode(String MortyId) {
        Response response1 = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when().get("/character/"+ MortyId)
                .then()
                .extract().response();
        value = Integer.parseInt(new JSONObject(response1.body().asString()).getJSONArray("episode").get((new JSONObject(response1.body().asString()).getJSONArray("episode").length() - 1)).toString().replaceAll("[^0-9]", ""));
    }
    public void   Getepisode (){
        System.out.println(" номер эпизода " +value );
        Response response3 = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when().get("episode/"+value)
                .then()
                .extract().response();
        System.out.println(response3.getBody().asString()  );
    }
}
