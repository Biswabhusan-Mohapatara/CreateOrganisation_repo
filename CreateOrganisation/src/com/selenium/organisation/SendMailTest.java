package com.selenium.organisation;
/*
 * 
 * @author Biswa
 * 
 * */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
/*
 * 
 * @author Biswa
 * 
 * */

public class SendMailTest {

	public static void main(String[] args) {
		
		/*test data*/
		String URL="http://localhost:8888/index.php?action=Login&module=Users";
		String username="admin";
		String password="manager";
		

		/*launch FirefoxBrowser*/
	       WebDriver driver=new FirefoxDriver();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	       driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	       
	       /*login to application*/
	       driver.findElement(By.name("user_name")).sendKeys("admin");
	       driver.findElement(By.name("user_password")).sendKeys("manager");
	       driver.findElement(By.id("submitButton")).click();
	      
	       
	       /*Place the mouse cursor on the "Organization" button and click on it*/
	       driver.findElement(By.linkText("Organizations")).click();
	       
	       /*Click on any of the existing organization*/
	       driver.findElement(By.linkText("Dtexus")).click();
	       
	    
          /*Select any of the organization by clicking on the checkbox given in each row and click on "Send Mail" button*/
	       WebElement wb19=driver.findElement(By.xpath("//img[@src='themes/images/sendmail.png']"));
	       Actions act19=new Actions(driver);
	       act19.moveToElement(wb19);
	       wb19.click();
	       
	       /*Select the "Email" checkbox with mailid (if mentioned during creation of the organization) and click on "Select" button*/
	       driver.findElement(By.name("Select")).click();
	       
	       /*Sign Out*/
	       WebElement wbe15=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	        Actions act112=new Actions(driver);
	        act112.moveToElement(wbe15).perform();
	        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	        
    


	}

}
