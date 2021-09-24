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
import PageObjects.IntelyHomePage;
import PageObjects.LoginPage;
import PageObjects.TeamSetup;
import junit.framework.Assert;
import resources.ReadExcel;

public class NegTeamSetupTest extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("--------------------------------------------------------------------");
		log.info("***********DRIVER INITIALIZED IN NEGATIVE TEAMSETUP PAGE************");
		log.info("--------------------------------------------------------------------");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void negativeTeamSetup() throws IOException, InterruptedException {

		ReadExcel re = new ReadExcel();
		ArrayList<String> data = re.getData("testData", "Tc1");

		LoginPage lgp = new LoginPage(driver);

		IntelyHomePage ip = lgp.getLogin(data.get(1), data.get(2));
		try {
			Assert.assertNotNull(ip);
			System.out.println("page not null");
		} catch (Exception e) {
			throw new AssertionError("Login validation failure error message", e);
		}

		Thread.sleep(2000);
		log.info("Successfully logged in to the website");
		lgp.getSettings().click();


		

		TeamSetup ts = new TeamSetup(driver);

		// Creating PLC TeamSetup without input values
		try {
			ts.getNextButton().click();
		} catch (Exception e) {
			log.error("Unable to move next without filling all the fields");
			throw new AssertionError("Select next validation failure error messgae", e);
		}
		// ****************************************************************************************
		try {
			Assert.assertEquals(ts.getTeamNameMsg().getText(), "Please Enter Team Name.");
			System.out.println(ts.getTeamNameMsg().getText());
			log.info("Cannot leave team name empty:" + ts.getTeamNameMsg().getText());
		} catch (Exception e) {
			log.error("Unable to move next without filling all the fields");
			throw new AssertionError("Select Team Name Validation failure error message", e);
		}

		try {
			Assert.assertEquals(ts.getSelectContentAreaMsg().getText(), "Please Select Content Area.");
			System.out.println(ts.getSelectContentAreaMsg().getText());
			log.info("Cannot leave content area empty:" + ts.getSelectContentAreaMsg().getText());
		} catch (Exception e) {
			log.error("Unable to move next without filling all the fields");
			throw new AssertionError("Select content area Validation failure error message", e);
		}
		try {
			Assert.assertEquals(ts.getSelectDaysMsg().getText(), "Please Select Days.");
			System.out.println(ts.getSelectDaysMsg().getText());
			log.info("Cannot leave days empty:" + ts.getSelectDaysMsg().getText());
		} catch (Exception e) {
			log.error("Unable to move next without filling all the fields");
			throw new AssertionError("Select days area Validation failure error message", e);
		}
		try {
			Assert.assertEquals(ts.getSelectStartTimeMsg().getText(), "Please Select Start Time.");
			System.out.println(ts.getSelectStartTimeMsg().getText());
			log.info("Cannot leave time empty:" + ts.getSelectStartTimeMsg().getText());
		} catch (Exception e) {
			log.error("Unable to move next without filling all the fields");
			throw new AssertionError("Select time area Validation failure error message", e);
		}
		try {
			Assert.assertEquals(ts.getEndTimeMsg().getText(), "Please Select End Time.");
			System.out.println(ts.getEndTimeMsg().getText());
			log.info("Cannot leave time empty:" + ts.getEndTimeMsg().getText());
		} catch (Exception e) {
			log.error("Unable to move next without filling all the fields");
			System.out.println(ts.getEndTimeMsg().getText());
			throw new AssertionError("Select time area Validation failure error message", e);
		}

		log.info("Verified all the error messages");
		System.out.println("Verified all the error messages");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("-------------------------------------------------------------------");
		log.info("**************************BROWSER CLOSED***************************");
		log.info("-------------------------------------------------------------------");
	}

}
