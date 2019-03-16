package com.selenium.organisation;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.selenium.lib.FileUtil;

/*
 * 
 * @author Biswa
 * 
 */
public class CreateOrganizationWithRatingAsActiveTest {
@Test
	public static void CreateOrganizationWithRatingAsActive() throws InterruptedException, Throwable {
		
		
		/*create java object to physical file*/
		FileReader fobj=new FileReader("./data/commonData.properties");
		 Properties pObj=new Properties();
	     pObj.load(fobj);
	     
	     String URL=pObj.getProperty("url");
	     String USERNAME=pObj.getProperty("username");
	     String PASSWORD=pObj.getProperty("password");
	     
	 /*launch the browser*/
         WebDriver driver=new FirefoxDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
         driver.get(URL);
         
         /*login to application*/
         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
         driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
         driver.findElement(By.id("submitButton")).click();
       
         FileUtil flib=new FileUtil();
 	    Random num=new Random();
 	    String orgName=flib.getExcelData("Sheet1", 3, 0)+num.nextInt(100);
 	   
 	    
         /*Place the mouse cursor on the "Organization" button and click on it*/
         driver.findElement(By.linkText("Organizations")).click();
       
         
         /*Place the mouse cursor on "+" symbol and click on it to create new organization*/
         driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
           
         
         /*Enter mandatory fields and select "Active" from the dropdown in "Rating" field*/
         driver.findElement(By.name("accountname")).sendKeys(orgName);
         WebElement wb=driver.findElement(By.xpath("//select[@name='rating']"));
         Select sel=new Select(wb);
         sel.selectByVisibleText("Active");
         
         /*validation*/
         String exOption=flib.getExcelData("Sheet1", 3, 3);
         int i=0;
         boolean flag=false;
         List<WebElement> lst=sel.getOptions();
         System.out.println(lst.size());
         for(i=0;i<lst.size();i++) {
      	   String actOption=lst.get(i).getText();
      	   if(exOption.equals(actOption)) {
      		   sel.selectByVisibleText(exOption);
          	   flag=true;
          	   break;
      	   } 
      	  } if(flag==true) {  	   
          	   System.out.println("Data is matched==>Pass");        	
             }else {
          	   System.out.println("Data is not matched==>Fail");
         }
        
     
        /* Click on Save Button*/
         driver.findElement(By.xpath("//input[@accesskey='S']")).click();
         
        
         /*Sign out*/
         WebElement wb1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
         Actions act=new Actions(driver);
         act.moveToElement(wb1).perform();
         driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
         
	}

}
