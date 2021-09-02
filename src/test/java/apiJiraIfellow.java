import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class apiJiraIfellow {
    @Test
    public void getBoards(){



        RequestSpecification request = given();
        request
                .header("Content-Type", "application/json")
                ;

        Response response = request
                .auth()
                .preemptive()
                .basic("admin","IghyoDPs3x")
                .get("https://edujira.ifellow.ru/rest/agile/1.0/board");
        int statuCode = response.statusCode();
        String boddy = response.getBody().asString();
        System.out.println(statuCode);
        System.out.println(boddy);


    }

    @Test
    public void getIssueParam() throws IOException {


        RequestSpecification request = given();
        request
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
        ;

        Response response = request
                .auth()
                .preemptive()
                .basic("admin","IghyoDPs3x")
                .queryParam("fields","all")
                .get("https://edujira.ifellow.ru/rest/api/2/issue/createmeta")
                ;
        int statuCode = response.statusCode();
        String boddy = response.getBody().asString();
        System.out.println(statuCode);
        System.out.println(boddy);


    }

    @Test
    public void getIssueType() throws IOException {


        RequestSpecification request = given();
        request
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
        ;

        Response response = request
                .auth()
                .preemptive()
                .basic("admin","IghyoDPs3x")
                .queryParam("fields","all")
                .get("https://edujira.ifellow.ru/rest/api/2/issue/createmeta")
                ;
        int statuCode = response.statusCode();
        String boddy = response.getBody().asString();
        System.out.println(statuCode);
        System.out.println(boddy);


    }
    @Test
    public void getProject() throws IOException {


        RequestSpecification request = given();
        request
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
        ;

        Response response = request
                .auth()
                .preemptive()
                .basic("admin","IghyoDPs3x")
                .get("https://edujira.ifellow.ru/rest/api/3/project/search")
                ;
        int statuCode = response.statusCode();
        String boddy = response.getBody().asString();
        System.out.println(statuCode);
        System.out.println(boddy);


    }

    @Test
    public void createIssue() throws IOException {

        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/JiraIssue.json"))));

            RequestSpecification request = given();
            request
                    .baseUri("https://edujira.ifellow.ru/rest/api/")
                    .header("Content-Type", "application/json")
//                    .header("Accept", "application/json")
                    .auth()
                    .preemptive()
                    .basic("admin","IghyoDPs3x")
            ;

            Response response = request

                    .body(body.toString())
                    .post("2/issue")
                    ;
            int statuCode = response.statusCode();
            String boddy = response.getBody().asString();
            System.out.println(statuCode);
            System.out.println(boddy);


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
