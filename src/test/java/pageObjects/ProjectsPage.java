package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {

	public ProjectsPage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	private static String PROJECT_ID = "test0";
	private static String CREATE_PROJECT_LINK_TEXT = "CREATE PROJECT";	
	
	// web elements
	private WebElement getProjectMenu() {
		WebElement web = driver.findElement(By.id(PROJECT_ID));
		return web;
	}	
	private WebElement getCreateProject() {
		WebElement web = driver.findElement(By.linkText(CREATE_PROJECT_LINK_TEXT));
		return web;
	}	
	
	// interactions
	private void clickProjectMenu() {
		getProjectMenu().click();
	}	
	private void clickCreateProject() {
		getCreateProject().click();
	}
}
