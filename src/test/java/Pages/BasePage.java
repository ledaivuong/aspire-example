package Pages;

import static org.testng.Assert.assertEquals;

import java.text.MessageFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	WebDriverWait wait;
	public static String BASE_URL = "https://feature-qa-automation.customer-frontend.staging.aspireapp.com/sg/";
	private static final int TIME_OUT = 15;
	public String titlePage;

	protected BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIME_OUT);
	}

	public void waitForTextPresence(String textValue) {
		By byXpath = By.xpath(MessageFormat.format("//*[contains(text(),\"{0}\")]", textValue));
		wait.until(ExpectedConditions.presenceOfElementLocated(byXpath));
	}

	public void sendKeyTo(By by, String stringKey) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(stringKey);

	}

	public void setTextContentJavaScriptTo(By by, String textValue) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].textContent = [1];",
				wait.until(ExpectedConditions.elementToBeClickable(by)), textValue);
	}

	public void clickOn(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void javaScriptClickOn(By by) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(by)));
	}

	public boolean isDisplayed(By by) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch (NoSuchElementException
				| StaleElementReferenceException
				| TimeoutException e) {
			return false;
		}
	}

	public void goToTestSite() {
		driver.get(BASE_URL);
	}

	public void waitUrl(String expectedUrl, String ActualUrl) {
		int flag = 0;
		while (flag < TIME_OUT) {
			try {
				assertEquals(expectedUrl, ActualUrl);
				break;
			} catch (AssertionError e) {
				flag++;
			}
		}

	}

	public void waitForPageTitle(String value) {
		wait.until(ExpectedConditions.titleContains(value));
	}

	public void waitForLoadingSpinnerDisappear() {
		WebElement spinner;
		try {
			spinner = By.xpath("//div[contains(@class,'q-inner-loading')]").findElement(driver);
			WebDriverWait waitSpinner = new WebDriverWait(driver, 1);
			waitSpinner.until(ExpectedConditions.visibilityOf(spinner));
			this.wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(spinner)));
		} catch (NoSuchElementException
				| StaleElementReferenceException
				| TimeoutException e) {
			return;
		}
	}

}
