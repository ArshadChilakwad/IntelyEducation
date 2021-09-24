    package TestCases.IntelyEdu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.base;
import PageObjects.IntelyHomePage;
import PageObjects.LoginPage;
import PageObjects.MembersPage;
import PageObjects.RolesPage;
import PageObjects.TeamSetup;
import junit.framework.Assert;
import resources.ReadExcel;

public class TeamSetupTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initiallize() throws IOException {

		driver = initializeDriver();
		log.info("--------------------------------------------------------------------");
		log.info("**************DRIVER INITIALIZED IN TEAM SETUP TEST PAGE************");
		log.info("--------------------------------------------------------------------");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Intely Education Website");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void teamSetUp() throws InterruptedException, IOException {

		ReadExcel re = new ReadExcel();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ArrayList<String> data = re.getData("testData", "Tc1");

		LoginPage lgp = new LoginPage(driver);
		 IntelyHomePage ip = lgp.getLogin(data.get(1), data.get(2));
		
		try{
			Assert.assertNotNull(lgp);
			System.out.println("page not null");
		}
		catch(Exception e){
			System.out.println("page null");
			throw new AssertionError("Login validation failure error message",e);
			
		}
		
		//js.executeScript("window.scrollBy(0,300)");
		
		ip.getSetting().click();
		TeamSetup ts = ip.getAdminSetting();
		log.info("Navigated to PLC Team Setup Page");

		ts.getTeamName().sendKeys(data.get(3));
		 log.info("Entered team name");
		//Thread.sleep(5000);
		List<WebElement> liDays = ts.getDays();
		
	System.out.println(liDays.get(2).getText());
	
		//liDays.get(0).click();
		liDays.get(2).click();
		liDays.get(4).click();
		
		log.info("Selected the number of days");

		ts.getContentArea().click();
		Thread.sleep(3000);
		List<WebElement> sub = ts.getSubject();
	
		System.out.println(data.get(15));
		
		for (int i = 0; i < sub.size(); i++) {
			String name = sub.get(i).getText();
			if (name.contains(data.get(15))) { 
				sub.get(i).click();
				break;
			} 
		}
		log.info("Selected content area from the dropdown menu");
		Thread.sleep(3000);
		System.out.println(ts.getStartTime().getText());
		ts.getStartTime().sendKeys("01:00PM");
		log.info("Entered the meeting start time");
		
		System.out.println(ts.getEndTime().getText());
		ts.getEndTime().sendKeys("02:00PM");
		log.info("Entered the meeting end time");
		
		
		//Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,250)");
	
		ts.getTeamNorm().sendKeys(data.get(6));
		log.info("Entered team norms");
		Thread.sleep(2000);
		ts.getNextButton().click();

		MembersPage memPage = new MembersPage(driver);
		List<WebElement> liMembers = memPage.getMembers();
		System.out.println(liMembers.size());

		memPage.getSearch().sendKeys(data.get(7));
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		log.info("Selected first member in the team");
		memPage.getAddMember().click();
		log.info("Added the first member successfully");
		memPage.getSearch().clear();

		memPage.getSearch().sendKeys(data.get(8));
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		log.info("Selected second member in the team");
		memPage.getAddMember().click();
		log.info("Added the second member successfully");
		memPage.getSearch().clear();

		memPage.getSearch().sendKeys(data.get(9));
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		log.info("Selected third member in the team");
		memPage.getAddMember().click();
		log.info("Added the third member successfully");
		memPage.getSearch().clear();

		Thread.sleep(3000);
		// driver.findElement(By.xpath("//span[contains(text(),'arshad')]");

		ts.getNextButton().click();
		log.info("Clicked on the next button");

		// Thread.sleep(10000);

		RolesPage rp = new RolesPage(driver);
		log.info("Successfully navigated to the roles page");
		/***********************TO Add New Roles**********************/
		
		rp.getAddNewRoles().click();
		log.info("Clicked Add new roles");
		rp.getRolesTitle().sendKeys(data.get(13)); 
		
		if(data.get(14).contains("Multiple")) {
			rp.getMultipleuserSelect().click();
			log.info("Selected checkbox for multipleusers");
			Thread.sleep(2000);
			rp.getCreateBtn().click();
		}
		
		else {
		rp.getCreateBtn().click();
		}
		Thread.sleep(2000);
		
		if(ts.getAlertMsg().isDisplayed()) {
			System.out.println(ts.getAlertMsg().getText());
			ts.getCancel().click();
		}
		
		rp.getSelectRoles1().click();
		List<WebElement> liRoles = rp.getRoles();

		log.info("All the list elements from the SelectRoles1 is collected");

		// String rl = data.get(10);

		for (int i = 0; i < liRoles.size(); i++) {
			String name = liRoles.get(i).getText();
			if (name.contains(data.get(10))) {
				System.out.println(liRoles.get(i).getText());
				log.info("Selected role for member 1");
				liRoles.get(i).click();
				break;
			}

		}

		rp.getSelectRoles2().click();
		List<WebElement> liRoles2 = rp.getRoles();
		// Thread.sleep(3000);
		// js.executeScript("document.querySelector('.MuiPaper-root.MuiMenu-paper.MuiPopover-paper.MuiPaper-elevation8.MuiPaper-rounded').scrollTop=200");
		Thread.sleep(3000);
		for (int i = 0; i < liRoles2.size(); i++) {
			String name = liRoles2.get(i).getText();

			if (name.contains(data.get(11))) {
				System.out.println(liRoles2.get(i).getText());
				log.info("Selected role for member 2");
				liRoles2.get(i).click();
				break;
			}
		}

		rp.getSelectRoles3().click();
		List<WebElement> liRoles3 = rp.getRoles();
		for (int i = 0; i < liRoles3.size(); i++) {
			String name = liRoles3.get(i).getText();
			if (name.contains(data.get(12))) {
				System.out.println(liRoles3.get(i).getText());
				log.info("Selected role for member 3");
				liRoles3.get(i).click();
				break;
			}
		}

		rp.getFinishButton().click();
		log.info("Clicked on finish button to create team");
		
	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("--------------------------------------------------------------------");
		log.info("*****************************BROWSER CLOSED*************************");
		log.info("--------------------------------------------------------------------");
	}
}
