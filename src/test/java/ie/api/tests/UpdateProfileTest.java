package ie.api.tests;

import org.testng.annotations.Test;

import ie.api.base.AuthService;
import ie.api.base.UserManagementService;
import ie.api.models.request.LoginRequest;
import ie.api.models.request.ProfileRequest;
import ie.api.models.response.LoginResponse;
import ie.api.models.response.UserProfileResponse;
import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test(description = "Check if Update Profile API functionality works fine")
	public void profileRequestTest() {

		LoginRequest loginRequest = new LoginRequest("john2007", "john2007");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		String token = loginResponse.getToken();

		ProfileRequest profileRequest = new ProfileRequest.Builder().firstName("Test").lastName("Test").email("john2007").mobileNumber("9876543210").build();
		UserManagementService userManagementService = new UserManagementService();
		UserProfileResponse userProfileResponse = userManagementService.getProfile(token).as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getFirstName());
		Response updateProfileResponse = userManagementService.updateProfile(token, profileRequest);
		System.out.println(updateProfileResponse.asPrettyString());

	}

}
