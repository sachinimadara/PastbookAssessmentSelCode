package PastbookPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreatePastbookPage {
	
	WebDriver driver;

	public CreatePastbookPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	By CreatePastbookPgTitle = By.xpath("//div/h1");
	By PastbookTitle = By.name("title");
	By PastbookSubmit = By.id("create-button");
	By AddPictures = By.xpath("//div[@class='container']/a");
	By SelectFiles = By.xpath("//div[@title='My Device']/span[1]");
	By SelectFilesToUpload = By.xpath("//div[@class='fsp-modal__body']/div[2]/div/div/div/div[1]");
	

	// methods to identify the title
	public String getTitle() {
		return driver.findElement(CreatePastbookPgTitle).getText();
	}

	public void enterTitle(String setTitle) {
		driver.findElement(PastbookTitle).sendKeys(setTitle);
	}
	
	public void clickSubmit() {
		driver.findElement(PastbookSubmit).click();
	}
	
	public void addPictures() {
		driver.findElement(AddPictures).click();
	}
	
	public void selectFiles() {
		driver.findElement(SelectFiles).click();
	}
	
	public void SelectFilesToUpload() {
		driver.findElement(SelectFilesToUpload).click();
	}
	
	// POM method to expose in testcase
	public void createMyPastbook(String setTitle) {
		this.enterTitle(setTitle);
		this.clickSubmit();
	}
	
	public void addPicturesToPastbook() {
		this.addPictures();
	}
	
	public void selectFilesToUpload() {
		this.selectFiles();
		this.SelectFilesToUpload();
	}
	
}
