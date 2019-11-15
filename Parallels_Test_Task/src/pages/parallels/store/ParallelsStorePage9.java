package pages.parallels.store;

import main.TestDriver;
import org.openqa.selenium.By;

public class ParallelsStorePage9 extends ParallelsStorePageBase {

	public final static String PAGE_INFO = "Checkout Page2 - Confirmation";

	public ParallelsStorePage9(TestDriver test) {
		super(test);
		test.logPage(PAGE_INFO);
	}

	public boolean verifyOrderPlaced() {
		test.log("Order is placed verification: ");
		boolean result = verifyElementContainsText(By.cssSelector(CONFIRMATION_MESSAGE_CSS), "Your Order is placed");
		test.logResult(result);
		return result;
	}

}
