package pages.parallels.store;

import main.TestDriver;
import org.openqa.selenium.WebElement;


public class ParallelsStorePage3 extends ParallelsStorePageBase {

	public final static String PAGE_INFO = "Productivity Bundles Page1 - Subscription Period";

	public ParallelsStorePage3(TestDriver test) {
		super(test);
		test.logPage(PAGE_INFO);
		verifyPageLoaded(month_radio());
	}

	public ParallelsStorePage4 openConfigurationPage() {
		continue_button().click();
		return new ParallelsStorePage4(test);
	}

	private WebElement month_radio() {
		return getElementById(MONTH_RADIO_ID);
	}

}
