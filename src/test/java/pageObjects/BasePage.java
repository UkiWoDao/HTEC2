package pageObjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	public static WebDriverWait wait;
	
	// user data
	public static String email = "u.vucenovic@gmail.com";
	public static String password = "grkljan12";
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
    public void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public WebElement findElementByLinkText(String linkText) {
    	WebElement web = driver.findElement(By.linkText(linkText));
    	return web;
    }
    
	public String getCurrentPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public String getCurrentPageUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public static String getRandomString(int maxChar) {
		// all English keyboard non-special characters
		String VALIDCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		
		// create instance of string builder
		StringBuilder stb = new StringBuilder();
		
		// create instance for random numbers
		Random rnd = new Random();
		
		// iterate over ENGCHARS and create a random string
		while(stb.length() < maxChar) {
			int i = (int) (rnd.nextFloat() * VALIDCHARS.length());
			stb.append(VALIDCHARS.charAt(i));
		}
		
		// to string
		String s = stb.toString();
		
		return s;
	}
	
}
