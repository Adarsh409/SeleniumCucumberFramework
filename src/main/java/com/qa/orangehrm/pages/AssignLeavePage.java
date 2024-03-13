package com.qa.orangehrm.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.base.Base;
import com.qa.orangehrm.utils.Utils;

public class AssignLeavePage extends Base {
	private static Logger log=LogManager.getLogger(AssignLeavePage.class);
	private By fromDateLocator = By.xpath("//label[text()='From Date']//following::input[1]");
	private By toDateLocator = By.xpath("//label[text()='From Date']//following::input[2]");

	private By yearDropDownLocator = By.cssSelector("li[class='oxd-calendar-selector-year']");
	private By calendarDropDownLocator = By.cssSelector("ul[class='oxd-calendar-dropdown']");
	private By monthDropDownLocator = By.cssSelector("li[class='oxd-calendar-selector-month']");
	private By leaveStatusDropDownLocator = By.xpath("//div[@class='oxd-multiselect-wrapper']//div[text()='Select']");
	private By leaveTypeDropDownLocator = By.xpath(
			"//label[text()='Leave Type']//parent::div//following-sibling::div//div[@class='oxd-select-text-input']");
	private By leaveTypeValuesLocator = By.cssSelector(".oxd-select-option");
	private By employeeNameFieldLocator = By
			.xpath("//label[text()='Employee Name']//parent::div//following-sibling::div//input");
	private By subUniDropDownLocator = By.xpath(
			"//label[text()='Sub Unit']//parent::div//following-sibling::div//descendant::div[@class='oxd-select-text-input']");

	private By valuesLocator = By.cssSelector("div[role='option']");
	private By submitButtonLocator = By.cssSelector("button[type='submit']");

	private By leaveListLinkLocator = By.linkText("Leave List");
	private By commentsFieldLocator = By.tagName("textarea");
	private By leaveConfirmationButtonLocator = By.xpath("//button[text()=' Ok ']");
	private By namesSuggestionLocator = By.xpath("//div[@role='option'][1]//span");
	private By userDropDownImageLocator = By.cssSelector("img[class='oxd-userdropdown-img']");
	private By logOutOptionLocator = By.linkText("Logout");

//	public String getCurrentUrl() {
//		String url = null;
//		try {
//			url = driver.getCurrentUrl();
//			log.info("Assign L");
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//		return url;
//	}

	public void clickFromDateField() {

		try {
			js.executeScript("arguments[0].click();", Utils.locateElement(fromDateLocator));
			log.info("Leave From Date clicked");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void clickToDateField() {
		try {
			Utils.locateElement(toDateLocator).click();
			log.info("Leave To Date clicked");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void enterDate(String userEnteredDate) {
		try {
			By calendarYearLocator;
			By calendarMonthLocator;
			By calendarDateLocator;
			int[] dateArray = Utils.dateSplitter(userEnteredDate);
			int month = dateArray[2];
			int date = dateArray[1];
			int year = dateArray[0];
			js.executeScript("arguments[0].click();", Utils.locateElement(yearDropDownLocator));
			Utils.scrollUp();
			WebElement element = Utils.locateElement(calendarDropDownLocator);
			ac.moveToElement(element).perform();
			calendarYearLocator = By.xpath("//li[text()='" + year + "']");
			Utils.locateElement(calendarYearLocator).click();
			Utils.locateElement(monthDropDownLocator).click();
			Utils.scrollUp();
			calendarMonthLocator = By.xpath("//div[contains(@class,'month')]//following-sibling::ul//li[" + month + "]");
			Utils.locateElement(calendarMonthLocator).click();
			calendarDateLocator = By
					.xpath("//div[contains(@class,'oxd-calendar-date') and text()='" + Integer.toString(date) + "']");
			Utils.locateElement(calendarDateLocator).click();
			log.info("Date selected");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public LeaveSearchPage navigateToLeaveSearchPage() {
		try {
			Utils.locateElement(leaveListLinkLocator).click();
			log.info("Navigated to Leave Search Page");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new LeaveSearchPage();
	}

	public void enterLeaveStatus(String leaveStatus) {
		try {
			Utils.locateElement(leaveStatusDropDownLocator).click();
			By leaveStatusLocator = By.xpath("//div[@role='option']//span[text()='" + leaveStatus + "']");
			Utils.locateElement(leaveStatusLocator).click();
			log.info("Leave status entered");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void enterLeaveType(String leaveType) {

		try {
			WebElement element = Utils.locateElement(leaveTypeDropDownLocator);
			element.click();
			List<WebElement> leaveTypeValueList = Utils.locateElements(leaveTypeValuesLocator);
			int count = 0;
			while (count != leaveTypeValueList.size()) {
				if (element.getText().equalsIgnoreCase(leaveType)) {
					element.sendKeys(Keys.ENTER);
					break;
				} else {
					element.sendKeys(Keys.ARROW_DOWN);
					count++;
					System.out.print(count);
				}
			}
			log.info("Leave type entered");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	public void enterName() {
		try {
			boolean flag = false;
			WebElement element = Utils.locateElement(employeeNameFieldLocator);
			element.sendKeys(userProperties.getProperty("EmployeeName"));
			System.out.println(Utils.locateElement(namesSuggestionLocator).getText());
			while (flag == false) {
				if (Utils.locateElement(namesSuggestionLocator).getText()
						.equalsIgnoreCase(userProperties.getProperty("EmployeeName"))) {
					element.sendKeys(Keys.ARROW_DOWN);
					element.sendKeys(Keys.ENTER);
					flag = true;

				}
			}
			log.info("Employee name entered");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

//	public void enterSubUnit(String subUnitType) {
//		try {
//			WebElement element = Utils.locateElement(subUniDropDownLocator);
//			element.click();
//			List<WebElement> subUnitValuesList = Utils.locateElements(valuesLocator);
//			int count = 0;
//			while (count != subUnitValuesList.size()) {
//				if (element.getText().equalsIgnoreCase(subUnitType)) {
//					element.sendKeys(Keys.ENTER);
//					break;
//				} else {
//					element.sendKeys(Keys.ARROW_DOWN);
//					count++;
//					
//				}
//			}
//			Utils.waitElementToDisapper(subUnitValuesList.get(0));
//		} catch (Exception e) {
//		
//			e.printStackTrace();
//		}
//	}

	public void clickSubmitButton() {
		try {
			Utils.locateElement(submitButtonLocator).click();
			log.info("Leave submit button clicked");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	public void clickConfirmButton() {
		try {
			Utils.locateElement(leaveConfirmationButtonLocator).click();
			log.info("Leave confirm button clicked");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void enterComments(String comment) {
		try {
			Utils.locateElement(commentsFieldLocator).sendKeys(comment);
			log.info("Leave comments entered");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	public LoginPage doLogout() {
		try {
			Utils.locateElement(userDropDownImageLocator).click();
			Utils.locateElement(logOutOptionLocator).click();
			log.info("User logged out");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return new LoginPage();
	}

}
