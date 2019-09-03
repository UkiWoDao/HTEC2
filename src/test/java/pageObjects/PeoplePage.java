package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PeoplePage extends BasePage {

	public PeoplePage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	private static String PEOPLE_ID = "test2";
	private static String CREATE_PERSON_LINK_TEXT = "CREATE PERSON";
	private static String FULL_NAME_XPATH = "//input[@placeholder='* Full Name']";
	private static String SUBMIT_BUTTON_XPATH = "//button[@value='Submit']";
	private static String BACK_BTN_XPATH = "//i[@class='fa fa-arrow-left']";
	private static By INVALID_ALERT_DIV_XPATH = By.xpath("//div[@class='invalid-feedback']");
	private static String PEOPLE_PAGE_URL = "https://qa-sandbox.apps.htec.rs/people";
	private static String CREATE_PERSON_PAGE_URL = "https://qa-sandbox.apps.htec.rs/create-person";
	private static String TRASH_ICON_XPATH = "//span[@class='input-group-btn delete-button']//button[@type='button']";
	private static String DELETE_BUTTON_XPATH = "//button[contains(text(),'Delete')]";
	
	public static By getInvalidDivXPath() {
		return INVALID_ALERT_DIV_XPATH;
	}	
	public static String getPeoplePageUrl() {
		return PEOPLE_PAGE_URL;
	}
	public static String getCreatePersonPageUrl() {
		return CREATE_PERSON_PAGE_URL;
	}
	
	// web elements
	private WebElement getPeopleMenu() {
		WebElement web = driver.findElement(By.id(PEOPLE_ID));
		return web;
	}	
	private WebElement getCreatePerson() {
		WebElement web = driver.findElement(By.linkText(CREATE_PERSON_LINK_TEXT));
		return web;
	}
	private WebElement getSubmitBtn() {
		WebElement web = driver.findElement(By.xpath(SUBMIT_BUTTON_XPATH));
		return web;
	}
	private WebElement getBackBtn() {
		WebElement web = driver.findElement(By.xpath(BACK_BTN_XPATH));
		return web;
	}
	private WebElement getFullNameField() {
		WebElement web = driver.findElement(By.xpath(FULL_NAME_XPATH));
		return web;
	}
	private WebElement getTrashIcon() {
		WebElement web = driver.findElement(By.xpath(TRASH_ICON_XPATH));
		return web;
	}
	private WebElement getDeleteBtn() {
		WebElement web = driver.findElement(By.xpath(DELETE_BUTTON_XPATH));
		return web;
	}
	
	// interactions
	public void clickPeopleMenu() {
		getPeopleMenu().click();
	}	
	public void clickCreatePerson() {
		getCreatePerson().click();
	}
	public void clickSubmitBtn() {
		getSubmitBtn().click();
	}
	public void clickBackBtn() {
		getBackBtn().click();
	}
	public void clickFullNameField() {
		getFullNameField().click();
	}
	public void inputFullNameField(String chars) {
		getFullNameField().sendKeys(chars);
	}
	public void clickTrashIcon() {
		getTrashIcon().click();
	}
	public void clickDeleteBtn() {
		getDeleteBtn().click();
	}

}
