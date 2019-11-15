package pages.parallels.store;

import main.TestDriver;
import org.openqa.selenium.WebElement;


public class ParallelsStorePage4 extends ParallelsStorePageBase {

	public final static String PAGE_INFO = "Productivity Bundles Page2 - Configuration";

	public ParallelsStorePage4(TestDriver test) {
		super(test);
		test.logPage(PAGE_INFO);
		verifyPageLoaded(blackberry_input());
	}

	public ParallelsStorePage5 openDomainSearchPage() {
		continue_button().click();
		return new ParallelsStorePage5(test);
	}

	private WebElement blackberry_input() {
		return getElementById(BLACKBERRY_INPUT_ID);
	}

}