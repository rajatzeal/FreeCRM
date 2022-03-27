package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(linkText="Login")
	WebElement Login;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//*[@class='ui fluid large blue submit button']")
	WebElement LoginButton;
	
	public LoginPage() {
		
		PageFactory.initElements(wd, this);
	}
	
	public String getURL() {
		return wd.getCurrentUrl();
	}
	
	public HomePage login(String un, String pwd) {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Login.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		email.sendKeys(un);

		password.sendKeys(pwd);
		
		LoginButton.click();
		
		return new HomePage();
	}
}
