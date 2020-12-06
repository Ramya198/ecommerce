package com.ecommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pageObjects.AdnwCustmr;
import com.ecommerce.pageObjects.Loginpage;
import com.ecommerce.pageObjects.SrchCustByName;
import com.ecommerce.testbase.Testbase;

public class TC_SrchCustByName_005 extends Testbase {
	
	@Test
	public void srchcustomerbyname() throws IOException, InterruptedException
	{
		logger.info("****Customer Login*****");
		driver.get(configobj.getProperty("url"));
		Loginpage lp = new Loginpage(driver);
		lp.setusr(configobj.getProperty("username"));
		lp.setpaswd(configobj.getProperty("password"));
		lp.loginbtn();
	
		logger.info("***Navigating to CustomerSearchPage****");
		 AdnwCustmr adcust = new AdnwCustmr(driver);
		 adcust.lnkCustmr();
		 adcust.lnkCustmr1();
		 Thread.sleep(3000);
	
		 logger.info("***Entering Customer Data****");
SrchCustByName srchbyname = new SrchCustByName(driver);
      
srchbyname.setFirstName("Victoria");
srchbyname.setLastName("Terces");
srchbyname.ClkOnSrch();
Thread.sleep(3000);
	
  logger.info("***Validating Data****");
 boolean status = srchbyname.SearchCustomerByName("Victoria Terces"); 
 
    if(status==true)
     {
	  logger.info("*****Valid data****");
	  Assert.assertTrue(true);
      }
     else
      {
	  logger.error("****Invalid Data****");
	  captureScreen(driver,"srchcustomerbyname");
	  Assert.assertTrue(false); 
      }
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
