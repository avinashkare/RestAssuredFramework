package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utils {
	
	public String getJsonPath(Response response, String key) {
		String res = response.asString();
		JsonPath jp = new JsonPath(res);
		return jp.get(key).toString();
	}

}
