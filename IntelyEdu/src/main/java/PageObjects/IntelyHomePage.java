package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class IntelyHomePage {
	
	public WebDriver  driver;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public IntelyHomePage(WebDriver driver) {
		this.driver=driver;
	}		
	
	By reports =By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text jss70']//span[@class='jss106']//*[local-name()='svg']");
	By setting = By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeStart']//span[@class='MuiIconButton-label']//*[local-name()='svg']");
	
	//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeStart']//span[@class='MuiIconButton-label']//*[local-name()='svg']
	By adminSetting = By.xpath("//p[normalize-space()='Admin Settings']");
	By plcMinButton = By.xpath("//p[normalize-space()='PLC Minutes']");
	By myClasses= By.xpath("//div[@class='MuiButtonBase-root MuiListItem-root jss31 MuiListItem-gutters MuiListItem-button']");
	By classSetup= By.xpath("//span[normalize-space()='Class Setup']");
	By expand = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text jss66']");
	By myschl = By.xpath("//span[text()='My Schools']");
	By achievements = By.xpath("//span[text()='Achievements']");
	By plcTasks = By.xpath("//p[text()='PLC tasks']");
	
	
	public  MyTeams getPLCTasks() {
		 driver.findElement(plcTasks).click();
		 return new MyTeams(driver); 
	}
	public WebElement getMySchools() {
		return driver.findElement(myschl);	
	}
	public MySchoolPage getAchievement() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(expand).click();
		driver.findElement(myschl).click();
		js.executeScript("document.querySelector('.jss60').scrollTop=200");
		driver.findElement(achievements).click();
		return new  MySchoolPage(driver);
		
		
	}
	public WebElement getExpand() {
		return driver.findElement(expand);	
	}
	public WebElement getSetting() {
		return driver.findElement(setting);	
	}
	public WebElement getClassSetupBtn() {
		return driver.findElement(classSetup);	
	}
	public WebElement getmyClasses() {
		return driver.findElement(myClasses);
		
	}
	public WebElement getReports() {
		return driver.findElement(reports);
	}
	public  TeamSetup getAdminSetting() {
		 driver.findElement(adminSetting).click();
		return new TeamSetup(driver);
	}
	public  MyTeams getPLCMinButton() {
		 driver.findElement(plcMinButton).click();
		 return new MyTeams(driver);
	}
	
	public ClassSetup getClassSetup() {
		getSetting().click();
		getAdminSetting();
		getmyClasses().click();
		getClassSetupBtn().click();
		return new ClassSetup(driver);
	}
}
