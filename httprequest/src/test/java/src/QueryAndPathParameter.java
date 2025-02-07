package src;

import static io.restassured.RestAssured.*;

public class QueryAndPathParameter {

    public static void main(String[] args) {
        QueryAndPathParameter qrp = new QueryAndPathParameter();
        qrp.queryPathParm();
    }

    public void queryPathParm(){
        given()
        .pathParam("myPath", "users")
        .queryParam("page", 2)
        .when()
        .get("https://reqres.in/api/{myPath}")
        .then()
        .statusCode(200)
        .header("", "")
        .header("", "");
        
    }
}
