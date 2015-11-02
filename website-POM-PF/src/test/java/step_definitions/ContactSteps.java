package step_definitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ContactPage;
import pages.HomePage;

public class ContactSteps {

	WebDriver driver;
	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	ContactPage contactPage = PageFactory.initElements(driver, ContactPage.class);

	@Before
	public void setup() {
		// System.out.println("--- @Before annotation running ---");
		driver = new FirefoxDriver();
	}
	
	@After
	public void tearDown(){
		driver.close();
	}

	@Given("^I am on the QAWorks Staging Site$")
	public void i_am_on_the_QAWorks_Staging_Site() throws Throwable {
		// System.out.println("--- @Given is running ---");
		driver.get("http://staging.qaworks.com:1403");
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	}

	@Then("^I should be able to contact QAWorks with the following information$")
	public void i_should_be_able_to_contact_QAWorks_with_the_following_information(DataTable table) throws Throwable {
		// System.out.println("--- @Then is running ---");

		List<List<String>> data = table.raw();

		// click on Contact link
		contactPage = homePage.goToContactPage(driver);

		contactPage.setNameField(data.get(0).get(1));
		contactPage.setEmailField(data.get(1).get(1));
		contactPage.setMsgField(data.get(2).get(1));
		contactPage = contactPage.clickSend();

		// closing the browser
		driver.close();
	}

}
