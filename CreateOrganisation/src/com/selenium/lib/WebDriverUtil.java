package com.selenium.lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {

	/*wait for page to load*/
	public void waitPagetoLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	}
	
	/*wait for only element is available in GUI*/
	public void waitforElementPresent(WebDriver driver,WebElement wb) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(wb));
       }
	
	/*custom wait: wait for element complete load and available in GUI*/
	public void waitforCompleteElementToLoad(WebElement wb) throws InterruptedException {
		int count=0;
		while(count<20) {
			try {
				wb.isDisplayed();
				break;
			}catch(Throwable t) {
				System.out.println("handle the Exception and continue");
				Thread.sleep(1000);
				count++;
				
			}
		}
	}
}
