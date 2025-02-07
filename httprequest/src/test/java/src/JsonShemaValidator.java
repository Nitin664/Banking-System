package src;

import static io.restassured.RestAssured.*;


import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonShemaValidator {
public static void main(String[] args) {
    JsonShemaValidator jsv = new JsonShemaValidator();
    jsv.jsonSchema();
}

public void jsonSchema(){
    given()
    .when()
    .get("https://jsonplaceholder.typicode.com/users")
    .then().assertThat()
    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("C:\\Users\\nit4\\Desktop\\httprequest\\src\\main\\resources\\demoJsonschema.json"));
}
}
