package src;

import static io.restassured.RestAssured.*;



public class HeaderVerify {
    public static void main(String[] args) {
        HeaderVerify hv = new HeaderVerify();
        hv.headCheck();
    }

    public void headCheck(){
       given()
        .when()
        .get("https://www.google.com/")
      //  String header = res.getHeader("Content-Type");
     //   System.out.println("header is >>>>>>>>" +header);

            // Headers headers =  res.getHeaders();
            // for(Header hd : headers){
            //     System.out.println(hd.getName() + "===="+hd.getValue());

            .then()
            .log().body().toString();
            }


        
    }


