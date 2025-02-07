package src;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ThirdRequest {
    public static void main(String[] args) {
        ThirdRequest tr = new ThirdRequest();
        tr.addUserDetails();
    }

    public void addUserDetails(){
        POJO data = new POJO();
        data.setName("john");
        data.setLocation("Pune");
        data.setPhone("98764673834");
        String[] courses = {"C","C++"};
        data.setCourses(courses);

        given()
        .contentType("application/json")
        .body(data)
        .when()
        .post("https://reqres.in/api/users")
        .then()
        .statusCode(201).statusCode(201)
        .log().body()  // Log the response body to see what it contains
        .body("name", equalTo("John"))
        .body("location", equalTo("Pune"))
        .body("Courses[0]", equalTo("C"))
        .body("Courses[1]", equalTo("C++"))
        .log().all();

    }
}
