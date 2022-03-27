package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.screenshotFail.ListenerTest;

@Listeners(ListenerTest.class)
public class LoginPage_Test extends BaseClass {

	
	
	LoginPage lp;
	HomePage hp;
	
	public LoginPage_Test(){
		super();
	}

	@BeforeMethod
	public void TestSetup() {

		initialization();
		
		lp = new LoginPage();

	}

	@Test(priority =1)
	public void LoginPageURLTest() {
		String title = lp.getURL();
		System.out.println(title);
		Assert.assertNotEquals(title, prop.getProperty("url"));
	}
	
	@Test(priority =2)
	public void LoginPageTest() {
		
		hp =lp.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	
	@AfterMethod
	public void teardown() {
		wd.quit();
	}
}
