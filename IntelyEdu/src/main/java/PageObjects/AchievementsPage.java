package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AchievementsPage {
public WebDriver  driver;
	
	public AchievementsPage(WebDriver driver) {
		this.driver=driver;
	}	
	
	By title = By.cssSelector("[id='title']");
	By desc = By.cssSelector("[id='outlined-multiline-static']");
	By create = By.xpath("//span[normalize-space()='Create']");
	By cancel = By.xpath("//span[normalize-space()='Cancel']");
	By date = By.xpath("//input[@placeholder='MM/DD/YYYY']");
	By selectTeams = By.xpath("//div[normalize-space()='Select Team']");
	By calender = By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root']");
	By month = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-alignCenter']");
	By nxtArrow = By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton'])[2]");
	By days = By.cssSelector("[role='presentation']");
/******************************************************************************************/
	By alertMsgSelectTeam = By.xpath("//div[text()='Please Select Team']");
	By aletMsgTitle = By.xpath("//div[text()='Please Enter Title']");
	By alertMsgDesc = By.xpath("//div[text()='Please Enter Description']");
	By alertMsgAll = By.cssSelector("[id='client-snackbar']");
	
			
	public WebElement getAlertMsgAll() {
		return driver.findElement(alertMsgAll);
	}		
	public WebElement getAlertMsgDesc() {
		return driver.findElement(alertMsgDesc);
	}
	public WebElement getAletMsgTitle() {
		return driver.findElement(aletMsgTitle);
	}
	public WebElement getAlertMsgSelectTeam() {
		return driver.findElement(alertMsgSelectTeam);
	}
	public List<WebElement> getDays() {
		return driver.findElements(days);
	}
	public WebElement getNextArrow() {
		return driver.findElement(nxtArrow);
	}
	public WebElement getMonth() {
		return driver.findElement(month);
	}
	public WebElement getcalenlder() {
		return driver.findElement(calender);
	}
	public WebElement getSelectTeams() {
		return driver.findElement(selectTeams);
	}
	public WebElement getDate() {
		return driver.findElement(date);
	}
	public WebElement getCancel() {
		return driver.findElement(cancel);
	}
	
	public WebElement getCreate() {
		return driver.findElement(create);
	}
	
	public WebElement getDesc() {
		return driver.findElement(desc);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getCreateNewAchievement(String teamName, String title, String desc, String month, String date) throws InterruptedException {
		Thread.sleep(2000);
		getSelectTeams().click();
		Thread.sleep(2000);
		MyTeams ms = new MyTeams(driver);
		List<WebElement> liTeams = ms.getAllTeams();

		for (int i = 0; i < liTeams.size(); i++) {
			String name = liTeams.get(i).getText();
			if (name.contains(teamName)) {
				liTeams.get(i).click();
				break;
			}
		}

		getTitle().sendKeys(title);
		getDesc().sendKeys(desc);
		Thread.sleep(2000);
		
		getcalenlder().click();

		while (!getMonth().getText().contains(month)) {

			getNextArrow().click();
		}

		List<WebElement> lidays = getDays();
		for (int i = 0; i < lidays.size(); i++) {
			if (lidays.get(i).getText().contains(date)) {
				lidays.get(i).click();
				break;
			}
		}
		
		return getCreate();

	}
	
	
}
