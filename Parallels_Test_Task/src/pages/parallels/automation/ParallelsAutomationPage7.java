package pages.parallels.automation;

import main.TestDriver;
import org.openqa.selenium.WebElement;


public class ParallelsAutomationPage7 extends ParallelsAutomationPageBase {

	public final static String PAGE_INFO = "Parallels Automation Exchange - Add New Mailbox Page2";

	public ParallelsAutomationPage7(TestDriver test) {
		super(test);
		test.logPage(PAGE_INFO);
		setFrameByName(MAIN_FRAME_NAME);
	}

	public void completeForm() {
		test.log("Mailbox creation form part2 completion");
		size_limit().sendKeys(test.data.get("mailbox_sizelimit"));
		owa_box().click();
	}

	public ParallelsAutomationPage5 finishMailboxCreation() {
		finish_button().click();
		return new ParallelsAutomationPage5(test);
	}

	private WebElement size_limit() {
		return getElementById(SIZE_LIMIT_ID);
	}

	private WebElement owa_box() {
		return getElementById(OWA_BOX_ID);
	}

	private WebElement finish_button() {
		return getElementByCss(NEXT_BUTTON_CSS);
	}

}
