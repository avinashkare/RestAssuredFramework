
package ie.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ie.api.base.AuthService;
import io.restassured.response.Response;
import utils.Utils;

public class ForgotPasswordTest {

	@Test(description = "Verify if forgot password functionality is working")
	public void forgotPasswordTest() {

		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("pen.killer77@gmail.com");

		Utils utils = new Utils();
		Assert.assertEquals(utils.getJsonPath(response, "message"), "If your email exists in our system, you will receive reset instructions.");
	}

}
