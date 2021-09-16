package PastbookPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterPasswordPage {
	
	WebDriver driver;

	public EnterPasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	By WindowTitle = By.xpath("//Title");
	By EnterPassword = By.name("password");
	By ClickArrow = By.xpath("//span/button/i");

	// Verify page
	public String getTitle() {
		return driver.findElement(WindowTitle).getText();
	}

	// methods to identify the fields
	public void enterPassword(String setPassword) {
		driver.findElement(EnterPassword).sendKeys(setPassword);
	}
	
	public void clickOnArrow() {
		driver.findElement(ClickArrow).click();
	}

	// POM method to expose in testcase
	public void navigateToEnterPassword(String setPassword) {
		this.enterPassword(setPassword);
	}

	public void navigateToCreatePastbookPage() {
		this.clickOnArrow();
	}

}
