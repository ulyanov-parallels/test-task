package pages.parallels.automation;

import main.TestDriver;
import org.openqa.selenium.WebElement;


public class ParallelsAutomationPage1 extends ParallelsAutomationPageBase {

	public final static String PAGE_INFO = "Parallels Automation Login Page";

	public ParallelsAutomationPage1(TestDriver test) {
		super(test);
		url = URL;
		test.log("url: " + url);
		test.logPage(PAGE_INFO);
		pageTitle = PAGE_TITLE;
		open();
		setFrameByName(LOGIN_FRAME_NAME);		
	}

	public ParallelsAutomationPage2 logIn() {
		test.log("LogIn");
		//username().sendKeys(test.data.get("login"));
		username().sendKeys(test.testId);		
		password().sendKeys(test.data.get("password"));
		selectComboItem(lang_combo(),LANG);
		login_button().click();
		return new ParallelsAutomationPage2(test);
	}

	private WebElement username() {
		return getElementById(USERNAME_ID);
	}

	private WebElement password() {
		return getElementById(PASSWORD_ID);
	}

	private WebElement lang_combo() {
		return getElementById(LANG_COMBO_ID);
	}

	private WebElement login_button() {
		return getElementById(LOGIN_BUTTON_ID);
	}

}