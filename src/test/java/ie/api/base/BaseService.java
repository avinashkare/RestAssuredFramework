package ie.api.base;

import ie.api.filters.LoggingFilter;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification reqSpec;
	
	static {
		RestAssured.filters(new LoggingFilter());
	}

	public BaseService() {
		reqSpec = given().baseUri(BASE_URL);
	}

	protected void setAuthToke(String token) {
		reqSpec.header("Authorization", "Bearer " + token);
	}

	protected Response postRequest(Object payload, String endPoint) {
		return reqSpec.contentType(ContentType.JSON).body(payload).post(endPoint);
	}

	protected Response getRequest(String endPoint) {
		return reqSpec.get(endPoint);
	}
	
	protected Response putRequest(Object payload, String endPoint) {
		return reqSpec.contentType(ContentType.JSON).body(payload).put(endPoint);
	}

}
