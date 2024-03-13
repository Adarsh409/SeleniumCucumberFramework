package com.qa.orangehrm.stepdefs;


import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.orangehrm.pages.AssignLeavePage;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LeaveSearchPage;
import com.qa.orangehrm.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeavePageDefs {
	AssignLeavePage assignLeavePageObj;
	LoginPage loginPageObj;
	LeaveSearchPage leaveSearchPageObj;
	List<Map<String, String>> leaveDetailsMap;

	@Then("User is already on Assign Leave page")
	public void user_is_already_on_assign_leave_page() {
		loginPageObj = new LoginPage();
		HomePage homePageObj;
		LeaveSearchPage leaveSearchPageObj;
		homePageObj = loginPageObj.doLogin();
		leaveSearchPageObj = homePageObj.clickOnLeavePageLink();
		assignLeavePageObj = leaveSearchPageObj.navigateToAssignLeavePage();
	}

	@Given("User enter the employee name and leave details")
	public void user_enter_the_employee_name_and_leave_details(DataTable leaveDetailsTable) {
		leaveDetailsMap = leaveDetailsTable.asMaps(String.class, String.class);
		assignLeavePageObj.enterName();
		assignLeavePageObj.enterLeaveType(leaveDetailsMap.get(0).get("leavetype"));
		assignLeavePageObj.clickFromDateField();
		assignLeavePageObj.enterDate(leaveDetailsMap.get(0).get("fromdate"));
		assignLeavePageObj.clickToDateField();
		assignLeavePageObj.enterDate(leaveDetailsMap.get(0).get("todate"));
		assignLeavePageObj.enterComments(leaveDetailsMap.get(0).get("comments"));
	}

	@When("User clicks Assign Leave button")
	public void user_clicks_assign_leave_button() {
		assignLeavePageObj.clickSubmitButton();
	}

	@When("User clicks OK button")
	public void user_clicks_ok_button() {
		assignLeavePageObj.clickConfirmButton();
	}

	@Then("User navigates to Leave Search Page")
	public void user_navigates_to_leave_search_page() {
		leaveSearchPageObj = assignLeavePageObj.navigateToLeaveSearchPage();
	}

	@Then("User searches leaves using leave type")
	public void user_searches_leaves_using_leave_type() {
		leaveSearchPageObj.enterLeaveType(leaveDetailsMap.get(0).get("leavetype"));
		leaveSearchPageObj.enterLeaveStatus(leaveDetailsMap.get(0).get("leavestatus"));
		leaveSearchPageObj.clickSubmitButton();
	}

	@Then("Leave record is displayed")
	public void leave_record_is_displayed() {
		Assert.assertTrue(leaveSearchPageObj.isLeaveRecordPresent(leaveDetailsMap));
	}
}
