package api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public  class baseApi {

    public static void createIssue() throws IOException {

        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/JiraIssue.json"))));

        RequestSpecification request = given();
        request
                .baseUri("https://edujira.ifellow.ru/rest/api/")
                .header("Content-Type", "application/json")
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
        String issueID = new JSONObject(response.getBody().asString()).get("id").toString();
        return;
    }

    public static void updateIssue(String issueID) throws IOException {
        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/updJiraIssue.json"))));

        RequestSpecification request = given();
        request
                .baseUri("https://edujira.ifellow.ru/rest/api/")
                .header("Content-Type", "application/json")
                .auth()
                .preemptive()
                .basic("admin","IghyoDPs3x")
        ;

        Response response = request

                .body(body.toString())
                .put("2/issue/"+ issueID)
                ;
        int statuCode = response.statusCode();
        String boddy = response.getBody().asString();
        System.out.println(statuCode);
        System.out.println(boddy);
        return;
    }

    public static void deleteIssue() throws IOException {

        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/updJiraIssue.json"))));

        RequestSpecification request = given();
        request
                .baseUri("https://edujira.ifellow.ru/rest/api/")
                .header("Content-Type", "application/json")
                .auth()
                .preemptive()
                .basic("admin","IghyoDPs3x")
        ;

        Response response = request

                .delete("2/issue/10004")
                ;
        int statuCode = response.statusCode();
        String boddy = response.getBody().asString();
        System.out.println(statuCode);
        System.out.println(boddy);


    }


}
