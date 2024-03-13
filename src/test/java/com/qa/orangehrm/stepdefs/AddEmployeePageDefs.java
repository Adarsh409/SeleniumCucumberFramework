package com.qa.orangehrm.stepdefs;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import com.qa.orangehrm.pages.AddEmployeePage;
import com.qa.orangehrm.pages.EmployeeSearchPage;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeePageDefs {
	AddEmployeePage addEmployeePageObj;
	EmployeeSearchPage employeeSearchPageObj;
	HomePage homePageObj;
	LoginPage loginPageObj = new LoginPage();
	String expectedEmployeeId = null;

	@Given("User enters employee name")
	public void user_enters_employee_name() {
		addEmployeePageObj.enterEmployeeName();
	}

	@Given("User enters login credentials")
	public void user_enters_login_credentials() {
		addEmployeePageObj.clickCreateLoginCheckbox();
		addEmployeePageObj.enterLoginDetails();

	}

	@When("User clicks Save button")
	public void user_clicks_save_button() {
		addEmployeePageObj.clickLoginDetailsSaveButton();
	}

	@When("User enters employee registration details")
	public void user_enters_employee_registration_details() {
		addEmployeePageObj.enterPersonalDetails();
		addEmployeePageObj.enterContactDetails();
		addEmployeePageObj.enterJobDetails();
	}

//	@Then("employee name is displayed")
//	public void employee_name_is_displayed() {
//		String expectedEmployeeName = addEmployeePageObj.getFirstName() + " " + addEmployeePageObj.getLastName();
//		String actualEmployeeName = addEmployeePageObj.getEmployeeFullName();
//		Assert.assertEquals(expectedEmployeeName, actualEmployeeName);
//
//	}

	@Then("User navigates to Employee Search Page")
	public void user_navigates_to_employee_search_page() {
		employeeSearchPageObj = addEmployeePageObj.navigateToEmployeeSearchPage();
	}

	@Then("User searches employee using employee id")
	public void user_searches_employee_using_employee_id() {
		expectedEmployeeId=employeeSearchPageObj.enterEmployeeId();
		employeeSearchPageObj.clickSearchButton();
	}

	@Then("Employee record is displayed")
	public void employee_record_is_displayed() {
		List<HashMap<String, String>> employeeSearchResultsList = employeeSearchPageObj.getEmployeeRecords();
		Assert.assertEquals(1, employeeSearchResultsList.size());
		for (int i = 0; i < employeeSearchResultsList.size(); i++) {
			HashMap<String, String> employeeDetailsHashMap = employeeSearchResultsList.get(i);
			for (Object obj : employeeDetailsHashMap.keySet()) {
				String actualEmployeeId = employeeDetailsHashMap.get("Id");
				Assert.assertEquals(expectedEmployeeId, actualEmployeeId);
			}

		}
	}

	@Given("Admin is already on Add Employee Page")
	public void admin_is_already_on_add_employee_page() {
		homePageObj = loginPageObj.doLogin();
		employeeSearchPageObj = homePageObj.clickOnPIMPageLink();
		addEmployeePageObj = employeeSearchPageObj.navigateToAddEmployeePage();

	}

}
