package src;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import io.restassured.http.ContentType;

public class Authorization {

    public static void main(String[] args) {
        Authorization ba = new Authorization();
        ba.basicAuth();
        ba.digestAuth();
        ba.bearerToken();
    }

    public void basicAuth() {
        given()
                .auth().basic("postman", "password")
                .when()
                .get("http://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();

    }

    public void digestAuth() {
        given()
                .auth().preemptive().basic("postman", "password")
                .when()
                .get("http://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    }

    public void bearerToken() {
        JSONObject data = new JSONObject();
        data.put("name", "Nitin");
        data.put("location", "America");
        data.put("phone", "8769546");
        String authToken = "Bearer c16222e3829986cb019457496f9fb169d270462f821fe871cee300365fbec40e";
        given()
                .headers("Authorization", authToken)
                .contentType(ContentType.JSON)
                .body(data.toString())
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(201)
                .log().all();
    }
}
