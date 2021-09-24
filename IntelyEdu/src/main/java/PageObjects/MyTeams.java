package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class MyTeams  {
	public WebDriver driver;

	public MyTeams(WebDriver driver) {
		this.driver = driver;
	}

	By selectTeams = By.xpath("//div[@id='demo-simple-select-outlined']");
	By allTeams = By.cssSelector("[role='option']");
	By newMinute = By.xpath("//span[normalize-space()='New Minutes']");
	By description = By.xpath("//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']");
	By description2 = By.xpath("(//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr'])[2]");
	By addTopic = By.xpath("//div[6]//div[1]//button[1]//*[local-name()='svg']");
	By addTask = By.xpath("//div[8]//div[1]//button[1]//*[local-name()='svg']");
	By dateTask = By.className("react-datepicker__input-container");
	By dateAchievement = By.xpath("(//div[(@class='react-datepicker__input-container')])[2]");
	By taskDesc = By.xpath("//textarea[@id='[object Object]']");
	By addAchievement = By.xpath("//div[10]//div[1]//button[1]//*[local-name()='svg']");
	By achievementDesc = By.xpath("//textarea[@id='0']");
	By saveButton = By.xpath("//p[normalize-space()='Save']");
	By addEditMember = By.xpath("//p[normalize-space()='Add/Edit Members']");
	By selectRole1 = By.xpath("(//div[text()='Select Role'])");
	By selectRole2 = By.xpath("(//div[text()='Select Role'])[2]");
	By selectRole3 = By.xpath("(//div[text()='Select Role'])[3]");
	By selectRole4 = By.xpath("(//div[text()='Select Role'])[4]");
	By present = By.cssSelector("[title='Mark Present']");
	By search = By.xpath("//input[@type='text']");
	By leftArrow = By.xpath(
			"//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']//span[@class='MuiIconButton-label']//*[local-name()='svg']");
	By viewOwner = By.xpath("//p[normalize-space()='View Owner']");
	By ownerList = By.cssSelector("[type='checkbox']");
	By savOwner = By.xpath("//span[contains(text(),'Save')]");
	By date1 = By.xpath("//div[@class='react-datepicker__input-container']");
	By date2 = By.xpath("(//div[@class='react-datepicker__input-container'])[2]");
	// By month = By.xpath("//div[@class='react-datepicker__month']");
	By saveLater = By.xpath("//p[text()='Save For Later']");
	// List<WebElement> w =
	// driver.findElements(By.xpath("(//div[normalize-space()='Select Role'])"));
	// String l = "(//div[normalize-space()='Select Role'])";
	By alertMsg = By.cssSelector("[id='client-snackbar']");
	By plus = By.xpath("(//div[@id='panel1bh-header'])[1]");
	By taskSummary = By.xpath(
			"//div[@class='MuiCollapse-container MuiCollapse-entered']//p[@class='MuiTypography-root MuiTypography-body1'][normalize-space()='Task Summary']");
	By comment = By.xpath("(//div[@class='MuiInputBase-root MuiInputBase-fullWidth MuiInputBase-multiline'])[1]");

	public WebElement getComment() {
		return driver.findElement(comment);
	}

	public WebElement getTaskSummary() {
		return driver.findElement(taskSummary);
	}

	public WebElement getPlus() {
		return driver.findElement(plus);
	}

	public WebElement getAlertMsg() {
		return driver.findElement(alertMsg);
	}

	public WebElement getSaveLater() {
		return driver.findElement(saveLater);
	}

	public WebElement getDate1() {
		return driver.findElement(date1);
	}

	public WebElement getDate2() {
		return driver.findElement(date2);
	}

	public List<WebElement> getOwnerList() {
		return driver.findElements(ownerList);
	}

	public WebElement getSavOwner() {
		return driver.findElement(savOwner);
	}

	public WebElement getViewOwner() {
		return driver.findElement(viewOwner);
	}

	public WebElement getLeftArrow() {
		return driver.findElement(leftArrow);
	}

	public WebElement getSearch() {
		return driver.findElement(search);
	}

	public List<WebElement> getPresent() {
		return driver.findElements(present);
	}

	public WebElement getSelectRole1() {
		return driver.findElement(selectRole1);
	}

	public WebElement getSelectRole2() {
		return driver.findElement(selectRole2);
	}

	public WebElement getSelectRole3() {
		return driver.findElement(selectRole3);
	}

	public WebElement getSelectRole4() {
		return driver.findElement(selectRole4);
	}

	public WebElement getSelectTeams() {

		return driver.findElement(selectTeams);

	}

	public WebElement getAddEditMember() {
		return driver.findElement(addEditMember);
	}

	public List<WebElement> getAllTeams() {
		return driver.findElements(allTeams);
	}

	public WebElement getNewMinute() {
		return driver.findElement(newMinute);
	}

	public WebElement getDescription() {
		return driver.findElement(description);
	}

	public WebElement getDescription2() {
		return driver.findElement(description2);
	}

	public WebElement getAddTopic() {
		return driver.findElement(addTopic);
	}

	public WebElement getAddTask() {
		return driver.findElement(addTask);
	}

	public WebElement getTaskDesc() {
		return driver.findElement(taskDesc);
	}

	public WebElement getAddAchievement() {
		return driver.findElement(addAchievement);
	}

	public WebElement getAchievementDesc() {
		return driver.findElement(achievementDesc);
	}

	public WebElement getSaveButton() {
		return driver.findElement(saveButton);
	}

	public WebElement getDateTask() {
		return driver.findElement(dateTask);
	}

	public WebElement getDateAchievement() {
		return driver.findElement(dateAchievement);
	}

	public WebElement getDateAchievment() {
		return driver.findElement(saveButton);
	}

	public void getTeam(String strTeamName) throws InterruptedException {
		
		getSelectTeams().click();
		Thread.sleep(2000);
		
		List<WebElement> liTeams = getAllTeams();
		for (int i = 0; i < liTeams.size(); i++) {
			String name = liTeams.get(i).getText();
			if (name.contains(strTeamName)) {
				liTeams.get(i).click();
				break;
			}
		}
		
		
		
	}
}
