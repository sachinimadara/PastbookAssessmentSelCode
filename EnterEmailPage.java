package PastbookPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterEmailPage {

	WebDriver driver;

	public EnterEmailPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	By WindowTitle = By.xpath("//Title");
	By ClickEmailOption = By.xpath("//div[@class='container']/div/div/div[2]/a");
	By EnterEmail = By.name("email");
	By ClickArrow = By.xpath("//span/button/i");
	By Submit = By.xpath("//button");

	// Verify page
	public String getTitle() {
		return driver.findElement(WindowTitle).getText();
	}

	// methods to identify the fields
	public void clickOnEmail() {
		driver.findElement(ClickEmailOption).click();
	}

	public void enterEmail(String setEmail) {
		driver.findElement(EnterEmail).sendKeys(setEmail);
	}
	
	public void clickOnArrow() {
		driver.findElement(ClickArrow).click();
	}

	// POM method to expose in testcase
	public void redirectToEnterEmail() {
		this.clickOnEmail();
	}

	public void navigateToEnterEmail(String setEmail) {
		this.enterEmail(setEmail);
	}

	public void navigateToCreatePastbookPage() {
		this.clickOnArrow();
	}
}
