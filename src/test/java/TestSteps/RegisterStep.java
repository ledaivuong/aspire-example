package TestSteps;

import org.openqa.selenium.WebDriver;

import Models.Customer;
import Pages.HomePage;
import Pages.RegisterPage;

public class RegisterStep extends BaseStep {
	WebDriver driver;
	RegisterPage registerPage;

	private static RegisterStep instanceRegisterStep;

	private RegisterStep(WebDriver driver) {
		this.driver = driver;
		registerPage = RegisterPage.getInstance(this.driver);
	}

	public static RegisterStep getInstance(WebDriver driver) {
		if (instanceRegisterStep == null)
			instanceRegisterStep = new RegisterStep(driver);
		return instanceRegisterStep;
	}

	public RegisterStep verifyPageDisplay() {
		registerPage.waitForLoadingSpinnerDisappear();
		String currentUrlString = this.driver.getCurrentUrl();
		registerPage.waitUrl(HomePage.BASE_URL + registerPage.urlString, currentUrlString);
		registerPage.waitForPageTitle(registerPage.titlePage);
		registerPage.waitForTextPresence(registerPage.headerText);
		registerPage.waitForTextPresence(registerPage.contentText);
		return this;
	}

	public void completeRegisterInformation(String fullName, String email, String phone, String hearAbout,
			String referral) {
		if (fullName == null)
			fullName = "";
		if (email == null)
			email = "";
		if (phone == null)
			phone = "";
		if (hearAbout == null)
			hearAbout = "";
		if (referral == null)
			referral = "";
		registerPage
				.sendKeyToFullNameTextBox(fullName)
				.sendKeyToEmailTextBox(email)
				.sendKeyToPhoneTextBox(phone)
				.selectHeardAboutItem(hearAbout)
				.clickOnAgreeCheckBox()
				.clickOnCotinueButton();
	}

	public void completeRegisterInformation(Customer customer) {
		completeRegisterInformation(customer.getFullName(), customer.getEmail(), customer.getPhone(),
				customer.getHearAbout(), customer.getReferral());
	}
}
