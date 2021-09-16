package PastbookTestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PastbookPages.EnterEmailPage;
import PastbookPages.EnterPasswordPage;
import PastbookPages.LandingPage;
import Utility.ReadExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginNLogout {
	
	WebDriver driver;

	LandingPage LanPg;
	EnterEmailPage EmailPg;
	EnterPasswordPage PasswdPg;

	@BeforeTest
	public void setup() throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://moments.pastbook.com/");
		driver.get(ReadExcel.readExcel(1, 0, ".\\Data\\PastBookData.xlsx", "Sheet1"));
		
		driver.manage().window().maximize();
	}
	
	@Test(priority = 0)
	public void test_LoginNLogout() throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException {

		// create login page object
		LanPg = new LandingPage(driver);
		
		// verify the landing page
		//Assert.assertTrue(LanPg.getTitle().toLowerCase().contains("Create beautiful photo albums, " + "\n" + "together with your friends. "));

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Click SignIn
		LanPg.redirectToSignIn();
		//LanPg.redirectToSignInFromLeftMenu();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Handling second window
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//driver.manage().window().maximize();

		EmailPg = new EnterEmailPage(driver);

		EmailPg.redirectToEnterEmail();

		// perform the actions on new window enter email
		//EmailPg.navigateToEnterEmail("sdsmadara@gmail.com");
		EmailPg.navigateToEnterEmail(ReadExcel.readExcel(1, 1, ".\\Data\\PastBookData.xlsx", "Sheet1"));
		EmailPg.navigateToCreatePastbookPage();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		PasswdPg = new EnterPasswordPage(driver);		
		// Enter password
		//PasswdPg.navigateToEnterPassword("IrKizINq");
		PasswdPg.navigateToEnterPassword(ReadExcel.readExcel(1, 2, ".\\Data\\PastBookData.xlsx", "Sheet1"));
		PasswdPg.navigateToCreatePastbookPage();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Close second window and switch to first
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		
		//SignOut from left menu
		LanPg.signOutfromPastbook();
		
		//driver.quit();
	}

}
