package com.ecommerce.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SrchCustByName {
	
	public WebDriver driver;
	
public SrchCustByName(WebDriver driver)
	{
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
	}
	
 @FindBy(id="SearchFirstName")
 @CacheLookup
 WebElement fname;
 
 @FindBy(id="SearchLastName")
 @CacheLookup
 WebElement Lname;
 
 @FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
 @CacheLookup
 List<WebElement>rows;
 
 @FindBy(id="search-customers")
 @CacheLookup
 WebElement srchbtn;
 
 public void setFirstName(String firstname)
 {
	 fname.sendKeys(firstname);
 }
 
 public void setLastName(String lastname)
 {
	 Lname.sendKeys(lastname);
 }
 public void ClkOnSrch()
 {
	 srchbtn.click();
 }
 
 public int getnoRows()
 {
	return(rows.size());
}
 
 
 public boolean SearchCustomerByName(String name)
 {
	boolean flag=false;
for(int i=1;i<=getnoRows();i++)
{
	String Name = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+ i +"]/td[3]")).getText();
	
	if(Name.equals(name))
	{
	    flag=true;
		break;
	}	
}
return flag;

	 
	 
 }
	

}
