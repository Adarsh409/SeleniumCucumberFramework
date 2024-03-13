package com.qa.orangehrm.pages;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.qa.orangehrm.base.Base;
import com.qa.orangehrm.utils.Utils;

public class HomePage extends Base {
	private static Logger log=LogManager.getLogger(HomePage.class);
	private By logOutOptionLocator = By.linkText("Logout");
	private By userDropDownLocator = By.cssSelector("i[class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
	private By pimPageLinkLocator = By.linkText("PIM");
	private By leavePageLinkLocator = By.linkText("Leave");
	
	LoginPage loginPageObj;
	HomePage homePageObj;
	EmployeeSearchPage employeeSearchPageObj;
	
	public void clickUserDropDown() {
		try {
			Utils.locateElement(userDropDownLocator).click();
			log.info("User Drop down clicked");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public LoginPage logOut() {
		try {
			Utils.locateElement(logOutOptionLocator).click();
			log.info("User logged out");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return new LoginPage();

	}



	public EmployeeSearchPage clickOnPIMPageLink() {
		try {
			Utils.locateElement(pimPageLinkLocator).click();
			log.info("PIM Page link clicked");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return new EmployeeSearchPage();

	}

	public LeaveSearchPage clickOnLeavePageLink() {
		try {
			Utils.locateElement(leavePageLinkLocator).click();
			log.info("Leave Page link clicked");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return new LeaveSearchPage();
	}
	
	

	



}
