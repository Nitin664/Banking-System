package src;

import static io.restassured.RestAssured.*;

import java.util.Map;

import io.restassured.response.Response;

public class CookiesHandle {

    public static void main(String[] args) {
        CookiesHandle ch = new CookiesHandle();
        ch.getCookiesHan();
    }

    public void getCookiesHan(){
       Response res = given()
        .when()
        .get("https://www.google.com/");
        // String cookies_Value  = res.getCookie("AEC");
        // System.out.println("Value of the Cookies >>>>>>>>>"+cookies_Value);
        Map<String,String> cookies_Values = res.getCookies();
        for(String map : cookies_Values.keySet()){
            System.out.println(map);
            String cookie_Value = res.getCookie(map);
           System.out.println(map +"       " + cookie_Value);
        }
    }
}
