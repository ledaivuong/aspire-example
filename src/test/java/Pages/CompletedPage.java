package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletedPage extends BasePage {

	private static CompletedPage instanceCompletedPage;

	private CompletedPage(WebDriver driver) {
		super(driver);
	}

	public static CompletedPage getInstance(WebDriver driver) {
		if (instanceCompletedPage == null)
			instanceCompletedPage = new CompletedPage(driver);
		return instanceCompletedPage;
	}

	WebDriver driver;

	public String urlString = "register/completed";
	public String titlePage = "Login to Aspire | Aspire";
	public String headerText = "Wohoo!";
	public String contentText = "You have successfully verified your mobile number. You’re on to a great start!";
	public By continueButton = By.xpath("//button");

	public CompletedPage clickOnContinueButton() {
		clickOn(continueButton);
		return this;
	}

}
