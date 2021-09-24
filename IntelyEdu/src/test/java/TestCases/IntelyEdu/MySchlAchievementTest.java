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

public class MySchlAchievementTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initiallize() throws IOException {

		driver = initializeDriver();
		log.info("--------------------------------------------------------------------");
		log.info("***********DRIVER INITIALIZED MY SCHOOL ACHIEVEMENT TEST************");
		log.info("--------------------------------------------------------------------");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	@Test
	public void mySclAchievement() throws IOException, InterruptedException {
		ReadExcel re = new ReadExcel();
		ArrayList<String> data = re.getData("testData", "Tc4");
		
		// Step 1. Login to the Website
		LoginPage lp = new LoginPage(driver);
		IntelyHomePage ip = lp.getLogin(data.get(1), data.get(2));
		try {
		Assert.assertNotNull(ip);
		log.info("Successfully loggged in to the website");
		Thread.sleep(2000);
		}
		catch(Throwable e) {
			log.error("Login validation failure message");
			throw new AssertionError("Login Valiation failure error messsage", e);
			
		}
		//Step 2. Create Achievement
		try {
		MySchoolPage msp = ip.getAchievement();
		AchievementsPage ap = msp.getCreateAchievement();
		log.info("Navigated to Create Achievement page");
		Thread.sleep(4000);
		ap.getCreateNewAchievement(data.get(3), data.get(4), data.get(5), data.get(6), data.get(7)).click();
		log.info("Filled all the details");
		log.info("Achievement created successsfully.");
		
		}
		catch(Throwable e) {
			log.error("Create Achievement Validation failure error");
			new AssertionError("Create Achievement validation failure error message", e);
		}

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
