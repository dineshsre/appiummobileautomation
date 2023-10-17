package com.appium.Appium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class HybridDemo extends AppiumSetup{
	
	@Test
	public void HybridTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("android:id/text1")).click();//Click Drop down 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));//Select Value from Dropdown
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'India']")).click();//Click the selected value
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Samsung");//Enter Name
		
		//Select radio button for Gender
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		//Hide keyboard on Mobile app
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();///submit button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Scroll to the page down to selectthe product
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"))"));

	}

}
