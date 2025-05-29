package ie.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ie.api.base.AuthService;
import ie.api.models.request.LoginRequest;
import ie.api.models.response.LoginResponse;
import io.restassured.response.Response;

@Listeners(ie.api.listeners.TestListeners.class)
public class LoginTest {
	
	@Test(description = "Verify if login functionality is working")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("john2007", "john2007");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
	}

}
