package pages.parallels.automation;

import main.TestDriver;
import org.openqa.selenium.WebElement;


public class ParallelsAutomationPage3 extends ParallelsAutomationPageBase {

	public final static String PAGE_INFO = "Parallels Automation Account Page - Subscription Management";

	public ParallelsAutomationPage3(TestDriver test) {
		super(test);
		test.logPage(PAGE_INFO);
		setFrameByName(MAIN_FRAME_NAME);
	}

	public ParallelsAutomationPage4 openSubscriptionPage() {
		subscription_link().click();
		return new ParallelsAutomationPage4(test);
	}

	private WebElement subscription_link() {
		return getElementByCss("[href*='" + domain_name + "']");
	}

}