package com.appium.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumSetup {
	
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	public static String appPath = "/Users/Canada/AppData/Roaming/npm/node_modules/appium/lib/main.js";//Wrong Path
	public static UiAutomator2Options options ;
	   
	@BeforeClass	
	public void configureAppium() throws MalformedURLException {
		//programmatically starting appium server
		
		File file = new File("C:/Users/Canada/AppData/Roaming/npm/node_modules/appium/build/lib/main.js");//Correct path found in 3 days 
		 service =new AppiumServiceBuilder()
				.withAppiumJS(file)
				.withLogFile(new File(System.getProperty("user.dir")+"appium.log"))
				.withIPAddress("127.0.0.1")
				.withArgument(GeneralServerFlag.BASEPATH,"/wd/hub")
				.usingPort(4723)
				.withTimeout(Duration.ofSeconds(60))
				.build();
		
		System.out.println("Starting Appium Server..............");
		service.start();//starting appium server programmatically
		//desired capabilities
		options = new UiAutomator2Options();
		options.setDeviceName("Pixel_Demo");
		//options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\ApiDemos-debug.apk");//Api demo app 
		options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\General-Store.apk");//General Store app
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);  
	}
	//MEthod to Scrollto the Element
	public void scrollToElement(String ele) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"ele\"))"));
	}
	//MEthod to Scroll to the End
	public void scrollToEnd() {
		boolean canScrollMore;
		do {
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 3.0
		));
		}while(canScrollMore);
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();//stop appium server 
	}
	
	/*
	public void locatorTest() {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
	}*/
}
