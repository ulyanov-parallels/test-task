package pages.parallels.automation;

import main.TestDriver;
import org.openqa.selenium.WebElement;


public class ParallelsAutomationPage6 extends ParallelsAutomationPageBase {

	public final static String PAGE_INFO = "Parallels Automation Exchange - Add New Mailbox Page1";

	public ParallelsAutomationPage6(TestDriver test) {
		super(test);
		test.logPage(PAGE_INFO);
		setFrameByName(MAIN_FRAME_NAME);
	}

	public void completeForm() {
		test.log("Mailbox creation form part1 completion");
		mailbox_displayname().sendKeys(test.data.get("mailbox_displayname"));
		mailbox_login().sendKeys(test.testId);
		mailbox_password().sendKeys(test.data.get("password"));
		mailbox_confirmpassword().sendKeys(test.data.get("password"));
	}

	public ParallelsAutomationPage7 openSecondMailboxCreationPage() {
		next_button().click();
		return new ParallelsAutomationPage7(test);
	}

	private WebElement mailbox_displayname() {
		return getElementById(MAILBOX_DISPLAYNAME_ID);
	}

	private WebElement mailbox_login() {
		return getElementById(MAILBOX_LOGIN_ID);
	}

	private WebElement mailbox_password() {
		return getElementByCss(MAILBOX_PASSWORD_CSS);
	}

	private WebElement mailbox_confirmpassword() {
		return getElementByCss(MAILBOX_CONFIRMPASSWORD_CSS);
	}

	private WebElement next_button() {
		return getElementByCss(NEXT_BUTTON_CSS);
	}

}