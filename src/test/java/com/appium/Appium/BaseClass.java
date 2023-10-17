package com.appium.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseClass {
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	public static String appPath = "/Users/Canada/AppData/Roaming/npm/node_modules/appium/lib/main.js";//Wrong Path
	@Test
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
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel_Demo");
		options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		//creating object for Androiddriver
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);  
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//object locators xpath,id,class,Accessibilty Id androiduiautomator,
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.quit();
		service.stop();//stop appium server 
	}

}
