package com.appium.Appium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class SwipeDemo extends AppiumSetup{
	@Test
	public void swipeDemoTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Gallery\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		String firstImageloc = firstImage.getAttribute("focusable");
		Assert.assertEquals("true", firstImageloc);
		
		// Java
		 ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				 ImmutableMap.of("elementId", ((RemoteWebElement) firstImage).getId(),
						 "direction", "left",
						  "percent", 0.75
		 ));
		 
		 String SecondImageloc = firstImage.getAttribute("focusable");
			Assert.assertEquals("false", SecondImageloc);
			
		 
	}

}
