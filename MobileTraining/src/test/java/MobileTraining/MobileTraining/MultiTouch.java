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


public class MultiTouch {
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
	
	capabilities.setCapability("appPackage", "com.the511plus.MultiTouchTester");
	//capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
	capabilities.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");

	
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	//WebDriverWait wait = new WebDriverWait(driver, 300);
	//wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout"))); 
	
	// create new android driver
 }
 
 @Test 
 public void mTouchAction() throws InterruptedException 
 { 
	 size = driver.manage().window().getSize();
	 //Get X Y Coordinates for touch action 1(Top left side).
	 int x1 = (int) (size.width * 0.20); 
	 int y1 = (int) (size.height * 0.20);
	 //Get X Y Coordinates for touch action 2(Top right side). 
	 int x2 = (int) (size.width * 0.80); 
	 int y2 = (int) (size.height * 0.20);
	 //Get X Y Coordinates for touch action 3(Bottom left side).
	 int x3 = (int) (size.width * 0.20);
	 int y3 = (int) (size.height * 0.80); 
	 //Get X Y Coordinates for touch action 4(Bottom right side).
	 int x4 = (int) (size.width * 0.80); 
	 int y4 = (int) (size.height * 0.80); 
	 //Get X Y Coordinates for touch action 5(middle of the screen).
	 int x5 = size.width / 2; 
	 int y5 = size.height / 2; 
	 int x6 = size.width / 2; 
	 int y6 = size.height / 4; 
	 // Create object of MultiTouchAction class.
	 MultiTouchAction maction = new MultiTouchAction((MobileDriver) driver);
	 // Set touch action1 on given X Y Coordinates of screen.
	 TouchAction action1 = new TouchAction((MobileDriver) driver).longPress(x1, y1).waitAction(15000); 
	 // Set touch action2 on given X Y Coordinates of screen.
	 TouchAction action2 = new TouchAction((MobileDriver) driver).longPress(x2, y2).waitAction(15000); 
	 // Set touch action3 on given X Y Coordinates of screen. 
	 TouchAction action3 = new TouchAction((MobileDriver) driver).longPress(x3, y3).waitAction(15000);
	 // Set touch action4 on given X Y Coordinates of screen.
	 TouchAction action4 = new TouchAction((MobileDriver) driver).longPress(x4, y4).waitAction(15000); 
	 // Set touch action5 on given X Y Coordinates of screen. 
	 TouchAction action5 = new TouchAction((MobileDriver) driver).longPress(x5, y5).waitAction(15000); 
	 TouchAction action6 = new TouchAction((MobileDriver) driver).longPress(x6, y6).waitAction(15000); 
	 // Generate multi touch action chain using different actions and perform It. 
	 //maction.add(action1).add(action2).add(action3).add(action4).add(action5).add(action6).perform();
	 maction.add(action1).add(action2).add(action3).add(action4).add(action5).perform();
	 //maction.add(action1).add(action2).add(action3).perform();
	 }



@AfterTest
public void End(){
	driver.quit();
}
} 
