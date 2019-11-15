package pages.parallels.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.base.PageBase;

import main.TestDriver;

public class ParallelsAutomationPageBase extends PageBase {

	public final static String URL = "https://cp.parallelsclouddemo.net";
	public final static String PAGE_TITLE = "Parallels® Automation";
	public final static String LANG = "English (United States)";

	// LOCATORS
	public final static String LOGIN_FRAME_NAME = "loginFrame";
	public final static String MAIN_FRAME_NAME = "mainFrame";
	public final static String TOP_FRAME_NAME = "topFrame";
	public final static String USERNAME_ID = "inp_user";
	public final static String PASSWORD_ID = "inp_password";
	public final static String LANG_COMBO_ID = "sel_lang";
	public final static String LOGIN_BUTTON_ID = "login";
	public final static String REFRESH_BUTTON_CSS = "[id*='refresh']";
	public final static String LOGOUT_LINK_ID = "_logout";
	public final static String SUBSCRIPTIONS_LINK_CSS = "a[onclick*='ToHostingSubscriptionHandler']";
	public final static String HOME_TAB_CSS = "a[onclick*='home']";
	public final static String ACCOUNT_TAB_CSS = "a[onclick*='billing']";
	public final static String EXCHANGE_TAB_CSS = "a[onclick*='exchange']";
	public final static String ADDNEWMAILBOX_BUTTON_ID = "exchange_mailboxes_admin";
	public final static String MAILBOX_DISPLAYNAME_ID = "inp_su_display_name";
	public final static String MAILBOX_LOGIN_ID = "inp_su_domain_upn";
	public final static String MAILBOX_PASSWORD_CSS = "input[id$='Wizard_password']";
	public final static String MAILBOX_CONFIRMPASSWORD_CSS = "input[id$='Wizard_confirm_password']";
	public final static String MAILBOX_LINK_ID = "exchange_mailboxes_view";
	public final static String NEXT_BUTTON_CSS = "button[id$='WizardHandler:doNext']";
	public final static String SIZE_LIMIT_ID = "inp_mailbox_size_limit";
	public final static String OWA_BOX_ID = "check_exchange_mailbox_access_HTTP";
	public final static String SUBSCRIPTION_STATUS_ID = "Status";
	public final static String MAILBOX_STATUS_ID = "indicator";

	public ParallelsAutomationPageBase(TestDriver test) {
		super(test);
	}

	public boolean verifyStatus(By elementBy, String expected_text) {
		setFrameByName(MAIN_FRAME_NAME);
		int limit = Math.round(global_timeout / timeout);
		int i = 0;
		do {
			refresh_button().click();
			i++;
			if (i > limit)
				return false;
			test.log("attempt: " + Integer.toString(i) + " / "
					+ Integer.toString(limit));
		} while (!checkCondition(elementContainsText(elementBy, expected_text)));
		return true;
	}
		
	public ParallelsAutomationPage5 openExchangePage() {
		openExchangeTab();
		return new ParallelsAutomationPage5(test);
	}

	private void openExchangeTab() {
		setFrameByName(TOP_FRAME_NAME);
		exchange_tab().click();
	}

	private WebElement exchange_tab() {
		return getElementByCss(EXCHANGE_TAB_CSS);
	}

	public ParallelsAutomationPage1 logout() {
		test.log("Logout");
		setFrameByName(TOP_FRAME_NAME);
		logout_link().click();
		return new ParallelsAutomationPage1(test);
	}

	public WebElement refresh_button() {
		return getElementByCss(REFRESH_BUTTON_CSS);
	}

	private WebElement logout_link() {
		return getElementById(LOGOUT_LINK_ID);
	}

}
