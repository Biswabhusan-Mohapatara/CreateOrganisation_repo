package com.selenium.organisation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.selenium.lib.FileUtil;



/*
 * 
 * @author Biswa
 * 
 */
public class CreateOrganisationWithPhoneNoTest {

	@Test
	public static void CreateOrganisationWithPhoneNo() throws InterruptedException, Throwable {
	
		
		
		/*create java object to physical file*/
	   	 FileReader fobj=new FileReader("./data/commonData.properties");
		 Properties pObj=new Properties();
	     pObj.load(fobj);
	     
	     String URL=pObj.getProperty("url");
	     String USERNAME=pObj.getProperty("username");
	     String PASSWORD=pObj.getProperty("password");
	     
	    FileUtil flib=new FileUtil();
	    Random num=new Random();
	    String orgName=flib.getExcelData("Sheet1", 1, 0)+num.nextInt(100);
	    String phnName=flib.getExcelData("Sheet1", 1, 1);
	    
		/*launch FirefoxBrowser*/
       WebDriver driver=new FirefoxDriver();
       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
       driver.manage().window().maximize();
       driver.get(URL);
       
       /*login to application*/
       driver.findElement(By.name("user_name")).sendKeys(USERNAME);
       driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
       driver.findElement(By.id("submitButton")).click();
      
       /**/
       /*validation*/
       String pTitle=driver.getTitle();
       System.out.println(pTitle);
       String expecpTitle=flib.getExcelData("Sheet1", 1, 2);
       if(pTitle.equals(expecpTitle)) {
    	   System.out.println("Home Page displayed==>Pass");
       }else {
    	   System.out.println("Home Page not displayed==>Fail");
       }
    	   
       /*Place the mouse cursor on the "Organization" button and click on it*/
       driver.findElement(By.linkText("Organizations")).click();
     
       
       /*Place the mouse cursor on "+" symbol and click on it to create new organization*/
       driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
         
       
       /*Enter the mandatory values, phone no and click on Save button*/
       driver.findElement(By.name("accountname")).sendKeys(orgName);
       driver.findElement(By.id("phone")).sendKeys(phnName);
       driver.findElement(By.xpath("//input[@accesskey='S']")).click();
      
       
       /*validation*/
       WebElement wb123=driver.findElement(By.id("dtlview_Phone"));
       String str123=wb123.getText();
       if(str123.equals(phnName)) {
    	   System.out.println("phone no matched==>Pass");
       }else {
    	   System.out.println("phone no not matched==>Fail");
       }
      
        /*sign out*/
       WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
       Actions act=new Actions(driver);
       act.moveToElement(wb).perform();
       driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
       
       
	}

}
