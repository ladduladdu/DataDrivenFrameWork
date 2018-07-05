package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Generics 
{

	public static void selectItem(WebDriver driver,String locator,String item)
	{
		WebElement listelement;
		listelement=driver.findElement(By.xpath(locator));
		Select dlist=new Select(listelement);
		dlist.selectByVisibleText(item);		
	}   
	    
	
	
	
	
}
