package src;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class SecondRequest {
    public static void main(String[] args) {
        SecondRequest sd = new SecondRequest();
        sd.newUserDetails();
    }
    public void newUserDetails(){
      //  HashMap<String,Object> data = new HashMap<>();
      JSONObject data = new JSONObject();
      data.put("name", "Ram");
      data.put("location", "Gurugram");
      data.put("phone", "78997665");
  
      String courseArr[] = {"C", "C++", "Python"};
      data.put("Courses", courseArr);
  
      given()
          .contentType("application/json")
          .body(data.toString())
      .when()
          .post("https://reqres.in/api/users")
      .then()
          .statusCode(201)
          .log().body()  // Log the response body to see what it contains
          .body("name", equalTo("Ram"))
          .body("location", equalTo("Gurugram"))
          .body("Courses[0]", equalTo("C"))
          .body("Courses[1]", equalTo("C++"))
          .body("Courses[2]", equalTo("Python"))
          .log().all();
  }
   
    public void deleteUser(){
        given()
        .when()
        .delete("")
        .then()
        .statusCode(204);
    }

    
}
