package pages.parallels.store;

	import org.openqa.selenium.WebElement;

import pages.base.PageBase;



import main.TestDriver;

	public class ParallelsStorePageBase extends PageBase {

		public final static String URL = "http://parallelsclouddemo.net";
		public final static String PAGE_TITLE = "Parallels Cloud Demo Store";
		
		//LOCATORS
		public final static String COMM_COLL_TAB_CSS = "[href$='PRODUCTIVITY_PATH']";
		public final static String BUY_BUTTON_CSS = "a[href*='3673']";
		public final static String MONTH_RADIO_ID ="PeriodPlanID_3673";
		public final static String CONTINUE_BUTTON_ID = "editplan_buttonContinue";
		public final static String BLACKBERRY_INPUT_ID ="ExtRateAmount[11][_4058_]";
		public final static String SEARCH_INPUT_ID = "new_DomainNameID";
		public final static String SEARCH_BUTTON_ID = "dm_create_Button";
		public final static String AVAILABILITY_LABEL_CSS = "[class='tableSelectDomainList'] tr:nth-child(1) td:nth-child(3)";
		public final static String ADDTOCARD_BUTTON_ID = "AddToCard";		
		public final static String NEWORDER_BUTTON_ID = "neworderButton_next";		
		public final static String PLCEORDER_BUTTON_ID = "apt";
		public final static String CUSTOMER_NO_RADIO_ID = "AuthModeNo";
		public final static String ACC_PERSONAL_RADIO_ID = "AccModePersonal";
		public final static String LOGIN_ID = "LoginID";
		public final static String PASSWORD_ID = "PasswordID";
		public final static String CONFIRM_PASSWORD_ID = "Password2ID";
		public final static String FIRST_NAME_ID = "FirstNameID";
		public final static String LAST_NAME_ID = "LastNameID";
		public final static String EMAIL_ID = "EmailID";
		public final static String CONFIRM_EMAIL_ID = "Email2ID";
		public final static String ADDRESS_ID = "AddressID";
		public final static String CITY_ID = "CityID";
		public final static String COUNTRY_COMBO_ID = "CountryID";
		public final static String PROVINCE_COMBO_ID = "StateID";
		public final static String ZIP_CODE_ID = "ZipID";
		public final static String PHONE_COUNTRY_ID = "country_Phone";
		public final static String PHONE_AREA_ID = "area_Phone";
		public final static String PHONE_NUMBER_ID = "number_Phone";
		public final static String CARD_TYPE_COMBO_ID = "NewCardTypeID";
		public final static String CARD_NUMBER_ID = "CardNumberID";
		public final static String EXP_MONTH_COMBO_ID = "id__ExpirationDateMonth";
		public final static String EXP_YEAR_COMBO_ID = "id__ExpirationDateYear";
		public final static String CARDHOLDER_NAME_ID = "CardHolderNameID";
		public final static String CARD_CODE_ID = "CvvID";
		public final static String USE_ADDRESS_CBOX_ID = "UseContactData";
		public final static String ACCEPT_TERMS_CBOX_ID = "AgreementID";	
		public final static String CONTROL_PANEL_LINK_CSS = "[onclick*='LoginToCP']";
		public final static String CONFIRMATION_MESSAGE_CSS = "[class*='OrderConfirmation']";

		public ParallelsStorePageBase(TestDriver test) {
			super(test);
		}
				
		public WebElement comm_coll_tab() {
			return getElementByCss(COMM_COLL_TAB_CSS);
		}
		
		public WebElement continue_button() {
			return getElementById(CONTINUE_BUTTON_ID);
		}

	}