package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderFilterPOM {
	public WebDriver driver;

	public OrderFilterPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath= "//li[@id='sale']") private WebElement Sales;
	@FindBy (xpath= "//*[@id='sale']/ul/li[1]/a") private WebElement Orders;
	@FindBy (id="input-order-id") private WebElement orderID;
	@FindBy (id= "input-order-status") private WebElement orderStatus;
	Select s = new Select(orderStatus);
	@FindBy (id= "input-date-added") private WebElement orderDate;
	@FindBy (id="input-customer") private WebElement orderCust;
	@FindBy (id="input-total") private WebElement orderTotal;
	@FindBy (id= "input-date-modified") private WebElement orderModifDt;
	@FindBy (id="button-filter") private WebElement filter;
	@FindBy (xpath="//*[@id='form-order']/div/table/tbody/tr/td[2]") private List<WebElement> orderIDList;
	@FindBy (xpath="//*[@id='form-order']/div/table/tbody/tr/td[3]") private List<WebElement> orderCustList;
	@FindBy (xpath="//*[@id='form-order']/div/table/tbody/tr/td[4]") private List<WebElement> orderStatusList;
	@FindBy (xpath="//*[@id='form-order']/div/table/tbody/tr/td[5]") private List<WebElement> orderTotalList;
	@FindBy (xpath="//*[@id='form-order']/div/table/tbody/tr/td[6]") private List<WebElement> orderDateList;
	@FindBy (xpath="//*[@id='form-order']/div/table/tbody/tr/td[7]") private List<WebElement> orderModifDtList;
	public void clickSalesIcon () 	{
		this.Sales.click();
	}
	public void clickOrderList ()	{
		this.Orders.click();
	}
	public void clearFilter() {
		this.orderID.clear(); 
		this.s.selectByValue("*"); 
		this.orderDate.clear(); 
		this.orderCust.clear();
		this.orderTotal.clear(); 
		this.orderModifDt.clear();
	}
	public void orderIDFilter (String orderID) {	
		this.orderID.sendKeys(orderID); 
	}
	public void orderStatusFilter (String orderStatus) {
		this.s.selectByValue(orderStatus); 
	}
	public void orderDateFilter (String orderDate) {	
		this.orderDate.sendKeys(orderDate); 
	}
	public void orderCustFilter (String orderCust) {
		this.orderCust.sendKeys(orderCust); 
	}
	public void orderTotalFilter (String orderTotal) {	
		this.orderTotal.sendKeys(orderTotal); 
	}
	public void orderModifDtFilter (String orderModifDt) {
		this.orderModifDt.sendKeys(orderModifDt); 
	}
	public void clickFilter() {
		this.filter.click();
	}
	public void chkIDFilter(String orderID) {
		int x = this.orderIDList.size();
		for (int i=0; i<x; i++) {
			String ID = orderIDList.get(i).getText();
			System.out.println("Filtered value at row "+(i+1)+ ": " + ID+ " matches "+ orderID);
			if (!ID.contains(orderID)){
				System.out.println("Filtered value at row "+(i+1)+ ": " + ID+ " does NOT match "+ orderID);
			}
		}
	}
	public void chkStatusFilter(String orderStatus) {
		int x = this.orderStatusList.size();
		for (int i=0; i<x; i++) {
			String status = orderStatusList.get(i).getText();
			System.out.println("Filtered value at row "+(i+1)+ ": "+status+ " matches with "+ orderStatus);
			if (!status.equalsIgnoreCase(orderStatus)){
				System.out.println("Filtered value at row "+(i+1)+ ": "+ status+" does NOT match with "+ orderStatus);
			}
		}
	}
	public void chkDateFilter(String orderDate) {
		int x = this.orderDateList.size();
		for (int i=0; i<x; i++) {
			String Dt = orderDateList.get(i).getText();
			System.out.println("Filtered value at row "+(i+1)+ ": "+Dt+ " matches with "+ orderDate);
			if (!Dt.equalsIgnoreCase(orderDate)){
				System.out.println("Filtered value at row "+(i+1)+ ": "+ Dt+" does NOT match with "+ orderDate);
			}
		}
	}
	public void chkCustFilter(String orderCust) {
		int x = this.orderCustList.size();
		for (int i=0; i<x; i++) {
			String Cust = orderCustList.get(i).getText();
			System.out.println("Filtered value at row "+(i+1)+ ": "+Cust+ " matches with "+ orderCust);
			if (!Cust.equalsIgnoreCase(orderCust)){
				System.out.println("Filtered value at row "+(i+1)+ ": "+ Cust+" does NOT match with "+ orderCust);
			}
		}
	}
	public void chkTotalFilter(String orderTotal) {
		int x = this.orderTotalList.size();
		for (int i=0; i<x; i++) {
			String Total = orderTotalList.get(i).getText();
			System.out.println("Filtered value at row "+(i+1)+ ": "+Total+ " matches with "+ orderTotal);
			if (!Total.equalsIgnoreCase(orderTotal)){
				System.out.println("Filtered value at row "+(i+1)+ ": "+ Total+" does NOT match with "+ orderTotal);
			}
		}
	}
	public void chkModifDtFilter(String orderModifDt) {
		int x = this.orderModifDtList.size();
		for (int i=0; i<x; i++) {
			String ModifDt = orderModifDtList.get(i).getText();
			System.out.println("Filtered value at row "+(i+1)+ ": "+ModifDt+ " matches with "+ orderModifDt);
			if (!ModifDt.equalsIgnoreCase(orderModifDt)){
				System.out.println("Filtered value at row "+(i+1)+ ": "+ ModifDt+" does NOT match with "+ orderModifDt);
			}
		}
	}
}
