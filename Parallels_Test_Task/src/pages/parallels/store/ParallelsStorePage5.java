package pages.parallels.store;

import main.TestDriver;
import org.openqa.selenium.WebElement;


public class ParallelsStorePage5 extends ParallelsStorePageBase {

	public final static String PAGE_INFO = "Select Your Domain Page1 - Domain Search";

	public ParallelsStorePage5(TestDriver test) {
		super(test);
		test.logPage(PAGE_INFO);
	}

	public ParallelsStorePage6 searchDomainName() {
		test.log("Search Domain Name: " + domain_name);
		search_input().sendKeys(domain_name);
		search_button().click();
		return new ParallelsStorePage6(test);
	}

	private WebElement search_button() {
		return getElementById(SEARCH_BUTTON_ID);
	}

	private WebElement search_input() {
		return getElementById(SEARCH_INPUT_ID);
	}

}