package com.qa.orangehrm.stepdefs;


import java.io.IOException;
import org.junit.Assert;




import com.qa.orangehrm.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class LoginPageDefs {
	LoginPage loginPageObj;
	
	
	@Given("User is on Login page")
	public void user_is_on_login_page() throws IOException {
		loginPageObj = new LoginPage();
		loginPageObj.launchUrl();

	}

	@When("User enters  {string} as username and {string} as password")
	public void user_enters_as_username_and_as_password(String userName, String password) {
		try {
			loginPageObj.enterUserName(userName);
			loginPageObj.enterPassword(password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("User clicks Login button")
	public void user_clicks_login_button() {
		loginPageObj.clickLoginButton();

	}

	@Then("User lands on user homepage page with url {string}")
	public void user_lands_on_user_homepage_page_with_url(String homePageUrl) {
		Assert.assertEquals(homePageUrl, loginPageObj.getCurrentUrl());
	}

	@Then("{string} error message is displayed")
	public void error_message_is_displayed(String errorMsg) {
		Assert.assertTrue(loginPageObj.isErrorMsgDisplayed(errorMsg));
	}
	

}
