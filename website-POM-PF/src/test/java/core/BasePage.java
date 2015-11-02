package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {

	protected final WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		
		//driver = new FirefoxDriver();
		//driver.get("http://staging.qaworks.com:1403");
		//driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	}
	
}
