package RegressionTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TestSteps.CompletedStep;
import TestSteps.HomeSteps;
import TestSteps.PhoneOTPStep;
import TestSteps.RegisterStep;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	HomeSteps homeSteps;
	RegisterStep registerStep;
	PhoneOTPStep phoneOTPStep;
	CompletedStep completedStep;

	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		homeSteps = HomeSteps.getInstance(driver);
		registerStep = RegisterStep.getInstance(driver);
		phoneOTPStep = PhoneOTPStep.getInstance(driver);
		completedStep = CompletedStep.getInstance(driver);

		homeSteps.goToTestSite();
	}

	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}

}
