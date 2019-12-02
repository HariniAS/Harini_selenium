package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteReturnedProductsPOM {
	public WebDriver driver;

	public DeleteReturnedProductsPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath= "//li[@id='sale']") private WebElement sales;
	@FindBy (xpath= "//*[@id=\"sale\"]/ul/li[3]/a") private WebElement returns;
	//@FindBy (xpath= "//div[@class='table-responsive'/table/tbody/tr[1]/td/input[@type='checkbox']")
	//@FindBy (xpath= "//input[type='checkbox']") private WebElement checkbox;
	@FindBy (xpath= "//*[@id=\'form-return\']/div/table/tbody/tr[1]/td[1]/input") private WebElement checkbox;
	@FindBy (xpath= "//*[@id=\'content\']/div[1]/div/div/button") private WebElement delete;
	@FindBy (xpath= "//div[@class='alert alert-success']") private WebElement successMsg;
	public void clickSaleIcon () 	{
		this.sales.click();
	}
	public void clickReturns ()	{
		this.returns.click();
	}
	public void selectCheckBox()	{
		this.checkbox.click();
	}
	public void clickDelete() {
		this.delete.click();
	}
	public void testResult() {
		if (this.successMsg.equals("Success: You have modified returns!")) {
			System.out.println("Deletion success");
		}
	}
}
