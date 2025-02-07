package src;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;



public class Firstrequest {
    int id;
     public static void main(String[] args) {
        Firstrequest fis = new Firstrequest();
        fis.getUser();
        fis.createUser();
        fis.updateUser();
     }
        public void getUser(){
            given()
            .when()
            .get("https://reqres.in/api/users?page=2")
            .then()
            .statusCode(200)
            .body("page", equalTo(2))
            .log().all();
        }

        public void createUser(){

            HashMap<String,String> map = new HashMap<>();
            map.put("name", "Nitin");
            map.put("job", "Soft Engg");
           id = given()
            .contentType("application/json")
            .body(map)
            .when()
            .post("https://reqres.in/api/users")
            .jsonPath().getInt("id");
            System.out.println("User Id is :" + id);
            // .then()
            // .statusCode(201)
            // .log().all();
        }

        public void updateUser() {
            // Create a HashMap to send as JSON body
            HashMap<String, String> map = new HashMap<>();
            map.put("name", "Ram");
            map.put("job", "Testing");
    
            // Ensure the URL has a '/' before the id
            given()
                .contentType("application/json")
                .body(map) // Pass the HashMap as the body
            .when()
                .put("https://reqres.in/api/users/" + id) // Add '/' before the id
            .then()
                .statusCode(200) // Expecting status code 200 for successful update
                .log().all(); // Log the response to see the updated details
        }
    }
    

