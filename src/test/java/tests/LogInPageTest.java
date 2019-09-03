package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.DashboardPage;
import setup.TestSetup;

public class LogInPageTest extends TestSetup {
	
	private static WebDriver driver;
	public static By containerXPath = DashboardPage.getContainerXPath();
	public static String dashboardUrl = DashboardPage.getDashboardUrl();
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}
	
	@Test
	public void verifyIfLogInSuccessful() throws InterruptedException {
		String expectedPageUrl = dashboardUrl;
		BasePage basePage = new BasePage(driver);
		basePage.waitForElementToAppear(containerXPath);
		Assert.assertEquals(basePage.getCurrentPageUrl(), expectedPageUrl);;
	}
	
}

