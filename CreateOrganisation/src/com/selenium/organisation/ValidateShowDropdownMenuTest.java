package com.selenium.organisation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/*
 * 
 * @author Biswa
 * 
 */
public class ValidateShowDropdownMenuTest {

	public static void main(String[] args) throws InterruptedException {
		
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
	       
	       
	       /*Move the mouse cursor to the "Show" dropdown menu in the "Comment Information" section and click on it*/
	       WebElement wb8=driver.findElement(By.xpath("//img[@id='indicatorModCommentsDetailViewBlockCommentWidget']/following-sibling::select[@class='small']"));
           Actions act=new Actions(driver);
           act.moveToElement(wb8).perform();;
           wb8.click();
           
           
           /*Click on "Last 5" option from the dropdown menu*/
           Select sel=new Select(wb8);
           sel.selectByVisibleText("Last 5");
           
     
           /*validation*/
	      
	       
	        /*Sign Out*/
		       WebElement wbe14=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		        Actions act111=new Actions(driver);
		        act111.moveToElement(wbe14).perform();
		        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		        
        
	}

}
