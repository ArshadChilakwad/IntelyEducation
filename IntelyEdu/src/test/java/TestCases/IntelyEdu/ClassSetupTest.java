package TestCases.IntelyEdu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.base;
import PageObjects.ClassSetup;
import PageObjects.IntelyHomePage;
import PageObjects.LoginPage;
import PageObjects.TeamSetup;
import junit.framework.Assert;
import resources.ReadExcel;

public class ClassSetupTest extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initiallize() throws IOException {

		driver = initializeDriver();
		log.info("--------------------------------------------------------------------");
		log.info("**************DRIVER INITIALIZED IN CLASS SETUP TEST****************");
		log.info("--------------------------------------------------------------------");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	@Test
	public void classSetup() throws IOException, InterruptedException {
		ReadExcel re = new ReadExcel();
		ArrayList<String> data = re.getData("testData", "Tc3");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		LoginPage lgp = new LoginPage(driver);
		IntelyHomePage ip = lgp.getLogin(data.get(1), data.get(2));
		
		try{
			Assert.assertNotNull(lgp);
		}
		catch(Exception e){
			throw new AssertionError("Login validation failure error message",e);
		}
		log.info("Successfully logged in to the website");
		
		Thread.sleep(3000);
		
		ClassSetup cs = ip.getClassSetup();
		log.info("Navigated to the Class Setup Page");
		cs.getSelectClassName().sendKeys(data.get(3));
		log.info("Entered Class Name");
		Thread.sleep(2000);
		cs.getSelectContentArea().click();
		log.info("Selected Content Area");
		TeamSetup ts = new TeamSetup(driver);
		List<WebElement> liSubs = ts.getSubject();
		for (int i = 0; i < liSubs.size(); i++) {
			String name = liSubs.get(i).getText();
			if (name.contains(data.get(4))) {
				// System.out.println(sub.get(i).getText());
				liSubs.get(i).click();
				break;
			}

		}
		log.info("Selected the subject");
		cs.getSelectTeacher().sendKeys(data.get(6));
		log.info("Selected the Teacher");
		cs.getPopUp().click();

		List<WebElement> liDays = cs.getdays();
		System.out.println(liDays.get(1).getText());
		System.out.println(liDays.get(2).getText());
		liDays.get(1).click();
		liDays.get(2).click();
		log.info("Selected the number of days");

		cs.getClassStart().sendKeys("07:00AM");
		cs.getClassEnd().sendKeys("08:00AM");
		log.info("Entered meeting Start Time and End Time");
		js.executeScript("document.querySelector('#contanerid').scrollTop=500");

		cs.getAddInstance().click();
		log.info("Clicked on Add new Class Instance");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('#contanerid').scrollTop=500");
		cs.getSelectTeacher2().sendKeys(data.get(7));
		cs.getPopUp().click();

		List<WebElement> liDays2 = cs.getdays2();
		liDays2.get(9).click();
		liDays2.get(10).click();

		cs.getClassStart2().sendKeys("08:00AM");
		cs.getClassEnd2().sendKeys("09:00AM");
		log.info("Successfully added all the details ");
		cs.getSaveButton().click();
		Thread.sleep(6000);

	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("--------------------------------------------------------------------");
		log.info("****************************BROWSER CLOSED**************************");
		log.info("--------------------------------------------------------------------");
	}
}
