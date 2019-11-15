package pages.base;

import java.util.List;

import main.TestDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	public TestDriver test;
	public WebDriver driver;
	public int timeout;
	public int global_timeout;
	public String url;
	public String pageTitle;
	public WebElement loadVerificationElement;
	public String domain_name;

	public PageBase(TestDriver test) {
		this.test = test;
		driver = test.driver;
		timeout = test.timeout;
		global_timeout = test.global_timeout;
		domain_name = test.testId + "-" + test.data.get("domain_name");
	}

	public void open() {
		navigate();
		waitPageTitle();
	}

	private void navigate() {
		driver.get(url);
	}

	private boolean waitPageTitle() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.titleContains(pageTitle));
	}

	public boolean verifyPageLoaded(WebElement el) {
		return el.isDisplayed();
	}

	public WebElement getElementById(String id) {
		return findElement(By.id(id));
	}

	public WebElement getElementByName(String name) {
		return findElement(By.name(name));
	}

	public WebElement getElementByCss(String css) {
		return findElement(By.cssSelector(css));
	}

	public WebElement findElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void setFrameByName(String name) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(getElementByName(name));
	}

	public boolean verifyElementText(By elementBy, String expected_text) {
		return checkCondition(elementTextEquals(elementBy, expected_text));
	}

	public boolean verifyElementContainsText(By elementBy, String expected_text) {
		return checkCondition(elementContainsText(elementBy, expected_text));
	}

	public Boolean checkCondition(ExpectedCondition<Boolean> expCondition) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(expCondition);
		} catch (Exception e) {
			return false;
		}
	}

	public ExpectedCondition<Boolean> elementTextEquals(final By elementBy,
			final String text) {
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					String actual_text = findElement(elementBy).getText();
					test.log("actual text = " + actual_text);
					return actual_text.equalsIgnoreCase(text);
				} catch (Exception e) {
					return false;
				}
			}
		};
	}

	public ExpectedCondition<Boolean> elementContainsText(final By elementBy,
			final String text) {
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					String actual_text = findElement(elementBy).getText();
					test.log("actual text = " + actual_text);
					return actual_text.contains(text);
				} catch (Exception e) {
					return false;
				}
			}
		};
	}

	public void selectComboItem(WebElement el, String text) {
		Select selectObject = new Select(el);
		selectObject.selectByVisibleText(text);
	}

	public void waitComboUpdate(By comboBy, String option_text) {
		test.log("Waiting for combo option value: " + option_text);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		;
		checkCondition(comboHasOption(comboBy, option_text));
	}

	private ExpectedCondition<Boolean> comboHasOption(final By comboBy,
			final String option_text) {
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					boolean result = false;
					Select select = new Select(findElement(comboBy));
					List<WebElement> options = select.getOptions();
					String option_value;
					for (int i = 0; i < options.size(); i++) {
						option_value = options.get(i).getAttribute("value");
						if (option_value.equals(option_text)) {
							result = true;
							test.log(Integer.toString(i) + " option value = "
									+ option_value);
							test.log("Matched");
						}
					}
					return result;
				} catch (Exception e) {
					return false;
				}
			}
		};
	}

}
