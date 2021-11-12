import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class RickMortyApi extends Vova {

    @Test
    public void rickMortyTest () {
        GetValueEpisode("2");
        Getepisode();

    }

   @Test
    public void rickMortyApiTest () {
        Response response = given()
                .baseUri("https://rickandmortyapi.com/api")
                .contentType(ContentType.JSON)
                .when().get("/character/4")
                .then()
                .statusCode(200)
                .extract().response();

        //System.out.println(response.getBody().asString());
       System.out.println(response.getBody().asString());

        String key1 = new JSONObject(response.getBody().asString()).get("name").toString();
        System.out.println(key1);

       String race = new JSONObject(response.getBody().asString()).get("species").toString();
       System.out.println(race);

        String key2 = new JSONObject(response.getBody().asString()).getJSONArray("results").getJSONObject(0).toString();
        System.out.println(key2);

//        String earth137 = new JSONObject(response.getBody().asString()).getJSONArray("results").getJSONObject(0).getJSONObject("origin").get("name").toString();
//        System.out.println(earth137);
//
//        String infoMorty = new JSONObject(response.getBody().asString()).getJSONArray("results").getJSONObject(1).toString();
//        System.out.println("ИНФО " + infoMorty);
//
//        String nameMorty7 = new JSONObject(response.getBody().asString()).getJSONArray("results").getJSONObject(1).get("name").toString();
//        System.out.println(nameMorty7);
//
//        String episode = new JSONObject(response.getBody().asString()).getJSONArray("results").getJSONObject(1).getJSONArray("episode").toString();
//        System.out.println(episode);
//
//
//        // Найти информацию по персонажу Морти Смит.
//
        String name = "Beth Smith";
       int m = 0;
        String nameMortyy = "";

        while (!Objects.equals(nameMortyy, name)){
            nameMortyy = new JSONObject(response.getBody().asString()).getJSONArray("results").getJSONObject(m).get("name").toString();
            System.out.println(nameMortyy);
            m++;
        };
//
//
//        System.out.println(m);
//        System.out.println(new JSONObject(response.getBody().asString()).getJSONArray("results").getJSONObject(m-1).toString());
//        System.out.println(new JSONObject(response.getBody().asString()).getJSONArray("results").getJSONObject(m-1).get("name").toString());
//
//
//        String infoMortyy = new JSONObject(response.getBody().asString()).getJSONArray("results").getJSONObject(m-1).toString();
//        System.out.println("ЗАДАНИЕ 1 " + infoMortyy);
//
//
//
//        String infoMorty7 = new JSONObject(response.getBody().asString()).getJSONArray("results").getJSONObject(0).get("name").toString();
//
//        String nameMorty9 = new JSONObject(response.getBody().asString()).getJSONArray("results").getJSONObject(1).get("name").toString();
//        System.out.println(nameMorty9);
//
//
//
//
//
//       // Выбрать из ответа последний эпизод где появлялся Морти.
//        int n = 1;
//
//        String episode1 = new JSONObject(response.getBody().asString()).getJSONArray("results").getJSONObject(1).getJSONArray("episode").get(n).toString();
//        System.out.println(episode1);
//
//
//
//
////
////        String name1 = new JSONArray(response.getBody().asString()).getJSONArray(1).getJSONObject("result").get("name");
////        System.out.println(name1);


    }
}
