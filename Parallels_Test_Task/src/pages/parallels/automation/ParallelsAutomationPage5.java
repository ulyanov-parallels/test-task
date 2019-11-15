package pages.parallels.automation;

import main.TestDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ParallelsAutomationPage5 extends ParallelsAutomationPageBase {

	public final static String PAGE_INFO = "Parallels Automation Exchange - Mailboxes Page";

	public ParallelsAutomationPage5(TestDriver test) {
		super(test);
		test.logPage(PAGE_INFO);
		setFrameByName(MAIN_FRAME_NAME);
	}
	
	public boolean verifyMailboxCreationEnabled() {
	return 	verifyStatus(By.id(ADDNEWMAILBOX_BUTTON_ID), "Add New Mailbox");
	}

	public ParallelsAutomationPage6 addNewMailbox() {
		addnewmailbox_button().click();
		return new ParallelsAutomationPage6(test);
	}

	public ParallelsAutomationPage8 openMailboxPage() {
		mailbox_link().click();
		return new ParallelsAutomationPage8(test);
	}

	private WebElement addnewmailbox_button() {
		return getElementById(ADDNEWMAILBOX_BUTTON_ID);
	}

	private WebElement mailbox_link() {
		return getElementById(MAILBOX_LINK_ID);
	}
	
}