package com.qa.orangehrm.pages;

import java.io.FileOutputStream;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import com.qa.orangehrm.base.Base;
import com.qa.orangehrm.utils.Constants;
import com.qa.orangehrm.utils.FileScanner;
import com.qa.orangehrm.utils.Utils;

public class AddEmployeePage extends Base {
	private static Logger log=LogManager.getLogger(AddEmployeePage.class);
	private By firstNameFieldLocator = By.name("firstName");
	private By lastNameFieldLocator = By.name("lastName");
	private By loginDetailsSaveButtonLocator = By.cssSelector("button[type='submit']");
	private By driverLicenseNumberFieldLocator = By
			.xpath("//label[contains(text(),'License Number')]//parent::div//following-sibling::div//input");
	private By licenseExpiryCalendarLocator = By
			.xpath("//label[contains(text(),'License Expiry Date')]//parent::div//following-sibling::div//input");
	private By yearDropDownLocator = By.cssSelector("li[class='oxd-calendar-selector-year']");
	private By calendarDropDownLocator = By.cssSelector("ul[class='oxd-calendar-dropdown']");
	private By monthDropDownLocator = By.cssSelector("li[class='oxd-calendar-selector-month']");
	private By nationalityFieldLocator = By.xpath(
			"//label[contains(text(),'Nationality')]//parent::div//following-sibling::div//div[@class='oxd-select-text-input']");
	private By valuesLocator = By.cssSelector("div[role='option']");
	private By maritalStatusFieldLocator = By.xpath(
			"//label[contains(text(),'Marital')]//parent::div//following-sibling::div//div[@class='oxd-select-text-input']");
	private By dateOfBirthCalendarLocator = By
			.xpath("//label[contains(text(),'Date of Birth')]//parent::div//following-sibling::div//input");
	private By personalDetailsSaveButton = By.xpath("//label[text()='Gender']//following::button[1]");
//	private By bloodTypeDetailsSaveButtonLocator = By.xpath(
//			"//div[@class='orangehrm-attachment']//preceding-sibling::div[@class='orangehrm-custom-fields']//descendant::button");
	private By contactDetailsLink = By.linkText("Contact Details");
	private By streetAddress1FieldLocator = By
			.xpath("//label[text()='Street 1']//parent::div//following-sibling::div//input");
	private By employeeCityFieldLocator = By
			.xpath("//label[text()='City']//parent::div//following-sibling::div//input");
	private By employeeStateFieldLocator = By
			.xpath("//label[text()='State/Province']//parent::div//following-sibling::div//input");
	private By employeePostalCodeFieldLocator = By
			.xpath("//label[text()='Zip/Postal Code']//parent::div//following-sibling::div//input");
	private By employeeCountryFieldLocator = By.xpath(
			"//label[contains(text(),'Country')]//parent::div//following-sibling::div//div[@class='oxd-select-text-input']");
	private By employeeMobilePhoneFieldLocator = By
			.xpath("//label[text()='Mobile']//parent::div//following-sibling::div//input");
	private By employeeWorkEmailFieldLocator = By
			.xpath("//label[text()='Work Email']//parent::div//following-sibling::div//input");
	private By contactDetailsSaveButton = By.cssSelector("button[type='submit']");
	private By joinedDateCalendarLocator = By
			.xpath("//label[contains(text(),'Joined Date')]//parent::div//following-sibling::div//input");
	private By employeeJobTitleFieldLocator = By.xpath(
			"//label[contains(text(),'Job Title')]//parent::div//following-sibling::div//div[@class='oxd-select-text-input']");
	private By employeeJobCategoryFieldLocator = By.xpath(
			"//label[contains(text(),'Job Category')]//parent::div//following-sibling::div//div[@class='oxd-select-text-input']");
	private By employeeSubUnitFieldLocator = By.xpath(
			"//label[contains(text(),'Sub Unit')]//parent::div//following-sibling::div//div[@class='oxd-select-text-input']");
//	private By employeeLocationFieldLocator = By.xpath(
//			"//label[contains(text(),'Location')]//parent::div//following-sibling::div//div[@class='oxd-select-text-input']");
	private By employeeEmploymentStatusLocator = By.xpath(
			"//label[contains(text(),'Employment Status')]//parent::div//following-sibling::div//div[@class='oxd-select-text-input']");
	private By employeementContractDetailsLocator = By
			.xpath("//p[text()='Include Employment Contract Details']//parent::div//descendant::span");
	private By employeeContractStartCalendar = By
			.xpath("//label[contains(text(),'Contract Start Date')]//parent::div//following-sibling::div//input");
	private By employeeContractEndCalendar = By
			.xpath("//label[contains(text(),'Contract End Date')]//parent::div//following-sibling::div//input");
	private By jobDetailsSaveButton = By.cssSelector("button[type='submit']");

//	private By reportToLink = By.linkText("Report-to");
	private By jobDetailsLink = By.linkText("Job");
//	private By assignSupervisorsButton = By.xpath("//h6[text()='Assigned Supervisors']//following-sibling::button");
//	private By supervisorNameFieldLocator = By
//			.xpath("//label[text()='Name']//parent::div//following-sibling::div//input");
//	private By reportingMethodLocator = By.xpath(
//			"//label[contains(text(),'Reporting Method')]//parent::div//following-sibling::div//div[@class='oxd-select-text-input']");
//	private By reportsToDetailsSaveButton = By.cssSelector("button[type='submit']");
//	private By supervisorNameLocator = By.cssSelector("div[role='option']:first-of-type");
	private By employeeListPageLink = By.linkText("Employee List");
	private By employeeIdFieldLocator = By
			.xpath("//label[text()='Employee Id']//parent::div//following-sibling::div//input");
	private By employeeUserNameFieldLocator = By
			.xpath("//label[text()='Username']//parent::div//following-sibling::div//input");
	private By employeePasswordFieldLocator = By
			.xpath("//label[text()='Password']//parent::div//following-sibling::div//input");
	private By employeeConfirmPasswordFieldLocator = By
			.xpath("//label[text()='Confirm Password']//parent::div//following-sibling::div//input");
	private By createLoginCheckBoxLocator = By.xpath("//div[@class='oxd-switch-wrapper']");
	private By employeeFullNameLocator = By.xpath("//div[contains(@class,'employee-name')]//h6");
	private By userDropDownImageLocator = By.cssSelector("img[class='oxd-userdropdown-img']");
	private By logOutOptionLocator = By.linkText("Logout");
	private By employeeSearchPageLinkLocator = By.linkText("Employee List");
	JSONObject employeeDetails;
	JSONObject personalDetails;
	JSONObject contactDetails;
	JSONObject jobDetails;
	JSONObject reportsToDetails;
	JSONObject basicDetails;
//	private String firstName = null;
//	private String lastName = null;
	List<Object> employeeDetailsList;
	private String employeeId = null;
	LoginPage loginPageObj = new LoginPage();
	HomePage homePageObj;
	EmployeeSearchPage employeeSearchPageObj;
	AddEmployeePage addEmployeePageObj;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
		try {
			userProperties.setProperty("EmployeeId", employeeId);
			userProperties.store(new FileOutputStream(Constants.USER_PROPERTIES_FILE_PATH), null);
			log.info("Employee id saved to file");
		} catch (Exception e) {

		}
	}
	
	public EmployeeSearchPage nvaigateToEmployeeSearchPage() {
		Utils.locateElement(employeeSearchPageLinkLocator).click();
		log.info("Navigated to Employee Search Page");
		return new EmployeeSearchPage();
	}

//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}

//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}

//	public String getCurrentUrl() {
//		String url = null;
//		try {
//			url = driver.getCurrentUrl();
//			log.info("Add Employee page url fetched");
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//		return url;
//	}

	public void enterPersonalDetails() {
		try {
			for (int i = 0; i < employeeDetailsList.size(); i++) {
				personalDetails = (JSONObject) employeeDetails.get("personalDetails");
				clickLicenseExpiryDateCalendar();
				enterDate(personalDetails.get("licenseExpiryDate").toString());
				enterDriverLicenseNumber(personalDetails.get("driverLicenseNumber").toString());
				enterNationality(personalDetails.get("nationality").toString());
				enterMaritalStatus(personalDetails.get("maritalStatus").toString());
				clickDateOfBithCalendar();
				enterDate(personalDetails.get("dateOfBirth").toString());
				enterGender(personalDetails.get("gender").toString());
				clickPersonalDetailsSaveButton();
				log.info("Employee personal details saved");

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public String getEmployeeFullName() {
		String employeeName = null;
		try {
			employeeName = Utils.locateElement(employeeFullNameLocator).getText();
			userProperties.setProperty("EmployeeName", employeeName);
			userProperties.store(new FileOutputStream(Constants.USER_PROPERTIES_FILE_PATH), null);
			log.info("Employee Name saved to file");
		} catch (Exception e) {

			e.printStackTrace();
		}

		return employeeName;
	}

	public void clickCreateLoginCheckbox() {
		try {
			Utils.locateElement(createLoginCheckBoxLocator).click();
			log.info("Create Login checkbox clicked");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void enterContactDetails() {
		try {
			contactDetails = (JSONObject) employeeDetails.get("contactDetails");
			Utils.scrollUp();
			clickContactDetailsLink();
			enterCountry(contactDetails.get("country").toString());
			enterStreetAddress1(contactDetails.get("street1").toString());
			enterCity(contactDetails.get("city").toString());
			enterState(contactDetails.get("state").toString());
			enterPostalCode(contactDetails.get("zip").toString());

			enterMobilePhone(contactDetails.get("mobile").toString());
			enterWorkEmail(contactDetails.get("workEmail").toString());
			clickContactDetailsSaveButton();
			log.info("Employee contact details saved");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void enterJobDetails() {
		try {
			jobDetails = (JSONObject) employeeDetails.get("jobDetails");
			clickJobDetailsLink();
			clickEmployeeJoinedDateCalendar();
			enterDate(jobDetails.get("joinedDate").toString());
			enterJobTitle(jobDetails.get("jobTitle").toString());
			enterJobSubUnit(jobDetails.get("subUnit").toString());
			//enterJobCategory(jobDetails.get("jobCategory").toString());
			// enterJobLocation(jobDetails.get("location").toString());
			enterEmploymentStatus(jobDetails.get("employmentStatus").toString());
			if (jobDetails.get("includeEmployeeContractDetails").toString().equalsIgnoreCase("y")) {
				includeEmploymentContractDetails();
				Utils.scrollUp();
				clickContractStartDateCalendar();
				enterDate(jobDetails.get("contractStartDate").toString());
				clickContractEndDateCalendar();
				enterDate(jobDetails.get("contractEndDate").toString());
			}
			clickJobDetailsSaveButton();
			log.info("Employee job details saved");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public EmployeeSearchPage navigateToEmployeeSearchPage() {
		try {
			Utils.locateElement(employeeListPageLink).click();
			log.info("Navigated to Employee Search page");
		} catch (Exception e) {

			e.printStackTrace();
		}
		return new EmployeeSearchPage();
	}

	public void enterUserName(String userName) {
		try {
			Utils.locateElement(employeeUserNameFieldLocator).sendKeys(userName);
			log.info("Employee user name entered");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void enterPassword(String password) {
		try {
			Utils.locateElement(employeePasswordFieldLocator).sendKeys(password);
			log.info("Employee password entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void enterConfirmPassword(String confirmPassword) {
		try {
			Utils.locateElement(employeeConfirmPasswordFieldLocator).sendKeys(confirmPassword);
			log.info("Employee confirm password entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

//	public void enterSupervisorName(String name) {
//		try {
//			WebElement element = Utils.locateElement(supervisorNameFieldLocator);
//			element.sendKeys(name);
//			Utils.locateElement(supervisorNameLocator);
//			element.sendKeys(Keys.ARROW_DOWN);
//			element.sendKeys(Keys.ENTER);
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//	}

//	public void clickAddAssignedSupervisorsButton() {
//		try {
//			Utils.locateElement(assignSupervisorsButton).click();
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//	}

//	public void clickReportsToLink() {
//		try {
//			Utils.locateElement(reportToLink).click();
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//	}

	public void clickJobDetailsLink() {
		try {
			Utils.locateElement(jobDetailsLink).click();
			log.info("Job details link clicked");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void clickContactDetailsLink() {
		try {
			Utils.locateElement(contactDetailsLink).click();
			log.info("Contact details link clicked");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void clickJobDetailsSaveButton() {
		try {
			Utils.locateElement(jobDetailsSaveButton).click();
			log.info("Job details save button clicked");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void enterEmploymentStatus(String employmentStatus) {
		try {
			WebElement element = Utils.locateElement(employeeEmploymentStatusLocator);
			element.click();
			List<WebElement> employmenttStatusValueList = Utils.locateElements(valuesLocator);
			int count = 0;
			while (count != employmenttStatusValueList.size()) {
				if (element.getText().equalsIgnoreCase(employmentStatus)) {
					element.sendKeys(Keys.ENTER);
					break;
				} else {
					element.sendKeys(Keys.ARROW_DOWN);
					count++;

				}
			}
			Utils.waitElementToDisapper(valuesLocator);
			log.info("Employement status entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void includeEmploymentContractDetails() {
		try {
			Utils.locateElement(employeementContractDetailsLocator).click();
			log.info("Include contract details option clicked");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void clickContractStartDateCalendar() {
		try {
			Utils.locateElement(employeeContractStartCalendar).click();
			log.info("Contract Start date calendar clicked");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void clickContractEndDateCalendar() {
		try {
			Utils.locateElement(employeeContractEndCalendar).click();
			log.info("Contract End date calendar clicked");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void clickEmployeeJoinedDateCalendar() {

		try {
			js.executeScript("arguments[0].click();", Utils.locateElement(joinedDateCalendarLocator));
			log.info("Employee Joined date calendar clicked");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void enterJobTitle(String jobTitle) {
		try {
			WebElement element = Utils.locateElement(employeeJobTitleFieldLocator);
			ac.moveToElement(element).click().build().perform();
			List<WebElement> jobTitleValueList = Utils.locateElements(valuesLocator);
			int count = 0;
			while (count != jobTitleValueList.size()) {
				if (element.getText().equalsIgnoreCase(jobTitle)) {
					element.sendKeys(Keys.ENTER);
					break;
				} else {
					element.sendKeys(Keys.ARROW_DOWN);
					count++;

				}
			}
			Utils.waitElementToDisapper(valuesLocator);
			log.info("Employee Job title entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

//	public void enterJobCategory(String jobCategory) {
//		try {
//			WebElement element = Utils.locateElement(employeeJobCategoryFieldLocator);
//			ac.moveToElement(element).click().build().perform();
//			List<WebElement> jobCategoryValueList = Utils.locateElements(valuesLocator);
//			int count = 0;
//			while (count != jobCategoryValueList.size()) {
//				if (element.getText().equalsIgnoreCase(jobCategory)) {
//					element.sendKeys(Keys.ENTER);
//					break;
//				} else {
//					element.sendKeys(Keys.ARROW_DOWN);
//					count++;
//
//				}
//			}
//			Utils.waitElementToDisapper(valuesLocator);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public void enterJobSubUnit(String subUnit) {
		try {
			WebElement element = Utils.locateElement(employeeSubUnitFieldLocator);
			element.click();
			List<WebElement> jobSubUnitValueList = Utils.locateElements(valuesLocator);
			int count = 0;
			while (count != jobSubUnitValueList.size()) {
				if (element.getText().equalsIgnoreCase(subUnit)) {
					element.sendKeys(Keys.ENTER);
					break;
				} else {
					element.sendKeys(Keys.ARROW_DOWN);
					count++;

				}
			}
			Utils.waitElementToDisapper(valuesLocator);
			log.info("Employee Sub unit entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

//	public void enterJobLocation(String jobLocation) {
//		try {
//			WebElement element = Utils.locateElement(employeeLocationFieldLocator);
//			element.click();
//			List<WebElement> jobLocationValueList = Utils.locateElements(valuesLocator);
//			int count = 0;
//			while (count != jobLocationValueList.size()) {
//				if (element.getText().equalsIgnoreCase(jobLocation)) {
//					element.sendKeys(Keys.ENTER);
//					break;
//				} else {
//					element.sendKeys(Keys.ARROW_DOWN);
//					count++;
//
//				}
//			}
//			Utils.waitElementToDisapper(valuesLocator);
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//	}

	public void enterStreetAddress1(String address) {
		try {
			Utils.locateElement(streetAddress1FieldLocator).sendKeys(address);
			log.info("Employee Street Address 1 entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void enterPostalCode(String postalCode) {
		try {
			Utils.locateElement(employeePostalCodeFieldLocator).sendKeys(postalCode);
			log.info("Employee Postal code entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void enterCity(String city) {
		try {
			Utils.locateElement(employeeCityFieldLocator).sendKeys(city);
			log.info("Employee City entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void enterState(String state) {
		try {
			Utils.locateElement(employeeStateFieldLocator).sendKeys(state);
			log.info("Employee State entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void enterCountry(String country) {
		try {
			WebElement element = Utils.locateElement(employeeCountryFieldLocator);
			element.click();
			List<WebElement> leaveTypeValueList = Utils.locateElements(valuesLocator);
			int count = 0;
			while (count != leaveTypeValueList.size()) {
				if (element.getText().equalsIgnoreCase(country)) {
					element.sendKeys(Keys.ENTER);
					break;
				} else {
					element.sendKeys(Keys.ARROW_DOWN);
					count++;

				}
			}
			log.info("Employee Country entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void enterMobilePhone(String mobileNumber) {
		try {
			Utils.locateElement(employeeMobilePhoneFieldLocator).sendKeys(mobileNumber);
			log.info("Employee Mobile Phone entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void enterWorkEmail(String workEmail) {
		try {
			Utils.locateElement(employeeWorkEmailFieldLocator).sendKeys(workEmail);
			log.info("Employee Work email entered entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void clickContactDetailsSaveButton() {
		try {
			Utils.locateElement(contactDetailsSaveButton).click();
			log.info("Employee Contact Details save button clicked");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void clickPersonalDetailsSaveButton() {
		try {
			WebElement element = Utils.locateElement(personalDetailsSaveButton);
			js.executeScript("arguments[0].click();", element);
			log.info("Employee Personal Details save button clicked");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void enterGender(String gender) {
		String value = null;
		try {
			By genderLocator;
			if (gender.equalsIgnoreCase("Male")) {
				value = "1";
			} else {
				value = "2";
			}
			genderLocator = By.cssSelector("input[value='" + value + "']+span");
			WebElement element = Utils.locateElement(genderLocator);

			js.executeScript("arguments[0].click();", element);
			log.info("Employee Gender entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void enterNationality(String nationality) {
		try {
			WebElement element = Utils.locateElement(nationalityFieldLocator);
			element.click();
			List<WebElement> leaveTypeValueList = driver.findElements(valuesLocator);
			int count = 0;
			while (count != leaveTypeValueList.size()) {
				if (element.getText().equalsIgnoreCase(nationality)) {
					element.sendKeys(Keys.ENTER);
					break;
				} else {
					element.sendKeys(Keys.ARROW_DOWN);
					count++;
				}
			}
			log.info("Employee Nationality entered");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void clickDateOfBithCalendar() {

		try {
			js.executeScript("arguments[0].click();", Utils.locateElement(dateOfBirthCalendarLocator));
			log.info("Employee Date of birth calendar clicked");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void enterMaritalStatus(String maritalStatus) {
		try {
			WebElement element = Utils.locateElement(maritalStatusFieldLocator);
			element.click();
			List<WebElement> leaveTypeValueList = Utils.locateElements(valuesLocator);
			int count = 0;
			while (count != leaveTypeValueList.size()) {
				if (element.getText().equalsIgnoreCase(maritalStatus)) {
					element.sendKeys(Keys.ENTER);
					break;
				} else {
					element.sendKeys(Keys.ARROW_DOWN);
					count++;
				}
			}
			log.info("Employee Marital status entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void enterEmployeeName() {
		try {
			employeeDetailsList = FileScanner.readJSONFile(Constants.ADDEMPLOYEE_TESTDATA_FILE_PATH, "employees");
			for (int i = 0; i < employeeDetailsList.size(); i++) {
				employeeDetails = (JSONObject) employeeDetailsList.get(i);
				basicDetails = (JSONObject) employeeDetails.get("basicDetails");

			}
			enterFirstName(basicDetails.get("firstName").toString());
			enterLastName(basicDetails.get("lastName").toString());
//			this.setFirstName(basicDetails.get("firstName").toString());
//			this.setLastName(basicDetails.get("lastName").toString());
			this.getEmpId();
			log.info("Employee full name entered");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void enterFirstName(String firstName) {
		try {
			Utils.locateElement(firstNameFieldLocator).sendKeys(firstName);
			log.info("Employee first name entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void enterLastName(String lastName) {
		try {
			Utils.locateElement(lastNameFieldLocator).sendKeys(lastName);
			log.info("Employee last name entered");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void getEmpId() {
		try {
			this.setEmployeeId(Utils.locateElement(employeeIdFieldLocator).getAttribute("value"));
			log.info("Employee id value fetched from the field");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void clickLoginDetailsSaveButton() {
		try {
			Utils.locateElement(loginDetailsSaveButtonLocator).click();
			log.info("Login Details save button clicked");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void enterDriverLicenseNumber(String licenseNumber) {
		try {
			Utils.locateElement(driverLicenseNumberFieldLocator).sendKeys(licenseNumber);
			log.info("Employee Driver license number entered");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void clickLicenseExpiryDateCalendar() {
		try {
			js.executeScript("arguments[0].click();", Utils.locateElement(licenseExpiryCalendarLocator));
			log.info("Employee License expiry date calendar clicked");
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

			calendarMonthLocator = By
					.xpath("//div[contains(@class,'month')]//following-sibling::ul//li[" + month + "]");
			Utils.locateElement(calendarMonthLocator).click();
			calendarDateLocator = By
					.xpath("//div[contains(@class,'oxd-calendar-date') and text()='" + Integer.toString(date) + "']");
			Utils.locateElement(calendarDateLocator).click();
			log.info("Date selected");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void enterLoginDetails() {
		try {
			enterUserName(basicDetails.get("userName").toString());
			enterPassword(basicDetails.get("password").toString());
			enterConfirmPassword(basicDetails.get("password").toString());
			log.info("Employee Login details enetered");
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

	public void createEmployeeRecord(List<Map<String, String>> employeeDetailsList) {
		try {
			homePageObj = loginPageObj.doLogin();
			employeeSearchPageObj = homePageObj.clickOnPIMPageLink();
			employeeSearchPageObj.navigateToAddEmployeePage();
			enterFirstName(employeeDetailsList.get(0).get("firstname"));
			enterLastName(employeeDetailsList.get(0).get("lastname"));
			getEmpId();
			clickLoginDetailsSaveButton();
			clickPersonalDetailsSaveButton();
			clickJobDetailsLink();
			// Thread.sleep(3000);
			enterEmploymentStatus(employeeDetailsList.get(0).get("employmentstatus"));
			// Thread.sleep(3000);
			enterJobTitle(employeeDetailsList.get(0).get("jobtitle"));
			// Thread.sleep(3000);
			enterJobSubUnit(employeeDetailsList.get(0).get("subunit"));

			getEmployeeFullName();
			clickJobDetailsSaveButton();
			log.info("Employee Record created");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}