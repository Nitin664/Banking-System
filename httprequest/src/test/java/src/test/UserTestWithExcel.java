package src.test;

import static org.hamcrest.Matchers.*;


import io.restassured.response.Response;
import src.endpoints.UserEndPoints;
import src.payload.User;

public class UserTestWithExcel {
    public void testPostUser(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus) {
        
        User userPayload = new User();
        userPayload.setId(id);
        userPayload.setUsername(username);
        userPayload.setFirstName(firstName);
        userPayload.setLastName(lastName);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhone(phone);
        userPayload.setUserStatus(userStatus);

        Response response = UserEndPoints.createUser(userPayload);
        response.then()
                .statusCode(200)
                .body("message", equalTo(String.valueOf(id)))  // Verify ID matches in response
                .log().all();
    }
}
