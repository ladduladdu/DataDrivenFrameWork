package com.primusbank.tests;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.primusbank.constants.Primusbankconstants;
import com.primusbank.libraries.Adminlogin;
import com.primusbank.libraries.BankerLogin;
import com.primusbank.utils.Xlutils;
public class DataDrivenTest  extends Primusbankconstants
{
public String Xlfile="D:\\BankLogin Details.xlsx";
public String Xlsheet="Employe details";
@Test
	public void bankLogintest() throws IOException
	{
	boolean res;
	int rc;
	rc=Xlutils.getRowcount(Xlfile, Xlsheet);
	System.out.println(rc);
	Adminlogin al=new Adminlogin();
	BankerLogin bl=new BankerLogin();
	for (int i = 1; i <=rc; i++) 
	{
		bl.brname=Xlutils.getCelldata(Xlfile, Xlsheet, i, 0);
		bl.uid=Xlutils.getCelldata(Xlfile, Xlsheet, i, 1);
		bl.pwd=Xlutils.getCelldata(Xlfile, Xlsheet, i, 2);
		res=bl.bankerLogin(bl.brname, bl.uid, bl.pwd);	
		if (res) 
		{
			Xlutils.setCelldata(Xlfile, Xlsheet, i, 3, "pass");
			Xlutils.fillGreencolour(Xlfile, Xlsheet, i, 3);
		} 
		else 
		{
			Xlutils.setCelldata(Xlfile, Xlsheet, i, 3, "Fail");
			Xlutils.fillRedcolour(Xlfile, Xlsheet, i, 3);
		}
		Assert.assertTrue(res);
		al.adminLogout();	
	}
	}	
}
