package pages.parallels.automation;

import main.TestDriver;
import org.openqa.selenium.WebElement;


public class ParallelsAutomationPage2 extends ParallelsAutomationPageBase {

	public final static String PAGE_INFO = "Parallels Automation Home Page";

	public ParallelsAutomationPage2(TestDriver test) {
		super(test);
		test.logPage(PAGE_INFO);
		setFrameByName(MAIN_FRAME_NAME);
	}

	public ParallelsAutomationPage3 openAccountPage() {
		subscriptions_link().click();
		return new ParallelsAutomationPage3(test);
	}

	private WebElement subscriptions_link() {
		return getElementByCss(SUBSCRIPTIONS_LINK_CSS);
	}

}
