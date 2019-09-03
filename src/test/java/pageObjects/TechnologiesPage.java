package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TechnologiesPage extends BasePage {

	public TechnologiesPage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	private static String TECH_ID = "test4";
	private static String CREATE_TECH_LINK_TEXT = "CREATE TECHNOLOGY";
	private static String TECHNOLOGY_TITLE_XPATH = "//input[@placeholder='* Technology Title']";
	private static String SUBMIT_BTN_XPATH = "//button[@value='Submit']";
	private static By INVALID_ALERT_DIV_XPATH = By.xpath("//div[@class='invalid-feedback']");
	
	// web elements
	private WebElement getTechMenu() {
		WebElement web = driver.findElement(By.id(TECH_ID));
		return web;
	}
	private WebElement getCreateTech() {
		WebElement web = driver.findElement(By.linkText(CREATE_TECH_LINK_TEXT));
		return web;
	}
	private WebElement getTechnologyTitle() {
		WebElement web = driver.findElement(By.xpath(TECHNOLOGY_TITLE_XPATH));
		return web;
	}
	private WebElement getSubmitBtn() {
		WebElement web = driver.findElement(By.xpath(SUBMIT_BTN_XPATH));
		return web;
	}
	
	// interactions
	public void clickTechMenu() {
		getTechMenu().click();
	}
	public void clickCreateTech() {
		getCreateTech().click();
	}
	public void clickTechnologyTitle() {
		getTechnologyTitle().click();
	}
	public void inputTechnologyTitle(String chars) {
		getTechnologyTitle().sendKeys(chars);
	}
	public void clickSubmitBtn() {
		getSubmitBtn().click();
	}
}
