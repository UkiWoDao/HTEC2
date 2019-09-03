package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage{
	
	private WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private static By PLAYGROUND_CARD_XPATH = By.xpath("//div[@class='row']//div[3]");
	private static By CONTAINER_XPATH = By.xpath("//div[@class='container noselect']");
	private static String SANDBOX_MENU_XPATH = "//a[contains(text(),'Sandbox')]";
	private static String DASHBOARD_URL = "https://qa-sandbox.apps.htec.rs/dashboard";
	
	// getters
	public static By getContainerXPath() {
		return CONTAINER_XPATH;
	}
	public static By getPlaygroundCardXpath() {
		return PLAYGROUND_CARD_XPATH;
	}
	public static String getDashboardUrl() {
		return DASHBOARD_URL;
	}
	
	// web elements
	private WebElement getPlaygroundCard() {
		WebElement web = driver.findElement(PLAYGROUND_CARD_XPATH);
		return web;
	}
	private WebElement getSandboxMenuItem() {
		WebElement web = driver.findElement(By.xpath(SANDBOX_MENU_XPATH));
		return web;
	}
	
	// interactions
	public void clickPlaygroundCard() {
		getPlaygroundCard().click();
	}
	public void clickSandboxMenuItem() {
		getSandboxMenuItem().click();
	}
}
