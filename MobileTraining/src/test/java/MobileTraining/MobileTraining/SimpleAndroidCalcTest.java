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

public class SimpleAndroidCalcTest {
AndroidDriver driver;	  	
 @BeforeTest
 public void setUp() throws MalformedURLException{
	 // Set android device desired capablity,set devicename
	 DesiredCapabilities capabilities = new DesiredCapabilities();
	 //capabilities.setCapability("deviceName", "MyNewDevice");
	 capabilities.setCapability("deviceName", "SM-G730W8");
	 //capabilities.setCapability("udid", "2a9497ff");
	 // Set Browser_name
	capabilities.setCapability("platformName", "Android");
	
	//set version
	capabilities.setCapability("platformVersion", "4.4.2");
	//set app package and launch activity
	
	capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
	//capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
	capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
	
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	
	// create new android driver
 }
  @Test
  public void Sum(){
	  // name property in the UIAutomation file :content-desc????
	  driver.findElement(By.name("2")).click();
	  driver.findElement(By.name("plus")).click();
	  driver.findElement(By.name("3")).click();
	  driver.findElement(By.name("equal")).click();
	  
	  
	  //get the result=drive
	  String result = driver.findElement(By.className("android.widget.EditText")).getText();
	  System.out.println("Number sum result is :"+result);
  }
@AfterTest
public void End(){
	driver.quit();
}
} 
