package pages.parallels.store;

import main.TestDriver;
import org.openqa.selenium.WebElement;


public class ParallelsStorePage7 extends ParallelsStorePageBase {

	public final static String PAGE_INFO = "Select Your Domain Page3 - Review";

	public ParallelsStorePage7(TestDriver test) {
		super(test);
		test.logPage(PAGE_INFO);
	}

	private WebElement neworder_button() {
		return getElementById(NEWORDER_BUTTON_ID);
	}

	public ParallelsStorePage8 openAccountAndPaymentDetailsPage() {
		neworder_button().click();
		return new ParallelsStorePage8(test);
	}

}
