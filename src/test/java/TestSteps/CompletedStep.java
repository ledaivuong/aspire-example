package TestSteps;

import org.openqa.selenium.WebDriver;

import Pages.CompletedPage;
import Pages.HomePage;

public class CompletedStep extends BaseStep {

	WebDriver driver;
	CompletedPage completedPage;

	private static CompletedStep instanceCompletedStep;

	private CompletedStep(WebDriver driver) {
		this.driver = driver;
		completedPage = CompletedPage.getInstance(this.driver);
	}

	public static CompletedStep getInstance(WebDriver driver) {
		if (instanceCompletedStep == null)
			instanceCompletedStep = new CompletedStep(driver);
		return instanceCompletedStep;
	}

	public CompletedStep verifyPageDisplay() {
		completedPage.waitForLoadingSpinnerDisappear();
		String currentUrlString = this.driver.getCurrentUrl();
		completedPage.waitUrl(HomePage.BASE_URL + completedPage.urlString, currentUrlString);
		completedPage.waitForPageTitle(completedPage.titlePage);
		completedPage.waitForTextPresence(completedPage.headerText);
		completedPage.waitForTextPresence(completedPage.contentText);
		return this;
	}

	public CompletedStep goToRolePage() {
		completedPage.clickOnContinueButton();
		return this;
	}

}
