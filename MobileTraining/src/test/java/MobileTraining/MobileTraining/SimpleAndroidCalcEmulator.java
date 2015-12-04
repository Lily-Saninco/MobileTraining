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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class SimpleAndroidCalcEmulator {
AndroidDriver driver;	  	
 @BeforeTest
 public void setUp() throws MalformedURLException{
	 // Set android device desired capablity,set devicename
	 DesiredCapabilities capabilities = new DesiredCapabilities();
	 capabilities.setCapability("deviceName", "MyNewDevice");

	 //capabilities.setCapability("udid", "2a9497ff");
	 // Set Browser_name
	capabilities.setCapability("platformName", "Android");
	
	//set version
	capabilities.setCapability("platformVersion", "4.4.2");
	//set app package and launch activity
	
	capabilities.setCapability("appPackage", "com.android.calculator2");
	//capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
	capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	
	driver = new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	
	// create new android driver
 }
  @Test
  public void Sum(){
	  // name property in the UIAutomation file :content-desc????,text is also as a name to find???
	  driver.findElement(By.name("2")).click();
	  driver.findElement(By.name("+")).click();
	  driver.findElement(By.name("3")).click();
	  driver.findElement(By.name("=")).click();
	  	  
	  //get the result=drive
	  String result = driver.findElement(By.className("android.widget.EditText")).getText();
	  System.out.println("Number sum result is :"+result);
	  
	  
	  // Using findElements.
	  // Locate DElETE/CLR button using findelements and get() method and click  on it
	  ((WebElement) driver.findElements(By.xpath("//android.widget.Button")).get(0)).click();
	  // Locate number button 2 by xpath element locator and click on it
	  
	   driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
	   
	   ((WebElement) driver.findElements(By.xpath("//android.widget.Button")).get(16)).click();
		  // Locate number button 2 by xpath element locator and click on it
		  
	   //By id
	   driver.findElement(By.id("com.android.calculator2:id/digit5")).click();
	   //By name
	   driver.findElement(By.name("=")).click();
	   //By ClassName
	   //get the result=drive
		  String result2 = driver.findElement(By.className("android.widget.EditText")).getText();
		  System.out.println("Number sum result2 is :"+result);

	   
  }
@AfterTest
public void End(){
	driver.quit();
}
} 
