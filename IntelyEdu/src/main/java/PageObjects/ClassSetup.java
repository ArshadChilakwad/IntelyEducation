package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassSetup {
	public WebDriver driver;
	
	public ClassSetup(WebDriver driver) {
		this.driver=driver;
	}	
	
	By selectClassName = By.cssSelector("[id='outlined-multiline-static']");
	By selectcontentArea = By.xpath("//div[normalize-space()='Select Content Area']");
	By selectTeacher = By.cssSelector("[id='combo-box-demo']");
	By popUpSelect = By.xpath("//ul[@id='combo-box-demo-popup']");
	By days =  By.cssSelector("[name='days']");
	By days2 =  By.cssSelector("[type='checkbox']");
	
	By classStart = By.xpath("(//input[@id='time'])[1]");
	By classEnd = By.xpath("(//input[@id='time'])[2]");
	By addClassinstance = By.xpath("//*[name()='path' and contains(@d,'M13 7h-2v4')]");


	
	By selectcontentArea2 = By.xpath("(//div[@class='jss5452'])[2]");
	By selectTeacher2 = By.xpath("(//input[@id='combo-box-demo'])[2]");
	By classStart2 = By.xpath("(//input[@id='time'])[3]");
	By classEnd2 = By.xpath("(//input[@id='time'])[4]");
	By saveButton = By.xpath("//span[normalize-space()='Save']");
	
	
	/*By msgTeamName= By.xpath("//p[text()='Please Enter Class Name.']");
	By msgSelectContentArea = By.xpath("//p[text()='Please Select Content Area.']");
	By msgSelectDays = By.xpath("//p[text()='Please Select Days.']");
	By msgStartTime = By.xpath("//p[text()='Please Select Start Time.']");
	By msgEndTime = By.xpath("//p[text()='Please Select End Time.']");
	By msgSelectTeacher = By.xpath("//p[text()='Please Select Teacher.']");*/
	
	
	
	
	public WebElement getSelectClassName() {
		return driver.findElement(selectClassName);
	}

	public WebElement getSelectContentArea() {
		return driver.findElement(selectcontentArea);
	}
	public WebElement getSelectContentArea2() {
		return driver.findElement(selectcontentArea2);
	}
	public WebElement getPopUp() {
		return driver.findElement(popUpSelect);
	}
	public List<WebElement> getdays() {
		return driver.findElements(days);
	}
	public List<WebElement> getdays2() {
		return driver.findElements(days2);
	}
	public WebElement getClassStart() {
		return driver.findElement(classStart);
	}
	public WebElement getClassStart2() {
		return driver.findElement(classStart2);
	}
	public WebElement getClassEnd() {
		return driver.findElement(classEnd);
	}
	public WebElement getClassEnd2() {
		return driver.findElement(classEnd2);
	}
	public WebElement getSelectTeacher() {
		return driver.findElement(selectTeacher);
	}
	public WebElement getSelectTeacher2() {
		return driver.findElement(selectTeacher2);
	}
	
	public WebElement getAddInstance() {
		return driver.findElement(addClassinstance);
	}
	public WebElement getSaveButton() {
		return driver.findElement(saveButton);
	}
	
}
