 package com.ecommerce.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdnwCustmr {
	
	public WebDriver driver;
	
	WebElement listitem;

    public AdnwCustmr(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

    @FindBy(xpath="/html/body/div[3]/div[2]/div/ul/li[4]/a")
	@CacheLookup
    WebElement Cstmr;
	
   @FindBy(xpath="/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]/a" )
   @CacheLookup
   WebElement Cstmr1;
   
   @FindBy(xpath="//a[normalize-space()='Add new']")
   @CacheLookup
   WebElement Addnw;
   
   @FindBy(xpath="//input[@id='Email']")
   @CacheLookup
   WebElement email;
   
   @FindBy (xpath="//input[@id='Password']")
   @CacheLookup
   WebElement passwd;
   
   @FindBy(xpath="//input[@id='FirstName']")
   @CacheLookup
   WebElement frstnme;
   
   @FindBy(xpath="//input[@id='Gender_Male']")
   @CacheLookup
   WebElement male;
   
   @FindBy(xpath="//input[@id='Gender_Female']")
   @CacheLookup
   WebElement Female;
   
   @FindBy(xpath="//*[@id='customer-info']/div[2]/div[1]/div[10]/div[2]/div/div[1]/div")
   @CacheLookup
   WebElement Custmrrole;
   
   @FindBy(xpath="//div[@class='content']//li[1]")
   @CacheLookup
   WebElement Admin;
   
   @FindBy(xpath="//li[contains(text(),'Forum Moderators')]")
   @CacheLookup
   WebElement ForumMod;
   
   @FindBy(xpath="//li[normalize-space()='Guests']")
   @CacheLookup
   WebElement guest;
   
   @FindBy(xpath="//li[normalize-space()='Registered']")
   @CacheLookup
   WebElement regstered;
   
   @FindBy(xpath="//li[contains(text(),'Vendors')]")
   @CacheLookup
   WebElement vendor;
   
   @FindBy(id="DateOfBirth")
   @CacheLookup
   WebElement dob;
   
   @FindBy(id="VendorId")
   @CacheLookup
   WebElement mgrvendor;
   
   @FindBy(xpath="//button[@name='save']")
   @CacheLookup
   WebElement btnsave;
   
   @FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
   @CacheLookup
   WebElement txtmsg;
   
   public void lnkCustmr()
   {
	   Cstmr.click(); 
   }
   
   public void lnkCustmr1()
   {
	   Cstmr1.click();
   }
   
   public void btnAddnew()
   {
	   Addnw.click();
   }
   
   public void txtbxemail(String id)
   {
	   email.sendKeys(id);
   }
   
   public void txtbxpasswd(String pwd)
   {
	   passwd.sendKeys(pwd);   
   }
   
   public void txtbxfrstnme (String fname)
   {
	   frstnme.sendKeys(fname);
   }
   
   public void setgender(String rbtn)
   {
	  if(rbtn.equals("Female"))
	{
		  Female.click();
	}
	  else if(rbtn.equals("male"))
	  {
		 male.click(); 
	  }
	  else 
	  {
		  Female.click();
	  }
   }
   
   public void setdob(String date)
   {
	   dob.sendKeys(date);
   }
   
   public void lstbxCustmr(String role)
   {
	   Custmrrole.click();
	   
	   if(role.equals("Administarators"))
	   {   
	   listitem = Admin;
	   }
	
	   else if(role.equals("Vendors"))  
	   {
		   listitem=vendor;
	   }
	   else if(role.equals("Guests"))
	   {
		   Admin.click();
		   listitem = guest;
	   }
	   else
	   {
		   listitem=ForumMod;
	   }
	   
	  // listitem.click();
	   JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", listitem);
   }
 
   public void setMgrvendor(String text)
   {
	   Select drp = new Select(mgrvendor);
		drp.selectByVisibleText(text);	   
   }
 
   public void clksave()
   {
	   btnsave.click();
   }
   
   public boolean confirmmsg()
   {
	String msg = txtmsg.getText();
	if(msg.contains("The new customer has been added successfully"))
	{
	 return true;
	}
	else
	{
		return false;
	}
	
   }
}
