package ie.api.tests;

import org.testng.annotations.Test;

import ie.api.base.AuthService;
import ie.api.base.UserManagementService;
import ie.api.models.request.LoginRequest;
import ie.api.models.response.LoginResponse;
import ie.api.models.response.UserProfileResponse;
import io.restassured.response.Response;

public class ProfileRequestTest {

	@Test(description = "Check if Profile API functionality works fine")
	public void profileRequestTest() {

		LoginRequest loginRequest = new LoginRequest("john2007", "john2007");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		String token = loginResponse.getToken();

		UserManagementService userManagementService = new UserManagementService();
		UserProfileResponse userProfileResponse = userManagementService.getProfile(token).as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getFirstName());
	}

}
