package TestCases.IntelyEdu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.base;
import PageObjects.IntelyHomePage;
import PageObjects.LoginPage;
import PageObjects.MyTeams;
import resources.ReadExcel;

public class PLCMinutesTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initiallize() throws IOException {

		driver = initializeDriver();
		log.info("--------------------------------------------------------------------");
		log.info("************DRIVER INITIALIZED IN PLC MINUTES TEST PAGE*************");
		log.info("--------------------------------------------------------------------");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Intely Edu website successfully ");
		driver.manage().window().maximize();
		
		
	}

	
	@Test
	public void newPLCMinutes() throws IOException, InterruptedException {
		
		
		ReadExcel re = new ReadExcel();
		ArrayList<String> data = re.getData("testData", "Tc2");
		
		//Step 1. Login in to the Website
		LoginPage lgp = new LoginPage(driver);
		IntelyHomePage ip = lgp.getLogin(data.get(1), data.get(2));
		log.info("Loggged in into the application ");
		Thread.sleep(2000);
		
		//Step 2. Click the PLC minutes button
		MyTeams ms = ip.getPLCMinButton();
		log.info("Clicked PLC Minutes");
		//WebDriverWait  w = new WebDriverWait(driver, 5);
		//w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='demo-simple-select-outlined']")));
		Thread.sleep(9000);
		
		//Step 3. Select teams from the dropdown.
		ms.getTeam(data.get(3));
		Thread.sleep(5000);
		
		
		ms.getNewMinute().click();
		log.info("Clicked on Add New Minutes");
		Thread.sleep(5000);
		
		/*****************ADD EDIT NEW MEMBER*********************/
		ms.getAddEditMember().click();
		log.info("Clicked on Add/Edit New Member");
		Thread.sleep(5000);
		
		ms.getSelectRole3().click();
		List<WebElement> liRol3= ms.getAllTeams();
		for(int i=0; i<liRol3.size(); i++) {
			String name = liRol3.get(i).getText();
			if(name.contains(data.get(9))) {
				liRol3.get(i).click();
				break;
			}
		}
		
		Thread.sleep(5000);
		//ms.getSearch().click();
		
		ms.getSelectRole2().click();
		List<WebElement> liRol2= ms.getAllTeams();
		for(int i=0; i<liRol2.size(); i++) {
			String name = liRol2.get(i).getText();
			if(name.contains(data.get(8))) {
				liRol2.get(i).click();
				break;
			}
		}
		
		List<WebElement> liPresent = ms.getPresent();
		for(int i=0; i<liPresent.size(); i++) {
			liPresent.get(i).click();
			lgp.getYes().click();
		}
		
		Thread.sleep(5000);
		ms.getSelectRole1().click();
		List<WebElement> liRol1 = ms.getAllTeams();
		for(int i=0; i<liRol1.size(); i++) {
			String name = liRol1.get(i).getText();
			if(name.contains(data.get(7))) {
				liRol1.get(i).click();
				break;
			}
		}
		
		ms.getLeftArrow().click();
		
		
		ms.getAddTopic().click();
		ms.getDescription().sendKeys(data.get(4));
		ms.getDescription2().sendKeys(data.get(4));
		ms.getDescription().sendKeys(data.get(4));
		
		ms.getAddTask().click();
		Thread.sleep(3000);
		
		ms.getTaskDesc().sendKeys(data.get(5));
		log.info("Task added successfully with description");
		//Thread.sleep(3000);
		ms.getViewOwner().click();
		//Thread.sleep(2000);
		List<WebElement> liOwner = ms.getOwnerList();
		
        liOwner.get(2).click();
        ms.getSavOwner().click();
        log.info("Owner Selected");
		
		ms.getAddAchievement().click();
		ms.getAchievementDesc().sendKeys(data.get(6));
		log.info("Achivement added successfully");
		ms.getSaveButton().click();
		log.info("Clicked on Save ");
		//
		Thread.sleep(9000);
		
		
	} 

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("--------------------------------------------------------------------");
		log.info("***************************BROWSER CLOSED***************************"); 
		log.info("--------------------------------------------------------------------");
	}

}


