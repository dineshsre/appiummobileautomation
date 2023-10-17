package com.appium.Appium;

import static org.junit.Assert.assertArrayEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DropDown extends AppiumSetup {
	
	@Test(enabled = false)//skip testcase
	public void DropDownDemo() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("android:id/text1")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'India']")).click();
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Samsung");
		
		//Select radio button
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		//Hide keyboard on Mobile app
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();///submit button
	}
	@Test
	public void toastMessage() {//Handling Error Messages or Toast Messages
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("android:id/text1")).click();//Click Drop down 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));//Select Value from Dropdown
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'India']")).click();//Click the selected value
		
		//driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Samsung");//Enter Name
		
		//Select radio button for Gender
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		//Hide keyboard on Mobile app
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();///submit button
		
		//spy toast message and get the text use tagname = android.widget.Toast
		
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMsg, "Please enter your name");
		
	}

}
