package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MySchoolPage {

public WebDriver  driver;
	
	public MySchoolPage(WebDriver driver) {
		this.driver=driver;
	}	
	By createAchievement = By.xpath("//span[text()='Create Achievement']");
	
	
	public AchievementsPage getCreateAchievement() {
		driver.findElement(createAchievement).click();
		return new AchievementsPage(driver);
	}
	
}
