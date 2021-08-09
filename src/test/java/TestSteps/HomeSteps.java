package TestSteps;

import org.openqa.selenium.WebDriver;

import Pages.HomePage;

public class HomeSteps extends BaseStep {

	WebDriver driver;
	HomePage homePage;

	private static HomeSteps instanceHomeSteps;

	private HomeSteps(WebDriver driver) {
		this.driver = driver;
		homePage = HomePage.getInstance(this.driver);
	}

	public static HomeSteps getInstance(WebDriver driver) {
		if (instanceHomeSteps == null)
			instanceHomeSteps = new HomeSteps(driver);
		return instanceHomeSteps;
	}

	public HomeSteps verifyPageDisplay() {
		homePage.waitForLoadingSpinnerDisappear();
		String currentUrlString = this.driver.getCurrentUrl();
		homePage.waitUrl(HomePage.BASE_URL, currentUrlString);
		homePage.waitForPageTitle(homePage.titlePage);
		homePage.waitForTextPresence(homePage.headerText);
		homePage.waitForTextPresence(homePage.contentText);
		return this;
	}

	public HomeSteps goToTestSite() {
		homePage.goToTestSite();
		return this;
	}

	public HomeSteps goToRegistrationPage() {
		homePage.clickOnRegisterLink();
		return this;
	}
}
