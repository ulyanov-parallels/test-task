package pages.parallels.automation;

import org.openqa.selenium.By;


import main.TestDriver;

public class ParallelsAutomationPage4 extends ParallelsAutomationPageBase {

	public final static String PAGE_INFO = "Parallels Automation Account Page - Subscription General";

	public ParallelsAutomationPage4(TestDriver test) {
		super(test);
		test.logPage(PAGE_INFO);
		setFrameByName(MAIN_FRAME_NAME);
	}

	public boolean verifySubscriptionStatus() {
		test.log("Subscription status verification:");
		boolean result = verifyStatus(By.id(SUBSCRIPTION_STATUS_ID), "Active");
		test.logResult(result);
		return result;
	}

}
