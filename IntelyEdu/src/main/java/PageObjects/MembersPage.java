package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MembersPage {
public WebDriver  driver;
	
	public MembersPage(WebDriver driver) {
		this.driver=driver;
		
		
	}		
    By searchMember = By.xpath("//input[@type='text']");
 
    By addMember = By.xpath("//span[normalize-space()='>']");
    
    By members = By.cssSelector("[type='checkbox']");
    
    public WebElement getSearch() {
    	return driver.findElement(searchMember);
    }
   
    public List<WebElement> getMembers() {
    	return driver.findElements(members);
    }
    public WebElement getAddMember() {
    	return driver.findElement(addMember);
    }
    
    
   
}
