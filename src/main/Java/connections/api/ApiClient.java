package connections.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {

    private final String baseUri;

    public ApiClient() {
        // Pega a URL centralizada de acordo com o ambiente (DEV/HML)
        this.baseUri = System.getProperty("api.url");
    }

    public Response post(String endpoint, Object body) {
        return RestAssured.given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract().response();
    }

    public Response get(String endpoint) {
        return RestAssured.given()
                .baseUri(baseUri)
                .when()
                .get(endpoint);
    }
}