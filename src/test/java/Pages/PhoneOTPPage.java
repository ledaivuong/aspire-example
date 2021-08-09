package Pages;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PhoneOTPPage extends BasePage {

	private static PhoneOTPPage instancePhoneOTPPage;

	private PhoneOTPPage(WebDriver driver) {
		super(driver);
	}

	public static PhoneOTPPage getInstance(WebDriver driver) {
		if (instancePhoneOTPPage == null)
			instancePhoneOTPPage = new PhoneOTPPage(driver);
		return instancePhoneOTPPage;
	}

	WebDriver driver;

	public String urlString = "register/verify-otp";
	public String titlePage = "Login to Aspire | Aspire";
	public String headerText = "Enter phone OTP";
	public String contentText = "We have sent a one-time password (OTP) via SMS to your mobile number";
	public By inputOTPItem = By.xpath("//div[@class='digit-input aspire-field']");
	public By inputOTP = By.xpath("//div[contains(@class,'digit-input__input--highlight')]");

	public PhoneOTPPage sendKeyToInputOTP(String value) throws Exception {
		String otpPattern = "^[0-9]{4}$";
		if (!Pattern.matches(otpPattern, value))
			throw new Exception("The OTP should be 4 digit");
		Thread.sleep(3000);
		for (int i = 0; i < value.length(); i++) {
			sendKeyTo(inputOTP, String.valueOf(value.charAt(i)));

		}
		return this;
	}

}
