package com.primusbank.constants;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.primusbank.library.AdminHomePage;
import com.primusbank.library.PrimusBankHomePage;

public class AdminModuleConstants extends PrimusBankConstants 
{

	@BeforeTest
	public void adminLogin()
	{
		PrimusBankHomePage phome=new PrimusBankHomePage();
		phome.adminuid="Admin";
		phome.adminpwd="Admin";
		phome.adminLogin(phome.adminuid, phome.adminpwd);
	}
	
	@AfterTest
	public void adminLogout()
	{
		AdminHomePage ahome=new AdminHomePage();
		ahome.adminLogout();
	}
	
	
	
}
