package com.primusbank.libraries;
import org.openqa.selenium.By;

import com.primusbank.constants.Primusbankconstants;
public class Adminlogin  extends Primusbankconstants
{
	public String uid,pwd;
public void adminLogin(String uid,String pwd)
{
	driver.findElement(By.id("txtuId")).sendKeys(uid);
	driver.findElement(By.id("txtPword")).sendKeys(pwd);
	driver.findElement(By.id("login")).click();
}

public void adminLogout()
{
	driver.findElement(By.xpath("//img[@src='images/admin_but_03.jpg']")).click();
}
}