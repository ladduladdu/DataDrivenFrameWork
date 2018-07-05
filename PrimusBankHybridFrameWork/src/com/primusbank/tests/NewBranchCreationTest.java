package com.primusbank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.primusbank.constants.AdminModuleConstants;
import com.primusbank.constants.PrimusBankConstants;
import com.primusbank.library.Branch;

public class NewBranchCreationTest extends AdminModuleConstants
{

	@Test
	public void branchCreationTest()
	{
		boolean res;
		Branch br=new Branch();
		res=br.createBranch("MtDemoBranch4","abcdrd" , "12345", "INDIA", "Andhra Pradesh", "Hyderabad");
		Assert.assertTrue(res);		
	}
	
	
	
}
