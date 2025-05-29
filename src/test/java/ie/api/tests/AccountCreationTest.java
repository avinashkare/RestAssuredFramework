
package ie.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ie.api.base.AuthService;
import ie.api.models.request.SignUpRequest;
import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description = "Verify if Account creation functionality is working")
	public void loginTest() {

		SignUpRequest signUpRequest = new SignUpRequest.Builder().username("john2007").email("john@gmail.com")
				.password("john2007").firstName("John").lastName("Test").mobileNumber("8080808080").build();
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);

		System.out.println(response.asPrettyString());
		//Assert.assertEquals(response.toString(), "");
	}
}
