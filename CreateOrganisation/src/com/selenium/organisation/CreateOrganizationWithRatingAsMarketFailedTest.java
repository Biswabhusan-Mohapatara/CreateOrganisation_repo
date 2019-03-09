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
 */
public class CreateOrganizationWithRatingAsMarketFailedTest {

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
      
       
       /*Place the mouse cursor on "+" symbol and click on it to create new organization*/
       driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
         
       
       /*Enter mandatory fields and select "Aquired" from the dropdown in "Rating" field*/
       driver.findElement(By.name("accountname")).sendKeys("Pspiders");
       WebElement wb=driver.findElement(By.xpath("//select[@name='rating']"));
       Select sel=new Select(wb);
       sel.selectByVisibleText("Market Failed");
       
       /*validation*/
       String exOption="Market Failed";
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
       WebElement wb2=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
       Actions act=new Actions(driver);
       act.moveToElement(wb2).perform();
       driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
       
		

	}

}



