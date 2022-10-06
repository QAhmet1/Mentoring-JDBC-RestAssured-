package _RestAssured;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CitizenshipTest {

    Cookies cookies;

   @BeforeClass

    public void login() {
        baseURI = "https://demo.mersys.io";
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", "richfield.edu");
        credentials.put("password", "Richfield2020!");
        credentials.put("rememberMe", "true");

       cookies= given()
                .body(credentials)
                .contentType(ContentType.JSON)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                //.log().body()
               .extract().response().getDetailedCookies()
        ;
       System.out.println("cookies = " + cookies);
    }

    public String getRandom(int value){
       return RandomStringUtils.randomAlphabetic(value);

    }

    String name=getRandom(8);
   String shortName=getRandom(4);
   String citizenShipId;

    @Test
    public void createCitizenship(){
       Citizenship citizenship=new Citizenship(name,shortName);

       citizenShipId= given()
               .cookies(cookies)
               .body(citizenship)
               .contentType(ContentType.JSON)

                .when()
               .post("/school-service/api/citizenships")

                .then()
               .statusCode(201)
               .log().body()
               .body("name",equalTo(name))
               .extract().jsonPath().getString("id")
        ;
        System.out.println("name manual = " + name);
    }


}
