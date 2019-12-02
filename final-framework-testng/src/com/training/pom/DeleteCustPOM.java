package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustPOM {
	public WebDriver driver;

	public DeleteCustPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath= "//li[@id='customer']") private WebElement customer;
	@FindBy (xpath= "//*[@id='customer']/ul/li[1]/a") private WebElement custList;
	@FindBy (xpath= "//*[@id='form-customer']/div/table/tbody/tr[1]/td[1]/input") private WebElement chkBox;
	@FindBy (xpath="//div[@id='content']/div/div/div/button") private WebElement delButton;
	@FindBy (xpath= "//div[@class='alert alert-success']") private WebElement successMsg;
	
	public void clickCustomerIcon () 	{
		this.customer.click();
	}
	public void clickCustomersList ()	{
		this.custList.click();
	}
	public void selectCheckBox()	{
		this.chkBox.click();
	}
	public void clickDelete() {
		this.delButton.click();
	}
	public void testResult() {
		if (this.successMsg.equals("Success: You have modified customers!")) {
			System.out.println("Deletion success");
		}
	}
}
