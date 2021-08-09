package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	private static HomePage instanceHomePage;

	private HomePage(WebDriver driver) {
		super(driver);
	}

	public static HomePage getInstance(WebDriver driver) {
		if (instanceHomePage == null)
			instanceHomePage = new HomePage(driver);
		return instanceHomePage;
	}

	WebDriver driver;

	public String titlePage = "Login to Aspire | Aspire";
	public String headerText = "Login to Aspire";
	public String contentText = "Please enter the required credentials to continue";
	public By registerLink = By.xpath("//div[@class='auth-form__buttons']//a");

	public void clickOnRegisterLink() {
		javaScriptClickOn(registerLink);
	}

}
