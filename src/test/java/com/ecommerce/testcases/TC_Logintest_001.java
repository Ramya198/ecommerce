package com.ecommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ecommerce.testbase.Testbase;

import com.ecommerce.pageObjects.*;

public class TC_Logintest_001 extends Testbase {
	
	
@Test
 public void logintest () throws IOException
 
 {
	
	driver.get(configobj.getProperty("url"));
	Loginpage lp = new Loginpage(driver);
	lp.setusr(configobj.getProperty("username"));
	lp.setpaswd(configobj.getProperty("password"));
	lp.loginbtn();
	
	logger.info("***validating TC_Logintest_001***");
	String act_title= "Dashboard / nopCommerce administration" ;
	String exp_title = driver.getTitle();
	
	if (exp_title.equals(act_title))
	{
		logger.info("*** Test case is success***");
		Assert.assertTrue(true);
	}
	
	else 
	{
		logger.error("***test case failed***");
		captureScreen(driver,"logintest");
		Assert.assertTrue(false);
	}
	//logger.info("***validating TC_Logintest_001***");
	//Assert.assertEquals(act_title,exp_title );
	
}




}
