package com.qa.orangehrm.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.base.Base;
import com.qa.orangehrm.utils.Utils;

public class LeaveSearchPage extends Base {
	private static Logger log=LogManager.getLogger(LeaveSearchPage.class);
	private By assignLeaveLinkLocator = By.linkText("Assign Leave");
	private By leaveTypeDropDownLocator = By.xpath(
			"//label[text()='Leave Type']//parent::div//following-sibling::div//div[@class='oxd-select-text-input']");
	private By leaveStatusFieldLocator = By.xpath(
			"//label[text()='Show Leave with Status']//parent::div//following-sibling::div//div[@class='oxd-select-text-input']");
	private By leaveStatusValuesLocator = By.cssSelector("div[role='option']>span");
	private By leaveTypeValuesLocator = By.cssSelector(".oxd-select-option");
	private By leaveTableDataLocator = By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']");
	private By leaveTableHeadersLocator = By.xpath("//div[@class='oxd-table-header']//div[@role='columnheader']");
	private By leaveSearchButtonLocator = By.cssSelector("button[type='submit']");

	public AssignLeavePage navigateToAssignLeavePage() {
		try {
			Utils.locateElement(assignLeaveLinkLocator).click();
			log.info("Navigated to Assign Leave page");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return new AssignLeavePage();
	}

	public void clickSubmitButton() {
		try {
			Utils.locateElement(leaveSearchButtonLocator).click();
			log.info("Leave Search button clicked");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void enterLeaveType(String leaveType) {

		try {
			WebElement element = Utils.locateElement(leaveTypeDropDownLocator);
			element.click();
			Utils.staticWait();
			List<WebElement> leaveTypeValueList = Utils.locateElements(leaveTypeValuesLocator);
			int count = 0;
			while (count != leaveTypeValueList.size()) {
				if (element.getText().equalsIgnoreCase(leaveType)) {
					element.sendKeys(Keys.ENTER);
					break;
				} else {
					element.sendKeys(Keys.ARROW_DOWN);
					count++;
				}
			}
			log.info("Leave type entered");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	public void enterLeaveStatus(String leaveStatus) {
		try {
			WebElement element = Utils.locateElement(leaveStatusFieldLocator);
			element.click();
			List<WebElement> leaveStatusValueList = Utils.locateElements(leaveStatusValuesLocator);
			int count = 0;
			while (count != leaveStatusValueList.size()) {
				System.out.println(leaveStatusValueList.get(count).getText() + "---->" + leaveStatus);
				if (leaveStatusValueList.get(count).getText().equalsIgnoreCase(leaveStatus)) {
					ac.moveToElement(leaveStatusValueList.get(count)).click().build().perform();
					break;
				} else {
					element.sendKeys(Keys.ARROW_DOWN);
					count++;
				}
			}
			log.info("Leave status entered");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public boolean isLeaveRecordPresent(List<Map<String, String>> expectedLeaveRecord) {
		boolean flag = false;
		try {
			log.info("Checking Leave records");
			String employeeName = userProperties.getProperty("EmployeeName");
			String leavePeriod = null;
			if (expectedLeaveRecord.get(0).get("fromdate").equalsIgnoreCase(expectedLeaveRecord.get(0).get("todate"))) {
				leavePeriod = expectedLeaveRecord.get(0).get("fromdate");
			} else {
				leavePeriod = expectedLeaveRecord.get(0).get("fromdate") + " to "
						+ expectedLeaveRecord.get(0).get("todate");
			}
			List<WebElement> leaveHeadersWebElementsList = Utils.locateElements(leaveTableHeadersLocator);
			List<WebElement> leaveTableWebElementsList = Utils.locateElements(leaveTableDataLocator);
			HashMap<String, String> hashMap = new HashMap<String, String>();
			for (int i = 1; i <= leaveTableWebElementsList.size(); i++) {
				for (int j = 1; j <= leaveHeadersWebElementsList.size(); j++) {
					String header = Utils
							.locateElement(
									By.xpath("//div[@class='oxd-table-header']//div[@role='columnheader'][" + j + "]"))
							.getText();
					String value = Utils
							.locateElement(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card'][" + i
									+ "]//div[@role='cell'][" + j + "]"))
							.getText();
					hashMap.put(header, value);

				}

				if (hashMap.get("Employee Name").equalsIgnoreCase(employeeName)
						&& hashMap.get("Date").equalsIgnoreCase(leavePeriod)) {
					
					flag = true;
					log.info("Leave record found");
					break;
				}

			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}

}
