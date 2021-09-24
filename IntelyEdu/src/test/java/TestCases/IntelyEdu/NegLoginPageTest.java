package TestCases.IntelyEdu;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.base;
import PageObjects.LoginPage;
import junit.framework.Assert;

public class NegLoginPageTest extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("--------------------------------------------------------------------");
		log.info("***********DRIVER INITIALIZED IN NEGATIVE LOGIN TEST PAGE***********");
		log.info("--------------------------------------------------------------------");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void negativeLoginTest() {
		LoginPage lp = new LoginPage(driver);

		try {
			lp.getSubmit().click();

		} catch (Exception e) {
			throw new AssertionError("", e);
		}
		// Username Alert message
		try {
			Assert.assertEquals(lp.getAlertMsgUsername().getText(), "Please Enter User Name");
			log.info("Username error validation: "+lp.getAlertMsgUsername().getText());
			System.out.println(lp.getAlertMsgUsername().getText());
		} catch (Exception e) {
			log.error("Enter password validation failure error message");
			throw new AssertionError("Enter username validation failure error message", e);
		}
		try {
			Assert.assertEquals(lp.getAlertMsgPassword().getText(), "Please Enter password");
			log.info("Password error validation: "+lp.getAlertMsgPassword().getText());
			System.out.println(lp.getAlertMsgPassword().getText());
		} catch (Exception e) {
			log.error("Enter password validation failure error message");
			throw new AssertionError("Enter password validation failure error message", e);

		}

	}
	@AfterTest
	public void teardown() {
		driver.close();
		log.info("-------------------------------------------------------------------");
		log.info("**************************BROWSER CLOSED***************************");
		log.info("-------------------------------------------------------------------");
	}
}