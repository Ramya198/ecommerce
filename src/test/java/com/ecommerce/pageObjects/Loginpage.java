package com.ecommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
public	WebDriver driver;
	
public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement Username;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement paswd;
	
	@FindBy(xpath="//input[@value='Log in']")
	@CacheLookup
	WebElement login;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement logout;
	
 public	void setusr (String id)
	{
	 Username.clear();
		Username.sendKeys(id);
	}
	
 public	void setpaswd (String pwd)
	{
	 paswd.clear();
		paswd.sendKeys(pwd);
	}
	
  public void loginbtn ()
    {
    	login.click();
    }
    
  public  void logoutbtn ()
    {
    	logout.click();
    }
}
