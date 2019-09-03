package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.DashboardPage;
import pageObjects.PeoplePage;
import setup.TestSetup;

public class PeoplePageTest extends TestSetup {
	
	private static WebDriver driver;
	public static By alertDivXPath = PeoplePage.getInvalidDivXPath();
	public static By playgroundCardXPath = DashboardPage.getPlaygroundCardXpath();
	public static String dashboardUrl = DashboardPage.getDashboardUrl();
	public static String createPersonUrl = PeoplePage.getCreatePersonPageUrl();
	public static String peoplePageUrl = PeoplePage.getPeoplePageUrl();
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}
	
	@Test(priority=1)
	public void verifyFullNameFieldIsRequired() throws InterruptedException {
		String expectedPageUrl = createPersonUrl;
		PeoplePage peoplePage = new PeoplePage(driver);
		BasePage basePage = new BasePage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		basePage.waitForElementToAppear(playgroundCardXPath);
		dashboardPage.clickPlaygroundCard();
		Thread.sleep(400);
		peoplePage.clickPeopleMenu();
		Thread.sleep(400);
		peoplePage.clickCreatePerson();
		Thread.sleep(400);
		peoplePage.clickSubmitBtn();
		// check whether an alert appears
		basePage.waitForElementToAppear(alertDivXPath);
		Assert.assertEquals(basePage.getCurrentPageUrl(), expectedPageUrl);
	}
	
	
	@Test(priority=2)
	public void verifyFullNameCantBeShorterThan4Chars(@Optional("asd") String letters) throws InterruptedException {
		String expectedPageUrl = createPersonUrl;
		PeoplePage peoplePage = new PeoplePage(driver);
		BasePage basePage = new BasePage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		basePage.waitForElementToAppear(playgroundCardXPath);
		dashboardPage.clickPlaygroundCard();
		Thread.sleep(400);
		peoplePage.clickPeopleMenu();
		Thread.sleep(400);
		peoplePage.clickCreatePerson();
		Thread.sleep(400);
		peoplePage.clickFullNameField();
		Thread.sleep(400);
		peoplePage.inputFullNameField(letters);
		Thread.sleep(400);
		peoplePage.clickSubmitBtn();
		basePage.waitForElementToAppear(alertDivXPath);
		Assert.assertEquals(basePage.getCurrentPageUrl(), expectedPageUrl);
	}
	
	@Test(priority=3)
	public void verifyFullNameCantContainNumbers(@Optional("Uros123") String chars) throws InterruptedException {
		String expectedPageUrl = createPersonUrl;
		BasePage basePage = new BasePage(driver);
		PeoplePage peoplePage = new PeoplePage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		basePage.waitForElementToAppear(playgroundCardXPath);
		dashboardPage.clickPlaygroundCard();
		Thread.sleep(400);
		peoplePage.clickPeopleMenu();
		Thread.sleep(400);
		peoplePage.clickCreatePerson();
		Thread.sleep(400);
		peoplePage.clickFullNameField();
		Thread.sleep(400);
		peoplePage.inputFullNameField(chars);
		Thread.sleep(400);
		peoplePage.clickSubmitBtn();
		basePage.waitForElementToAppear(alertDivXPath);
		Assert.assertEquals(basePage.getCurrentPageUrl(), expectedPageUrl);
	}
	
	@Test(priority=4)
	public void verifyFullNameCanBeValidString(@Optional("Radojica") String validName) throws InterruptedException {
		String expectedPageUrl = peoplePageUrl;
		BasePage basePage = new BasePage(driver);
		PeoplePage peoplePage = new PeoplePage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		basePage.waitForElementToAppear(playgroundCardXPath);
		dashboardPage.clickPlaygroundCard();
		Thread.sleep(400);
		peoplePage.clickPeopleMenu();
		Thread.sleep(400);
		peoplePage.clickCreatePerson();
		Thread.sleep(400);
		peoplePage.clickFullNameField();
		Thread.sleep(400);
		peoplePage.inputFullNameField(validName);
		Thread.sleep(400);
		peoplePage.clickSubmitBtn();
		try {
			basePage.waitForElementToAppear(alertDivXPath);
		} catch (Exception TimeoutException) {
			System.out.println("No alert appeared");
		} finally {
			Assert.assertEquals(basePage.getCurrentPageUrl(), expectedPageUrl);
		}
	}
	
	@Test(priority=5)
	public void verifyPersonCanBeDeleted(@Optional("Radojica") String validName) throws InterruptedException {
		String expectedPageUrl = peoplePageUrl;
		BasePage basePage = new BasePage(driver);
		PeoplePage peoplePage = new PeoplePage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		basePage.waitForElementToAppear(playgroundCardXPath);
		dashboardPage.clickPlaygroundCard();
		Thread.sleep(400);
		peoplePage.clickPeopleMenu();
		Thread.sleep(400);
		basePage.findElementByLinkText(validName).click();
		Thread.sleep(400);
		peoplePage.clickTrashIcon();
		Thread.sleep(400);
		peoplePage.clickDeleteBtn();
		try {
			basePage.waitForElementToAppear(alertDivXPath);
		} catch (Exception TimeoutException) {
			System.out.println("No alert appeared on delete request");
		} finally {
			Assert.assertEquals(basePage.getCurrentPageUrl(), expectedPageUrl);
		}
	}
	
	@AfterMethod
	public void navigateToDashboard() {
		BasePage basePage = new BasePage(driver);
		if(basePage.getCurrentPageUrl() != dashboardUrl) {
			driver.get(dashboardUrl);
		}
	}
	
	

}
