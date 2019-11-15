package pages.parallels.store;

import main.TestDriver;

public class ParallelsStorePage1 extends ParallelsStorePageBase {

	public final static String PAGE_INFO = "Parallels Cloud Demo Store Main Page";

	public ParallelsStorePage1(TestDriver test) {
		super(test);
		url = URL;
		test.log("url: " + url);
		test.logPage(PAGE_INFO);
		pageTitle = PAGE_TITLE;
		open();
	}

	public ParallelsStorePage2 openPlansPage() {
		comm_coll_tab().click();
		return new ParallelsStorePage2(test);
	}

}
