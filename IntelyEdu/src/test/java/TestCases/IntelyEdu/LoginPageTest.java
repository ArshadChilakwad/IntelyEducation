package TestCases.IntelyEdu;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.base;
import PageObjects.LoginPage;
import junit.framework.Assert;

public class LoginPageTest extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("--------------------------------------------------------------------");
		log.info("**************DRIVER INITIALIZED IN LOGIN TEST PAGE*****************");
		log.info("--------------------------------------------------------------------");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "getData")
	public void invalidInputs(String username, String password) throws IOException, InterruptedException {

		LoginPage lgp = new LoginPage(driver);

		lgp.getUsername().clear();
		lgp.getUsername().sendKeys(username);
		Thread.sleep(5000);
		lgp.getPassword().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		lgp.getPassword().sendKeys(password);
		lgp.getSubmit().click();

		WebElement l = driver.findElement(By.xpath("//div[@role='alert']//div[1]"));
		WebDriverWait wa = new WebDriverWait(driver, 4);
		wa.until(ExpectedConditions.visibilityOf(l));

		String msg = driver.findElement(By.xpath("//div[@role='alert']//div[1]")).getText();
		System.out.println(msg);

		String expectedText = "Username/Password is invalid";

		if (msg.equals(expectedText)) {

			Assert.assertTrue(false);

		} else {
			Assert.assertTrue(true);
		}
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		// Login with invalid Username and valid password
		log.info("Login with Invalid Username and Valid Password");
		data[0][0] = "hjsd";
		data[0][1] = "admin123";

		// Login with valid Username and invalid password
		log.info("Login with Valid Username and Invalid Password");
		data[1][0] = "admin";
		data[1][1] = "adm123 ";

		// Login with invalid Username and invalid password
		log.info("Login with Invalid Username and Invalid Password");
		data[2][0] = "adminhds,j";
		data[2][1] = "admin123";

		return data;

	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("--------------------------------------------------------------------");
		log.info("**************************BROWSER CLOSED****************************");
		log.info("--------------------------------------------------------------------");
	}

}
