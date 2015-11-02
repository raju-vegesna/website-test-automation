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

public class ContactSteps_v2 {

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

/*	@Given("^I am on the QAWorks Staging Site$")
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
*/
	@And("^I am on contact page$")
	public void i_am_on_contact_page() throws Throwable {
		contactPage = homePage.goToContactPage(driver);
	}

	@When("^I enter wrong email format$")
	public void i_enter_wrong_email_format(DataTable table) throws Throwable {
		// System.out.println("--- @When is running ---");

		List<List<String>> data = table.raw();

		// click on Contact link
		contactPage = homePage.goToContactPage(driver);

		// enter form details
		contactPage.setNameField(data.get(0).get(1));
		contactPage.setEmailField(data.get(1).get(1));
		contactPage.setMsgField(data.get(2).get(1));
		contactPage.clickSend();

	}

	@When("^I miss some input data \"([^\"]*)\" or \"([^\"]*)\" or \"([^\"]*)\" in the form$")
	public void i_miss_some_input_data_on_form(String name, String email, String msg) throws Throwable {
		System.out.println(name + "," + email + "," + msg);
		contactPage.setNameField(name);
		contactPage.setEmailField(email);
		contactPage.setMsgField(msg);
		contactPage.clickSend();
	}

	@Then("^I should be able to see ([^\"]*) msg$")
	public void i_should_be_able_to_see_error_msg(String error) throws Throwable {
		System.out.println(error);
		//contactPage.verifyErrorText(fieldType)
		//Assert.assertTrue(message, condition);
		
	}

	@Then("^the form will not be submitted$")
	public void the_form_will_not_be_submitted() throws Throwable {

	}

}
