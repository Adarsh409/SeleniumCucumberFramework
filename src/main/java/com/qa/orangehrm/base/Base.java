package com.qa.orangehrm.base;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import com.qa.orangehrm.utils.Constants;
import com.qa.orangehrm.utils.FileScanner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static Properties configProperties;
	public static JavascriptExecutor js;
	public static Properties userProperties;
	public static Actions ac;
	public static WebDriver driver;
	public static Logger log;

	public static void setUp() {

		try {
			log = LogManager.getLogger(Base.class);
			configProperties = FileScanner.readPropertiesFile(Constants.CONFIG_PROPERTIES_FILE_PATH);
			userProperties = FileScanner.readPropertiesFile(Constants.USER_PROPERTIES_FILE_PATH);
			System.out.println("Before:" + js);
			if (configProperties.getProperty("browser").equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				js = (JavascriptExecutor) driver;
				ac = new Actions(driver);
			}
			log.info("Test set up completed");
		}

		catch (Exception e) {

		}

	}

	public static void tearDown() {
		try {

			driver.quit();
			log.info("Browser closed");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
