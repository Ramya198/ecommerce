package com.ecommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecommerce.pageObjects.Loginpage;
import com.ecommerce.testbase.Testbase;
import com.ecommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends Testbase  {
	
	@Test (dataProvider = "LoginTest")
	public void logintest (String user,String pwd,String exp) throws InterruptedException
	{

		driver.get(configobj.getProperty("url"));
		Loginpage lp = new Loginpage(driver);
		lp.setusr(user);
		lp.setpaswd(pwd);
		lp.loginbtn();
		
		logger.info("***Starting TC_Logintest_001***");
		
		String act_title= "Dashboard / nopCommerce administration123" ;
		String exp_title = driver.getTitle();
		
		logger.info("**Validating TC_Logintest_001***");
		
		if(exp_title.equals(act_title))
		{
		   if(exp.equals("Pass"))
		   {
			   logger.info("*******logintest passed*****");
			  lp.logoutbtn();
			  Thread.sleep(3000);
			  Assert.assertTrue(true);
		    }
			
		   else if(exp.equals("Fail"))
			{
			   logger.info("*******logintest failed*****");
				  lp.logoutbtn(); 
				  Thread.sleep(3000);
				  Assert.assertTrue(false);
			}
			
			
		}
		

		if(!exp_title.equals(act_title))
		{
		   if(exp.equals("Pass"))
		   {
			   logger.info("*******logintest failed*****");
			  Thread.sleep(3000);
			  Assert.assertTrue(false);
		    }
			
		   else if(exp.equals("Fail"))
			{
			   logger.info("*******logintest passed*****");
				Thread.sleep(3000);
				  Assert.assertTrue(true);
			}
			
			
		}
	}
	

	
	@DataProvider(name = "LoginTest")
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/testdata/LoginData.xlsx";
		
		int rows = XLUtils.getRowCount(path,"Sheet1");
		int cols = XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][] = new String[rows][cols];
		
		for(int i=1;i<=rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				logindata[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
	return logindata;
		
		
		
	}

}
