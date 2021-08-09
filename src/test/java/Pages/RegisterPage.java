package Pages;

import java.text.MessageFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

	private static RegisterPage instancePage;

	private RegisterPage(WebDriver driver) {
		super(driver);
	}

	public static RegisterPage getInstance(WebDriver driver) {
		if (instancePage == null)
			instancePage = new RegisterPage(driver);
		return instancePage;
	}

	WebDriver driver;

	public String urlString = "register";
	public String titlePage = "Let's get started | Aspire";
	public String headerText = "Let\'s get started";
	public String contentText = "We are excited to have you here. To get started, please enter your name, email and mobile number.";
	public By fullNameTextBox = By.xpath("//input[@name='full_name']");
	public By emailTextBox = By.xpath("//input[@name='email']");
	public By phoneTextBox = By.xpath("//input[@name='phone']");
	public By heardAboutSelectBox = By.xpath("//input[@data-cy='register-person-heard-about']");
	public String heardAboutSelectItemString = "//div[@class=''q-virtual-scroll__content'']/div[.=''{0}'']";
	public By referralTextBox = By.xpath("//input[@data-cy='register-person-referral-code']");
	public By agreeCheckbox = By.xpath("//div[contains(@class, 'q-checkbox__bg')]");
	public By continueButton = By.xpath("//button");

	public RegisterPage sendKeyToFullNameTextBox(String value) {
		sendKeyTo(fullNameTextBox, value);
		return this;
	}

	public RegisterPage sendKeyToEmailTextBox(String value) {
		sendKeyTo(emailTextBox, value);
		return this;
	}

	public RegisterPage sendKeyToPhoneTextBox(String value) {
		sendKeyTo(phoneTextBox, value);
		return this;
	}

	public RegisterPage selectHeardAboutItem(String value) {
		clickOn(heardAboutSelectBox);
		By heardAboutSelectItem = By.xpath(MessageFormat.format(heardAboutSelectItemString, value));
		clickOn(heardAboutSelectItem);
		return this;
	}

	public RegisterPage sendKeyToReferralTextBox(String value) {
		sendKeyTo(referralTextBox, value);
		return this;
	}

	public RegisterPage clickOnAgreeCheckBox() {
		clickOn(agreeCheckbox);
		return this;
	}

	public RegisterPage clickOnCotinueButton() {
		clickOn(continueButton);
		return this;
	}

}
