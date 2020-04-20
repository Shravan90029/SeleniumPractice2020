package com.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilLib {

	public static WebElement webElement;
  	WebDriver driver;
  	
  	public UtilLib(WebDriver driver1) {
  		this.driver=driver1;
  	
  	}
	
	public void ImplicitWait(int TimeOut) {
		driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);	
	}
	
	public void ExplictitWait(int TimeOut, By webElement) {
		WebDriverWait wait=new WebDriverWait(driver,TimeOut);
		wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
	}
	
	public void FluentWait(int TimeOut, int PollTime) {
		@SuppressWarnings({ "deprecation", "unused" })
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(TimeOut, TimeUnit.SECONDS).pollingEvery(PollTime,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	}
	
	public String ScreenShot() throws IOException {
		String Base64ScreenShot="";
		//TakesScreenshot scrShot =((TakesScreenshot)driver);
		File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(scrFile);
		Base64ScreenShot = "data:image/png;base64,"+Base64.getEncoder().encodeToString(fileContent);
		return Base64ScreenShot;
	}
	
	public void RobotImple() throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		
	}
	
	public  boolean isVisible(By webele) {
		boolean visibility = false;
		if(driver.findElement(webele).getSize() != null) {
			driver.findElement(webele).isDisplayed();
			visibility=true;
		}
		return visibility;
	}

   
}
