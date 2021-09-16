package PastbookPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	By LandingTitle = By.xpath("//div[@class='main']/div/h1");
	By LandingSignIn = By.xpath("//span[@class='hidden-xs'][contains(text(),'Sign in')]");
	By HamburgerMenu = By.xpath("//span[@class='icon-hamburger-animated']");
	By LeftMenuSignin = By.className("icon-user");//a[@class='icon-user']
	By LeftMenuSignout = By.xpath("//a[contains(text(),'Sign out')]");
	By LeftCreateBookMenu = By.xpath("//div[@id='sidemenu']/div/a[2]");
	By CreateBookFromScratch = By.xpath("//div[@id='sidemenu']/div/div/a[1]/span[@class='glyphicon glyphicon-edit']");

	// methods to identify the title
	public String getTitle() {
		return driver.findElement(LandingTitle).getText();
	}

	public void clickSignIn() {
		driver.findElement(LandingSignIn).click();
	}
	
	//Left Hamburger menu SignIn option
	public void clickHamburgerMenuIcon() {
		driver.findElement(HamburgerMenu).click();
	}
	
	public void clickLeftMenuSignIn() {
		driver.findElement(LeftMenuSignin).click();
	}
	
	public void clickLeftMenuCreateBook() {
		driver.findElement(LeftCreateBookMenu).click();
	}
	
	public void clickCreateBookFromScratch() {
		driver.findElement(CreateBookFromScratch).click();
	}

	public void clickLeftMenuSignOut() {
		driver.findElement(LeftMenuSignout).click();
	}
	
	// POM method to expose in testcase
	public void redirectToSignIn() {
		this.clickSignIn();
	}
	
	//Sign in from Left menu ..i saw this later. Used this method in SignIn TC not above :D 
	public void redirectToSignInFromLeftMenu() {
		this.clickHamburgerMenuIcon();
		this.clickLeftMenuSignIn();
	}
	
	///create pastbook from scratch
	public void navigateToCreateBookPage() {
		this.clickLeftMenuCreateBook();
		this.clickCreateBookFromScratch();
	}
	
	public void signOutfromPastbook() {
		this.clickHamburgerMenuIcon();
		this.clickLeftMenuSignOut();
	}

}
