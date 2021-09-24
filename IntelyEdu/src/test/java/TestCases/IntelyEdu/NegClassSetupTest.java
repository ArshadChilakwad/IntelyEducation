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
import PageObjects.ClassSetup;
import PageObjects.IntelyHomePage;
import PageObjects.LoginPage;
import PageObjects.TeamSetup;
import junit.framework.Assert;
import resources.ReadExcel;

public class NegClassSetupTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("--------------------------------------------------------------------");
		log.info("**********DRIVER INITIALIZED IN NEGATIVE CLASSS SETUP PAGE**********");
		log.info("--------------------------------------------------------------------");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void negativeClassSetup() throws IOException, InterruptedException {

		ReadExcel re = new ReadExcel();
		ArrayList<String> data = re.getData("testData", "Tc1");

		//Step 1. Login to the website
		LoginPage lp= new LoginPage(driver);
		IntelyHomePage ip = lp.getLogin(data.get(1), data.get(2));
		try {
			Assert.assertNotNull(ip);
			System.out.println("page not null");
		} catch (Exception e) {
			throw new AssertionError("Login validation failure error message", e);
		}
		log.info("Successfully Logged in to the Website");
		
		// 2. Navigate to class setup
		Thread.sleep(2000);
		ClassSetup cs = ip.getClassSetup();
		Thread.sleep(9000);
		log.info("Navigated to Class Setup Page");
		
		try {
			cs.getSaveButton().click();

		} catch (Exception e) {

			log.error("Unable to move next without filling all the fields");
			throw new AssertionError("Select save validation failure error messgae", e);

		}

		TeamSetup ts = new TeamSetup(driver);

		// 3. Negative Test Cases
		try {
			Assert.assertEquals(ts.getClassNameMsg().getText(), "Please Enter Class Name");
			log.info("Cannot leave class name empty: " + ts.getClassNameMsg().getText());
			System.out.println(ts.getClassNameMsg().getText());
		} catch (Exception e) {
			log.error("Unable to move next without filling all the fields");
			throw new AssertionError("Select Class Name Validation failure error message", e);

		}
		try {
			Assert.assertEquals(ts.getSelectContentAreaMsg().getText(), "Please Select Content Area.");
			log.info("Cannot leave content area empty: " + ts.getSelectContentAreaMsg().getText());
			System.out.println(ts.getSelectContentAreaMsg().getText());
		} catch (Exception e) {
			log.error("Unable to move next without filling all the fields");
			throw new AssertionError("Select Content Name Validation failure error message", e);

		}
		try {
			Assert.assertEquals(ts.getSelectTeacherMsg().getText(), "Please Select Teacher.");
			log.info("Cannot leave select teacher empty: " + ts.getSelectTeacherMsg().getText());
			System.out.println(ts.getSelectTeacherMsg().getText());
		} catch (Exception e) {
			log.error("Unable to move next without filling all the fields");
			throw new AssertionError("Select teachers Name Validation failure error message", e);

		}
		try {
			Assert.assertEquals(ts.getSelectDaysMsg().getText(), "Please Select Days.");
			log.info("Cannot leave select teacher empty: " + ts.getSelectDaysMsg().getText());
			System.out.println(ts.getSelectDaysMsg().getText());
		} catch (Exception e) {
			log.error("Unable to move next without filling all the fields");
			throw new AssertionError("Select days Name Validation failure error message", e);

		}
		try {
			Assert.assertEquals(ts.getSelectStartTimeMsg().getText(), "Please Select Start Time.");
			log.info("Cannot leave select teacher empty: " + ts.getSelectStartTimeMsg().getText());
			System.out.println(ts.getSelectStartTimeMsg().getText());
		} catch (Exception e) {
			log.error("Unable to move next without filling all the fields");
			throw new AssertionError("Select start time Validation failure error message", e);

		}
		try {
			Assert.assertEquals(ts.getEndTimeMsg().getText(), "Please Select End Time.");
			log.info("Cannot leave select teacher empty: " + ts.getEndTimeMsg().getText());
			System.out.println(ts.getEndTimeMsg().getText());
		} catch (Exception e) {
			log.error("Unable to move next without filling all the fields");
			throw new AssertionError("Select end time Validation failure error message", e);

		}
		log.info("Verified all the error messages");

	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("-------------------------------------------------------------------");
		log.info("****************************BROWSER CLOSED*************************");
		log.info("-------------------------------------------------------------------");
	}
}
