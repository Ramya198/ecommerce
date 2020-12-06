package com.ecommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pageObjects.AdnwCustmr;
import com.ecommerce.pageObjects.CustmrEmlsrch;
import com.ecommerce.pageObjects.Loginpage;
import com.ecommerce.testbase.Testbase;

public class TC_CustmrSrchByEmail_004 extends Testbase {

	 @Test
	public void SrchCustmrByEmail() throws IOException, InterruptedException
	 {
		logger.info("****logging info*****");
		
		driver.get(configobj.getProperty("url"));
		Loginpage lp = new Loginpage(driver);
		lp.setusr(configobj.getProperty("username"));
		lp.setpaswd(configobj.getProperty("password"));
		lp.loginbtn();
		Thread.sleep(3000);
		
		logger.info("***Entering customer Details*****");
		 AdnwCustmr adcust = new AdnwCustmr(driver);
		 adcust.lnkCustmr();
		 adcust.lnkCustmr1();
		 Thread.sleep(3000);
		
	logger.info("***Searching customer by emailid***");	 
	 CustmrEmlsrch custsrch = new CustmrEmlsrch(driver);
	 custsrch.setemail("victoria_victoria@nopCommerce.com");
	 custsrch.setFirstName("Victoria");
	 custsrch.setLastName("Terces");
	 custsrch.clicksearch();
	 
	 logger.info("***Validating Emailid***");
	 
	 boolean status=custsrch.searchCustmrEmail("victoria_victoria@nopCommerce.com");
	 if(status==true)
	 {
		 logger.info("***Verified Customerid***");
		 Assert.assertTrue(true);
	 }
	 else
	 {
		 logger.error("***not Verified customerid***");
		 captureScreen(driver,"SrchCustmrByEmail");
		 Assert.assertTrue(false);
	 }
	 
	 
	 
	

	
	
	
	
	
	 }	

}
