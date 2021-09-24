package PageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class TeamSetup  {
public WebDriver  driver;
	
	public TeamSetup(WebDriver driver) {
		this.driver=driver;
		
		
	}
	
	By teamName = By.cssSelector("[id='outlined-multiline-static']");
	By contentArea = By.xpath("//div[contains(text(),'Select Content Area')]");
	By alertMsg = By.cssSelector("[id='client-snackbar']");
	
	By teamNorm = By.xpath("//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']");
	By subject = By.cssSelector("[role='option']");
	
	By days = By.cssSelector("[name='days']");
	By startTime = By.xpath("//*[@id=\"time\"]");
	By endTime =By.xpath("//body/div[@id='root']/div[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/form[2]/div[1]/div[1]/input[1]");
	By nextButton = By.xpath("//span[normalize-space()='Next']");
	By cancel = By.xpath("//span[text()='Cancel']");
	
/***************************************************************************************/	
	By msgClassName= By.xpath("//p[text()='Please Enter Class Name']");
	By msgTeamName= By.xpath("//p[text()='Please Enter Team Name.']");
	By msgSelectContentArea = By.xpath("//p[text()='Please Select Content Area.']");
	By msgSelectDays = By.xpath("//p[text()='Please Select Days.']");
	By msgStartTime = By.xpath("//p[text()='Please Select Start Time.']");
	By msgEndTime = By.xpath("//p[text()='Please Select End Time.']");
	By msgSelectTeacher = By.xpath("//p[text()='Please Select Teacher.']");
/************************************ALERT MESSAGES************************************/	
	
	public WebElement getClassNameMsg() {
		return driver.findElement(msgClassName);
	}
	public WebElement getTeamNameMsg() {
		return driver.findElement(msgTeamName);
	}
	public WebElement getSelectContentAreaMsg() {
		return driver.findElement(msgSelectContentArea);
	}
	public WebElement getSelectDaysMsg() {
		return driver.findElement(msgSelectDays);
	}
	public WebElement getSelectStartTimeMsg() {
		return driver.findElement(msgStartTime);
	}
	public WebElement getEndTimeMsg() {
		return driver.findElement(msgEndTime);
	}
	public WebElement getSelectTeacherMsg() {
		return driver.findElement(msgSelectTeacher);
	}
/****************************************************************************************/	
	public WebElement getCancel() {
		return driver.findElement(cancel);
	}
	public WebElement getAlertMsg() {
		return driver.findElement(alertMsg);
	}
	public WebElement getTeamName() {
		return driver.findElement(teamName);
	}

	public List<WebElement> getDays() {
		return driver.findElements(days);
	}
	public WebElement getStartTime() {
		return driver.findElement(startTime);
	}
	public WebElement getEndTime() {
		return driver.findElement(endTime);
	}

	public WebElement getContentArea() {
		return driver.findElement(contentArea);
	}
	public List<WebElement> getSubject() {
		return driver.findElements(subject);
	}

	public WebElement getTeamNorm() {
		return driver.findElement(teamNorm);
	}
	
	public WebElement getNextButton() {
		return driver.findElement(nextButton);
	}
	
	

}
