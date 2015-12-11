package MobileTraining.MobileTraining;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


	

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class SetDate {
AndroidDriver driver;	
Dimension size;
 @BeforeTest
 public void setUp() throws MalformedURLException{
	 // Set android device desired capablity,set devicename
	 DesiredCapabilities capabilities = new DesiredCapabilities();
	 capabilities.setCapability("deviceName", "MyDevice");

	 //capabilities.setCapability("udid", "2a9497ff");
	 // Set Browser_name
	capabilities.setCapability("platformName", "Android");
	
	//set version
	capabilities.setCapability("platformVersion", "4.4.2");
	//set app package and launch activity
	
	capabilities.setCapability("appPackage", "io.appium.android.apis");

	capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

	
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	//WebDriverWait wait = new WebDriverWait(driver, 300);
	//wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout"))); 
	
	// create new android driver
 }
 
 @Test 
 public void dateSet() 
 { 
	 // Scroll till element which contains "Views" text. 
	 driver.scrollTo("Views"); 
	 // Click on Views.
	 driver.findElement(By.name("Views")).click(); 
	 // Scroll till element which contains "Date Widgets" text. 
	 driver.scrollTo("Date Widgets"); 
	 // Click on element which contains "Date Widgets" text. 
	 driver.findElement(By.name("Date Widgets")).click(); 
	 // Scroll till element which contains "1. Dialog" text. 
	 driver.scrollTo("1. Dialog"); 
	 // Click on element which contains "1. Dialog" text. 
	 driver.findElement(By.name("1. Dialog")).click(); 
	 // Click on button which contains "change the date" text. 
	 driver.findElement(By.name("change the date")).click(); 
	 //Set Date = 25. 
	 driver.findElement(By.xpath("//android.widget.NumberPicker[@index='0']")).sendKeys("25");
	 //Set Month = Aug. 
	 driver.findElement(By.xpath("//android.widget.NumberPicker[@index='1']")).sendKeys("Aug"); 
	 //Set Year = 2009. 
	 driver.findElement(By.xpath("//android.widget.NumberPicker[@index='2']")).sendKeys("2009"); 
	 //Click on Done button. 
	 driver.findElement(By.id("android:id/button1")).click();
	 } 

 @Test 
 public void timeSet() 
 { 
	 // Click on button which contains "change the time" text.
	 driver.findElement(By.name("change the time")).click(); 
	 //Set Hours = 1. 
	 driver.findElement(By.xpath("//android.widget.NumberPicker[@index='0']")).sendKeys("1");
	 //Set Minutes = 25.
	 driver.findElement(By.xpath("//android.widget.NumberPicker[@index='2']")).sendKeys("25"); 
	 //Set pm. 
	 driver.findElement(By.xpath("//android.widget.NumberPicker[@index='1']")).sendKeys("pm"); 
	 //Click on Done button. 
	 driver.findElement(By.id("android:id/button1")).click();
} 


@AfterTest
public void End(){
	driver.quit();
}
} 
