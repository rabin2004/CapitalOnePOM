package com.qa.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.SupportCenter;

public class SupportCenterTest extends TestBase {
	
	HomePage homepage;
	SupportCenter supportcenter;
	
	public SupportCenterTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
		supportcenter = new SupportCenter();
		
		homepage.clickSupportCenter();
	}
	
	@Test (priority = 1)
	public void checkActivateDebitCardLink() {
		supportcenter.clickActivateDebitCard();
		Boolean pageHeading = driver.findElement(By.id("page-heading")).isDisplayed();
		Assert.assertTrue(pageHeading);
	}
	
	@Test (priority = 2)
	public void checkMakeADepositLink() {
		supportcenter.clickMakeADeposit();
		Boolean pageHeading = driver.findElement(By.id("page-heading")).isDisplayed();
		Assert.assertTrue(pageHeading);
	}
	
	@Test (priority =3)
	public void checkActivateCreditCardLink() {
		supportcenter.clickActivateCreditCard();
		Boolean pageHeading = driver.findElement(By.id("page-heading")).isDisplayed();
		Assert.assertTrue(pageHeading);
	}
	
	@Test (priority = 4)
	public void checkMakeCreditCardPayment() {
		supportcenter.clickMakeCreditCardPayment();
		Boolean pageHeading = driver.findElement(By.id("page-heading")).isDisplayed();
		Assert.assertTrue(pageHeading);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
