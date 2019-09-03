package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.LogInPage;

import org.testng.annotations.AfterSuite;

public class TestSetup {
	
	private static String url = "https://qa-sandbox.apps.htec.rs/login";
	private static WebDriver driver;
	private static String driverPath = "C:\\Users\\Uros\\eclipse-workspace\\sandbox\\src\\test\\java\\drivers\\chromedriver.exe";
	
	public WebDriver getDriver() {
		return driver;
	}
	
	private static WebDriver initChromeDriver() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
		
	
	@BeforeSuite
	public void initTestSetup() {
		try {
			initChromeDriver();
		} catch (Exception e) {
			System.out.println("Test setup failed");
		}
	}
	
	@BeforeTest
	public void fillLogInFormWithExistingUserData() {
		LogInPage logInPage = new LogInPage(driver);
		try {
			logInPage.logInAsRegisteredUser(BasePage.email, BasePage.password);
		} catch (Exception e) {
			System.out.println("Log in form not filled correctly");
		}
	}
	
//	@AfterSuite
//	public void terminateDriver() {
//		if(driver != null) {
//			driver.close();
//			driver.quit();
//		}
//	}
}
