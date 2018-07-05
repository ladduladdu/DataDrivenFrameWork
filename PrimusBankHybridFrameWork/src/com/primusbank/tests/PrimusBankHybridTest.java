package com.primusbank.tests;
import java.io.IOException;
import org.testng.annotations.Test;
import com.primusbank.constants.PrimusBankConstants;
import com.primusbank.library.AdminHomePage;
import com.primusbank.library.BankerHomePage;
import com.primusbank.library.PrimusBankHomePage;
import com.utils.XLUtils;

public class PrimusBankHybridTest extends PrimusBankConstants
{

	PrimusBankHomePage phome=new PrimusBankHomePage();
	AdminHomePage ahome=new AdminHomePage();
	BankerHomePage bhome=new BankerHomePage();
	
	@Test
	public void keywrodDrivenTest() throws IOException
	{
		String kwfile="D:\\eclipse\\PrimusBankHybridFrameWork\\src\\com\\primusbank\\keywords\\PrimusBankKeywords.xlsx";
		String tcsheet="TestCases";
		String tssheet="TestSteps";
		
		int tccount,tscount;
		tccount=XLUtils.getRowCount(kwfile, tcsheet);
		tscount=XLUtils.getRowCount(kwfile, tssheet);
		
		String tcexeflg,tcid,tstcid,keyword,tcres;
		boolean tsres = false;
		
		for (int i = 1; i <= tccount; i++) 
		{
			tcexeflg=XLUtils.getCellData(kwfile, tcsheet, i, 2);
			if (tcexeflg.equalsIgnoreCase("Y")) 
			{
				tcid=XLUtils.getCellData(kwfile, tcsheet, i, 0);
				for (int j = 1; j <= tscount; j++) 
				{
					tstcid=XLUtils.getCellData(kwfile, tssheet, j, 0);
					if (tcid.equalsIgnoreCase(tstcid)) 
					{
						keyword=XLUtils.getCellData(kwfile, tssheet, j, 4);
						switch (keyword.toLowerCase()) 
						{
						case "adminlogin":
							  phome.adminuid=XLUtils.getCellData(kwfile, tssheet, j, 5);
							  phome.adminpwd=XLUtils.getCellData(kwfile, tssheet, j, 6);							  
							  tsres=phome.adminLogin(phome.adminuid,phome.adminpwd);
							break;
						case "adminlogout":
							  tsres=ahome.adminLogout();
							  break;
						case "bankerlogin":
							  phome.brname=XLUtils.getCellData(kwfile, tssheet, j, 5);
							  phome.bankeruid=XLUtils.getCellData(kwfile, tssheet, j, 6);
							  phome.bankerpwd=XLUtils.getCellData(kwfile, tssheet, j, 7);
							  tsres=phome.bankerLogin(phome.brname,phome.bankeruid,phome.bankerpwd);
							  break;
						case "bankerlogout":
							  tsres=bhome.bankerLogout();
							  break;
						}
						String stepres;
						if (tsres) 
						{
							stepres="Pass";
							XLUtils.setCellData(kwfile, tssheet, j, 3, stepres);
							XLUtils.fillGreenColor(kwfile, tssheet, j, 3);
						} else 
						{
							stepres="Fail";
							XLUtils.setCellData(kwfile, tssheet, j, 3, stepres);
							XLUtils.fillRedColor(kwfile, tssheet, j, 3);
						}
						
						tcres=XLUtils.getCellData(kwfile, tcsheet, i, 3);
						if (!tcres.equalsIgnoreCase("FAIL")) 
						{
							XLUtils.setCellData(kwfile, tcsheet, i, 3, stepres);
						}
						tcres=XLUtils.getCellData(kwfile, tcsheet, i, 3);
						if (tcres.equalsIgnoreCase("PASS")) 
						{
							XLUtils.fillGreenColor(kwfile, tcsheet, i, 3);
						} else 
						{
							XLUtils.fillRedColor(kwfile, tcsheet, i, 3);
						}		
						
					}
				}
				
			} else 
			{
				XLUtils.setCellData(kwfile, tcsheet, i, 3, "Blocked");
				XLUtils.fillRedColor(kwfile, tcsheet, i, 3);
			}
		}
		
		
		
	}
	
	
	
}
