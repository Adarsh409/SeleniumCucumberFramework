package com.qa.orangehrm.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.orangehrm.base.Base;
import com.qa.orangehrm.utils.Utils;

public class EmployeeSearchPage extends Base {
	private static Logger log=LogManager.getLogger(EmployeeSearchPage.class);
	private By employeeNameFieldLocator = By.xpath("//label[text()='Employee Name']//following::input[1]");
	private By employeeIdFieldLocator = By.xpath("//label[text()='Employee Name']//following::input[2]");
	private By supervisorNameFieldLocator = By.xpath("//label[text()='Employee Name']//following::input[3]");
	private By emoploymentStatusLocator = By.xpath(
			"//label[text()='Employment Status']//parent::div//following::div[@class='oxd-select-text-input'][1]");
	private By employeeIncludeLocator = By.xpath(
			"//label[text()='Employment Status']//parent::div//following::div[@class='oxd-select-text-input'][2]");
	private By employeeJobTitleLocator = By.xpath(
			"//label[text()='Employment Status']//parent::div//following::div[@class='oxd-select-text-input'][3]");
	private By employeeSubUnitLocator = By.xpath(
			"//label[text()='Employment Status']//parent::div//following::div[@class='oxd-select-text-input'][4]");
	private By resultEmployeeRecordLocator = By
			.cssSelector("div[class='oxd-table-card'] div[role='cell']:nth-of-type(2)>div");

	private By searchButtonLocator = By.cssSelector("button[type = 'submit']");
	private By addEmployeeLinkLocator = By.linkText("Add Employee");
	private By employeeInfoColumnHeadersLocator = By
			.cssSelector("div[role='table'] div[role='rowgroup']:nth-of-type(1) div[role='columnheader']");
	private By employeeRecordsListLocator = By
			.cssSelector("div[role='table'] div[role='rowgroup']:nth-of-type(2) div[role='row']");
	private By resetButtonLocator = By.cssSelector("button[type='reset']");
	
	
	
	

	
//	public String getCurrentUrl() {
//		String url=null;
//		try {
//			url = driver.getCurrentUrl();
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		return url;
//	}
	
	public AddEmployeePage navigateToAddEmployeePage() {
		try {
			Utils.locateElement(addEmployeeLinkLocator).click();
			log.info("Navigated to Add Employee Page");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return new AddEmployeePage();
	}
	
	public String enterEmployeeId() {
		String employeeId = null;
		try {
			WebElement element = Utils.locateElement(employeeIdFieldLocator);
			employeeId = userProperties.getProperty("EmployeeId");
			element.sendKeys(employeeId);
			log.info("Employee Id entered");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return employeeId;
		
	}
	
	public void clickSearchButton() {
		try {
			Utils.locateElement(searchButtonLocator).click();
			log.info("Employee Search button clicked");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public List<HashMap<String, String>> getEmployeeRecords() {
		List<HashMap<String, String>> employeeSearchResultsList = null;
		try {
			employeeSearchResultsList = new ArrayList<HashMap<String, String>>();
			List<WebElement> columnHeadersList = Utils.locateElements(employeeInfoColumnHeadersLocator);
			List<WebElement> employeeRecordsList = Utils.locateElements(employeeRecordsListLocator);
			for (int i = 1; i <= employeeRecordsList.size(); i++) {
				List<WebElement> employeeDetailsList = driver.findElements(By.cssSelector(
						"div[role='table'] div[class='oxd-table-card']:nth-of-type(" + i + ") div[role='cell']"));
				HashMap<String, String> employeeDetailsHashMap = new HashMap<String, String>();
				for (int j = 1; j < columnHeadersList.size() - 1; j++) {
					employeeDetailsHashMap.put(columnHeadersList.get(j).getText(), employeeDetailsList.get(j).getText());
				}
				employeeSearchResultsList.add(employeeDetailsHashMap);
				log.info("Employee Records fetched");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return employeeSearchResultsList;
	}

}
