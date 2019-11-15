package pages.parallels.store;

import main.TestDriver;
import org.openqa.selenium.WebElement;


public class ParallelsStorePage2 extends ParallelsStorePageBase {

	public final static String PAGE_INFO = "Business Productivity Plans Page";

	public ParallelsStorePage2(TestDriver test) {
		super(test);
		test.logPage(PAGE_INFO);
	}

	public ParallelsStorePage3 openSubscriptionPeriodPage() {
		buy_button().click();
		return new ParallelsStorePage3(test);
	}

	private WebElement buy_button() {
		return getElementByCss(BUY_BUTTON_CSS);
	}

}