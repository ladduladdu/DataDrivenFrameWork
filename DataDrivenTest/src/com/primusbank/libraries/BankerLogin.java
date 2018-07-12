package com.primusbank.libraries;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.primusbank.constants.Primusbankconstants;
public class BankerLogin  extends Primusbankconstants
{
	 public String brname,uid,pwd;	
	 public boolean adminLogin(String uid,String pwd)
		{
		driver.findElement(By.id("txtuId")).sendKeys(uid);
		driver.findElement(By.id("txtPword")).sendKeys(pwd);
		driver.findElement(By.id("login")).click();
		return false;
	}

	public boolean bankerLogin(String brname, String uid, String pwd)
	{
		WebElement element;
		element= driver.findElement(By.id("drlist"));
		Select blist= new Select(element);
		blist.selectByVisibleText(brname);
		driver.findElement(By.id("txtuId")).sendKeys(uid);
		driver.findElement(By.id("txtPword")).sendKeys(pwd);
		driver.findElement(By.id("login")).click();
		return false;
	
}
}