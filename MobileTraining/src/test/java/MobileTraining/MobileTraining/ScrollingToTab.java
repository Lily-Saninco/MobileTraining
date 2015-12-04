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
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class ScrollingToTab {
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
	//capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
	capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
	
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	//WebDriverWait wait = new WebDriverWait(driver, 300);
	//wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout"))); 
	
	// create new android driver
 }
 
 @Test 
 public void scrollToTab() throws InterruptedException 
 {
//Scroll till element which contains "Views" text If It Is not visible on screen. 
 driver.scrollTo("Views"); 
 // Click on Views/. 
 driver.findElement(By.name("Views")).click();
 System.out.println("Scrolling has been started to find text -> Tabs."); 
 // Scroll till element which contains Tabs text. 
 driver.scrollTo("Tabs"); 
 System.out.println("Tabs text has been found and now clicking on It."); 
 // Click on Tabs. 
 driver.findElement(By.name("Tabs")).click(); 
 }
 
@AfterTest
public void End(){
	driver.quit();
}
} 
