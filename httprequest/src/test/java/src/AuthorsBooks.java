package src;

import static io.restassured.RestAssured.*;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.response.Response;

public class AuthorsBooks {

    public static void main(String[] args) {
        AuthorsBooks ab = new AuthorsBooks();
        ab.getTitleActivity();
    }

    public void getTitleActivity(){
       Response res = given()
        .contentType("application/json")
        .when()
        .get("https://fakerestapi.azurewebsites.net/api/v1/Activities");
        //     String activity = res.jsonPath().getString("[11].id");
        //     if(activity != null){
        //         System.out.println(activity);
        //      //   Assert.assertEquals(activity, "2025-01-31T06:07:19.5428713+00:00");
        //     } 
           
        // else {
        //     System.out.println("Not enough data in the response.");
        // }

        JSONArray activitiesArray = new JSONArray(res.getBody().asString());

        // Loop through the array and print each activity's title
        for (int i = 0; i < activitiesArray.length(); i++) {
            JSONObject activity = activitiesArray.getJSONObject(i);  // Get each activity object
            String title = activity.getString("title");  // Get the title of the activity
            System.out.println("Activity Title: " + title);
            
        }

    }
}
