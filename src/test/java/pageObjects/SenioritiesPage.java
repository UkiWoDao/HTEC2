package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SenioritiesPage extends BasePage{

	public SenioritiesPage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	private static String SENIOR_ID = "test3";
	private static String CREATE_SENIORITY_LINK_TEXT = "CREATE SENIORITY";
	
	// web elements
	private WebElement getSeniorMenu() {
		WebElement web = driver.findElement(By.id(SENIOR_ID));
		return web;
	}
	private WebElement getCreateSenior() {
		WebElement web = driver.findElement(By.linkText(CREATE_SENIORITY_LINK_TEXT));
		return web;
	}
	
	// interactions
	private void clickSeniorMenu() {
		getSeniorMenu().click();
	}
	private void clickCreateSenior() {
		getCreateSenior().click();
	}
}
