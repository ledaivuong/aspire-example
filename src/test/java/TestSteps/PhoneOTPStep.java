package TestSteps;

import org.openqa.selenium.WebDriver;

import Pages.HomePage;
import Pages.PhoneOTPPage;

public class PhoneOTPStep extends BaseStep {

	WebDriver driver;
	PhoneOTPPage phoneOTPPage;

	private static PhoneOTPStep instancePhoneOTPStep;

	private PhoneOTPStep(WebDriver driver) {
		this.driver = driver;
		phoneOTPPage = PhoneOTPPage.getInstance(this.driver);
	}

	public static PhoneOTPStep getInstance(WebDriver driver) {
		if (instancePhoneOTPStep == null)
			instancePhoneOTPStep = new PhoneOTPStep(driver);
		return instancePhoneOTPStep;
	}

	public PhoneOTPStep verifyPageDisplay() {
		phoneOTPPage.waitForLoadingSpinnerDisappear();
		String currentUrlString = this.driver.getCurrentUrl();
		phoneOTPPage.waitUrl(HomePage.BASE_URL + phoneOTPPage.urlString, currentUrlString);
		phoneOTPPage.waitForPageTitle(phoneOTPPage.titlePage);
		phoneOTPPage.waitForTextPresence(phoneOTPPage.headerText);
		phoneOTPPage.waitForTextPresence(phoneOTPPage.contentText);
		return this;
	}

	public PhoneOTPStep verifyPhoneOTP(String value) {
		try {
			phoneOTPPage.sendKeyToInputOTP(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

}
