package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;

	By username = By.cssSelector("[id='username']");
	By password = By.cssSelector("[id='outlined-adornment-password']");
	By login = By.cssSelector(".MuiButton-label");
	By settings = By.xpath(
			"//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeStart']");
	By logout = By.xpath("//p[normalize-space()='Logout']");
	By yes = By.xpath("//span[normalize-space()='Yes']");
	By alertMsgUsername = By.cssSelector("[id='username-helper-text']");
	By alertMsgPassword = By.xpath("//p[text()='Please Enter password']");

	
	
	public WebElement getAlertMsgUsername() {
		return driver.findElement(alertMsgUsername);
	}
	public WebElement getAlertMsgPassword() {
		return driver.findElement(alertMsgPassword);
	}
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsername() {
		return driver.findElement(username);

	}

	public WebElement getPassword() {
		return driver.findElement(password);

	}

	public WebElement getSubmit() {
		return driver.findElement(login);
	}

	public WebElement getSettings() {
		return driver.findElement(settings);
	}

	public WebElement getLogout() {
		return driver.findElement(logout);
	}

	public WebElement getYes() {
		return driver.findElement(yes);
	}
	
	
	public  IntelyHomePage getLogin(String username, String password) {
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getSubmit().click();
		return new IntelyHomePage(driver);
	}
	

}
