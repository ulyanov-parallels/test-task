package pages.parallels.automation;

import org.openqa.selenium.By;


import main.TestDriver;

public class ParallelsAutomationPage8 extends ParallelsAutomationPageBase {

	public final static String PAGE_INFO = "Parallels Automation Exchange - Mailbox General Page";

	public ParallelsAutomationPage8(TestDriver test) {
		super(test);
		test.logPage(PAGE_INFO);
		setFrameByName(MAIN_FRAME_NAME);
	}

	public boolean verifyMailboxStatus() {
		test.log("Mailbox status verification:");
		boolean result = verifyStatus(By.id(MAILBOX_STATUS_ID), "Ready");
		test.logResult(result);
		return result;
	}

}
