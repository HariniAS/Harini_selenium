package com.training.functional.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CustomerFilterPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC20_CustomerFilter {
	private WebDriver driver;
	private CustomerFilterPOM customerFilterPOM;
	private ScreenShot screenShot;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		customerFilterPOM = new CustomerFilterPOM(driver);
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		loginPOM.sendAdminUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickAdminLoginBtn();
	}
	
	@Test
	public void CustFilter() {
		customerFilterPOM.clickCustomerIcon();
		customerFilterPOM.clickCustomersList();
		//name filter
		customerFilterPOM.clearFilter();
		customerFilterPOM.custNameFilter("Neha");
		customerFilterPOM.clickFilter();
		customerFilterPOM.chkNameFilter("Neha");
		//email filter
		customerFilterPOM.clearFilter();
		customerFilterPOM.custEmailFilter("Neha@gmail.com");
		customerFilterPOM.clickFilter();
		customerFilterPOM.chkEmailFilter("Neha@gmail.com");
		//screenShot.captureScreenShot("First");
	}
}
