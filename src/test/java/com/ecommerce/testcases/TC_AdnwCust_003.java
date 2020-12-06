package com.ecommerce.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pageObjects.AdnwCustmr;
import com.ecommerce.pageObjects.Loginpage;
import com.ecommerce.testbase.Testbase;

public class TC_AdnwCust_003 extends Testbase {
	
	@Test
	 public void addnewCust () throws IOException, InterruptedException
	 
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
		 adcust.btnAddnew();
		 Thread.sleep(3000);
		 
		logger.info("****Providing Customer details****"); 
		 
		String emailid= randomstring()+"@gmail.com";
		
		adcust.txtbxemail(emailid);
		adcust.txtbxpasswd("Scorpio@1989");
		adcust.txtbxfrstnme("Ramya");
		Thread.sleep(3000);
		adcust.setgender("Female");
		adcust.setdob("11/4/2020");
		
		Thread.sleep(3000);
        adcust.lstbxCustmr("Forum Moderators");
        adcust.setMgrvendor("Vendor 1");
        
        Thread.sleep(3000);
        adcust.clksave();
        
        Thread.sleep(3000);
        
      logger.info("****validating*****");  
       if (adcust.confirmmsg())
       {
    	   logger.info("***Cust info saved sucessfully*****");
    	   Assert.assertTrue(true);
       }
       else 
       {
    	   logger.warn("****Cust info not saved******");
		Assert.assertTrue(false);
		captureScreen(driver,"addnewCust");
       }

	 }
}
