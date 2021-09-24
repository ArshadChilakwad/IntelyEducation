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
import PageObjects.LoginPage;
import resources.ReadExcel;

public class HomePageTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initiallize() throws IOException {

		driver = initializeDriver();
		log.info("--------------------------------------------------------------------");
		log.info("****************DRIVER INITIALIZED IN HOME TEST PAGE*****************");
		log.info("--------------------------------------------------------------------");
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	@Test
	public void validInputs() throws IOException, InterruptedException {
		
		ReadExcel re = new ReadExcel();
		ArrayList<String> data = re.getData("testData", "Tc1");
		
		LoginPage lgp = new LoginPage(driver);
		lgp.getUsername().sendKeys(data.get(1));
		log.info("Entered Username "+ data.get(1));
		lgp.getPassword().sendKeys(data.get(2));
		log.info("Entered Password "+ data.get(2));
		lgp.getSubmit().click();
		log.info("Clicked on submit");

		LoginPage lp = new LoginPage(driver);
		lp.getSettings().click();
		log.info("Clicked on admin setting");
		lp.getLogout().click();
		log.info("Clicked on logout");
		lp.getYes().click();
		log.info("Successfully logged out");
		

	}
	@AfterTest
	public void teardown() {
		driver.close();
		log.info("--------------------------------------------------------------------");
		log.info("*************************BROWSER IS CLOSED**************************");
		log.info("--------------------------------------------------------------------");
	}
}
