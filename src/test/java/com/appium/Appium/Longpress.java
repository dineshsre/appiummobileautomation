package com.appium.Appium;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Longpress extends AppiumSetup{
	@Test
	public void longPressDemo() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
//		driver.findElement(AppiumBy.accessibilityId("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		//this element will have long press
		 WebElement longPressElement = driver.findElement(By.xpath("//android.widget.TextView[@text = 'People Names']"));
		
		//OR driver.findElement(By.xpath("//android.widget.TextView[0]"));
		 
		 //LongPress code option 1
		 /*Point location = longPressElement.getLocation();
		 new TouchAction(driver)
		 .press(PointOption.point(location.getX(), location.getY()))
		 .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
		 .release()
		 .perform();*/
		 
		//LongPress code option 2
		 
		// Java
		 ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				 ImmutableMap.of("elementId", ((RemoteWebElement) longPressElement).getId(),
						 "duration",5000
		     
		 ));
		 
		 String peopleText = driver.findElement(By.id("android:id/title")).getText();
		 
		 Assert.assertEquals(peopleText, "Sample menu");
		 
		 Boolean peopleTextDisplay = driver.findElement(By.id("android:id/title")).isDisplayed();
		 
		 Assert.assertTrue(peopleTextDisplay);
		
		
		
	}

}
