package src.test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;
import src.endpoints.UserEndPoints;
import src.payload.User;



public class UserTest {

    Faker faker;
    User userPayload;

    public void setupData() {
        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5, 10));  // Corrected
        userPayload.setPhone(faker.phoneNumber().cellPhone());     // Corrected
    }

    public void testPostUser() {
        Response response = UserEndPoints.createUser(userPayload);  // Passing correct payload
        response.then()
                .statusCode(200)  // Change 201 to 200, as PetStore API typically returns 200 for successful creation
                .log().all();
    }

    public void testGetUser() {
        Response response = UserEndPoints.getUser(this.userPayload.getUsername());  // Fixed missing parentheses
        response.then()
                .statusCode(200)
                .log().all();
    }

    public void testUserUpdateByName(){
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        Response response = UserEndPoints.updateUser( this.userPayload.getUsername(), userPayload);
        response.then()
        .statusCode(200)
        .log().body();

        Response responseAfterUpdate = UserEndPoints.getUser(this.userPayload.getUsername());  // Fixed missing parentheses
        responseAfterUpdate.then()
                .statusCode(200)
                .log().all();
        }

    public static void main(String[] args) {
        UserTest ut = new UserTest();
        ut.setupData();     // Ensure you setup data before making API calls
        ut.testPostUser();
        ut.testGetUser();
    }
}