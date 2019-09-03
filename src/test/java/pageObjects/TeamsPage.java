package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TeamsPage extends BasePage {

	public TeamsPage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	private static String TEAM_ID = "test1";
	private static String CREATE_TEAM_LINK_TEXT = "CREATE TEAM";	
	
	// web elements
	private WebElement getTeamMenu() {
		WebElement web = driver.findElement(By.id(TEAM_ID));
		return web;
	}	
	private WebElement getCreateTeam() {
		WebElement web = driver.findElement(By.linkText(CREATE_TEAM_LINK_TEXT));
		return web;
	}	
	
	// interactions
	private void clickTeamMenu() {
		getTeamMenu().click();
	}	
	private void clickCreateTeam() {
		getCreateTeam().click();
	}
}
