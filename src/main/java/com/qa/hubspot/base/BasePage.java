package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	/**
	 * This method is used to initialize the WebDriver on the basis of
	 * browserName
	 * 
	 * @param browserName
	 * @return this method will return driver instance
	 */
	public WebDriver init_driver(Properties prop) {
		String browserName = null;
		if (System.getProperty("browser") == null) {
			browserName = prop.getProperty("browser");
		} else {
			browserName = System.getProperty("browser");
		}

		System.out.println("Running on ----> " + browserName + " browser");

		optionsManager = new OptionsManager(prop);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println(browserName + " is not found, please pass the right browser Name");
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return getDriver();

	}

	/**
	 * 
	 * @return this method returns properties - prop available in
	 *         config.proerties file
	 */
	public Properties init_prop() {
		prop = new Properties();
		String path = null;
		String env = null;

		try {
			env = System.getProperty("env");
			if (env == null) {
				path = "./src/main/java/com/qa/hubspot/config/config.properties";
			} else {
				switch (env) {
				case "qa":
					path = "./src/main/java/com/qa/hubspot/config/config.qa.properties";
					break;
				case "stg":
					path = "./src/main/java/com/qa/hubspot/config/config.stg.properties";
					break;
				case "prod":
					path = "./src/main/java/com/qa/hubspot/config/config.properties";
					break;
				default:
					System.out.println("no env is passed");
					break;
				}
			}

			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("config file is not foubd.....");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	/**
	 * take screenshot util
	 */

	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

}
