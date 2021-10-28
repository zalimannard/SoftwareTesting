import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class JSON {

    public static void main(String[] args) {
        ABOBA();
    }

    public static void ABOBA() {
        JsonPath jsonPath = given().baseUri("http://kpfu.ru").when().get("/cookies").then().extract().jsonPath();
        System.out.println(jsonPath);
    }
}
