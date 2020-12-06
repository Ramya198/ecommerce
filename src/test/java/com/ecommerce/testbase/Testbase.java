package com.ecommerce.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {

public Properties configobj;
	
	public WebDriver driver;
   //public Logger logger=Logger.getLogger(this.getClass());
	public Logger logger=LogManager.getLogger(this.getClass());
	
	@BeforeClass
	@Parameters ("browser")
	public void setup(String br) throws IOException
		{ 
		configobj = new Properties();
		FileInputStream configfile = new FileInputStream (".\\resources\\config.properties");
		configobj.load(configfile);
		
	if (br.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if (br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	} 
	
	@AfterClass
	public void teardown ()
	{
		driver.close();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomstring()
	{
		String genrandomString = RandomStringUtils.randomAlphabetic(5);
		return(genrandomString);
	}
	
}
