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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.base;
import PageObjects.IntelyHomePage;
import PageObjects.LoginPage;
import PageObjects.MyTeams;
import resources.ReadExcel;

public class PLCTaskTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initiallize() throws IOException {

		driver = initializeDriver();
		log.info("--------------------------------------------------------------------");
		log.info("****************DRIVER INITIALIZED PLC TASK TEST********************");
		log.info("--------------------------------------------------------------------");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	@Test
	public void plcTask() throws IOException, InterruptedException {
		ReadExcel re = new ReadExcel();
		ArrayList<String> data = re.getData("testData", "Tc5");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Step 1. Login to the Website
		LoginPage lp = new LoginPage(driver);
		IntelyHomePage ip = lp.getLogin(data.get(1), data.get(2));
		log.info("Successfully loggged in to the website");
		Thread.sleep(2000);

		// Step 2. Navigate to PLC Task
		MyTeams ms = ip.getPLCTasks();
		Thread.sleep(9000);
		ms.getSelectTeams().click();

		// Step 3. Select Team from the dropdown
		List<WebElement> liTeams = ms.getAllTeams();
		for (int i = 0; i < liTeams.size(); i++) {
			String name = liTeams.get(i).getText();
			if (name.contains(data.get(3))) {
				liTeams.get(i).click();
				break;
			}
		
		}
		
		// Step 4.
		
		Thread.sleep(5000);
		ms.getPlus().click();
		Thread.sleep(2000);
		
		//js.executeScript("document.querySelector('.MuiBox-root.jss40').scrollTop=200");
		ms.getTaskSummary().click();
		Thread.sleep(3000);
		//WebElement Element= ms.getComment();
		//js.executeScript("arguments[0].scrollIntoView();", Element);
		//js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		//js.executeScript("document.querySelector('#full-width-tabpanel-3').scrollTop=500");
		js.executeScript("arguments[0].scrollIntoView();", ms.getComment());
		js.executeScript("arguments[0].click();", ms.getComment());
		
		//js.executeScript("arguments[0].value='gcgyu';", ms.getComment());
		//ms.getComment().click();
		Thread.sleep(2000);
		System.out.println(ms.getComment().isEnabled());
		ms.getComment().sendKeys("vhhuvxxryuboijp9j9ij9puhi7frxrew");
		//js.executeScript("var element=document.querySelector('.MuiInputBase-root.MuiInputBase-fullWidth.MuiInputBase-multiline'); element.value='bhjsaj';");
	//js.executeScript("document.getElementByClassName('MuiInputBase-root MuiInputBase-fullWidth MuiInputBase-multiline').value='vjufyyt6'");
																

		
		
	}
}
