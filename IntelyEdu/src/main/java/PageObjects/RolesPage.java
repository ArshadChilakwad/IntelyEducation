package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RolesPage {
	public WebDriver driver;

	public RolesPage(WebDriver driver) {
		this.driver = driver;

	}
	
	By selectRoles1 = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div/div");
	By selectRoles2 = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[2]/div[2]/div/div/div");
	By selectRoles3= By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/div[2]/div/div/div");
	By addNewRoles = By.xpath("//p[normalize-space()='Add New Role']");
	By roleTitle = By.xpath("//input[@id='outlined-multiline-static']");
	By multipleUsersSelectBtn = By.xpath("//input[@id='1']");
	By createBtn = By.xpath("//span[normalize-space()='Create']");
	
	By roles1 = By.cssSelector("[role='option']");
	//By roles2 = By.cssSelector("[role='option']");
	//By roles3 = By.cssSelector("[role='option']");
	By finishButton = By.xpath("//span[normalize-space()='Finish']");
	
	public List<WebElement> getRoles() {
		return driver.findElements(roles1);
	}
	

	public WebElement getMultipleuserSelect() {
		return driver.findElement(multipleUsersSelectBtn);
	}
	public WebElement getCreateBtn() {
		return driver.findElement(createBtn);
	}
	
	public WebElement getSelectRoles1() {
		return driver.findElement(selectRoles1);
	}
	public WebElement getRolesTitle() {
		return driver.findElement(roleTitle);
	}
	public WebElement getSelectRoles2() {
		return driver.findElement(selectRoles2);
	}
	public WebElement getSelectRoles3() {
		return driver.findElement(selectRoles3);
	}
	public WebElement getFinishButton() {
		return driver.findElement(finishButton);
	}

	public WebElement getAddNewRoles() {
		return driver.findElement(addNewRoles);
	}
}
