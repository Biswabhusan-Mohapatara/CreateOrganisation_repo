package com.selenium.organisation;

import java.util.List;
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
 * */
public class ModifyExistingOrganizationByAddingCommentsTest {



	private static Object actCmt;

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
	       driver.findElement(By.linkText("Mspiders")).click();
	     
	       
	       /*Go to Add Comment section and enter the comments for the selected organization*/
	       WebElement wb6=driver.findElement(By.id("txtbox_ModCommentsDetailViewBlockCommentWidget"));
	       Actions act=new Actions(driver);
	       act.moveToElement(wb6);
	       wb6.click();
	       wb6.sendKeys("test case working");
	       driver.findElement(By.xpath("//textarea[@id='txtbox_ModCommentsDetailViewBlockCommentWidget']/following-sibling::input[@value='Save']")).click();
	
	       /*validation*/
	       int i=0;
	       String expCmt="test case working";
	       boolean flag=false;
	       WebElement wb126=driver.findElement(By.xpath("//div[@id='contentwrap_ModCommentsDetailViewBlockCommentWidget']/div"));
	       Actions act126=new Actions(driver);
	       act126.moveToElement(wb126);
	       Select sel126=new Select(wb126);
	       List<WebElement> lst126=sel126.getOptions();
	       System.out.println(lst126.size());
	       for(i=0;i<lst126.size();i++) {
	    	  String actCmt=lst126.get(i).getText();
	    	  if(actCmt.contains(expCmt)) {
	    		  sel126.selectByVisibleText(actCmt);
	    		  flag=true;
	    		  break;
	    	  }
	       }if(flag==true) {
	    	   System.out.println("actcmt is present==>pass");
	       }else {
	    	   System.out.println("actcmt is not present==>Fail");
	       }
	    
	       /*Sign Out*/
	        WebElement wb5=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	        Actions act1=new Actions(driver);
	        act1.moveToElement(wb5).perform();
	        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	        
	       

	}

}