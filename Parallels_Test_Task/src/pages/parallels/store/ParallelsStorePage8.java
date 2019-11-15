package pages.parallels.store;

import main.TestDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ParallelsStorePage8 extends ParallelsStorePageBase {

	public final static String PAGE_INFO = "Checkout Page1 - Account and Payment Details";

	public ParallelsStorePage8(TestDriver test) {
		super(test);
		test.logPage(PAGE_INFO);
	}

	public void completeForm() {
		test.log("Account and Payment Details form completion");
		customer_no_radio().click();
		acc_personal_radio().click();
		login().sendKeys(test.testId);
		password().sendKeys(test.data.get("password"));
		confirm_password().sendKeys(test.data.get("password"));
		first_name().sendKeys(test.data.get("first_name"));
		last_name().sendKeys(test.data.get("last_name"));
		email().sendKeys(test.data.get("email"));
		confirm_email().sendKeys(test.data.get("email"));
		address().sendKeys(test.data.get("address"));
		city().sendKeys(test.data.get("city"));		
		selectComboItem(country_combo(),test.data.get("country"));
		waitComboUpdate(By.id(PROVINCE_COMBO_ID), test.data.get("province"));
		selectComboItem(province_combo(),test.data.get("province"));
		zip_code().sendKeys(test.data.get("zip_code"));
		phone_country().clear();
		phone_country().sendKeys(test.data.get("phone_country"));
		phone_area().sendKeys(test.data.get("phone_area"));
		phone_number().sendKeys(test.data.get("phone_number"));
		selectComboItem(card_type_combo(),test.data.get("card_type"));
		card_number().sendKeys(test.data.get("card_number"));
		selectComboItem(exp_month_combo(),test.data.get("exp_month"));
		selectComboItem(exp_year_combo(),test.data.get("exp_year"));
		cardholder_name().sendKeys(test.data.get("cardholder_name"));
		card_code().sendKeys(test.data.get("card_code"));
		use_address_cbox().click();
		accept_terms_cbox().click();
	}

	private WebElement placeorder_button() {
		return getElementById(PLCEORDER_BUTTON_ID);
	}

	private WebElement customer_no_radio() {
		return getElementById(CUSTOMER_NO_RADIO_ID);
	}

	private WebElement acc_personal_radio() {
		return getElementById(ACC_PERSONAL_RADIO_ID);
	}

	private WebElement login() {
		return getElementById(LOGIN_ID);
	}

	private WebElement password() {
		return getElementById(PASSWORD_ID);
	}

	private WebElement confirm_password() {
		return getElementById(CONFIRM_PASSWORD_ID);
	}

	private WebElement first_name() {
		return getElementById(FIRST_NAME_ID);
	}

	private WebElement last_name() {
		return getElementById(LAST_NAME_ID);
	}

	private WebElement email() {
		return getElementById(EMAIL_ID);
	}

	private WebElement confirm_email() {
		return getElementById(CONFIRM_EMAIL_ID);
	}

	private WebElement address() {
		return getElementById(ADDRESS_ID);
	}

	private WebElement city() {
		return getElementById(CITY_ID);
	}

	private WebElement country_combo() {
		return getElementById(COUNTRY_COMBO_ID);
	}

	private WebElement province_combo() {
		return getElementById(PROVINCE_COMBO_ID);
	}

	private WebElement zip_code() {
		return getElementById(ZIP_CODE_ID);
	}

	private WebElement phone_country() {
		return getElementById(PHONE_COUNTRY_ID);
	}

	private WebElement phone_area() {
		return getElementById(PHONE_AREA_ID);
	}

	private WebElement phone_number() {
		return getElementById(PHONE_NUMBER_ID);
	}

	private WebElement card_type_combo() {
		return getElementById(CARD_TYPE_COMBO_ID);
	}

	private WebElement card_number() {
		return getElementById(CARD_NUMBER_ID);
	}

	private WebElement exp_month_combo() {
		return getElementById(EXP_MONTH_COMBO_ID);
	}

	private WebElement exp_year_combo() {
		return getElementById(EXP_YEAR_COMBO_ID);
	}

	private WebElement cardholder_name() {
		return getElementById(CARDHOLDER_NAME_ID);
	}

	private WebElement card_code() {
		return getElementById(CARD_CODE_ID);
	}

	private WebElement use_address_cbox() {
		return getElementById(USE_ADDRESS_CBOX_ID);
	}

	private WebElement accept_terms_cbox() {
		return getElementById(ACCEPT_TERMS_CBOX_ID);
	}

	public ParallelsStorePage9 placeOrder() {
		placeorder_button().click();
		return new ParallelsStorePage9(test);
	}

}
