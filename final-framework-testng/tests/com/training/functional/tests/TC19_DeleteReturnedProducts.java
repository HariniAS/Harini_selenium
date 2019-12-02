package com.training.functional.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.DeleteReturnedProductsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC19_DeleteReturnedProducts {
	private WebDriver driver;
	private DeleteReturnedProductsPOM deleteReturnedProductsPOM;
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
		deleteReturnedProductsPOM = new DeleteReturnedProductsPOM(driver);
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		loginPOM.sendAdminUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickAdminLoginBtn();
	}
	
	@Test
	public void DeleteReturns() {
		deleteReturnedProductsPOM.clickSaleIcon();
		deleteReturnedProductsPOM.clickReturns();
		deleteReturnedProductsPOM.selectCheckBox();
		deleteReturnedProductsPOM.clickDelete();
		driver.switchTo().alert().accept();
		deleteReturnedProductsPOM.testResult();
		//screenShot.captureScreenShot("First");
	}
}
