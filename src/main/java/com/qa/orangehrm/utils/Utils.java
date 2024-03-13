package com.qa.orangehrm.utils;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.orangehrm.base.Base;

public class Utils extends Base {

	public static WebDriverWait wait;

	public static WebElement locateElement(By locator) {
		WebElement element = null;
		wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.ELEMENT_WAIT_TIME));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

			element = driver.findElement(locator);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return element;
	}

	public static List<WebElement> locateElements(By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.ELEMENT_WAIT_TIME));
		List<WebElement> webElementsList = null;
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			webElementsList = driver.findElements(locator);
		} catch (Exception e) {

		}
		return webElementsList;
	}

	public static void waitElementToDisapper(By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.ELEMENT_WAIT_TIME));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static int[] dateSplitter(String date) {
		int[] dateArray = new int[3];
		String year = date.split("-")[0];
		dateArray[0] = Integer.valueOf(year);
		String day = date.split("-")[1];
		dateArray[1] = Integer.valueOf(day);
		String month = date.split("-")[2];
		dateArray[2] = Integer.valueOf(month);

		return dateArray;
	}

	public static void scrollUp() {

		js.executeScript("window.scrollBy(0,-600)", "");
	}

	public static void staticWait() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
