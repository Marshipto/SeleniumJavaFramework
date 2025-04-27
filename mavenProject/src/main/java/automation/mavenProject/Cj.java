package automation.mavenProject;
import org.testng.annotations.*;

import base.BaseTest;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import org.apache.logging.log4j.core.util.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Cj extends BaseTest {

 	@Test
	public static void Login()
	{
 		int myArray[] = new int[]{1,2,3,4,5};
 		System.out.println(myArray);
 	
 		Collections.reverse(Arrays.asList(myArray));		
 		System.out.println(myArray);
 		
 		
		  driver.get(pro.getProperty("testURL"));
		  driver.findElement(By.linkText("Iniciar sesión")).click(); Wait<WebDriver>
		  wait = new FluentWait<WebDriver>(driver) .withTimeout(Duration.ofSeconds(15))
		  .pollingEvery(Duration.ofSeconds(1)) .ignoring(NoSuchElementException.class)
		  .ignoring(ElementNotInteractableException.class);
		  wait.until(ExpectedConditions.elementToBeClickable(By.id("login_id")));
		  driver.findElement(By.id("login_id")).sendKeys("luis_130295@hotmail.com");
		  driver.findElement(By.id("nextbtn")).click();
		  driver.findElement(By.id("password")).sendKeys("1Zoho9f!");
		  driver.findElement(By.id("nextbtn")).click();
		  try {
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".remind-me-div")));
		 ((RemoteWebDriver) driver).executeScript("arguments[0].click();",driver.findElement(By.cssSelector(".remind-me-div")));
		 ((RemoteWebDriver) driver).executeScript("arguments[0].click();",driver.findElement(By.cssSelector("span.remind-list:nth-child(3)")));
		  }catch(Exception e)
		  {
			  //no remind me later pop up
		  }
		 
		 
		
 
	}
 	
}
