package com.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
	}
	
	
	@Test (priority = 1)
	public void userSignInWithInvalidUsernameAndPassword() {
		homepage.typeUserName(prop.getProperty("Username"));
		homepage.typePassword(prop.getProperty("Password"));
		 homepage.clickSignInTab();
		 Boolean ErrorPage = driver.findElement(By.xpath("//*[@class='ci-page-header']")).isDisplayed();
		 Assert.assertTrue(ErrorPage);
	}
	
	@Test (priority = 2)
	public void checkSignUpLink() {
		homepage.clickSignUpLink();
		Boolean signUpPage = driver.findElement(By.id("pii_title")).isDisplayed();
		Assert.assertTrue(signUpPage);
	}
	
	@Test (priority = 3)
	public void checkIfPrequalified() {
		homepage.clickIfYouArePrequalified();
		Boolean SubmitBtn = driver.findElement(By.id("continueToSubmit")).isDisplayed();
		Assert.assertTrue(SubmitBtn);;
	}
	
	@Test (priority = 4)
	public void checkFeedBackAlert() {
		homepage.clickFeedBackAlert();
		List <WebElement> iframe = driver.findElements(By.xpath("//iframe"));
		System.out.println("Number of iframes: "+iframe);
		Boolean FeedbackDisplayed=	driver.findElement(By.xpath("//div[@class='choice choice_specific']")).
				isDisplayed();
		Assert.assertTrue(FeedbackDisplayed);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
