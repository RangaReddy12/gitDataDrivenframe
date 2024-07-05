package com.PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {
//define Repository for login
	@FindBy(id="btnreset")
	WebElement ObjReset;
	@FindBy(xpath = "//input[@id='username']")
	WebElement ObjUser;
	@FindBy(name = "password")
	WebElement ObjPass;
	@FindBy(id="btnsubmit")
	WebElement ObjLogin;
	//method for login
	public void verify_Login(String user,String pass)
	{
		ObjReset.click();
		ObjUser.sendKeys(user);
		ObjPass.sendKeys(pass);
		ObjLogin.click();
	}
}
