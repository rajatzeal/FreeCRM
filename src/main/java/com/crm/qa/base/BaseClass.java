package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.crm.utils.Utility;

public class BaseClass {

	public static WebDriver wd;
	public static Properties prop;

	public BaseClass() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\RAJAT\\eclipse-workspace new\\GITCHECK\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void initialization() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\RAJAT\\Downloads\\geckodriver.exe");
		wd = new FirefoxDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		wd.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD, TimeUnit.SECONDS);
		wd.manage().deleteAllCookies();

		wd.get(prop.getProperty("url"));

		//wd.get("https:www.freecrm.com");
	}

}
