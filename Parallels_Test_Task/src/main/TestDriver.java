package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class TestDriver {

	public WebDriver driver;
	public String browser_name;
	public int global_timeout;
	public int timeout;
	public String config_file_path;
	public String config_file_name;
	public Map<String, String> config;
	public String data_file_path;
	public String data_file_name;
	public String file_ext;
	public String data_file;
	public String config_file;
	public String test_id_file;
	public Map<String, String> data;
	public Map<String, String> test_id_data;
	public String timeStamp;
	public String dateStamp;
	public String test_name;
	public String test_date;
	public int testNumber;
	public String test_id_prefix;
	public String testId;

	public TestDriver(String test_name) {
		this.test_name = test_name;
		config_file_path = "config\\";
		config_file_name = "global_config";
		data_file_path = "data\\";
		data_file_name = test_name + "_data";
		file_ext = ".properties";
		data_file = data_file_path + data_file_name + file_ext;
		config_file = config_file_path + config_file_name + file_ext;
		test_id_file = config_file_path + "test_id" + file_ext;
		config = readFile(config_file);
		data = readFile(data_file);
		test_id_data = readFile(test_id_file);
		browser_name = config.get("browser_name");
		global_timeout = Integer.valueOf(config.get("global_timeout"));
		timeout = Integer.valueOf(config.get("timeout"));
		timeStamp = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date());
		dateStamp = new SimpleDateFormat("ddMMyyyy").format(new Date());
		setTestId(test_id_file);
	}

	public void start() throws Exception {
		logTestSuite();
		switch (browser_name) {
		case "ff":
			driver = new FirefoxDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		case "gc":
			driver = new ChromeDriver();
			break;
		default:
			log("Incorrect Browser Name: " + browser_name);
			break;
		}
		driver.manage().timeouts()
				.implicitlyWait(global_timeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public void stop() throws Exception {
		driver.close();
		driver.quit();
	}

	private Map<String, String> readFile(String file) {
		try (FileInputStream fileInput = new FileInputStream(new File(file))) {
			InputStreamReader inputStreamReader = new InputStreamReader(
					fileInput, StandardCharsets.UTF_8);
			Properties properties = new Properties();
			properties.load(inputStreamReader);
			Enumeration<Object> enuKeys = properties.keys();
			Map<String, String> dataList = new HashMap<String, String>();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				key = key.trim();
				value = value.trim();
				dataList.put(key, value);
			}
			return dataList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setTestId(String file) {
		try {
			test_id_prefix = test_id_data.get("test_id_prefix");
			test_date = test_id_data.get("test_date");
			testNumber = Integer.valueOf(test_id_data.get("test_number"));
			try {
				if (!test_date.equalsIgnoreCase(dateStamp))
					testNumber = 1;
				else
					testNumber++;
			} catch (NumberFormatException e) {
				testNumber = 1;
			}
			FileInputStream in = new FileInputStream(file);
			Properties props = new Properties();
			props.load(in);
			in.close();
			FileOutputStream out = new FileOutputStream(file);
			props.setProperty("test_number", Integer.toString(testNumber));
			props.setProperty("test_date", dateStamp);
			props.setProperty("test_id_prefix", test_id_prefix);
			testId = test_id_prefix + "-" + dateStamp + "-"
					+ Integer.toString(testNumber);
			props.setProperty("test_id", testId);
			props.store(out, null);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logTestSuite() {
		log("===============================================");
		log(test_name);
		log("testId: " + testId);
		log("Browser: " + browser_name);
		log("Started: " + timeStamp);
		log("===============================================");
		log("");
	}

	public void logTestCase(String testcase_name) {
		log("===============================================");
		log("    " + testcase_name);
		log("===============================================");
	}

	public void logPage(String page_name) {
		log("   > " + page_name);
	}

	public void logResult(boolean result) {
		if (result)
			log("PASSED");
		else
			log("FAILED");
	}

	public void log(String text) {
		Reporter.log(text, true);
		Reporter.log("<br />");

	}

}
