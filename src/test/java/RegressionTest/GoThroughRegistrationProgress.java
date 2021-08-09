package RegressionTest;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Models.Customer;
import Utils.JsonHandler;

public class GoThroughRegistrationProgress extends BaseTest {

	Customer dataCustomerTest;

	@BeforeTest
	public void setup() {
		super.setup();

		// Setup data
		String dataId = "customer1";
		try {
			dataCustomerTest = JsonHandler.getJsonDataCustomer(dataId);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@AfterTest
	public void tearDown() {
		super.tearDown();
	}

	@Test
	public void simpleTest() {
		homeSteps.verifyPageDisplay().goToRegistrationPage();
		registerStep.verifyPageDisplay().completeRegisterInformation(dataCustomerTest);
		phoneOTPStep.verifyPageDisplay().verifyPhoneOTP("1234");
		completedStep.verifyPageDisplay().goToRolePage();
	}

}
