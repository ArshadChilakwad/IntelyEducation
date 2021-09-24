package TestCases.IntelyEdu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.base;
import PageObjects.AchievementsPage;
import PageObjects.IntelyHomePage;
import PageObjects.LoginPage;
import PageObjects.MySchoolPage;
import junit.framework.Assert;
import resources.ReadExcel;

public class NegMySchlAchievementTest extends base{

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initiallize() throws IOException {

		driver = initializeDriver();
		log.info("--------------------------------------------------------------------");
		log.info("*******DRIVER INITIALIZED NEGATIVE MY SCHOOL ACHIEVEMENT TEST*******");
		log.info("--------------------------------------------------------------------");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}
	
	@Test
	public void negativeMySchlAchievement() throws IOException, InterruptedException {
		ReadExcel re = new ReadExcel();
		ArrayList<String> data = re.getData("testData", "Tc4");
		LoginPage lp =new LoginPage(driver);
		IntelyHomePage ip = lp.getLogin(data.get(1), data.get(2));
		
		MySchoolPage msp = ip.getAchievement();
		
		Thread.sleep(6000);
		AchievementsPage ap = msp.getCreateAchievement();
		
		ap.getCreate().click();
		Thread.sleep(1000);
		try {
			System.out.println(ap.getAlertMsgAll().getText());
			log.info("Alert error message validation: "+ap.getAlertMsgAll().getText());
			Assert.assertEquals(ap.getAlertMsgAll().getText(), "Please Add All Valid Fields In Achievement."); 
		} 
		catch(Throwable e) {
			throw new AssertionError("Alert validation failure error message", e);
		}
		
		
		try {
			System.out.println(ap.getAletMsgTitle().getText());
			log.info("Title error validation message: "+ap.getAletMsgTitle().getText());
			Assert.assertEquals(ap.getAletMsgTitle().getText(), "Please Enter Title"); 
		} 
		catch(Throwable e) {
			throw new AssertionError("Title validation failure error message", e);
		}
		try {
			System.out.println(ap.getAlertMsgSelectTeam().getText());
			log.info("Select teams error validation message: "+ap.getAlertMsgSelectTeam().getText());
			Assert.assertEquals(ap.getAlertMsgSelectTeam().getText(), "Please Select Team"); 
		} 
		catch(Throwable e) {
			throw new AssertionError("Team validation failure error message", e);
		}
		try {
			System.out.println(ap.getAlertMsgDesc().getText());
			log.info("Description error validation message: "+ap.getAlertMsgDesc().getText());
			Assert.assertEquals(ap.getAlertMsgDesc().getText(), "Please Enter Description"); 
		} 
		catch(Throwable e) {
			throw new AssertionError("Description validation failure error message", e);
		}
		
	}
	@AfterTest
	public void teardown() {
		driver.close();
		log.info("-------------------------------------------------------------------");
		log.info("****************************BROWSER CLOSED*************************");
		log.info("-------------------------------------------------------------------");
	}
	
}
