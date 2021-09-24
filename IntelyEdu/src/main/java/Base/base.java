package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver wait;
	public String projectPath;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		projectPath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(
				projectPath+"//src//main//java//resources//data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName == "IE") {
			// IE code
		}

		else if (browserName.equals("firefox")) {
			// firefox code
			System.setProperty("webdriver.gecko.driver", projectPath+"//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

	/*
	 * @SuppressWarnings("deprecation") public void waitForPageLoaded() {
	 * ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
	 * public Boolean apply(WebDriver driver) { return ((JavascriptExecutor)
	 * driver).executeScript("return document.readyState").toString().equals(
	 * "complete"); } }; try { Thread.sleep(1000); WebDriverWait wait = new
	 * WebDriverWait(driver, 30); wait.until(expectation); } catch (Throwable error)
	 * { Assert.fail("Timeout waiting for Page Load Request to complete."); } }
	 */

}
