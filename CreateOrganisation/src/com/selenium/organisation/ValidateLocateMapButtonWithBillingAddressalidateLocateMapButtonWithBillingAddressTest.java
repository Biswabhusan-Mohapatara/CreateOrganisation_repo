package com.selenium.organisation;

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
public class ValidateLocateMapButtonWithBillingAddressalidateLocateMapButtonWithBillingAddressTest {

	public static void main(String[] args) throws InterruptedException {

		/*test data*/
		String URL="http://localhost:8888/index.php?action=Login&module=Users";
		String username="admin";
		String password="manager";
		
		
		/*launch FirefoxBrowser*/
	       WebDriver driver=new FirefoxDriver();
	       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	       driver.manage().window().maximize();
	       driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	       
	       /*login to application*/
	       driver.findElement(By.name("user_name")).sendKeys("admin");
	       driver.findElement(By.name("user_password")).sendKeys("manager");
	       driver.findElement(By.id("submitButton")).click();
	    
	       
	       
	       /*Place the mouse cursor on the "Organization" button and click on it*/
	       driver.findElement(By.linkText("Organizations")).click();
	      

	       /*Click on any of the existing organization*/
	       driver.findElement(By.linkText("Dtexus")).click();
	      
	       
	       /*Place the mouse cursor on Locate Map button and click on it*/
	       WebElement wb4=driver.findElement(By.name("mapbutton"));
	       Actions act=new Actions(driver);
	       act.moveToElement(wb4).perform();
	       wb4.click();
	       driver.findElement(By.xpath("//a[text()='Billing Address:']")).click();
	       
	       
	       /*validation*/
	       
	       
	       /*Sign Out*/
	        WebElement wb5=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	        Actions act1=new Actions(driver);
	        act1.moveToElement(wb5).perform();
	        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	        
	}

}
