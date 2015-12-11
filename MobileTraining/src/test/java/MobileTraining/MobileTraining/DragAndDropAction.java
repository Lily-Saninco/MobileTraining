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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class DragAndDropAction {
AndroidDriver driver;	  	
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
	
	capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");
	//capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
	capabilities.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
	
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	
	// create new android driver
 }
  @Test
  public void dragDrop(){
	  // Tap on basic usage playground
	  driver.findElement(By.name("Basic usage playground")).click();
	  // locate the third element
	  WebElement ele1 = (WebElement) driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(2); 
	// locate the sixth element
	  WebElement ele2 = (WebElement) driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(5);
	  

	  // perform drag and drop operation using TouchAction Class
	  //Create object of touchAction Class
	  
	  	  
	//Perform drag and drop operation using TouchAction class. 
	  //Created object of TouchAction class. 
	  TouchAction action = new TouchAction((MobileDriver) driver); 
	  System.out.println("It Is dragging element."); 
	  //It will hold tap on 3rd element and move to 6th position and then release tap.
	  action.longPress(ele1).moveTo(ele2).release().perform();
	  System.out.println("Element has been droped at destination successfully."); 
	  } 
 

@AfterTest
public void End(){
	driver.quit();
}
} 
