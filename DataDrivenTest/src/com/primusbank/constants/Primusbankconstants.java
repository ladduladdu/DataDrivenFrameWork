package com.primusbank.constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Primusbankconstants 
{
  public static WebDriver driver;
public  static String url="http://primusbank.qedgetech.com/";
 public static void launchApp()
 {
	System.setProperty("webdriver.chrome.driver","‪C:\\Users\\malli\\Downloads\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get(url);
 }
	
 public static void closeApp()
 {
	 driver.close();
 }	
	
	
}
