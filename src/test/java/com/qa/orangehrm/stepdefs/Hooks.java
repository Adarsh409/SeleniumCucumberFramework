package com.qa.orangehrm.stepdefs;

import com.qa.orangehrm.base.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public void beforeScenario() {
		Base.setUp();
		
	}
	
	@After
	public void afterScenario() {
		Base.tearDown();
	}

}
