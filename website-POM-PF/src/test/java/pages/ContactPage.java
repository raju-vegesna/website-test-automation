package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;

public class ContactPage extends BasePage {

	// explicit constructor
	public ContactPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "ctl00_MainContent_NameBox")
	public WebElement nameFieldId;

	@FindBy(id = "ctl00_MainContent_EmailBox")
	public WebElement emailFieldId;

	@FindBy(id = "ctl00_MainContent_MessageBox")
	public WebElement msgFieldId;

	@FindBy(id = "ctl00_MainContent_SendButton")
	public WebElement sendButtonId;

	@FindBy(id = "ctl00_MainContent_rfvName")
	public WebElement nameError;

	@FindBy(id = "ctl00_MainContent_rfvEmailAddress")
	public WebElement emailError;

	@FindBy(id = "ctl00_MainContent_revEmailAddress")
	public WebElement emailInvalid;

	@FindBy(id = "ctl00_MainContent_rfvMessage")
	public WebElement msgError;

	public ContactPage setNameField(String value) {
		nameFieldId.sendKeys(value);
		return this;
	}

	public ContactPage setEmailField(String value) {
		emailFieldId.sendKeys(value);
		return this;
	}

	public ContactPage setMsgField(String value) {
		msgFieldId.sendKeys(value);
		return this;
	}

	public ContactPage clickSend() {
		sendButtonId.click();
		return new ContactPage(driver);
	}

	public String verifyErrorText(String fieldType) {

		String errorText = null;

		if (fieldType == "name") {
			errorText = nameError.getText();
		} else if (fieldType == "email") {
			errorText = emailError.getText();
		} else if (fieldType == "msg") {
			errorText = msgError.getText();
		} else if (fieldType == "invalid") {
			errorText = emailInvalid.getText();
		}

		return errorText;
	}

}
