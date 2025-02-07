package src;

import static io.restassured.RestAssured.*;

import java.io.File;

public class FileUploadDemo{
    public static void main(String[] args) {
        FileUploadDemo fd = new FileUploadDemo();
        fd.uploadFile();
    }

    public void uploadFile(){
        File fileUpload = new File("C:\\Users\\nit4\\Desktop\\demo.txt");
        given()
        .multiPart(fileUpload)
        .contentType("multipart/form-data")
        .when()
        .post("https://httpbin.org/post")
        .then()
        .statusCode(200)
        
        .log().all();
         
    }
}
