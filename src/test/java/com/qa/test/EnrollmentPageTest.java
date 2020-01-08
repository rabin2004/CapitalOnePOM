package com.qa.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.EnrollmentPage;
import com.qa.pages.HomePage;

public class EnrollmentPageTest extends TestBase {
	HomePage homepage;
	EnrollmentPage enrollmentpage;
	
	public EnrollmentPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
		enrollmentpage = new EnrollmentPage();
	}
	
	@Test
	public void findMember() {
		homepage.clickSignUpLink();
		enrollmentpage.typeLastName(prop.getProperty("lastName"));
		enrollmentpage.typeSSNnumber(prop.getProperty("SSN"));
		enrollmentpage.typeITINnumber(prop.getProperty("itinNumber"));
		enrollmentpage.typeBankAccountNumber(prop.getProperty("AccountNumber"));
		enrollmentpage.selectDOBmonth(prop.getProperty("BirthMonth"));
		enrollmentpage.selectDOBday(prop.getProperty("BirthDay"));
		enrollmentpage.selectDOByear(prop.getProperty("BirthYear"));
		enrollmentpage.clickFindMeBtn();
		Boolean CustomerNotFoundError = driver.findElement(By.id("custNotFound_error")).isDisplayed();
		Assert.assertTrue(CustomerNotFoundError);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
