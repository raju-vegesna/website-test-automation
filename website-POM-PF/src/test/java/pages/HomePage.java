package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.BasePage;

public class HomePage extends BasePage {
	
	// explicit constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@id='menu']/li[1]/a")
	public WebElement contactMenuXpath;
	
	public ContactPage goToContactPage(WebDriver driver){
		driver.findElement(By.xpath("//*[@id='menu']/li[1]/a")).click();
		//contactMenuXpath.click();
		return PageFactory.initElements(driver, ContactPage.class);
		//return new ContactPage(driver);
		
	}
	
	
}
