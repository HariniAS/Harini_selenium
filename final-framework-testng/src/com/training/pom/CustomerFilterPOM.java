package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerFilterPOM {
	public WebDriver driver;

	public CustomerFilterPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath= "//li[@id='customer']") private WebElement customer;
	@FindBy (xpath= "//*[@id='customer']/ul/li[1]/a") private WebElement custList;
	@FindBy (id="input-name") private WebElement custName;
	@FindBy (id= "input-email") private WebElement custEmail;
	@FindBy (id="button-filter") private WebElement filter;
	@FindBy (xpath="//*[@id='form-customer']/div/table/tbody/tr/td[2]") private List<WebElement> custNameList;
	@FindBy (xpath="//*[@id='form-customer']/div/table/tbody/tr/td[3]") private List<WebElement> custEmailList;
	
	public void clickCustomerIcon () 	{
		this.customer.click();
	}
	public void clickCustomersList ()	{
		this.custList.click();
	}
	public void clearFilter() {
		this.custName.clear(); 
		this.custEmail.clear(); 
	}
	public void custNameFilter (String custName) {	
		this.custName.sendKeys(custName); 
	}
	public void custEmailFilter (String custEmail) {
		this.custEmail.sendKeys(custEmail); 
	}
	public void clickFilter() {
		this.filter.click();
	}
	public void chkNameFilter(String custName) {
		int x = this.custNameList.size();
		for (int i=0; i<x; i++) {
			String name = custNameList.get(i).getText();
			System.out.println("Filtered value at row "+(i+1)+ ":" + name+ " contains "+ custName);
			if (!name.contains(custName)){
				System.out.println("Filtered value at row "+(i+1)+ ":" + name+ " does NOT contain "+ custName);
			}
		}
	}
	public void chkEmailFilter(String custEmail) {
		int x = this.custEmailList.size();
		for (int i=0; i<x; i++) {
			String email = custEmailList.get(i).getText();
			System.out.println("Filtered value at row "+(i+1)+ ":"+email+ " matches with "+ custEmail);
			if (!email.equalsIgnoreCase(custEmail)){
				System.out.println("Filtered value at row "+(i+1)+ ":"+ email+" does NOT match with "+ custEmail);
			}
		}
	}
}
