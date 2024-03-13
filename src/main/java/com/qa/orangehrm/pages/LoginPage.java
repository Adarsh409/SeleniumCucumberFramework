package com.qa.orangehrm.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import com.qa.orangehrm.base.Base;
import com.qa.orangehrm.utils.Utils;

public class LoginPage extends Base {
	private static Logger log=LogManager.getLogger(LoginPage.class);
	HomePage homePageObj;

	private By userNameFieldLocator = By.name("username");
	private By passwordFieldLocator = By.name("password");
	private By loginButtonLocator = By.cssSelector("button[type='submit']");

	public void enterUserName(String userName) throws InterruptedException {
		try {
			WebElement userNameElement = Utils.locateElement(userNameFieldLocator);
			userNameElement.sendKeys(userName);
			log.info("Login user name entered");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void enterPassword(String password) {
		try {
			WebElement passwordElement = Utils.locateElement(passwordFieldLocator);
			passwordElement.sendKeys(password);
			log.info("Login password entered");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public HomePage clickLoginButton() {
		try {
			Utils.locateElement(loginButtonLocator).click();
			log.info("Login button clicked");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return new HomePage();
	}

	public String getCurrentUrl() {
		String url = null;
		try {
			url = driver.getCurrentUrl();
			log.info("Login page url fetched");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return url;
	}

	public void launchUrl() {
		try {
			driver.get(configProperties.getProperty("launchURL"));
			log.info("Opening the application");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	public boolean isErrorMsgDisplayed(String errorMsg) {
		boolean flag = false;
		try {
			flag = driver.getPageSource().contains(errorMsg);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return flag;

	}

	public HomePage doLogin() {
		try {
			launchUrl();
			enterUserName(userProperties.getProperty("AdminUserName"));
			enterPassword(userProperties.getProperty("AdminPassword"));
			clickLoginButton();

		} catch (Exception e) {

		}
		return new HomePage();
	}

	public HomePage doLogin(String username, String password) {
		try {
			launchUrl();
			enterUserName(username);
			enterPassword(password);
			clickLoginButton();

		} catch (Exception e) {

		}
		return new HomePage();
	}

}
