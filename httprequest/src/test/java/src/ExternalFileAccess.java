package src;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ExternalFileAccess {

    public static void main(String[] args) {
        ExternalFileAccess efa = new ExternalFileAccess();
        efa.addingDetails();
    }

    public void addingDetails(){
        try (FileInputStream fis = new FileInputStream(".\\body.json")) {
            JSONTokener jt = new JSONTokener(fis);
            JSONObject data = new JSONObject(jt);

            given()
            .contentType("application/json")
            .body(data.toString())
            .when()
            .post("https://reqres.in/api/users")
            .then()
            .statusCode(201)
            .body("location",equalTo("Pune"))
            .body("Courses[0]", equalTo("C"))
            .body("Courses[1]", equalTo("C++"))
            .log().all();
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }
}
