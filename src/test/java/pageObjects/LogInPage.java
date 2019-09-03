package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	
	private WebDriver driver;
	
	public LogInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// locators
	private static String EMAIL_PATH = "//input[@placeholder='Email Address']";
	private static String PASSWORD_PATH = "//input[@placeholder='Password']";
	private static String SUBMIT_BTN_PATH = "//button[@type='submit']";
	
	// email related
	private WebElement getEmailField() {
		WebElement web = driver.findElement(By.xpath(EMAIL_PATH));
		return web;
	}
	
	private void clickEmailField() {
		getEmailField().click();
	}	
	private void inputEmailField(String email) {
		getEmailField().sendKeys(email);
	}
	
	
	// password related
	private WebElement getPasswordField() {
		WebElement web = driver.findElement(By.xpath(PASSWORD_PATH));
		return web;
	}
	
	private void clickPasswordField() {
		getPasswordField().click();
	}	
	private void inputPasswordField(String password) {
		getPasswordField().sendKeys(password);
	}
	
	
	// submit
	private WebElement getSubmitBtn() {
		WebElement web = driver.findElement(By.xpath(SUBMIT_BTN_PATH));
		return web;
	}
	
	private void clickSubmitBtn() {
		getSubmitBtn().click();
	}
	
	public void logInAsRegisteredUser(String email, String password) throws InterruptedException {
		clickEmailField();
		inputEmailField(email);
		clickPasswordField();
		inputPasswordField(password);
		clickSubmitBtn();
	}
	
}
