package com.PageClasses;

import org.checkerframework.common.util.report.qual.ReportCall;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage {
WebDriver driver;
public CustomerPage(WebDriver driver)
{
	this.driver=driver;
}
//define repository
@FindBy(xpath = "(//a[contains(text(),'Customers')])[2]")
WebElement ObjCustomerLink;
@FindBy(xpath = "(//span[@data-caption='Add'])[1]")
WebElement ObjClickAddIcon;
@FindBy(name = "x_Customer_Number")
WebElement ObjCustomerNumber;
@FindBy(name = "x_Customer_Name")
WebElement ObjCustomername;
@FindBy(name = "x_Address")
WebElement ObjAddress;
@FindBy(name = "x_City")
WebElement ObjCity;
@FindBy(name = "x_Country")
WebElement ObjCountry;
@FindBy(name = "x_Contact_Person")
WebElement ObjContactperson;
@FindBy(name = "x_Phone_Number")
WebElement ObjPhonenumber;
@FindBy(name = "x__Email")
WebElement ObjEmail;
@FindBy(name = "x_Mobile_Number")
WebElement ObjMobileNumber;
@FindBy(name = "x_Notes")
WebElement ObjNotes;
@FindBy(id = "btnAction")
WebElement ObjAddBtn;
@FindBy(xpath = "//button[normalize-space()='OK!']")
WebElement ObjConfirmOk;
@FindBy(xpath = "(//button[starts-with(text(),'OK')])[6]")
WebElement ObjAlertOk;
@FindBy(xpath = "//span[@data-caption='Search']")
WebElement ObjSearchPanel;
@FindBy(xpath = "//input[@id='psearch']")
WebElement ObjSearcTextbox;
@FindBy(xpath = "//button[@id='btnsubmit']")
WebElement ObjSearchbtn;
@FindBy(xpath = "//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
WebElement webtable;
public boolean add_Customer(String cname,String Address,String city,String Country,String cperson,
		String pnumber,String email,String mnumber,String notes) throws Throwable
{
	Actions ac = new Actions(driver);
	ac.moveToElement(this.ObjCustomerLink).click().perform();
	Thread.sleep(2000);
	ac.moveToElement(this.ObjClickAddIcon).click().perform();
	Thread.sleep(2000);
	String Exp_Data = this.ObjCustomerNumber.getAttribute("value");
	this.ObjCustomername.sendKeys(cname);
	this.ObjAddress.sendKeys(Address);
	this.ObjCity.sendKeys(city);
	this.ObjCountry.sendKeys(Country);
	this.ObjContactperson.sendKeys(cperson);
	this.ObjPhonenumber.sendKeys(pnumber);
	this.ObjEmail.sendKeys(email);
	this.ObjMobileNumber.sendKeys(mnumber);
	this.ObjNotes.sendKeys(notes);
	ac.moveToElement(this.ObjAddBtn).click().perform();
	Thread.sleep(2000);
	ac.moveToElement(this.ObjConfirmOk).click().build().perform();
	ac.pause(4000);
	ac.moveToElement(this.ObjAlertOk).click().perform();
	Thread.sleep(3000);
	if(!this.ObjSearcTextbox.isDisplayed())
		this.ObjSearchPanel.click();
	this.ObjSearcTextbox.clear();
	this.ObjSearcTextbox.sendKeys(Exp_Data);
	this.ObjSearchbtn.click();
	Thread.sleep(4000);
	String Act_data = this.webtable.getText();
	if(Act_data.equals(Exp_Data))
	{
		Reporter.log(Act_data+"     "+Exp_Data,true);
		return true;
	}
	else
	{
		Reporter.log(Act_data+"     "+Exp_Data,true);
		return false;
	}
}


}
