package com.ecommerce.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustmrEmlsrch {
	
	public WebDriver driver;
	
public  CustmrEmlsrch (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath="//input[@id='SearchEmail']")
@CacheLookup
WebElement email;

@FindBy(id="SearchFirstName")
@CacheLookup
WebElement fname;

@FindBy(id="SearchLastName")
@CacheLookup
WebElement Lname;

@FindBy(xpath="//button[@id='search-customers']")
@CacheLookup
WebElement search;

@FindBy(xpath="//div[@id='customers-grid_wrapper']//tbody/tr")
@CacheLookup
List<WebElement>rows;


   public void setemail(String emailid)
   {
	email.sendKeys(emailid);
   }
   public void setFirstName(String firstname)
   {
  	 fname.sendKeys(firstname);
   }
   
   public void setLastName(String lastname)
   {
  	 Lname.sendKeys(lastname);
   }
   
   
   public void clicksearch()
    {
	search.click();
    }
   
   public int getRows()
   {
	return (rows.size());
   } 
   
  
   public boolean searchCustmrEmail(String emailid)
   {
     boolean flag=false;
     
    for(int i=1;i<=getRows();i++)
    {
    String Email = driver.findElement(By.xpath("//div[@id='customers-grid_wrapper']//tbody/tr["+ i +"]/td[2]")).getText();
    
    if(Email.equals(emailid))
       {
    	flag=true;
    	break;
       }

    }
	return flag;
	   
}

   
 

}
