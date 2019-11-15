package main;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.parallels.automation.ParallelsAutomationPage1;
import pages.parallels.automation.ParallelsAutomationPage2;
import pages.parallels.automation.ParallelsAutomationPage3;
import pages.parallels.automation.ParallelsAutomationPage4;
import pages.parallels.automation.ParallelsAutomationPage5;
import pages.parallels.automation.ParallelsAutomationPage6;
import pages.parallels.automation.ParallelsAutomationPage7;
import pages.parallels.automation.ParallelsAutomationPage8;
import pages.parallels.store.ParallelsStorePage1;
import pages.parallels.store.ParallelsStorePage2;
import pages.parallels.store.ParallelsStorePage3;
import pages.parallels.store.ParallelsStorePage4;
import pages.parallels.store.ParallelsStorePage5;
import pages.parallels.store.ParallelsStorePage6;
import pages.parallels.store.ParallelsStorePage7;
import pages.parallels.store.ParallelsStorePage8;
import pages.parallels.store.ParallelsStorePage9;

public class TestSuite1 {
	public static final String TEST_NAME = "TestSuite1";
	TestDriver test = new TestDriver(TEST_NAME);

	@BeforeSuite
	public void beforeSuite() throws Exception {
		test.start();
	}

	@Test
	public void TC1() throws Exception {		
        test.logTestCase("TC1 - Parallels Cloud Demo Store: Domain Subscription with Account Creation");        
		ParallelsStorePage1 page1 = new ParallelsStorePage1(test);
		ParallelsStorePage2 page2 = page1.openPlansPage();
		ParallelsStorePage3 page3 = page2.openSubscriptionPeriodPage();
		ParallelsStorePage4 page4 = page3.openConfigurationPage();
		ParallelsStorePage5 page5 = page4.openDomainSearchPage();
		ParallelsStorePage6 page6 = page5.searchDomainName();
		Assert.assertTrue(page6.verifyDomainAvailable(),"Domain Name is Not Available");
		ParallelsStorePage7 page7 = page6.openDomainSelectionReviewPage();
		ParallelsStorePage8 page8 = page7.openAccountAndPaymentDetailsPage();
		page8.completeForm();
		ParallelsStorePage9 page9 = page8.placeOrder();	
		Assert.assertTrue(page9.verifyOrderPlaced(),"Order is Not Placed ");		
	}

	@Test
	public void TC2() throws Exception {		
		test.logTestCase("TC2 - Parallels Automation: Domain Subscription Status Check");		
		ParallelsAutomationPage1 page1 = new ParallelsAutomationPage1(test);		
		ParallelsAutomationPage2 page2 = page1.logIn();	
		ParallelsAutomationPage3 page3 = page2.openAccountPage();	
		ParallelsAutomationPage4 page4 = page3.openSubscriptionPage();	
		Assert.assertTrue(page4.verifySubscriptionStatus(),"Status: Not Active. ");		
		page4.logout();
	}

	@Test
	public void TC3() throws Exception {		
		test.logTestCase("TC3 - Parallels Automation: Mailbox Creation with Status Check");		
		ParallelsAutomationPage1 page1 = new ParallelsAutomationPage1(test);		
		ParallelsAutomationPage2 page2 = page1.logIn();		
		ParallelsAutomationPage5 page3 = page2.openExchangePage();	
		Assert.assertTrue(page3.verifyMailboxCreationEnabled(),"Mailbox Creation is Disabled");
		ParallelsAutomationPage6 page4 = page3.addNewMailbox();
		page4.completeForm();
		ParallelsAutomationPage7 page5 = page4.openSecondMailboxCreationPage();
		page5.completeForm();
		ParallelsAutomationPage5 page6 = page5.finishMailboxCreation();		
		ParallelsAutomationPage8 page7 = page6.openMailboxPage();  	
		Assert.assertTrue(page7.verifyMailboxStatus(),"Status: Not Ready. ");	
		page7.logout();
	}

	@AfterSuite
	public void afterSuite() throws Exception {
		test.stop();
	}

}
