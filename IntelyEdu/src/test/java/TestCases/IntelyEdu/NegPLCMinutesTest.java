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
import PageObjects.MyTeams;
import junit.framework.Assert;
import resources.ReadExcel;

public class NegPLCMinutesTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("--------------------------------------------------------------------");
		log.info("***********DRIVER INITIALIZED IN NEGATIVE CLASSS SETUP PAGE**********");
		log.info("--------------------------------------------------------------------");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void negativePLCMinutes() throws IOException, InterruptedException {
		ReadExcel re = new ReadExcel();
		ArrayList<String> data = re.getData("testData", "Tc1");

		LoginPage lgp = new LoginPage(driver);

		// 1. Login to the website
		IntelyHomePage ip = lgp.getLogin(data.get(1), data.get(2));
		try {
			Assert.assertNotNull(ip);
			System.out.println("page not null");
		} catch (Exception e) {
			throw new AssertionError("Login validation failure error message", e);
		}

		log.info("Successfully logged in to the website");
		
		MyTeams ms = ip.getPLCMinButton();
		Thread.sleep(7000);

		log.info("Navigated to PLC Minutes Page");
		
		Thread.sleep(12000);
		ms.getNewMinute().click();
		Thread.sleep(5000);

		ms.getSaveButton().click();

		try {
			System.out.println(ms.getAlertMsg().getText());
			Assert.assertEquals(ms.getAlertMsg().getText(), "Please Select atleast one Team Leader");
			log.info("Cannot leave field empty: " + ms.getAlertMsg().getText());
		} catch (Exception e) {
			throw new AssertionError("New minutes creation Validation error message", e);
		}
		Thread.sleep(5000);
		log.info("Verified the eroor message");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("--------------------------------------------------------------------");
		log.info("*************************BROWSER CLOSED*****************************");
		log.info("--------------------------------------------------------------------");
	}
	
}
