
package com.framework.www.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.relevantcodes.extentreports.LogStatus;
import framework.BaseTest;
import pages.LoginPage;

public class Test1 extends BaseTest{
	@Test
	public void invalidLoginUsingEmailAddress() {
		driver.get(prop.getProperty("applicationURL"));
		assertEquals( "Facebook - Log In or Sign Up",getPageTitle(driver));
		test.log(LogStatus.PASS, "Navigated to facebook home page");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterCredentials("testing1@gmail.com", "test");
		loginPage.clickLoginButton();
		loginPage.validateInvalidPasswordErrorMessage();
	}

	@Test
	public void invalidLoginUsingPhoneNumber() {
		driver.get(prop.getProperty("applicationURL"));
		assertEquals( "Facebook - Log In or Sign Up",getPageTitle(driver));
		test.log(LogStatus.PASS, "Navigated to facebook home page");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterCredentials("123456", "test");
		loginPage.clickLoginButton();
		loginPage.validateSignUpErrorMessage();
	}
}
