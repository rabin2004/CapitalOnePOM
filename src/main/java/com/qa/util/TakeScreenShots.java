package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.base.TestBase;

public class TakeScreenShots extends TestBase {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		// Take sreenshot(.getScreenshotAs method) and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		// Now copy the screenshot to desired location using .copyFile method
		FileUtils.copyFile(src, new File("C:/Users/User/Desktop/eclipse/CapitalOnePOM/src/"
				+ "ScreenShots/CapitalOne.png"));
		
		System.out.println("Screenshots taken");

	}

}
