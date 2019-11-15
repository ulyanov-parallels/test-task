package pages.parallels.store;

import main.TestDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ParallelsStorePage6 extends ParallelsStorePageBase {

	public final static String PAGE_INFO = "Select Your Domain Page2 - Domain Selection";

	public ParallelsStorePage6(TestDriver test) {
		super(test);
		test.logPage(PAGE_INFO);
	}

	public boolean verifyDomainAvailable() {
		test.log("Domain availability verification:");
		boolean result = verifyElementText(By.cssSelector(AVAILABILITY_LABEL_CSS), "Available");
		test.logResult(result);
		return result;
	}

	public ParallelsStorePage7 openDomainSelectionReviewPage() {
		addtocard_button().click();
		return new ParallelsStorePage7(test);
	}

	private WebElement addtocard_button() {
		return getElementById(ADDTOCARD_BUTTON_ID);
	}

}
