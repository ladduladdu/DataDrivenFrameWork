package com.primusbank.tests;
import org.openqa.selenium.By;

import com.primusbank.constants.Primusbankconstants;
import com.primusbank.libraries.Adminlogin;

public class LoginTest  extends Primusbankconstants
{
	public static void main(String[] args)
	{
		
launchApp();
 Adminlogin al=new Adminlogin();
 al.uid="Admin";
al.pwd="Admin";
al.adminLogin(al.uid, al.pwd);
if (driver.findElement(By.xpath("//img[@src='images/admin_but_01.jpg']")).isDisplayed()) 
{
System.out.println("Admin login pass");
}
al.adminLogout();
closeApp();
	}

}
