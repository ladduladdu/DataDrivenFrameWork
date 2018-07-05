package com.primusbank.library;

import org.openqa.selenium.By;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

import com.primusbank.constants.PrimusBankConstants;
import com.utils.Generics;

public class Branch extends PrimusBankConstants
{

	
	public boolean createBranch(String branchname,String add1,String zip,String country,String state,String city)
	{
		driver.findElement(By.xpath("//table/tbody/tr[2]/td/a/img")).click();
		driver.findElement(By.id("BtnNewBR")).click();
		driver.findElement(By.id("txtbName")).sendKeys(branchname);
		driver.findElement(By.id("txtAdd1")).sendKeys(add1);
		driver.findElement(By.id("txtZip")).sendKeys(zip);
		
		Generics.selectItem(driver, "//*[@id='lst_counrtyU']", country);
		Sleeper.sleepTightInSeconds(2);
		Generics.selectItem(driver, "//*[@name='lst_stateI']", state);
		Sleeper.sleepTightInSeconds(2);
		Generics.selectItem(driver, "//*[@id='lst_cityI']", city);
		Sleeper.sleepTightInSeconds(2);
		driver.findElement(By.id("btn_insert")).click();
		String msg=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if (msg.toLowerCase().contains("new branch with id")) 
		{
			return true;
		} else 
		{
			return false;
		}		
	}
	
	
	public boolean createBranch(String branchname,String add1,String add2,String zip,String country,String state,String city)
	{
		driver.findElement(By.xpath("//table/tbody/tr[2]/td/a/img")).click();
		driver.findElement(By.id("BtnNewBR")).click();
		driver.findElement(By.id("txtbName")).sendKeys(branchname);
		driver.findElement(By.id("txtAdd1")).sendKeys(add1);
		driver.findElement(By.id("Txtadd2")).sendKeys(add2);
		driver.findElement(By.id("txtZip")).sendKeys(zip);
		
		Generics.selectItem(driver, "//*[@id='lst_counrtyU']", country);
		Generics.selectItem(driver, "//*[@name='lst_stateI']", state);
		Generics.selectItem(driver, "//*[@id='lst_cityI']", city);
		driver.findElement(By.id("btn_insert")).click();
		String msg=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if (msg.toLowerCase().contains("new branch with id")) 
		{
			return true;
		} else 
		{
			return false;
		}		
	}
	
	
	
	
	
	public void updateBranch()
	{
		
	}
	
	
	public void deleteBranch()
	{
		
	}
	
	
	public void searchBranch()
	{
		
	}
	
}
