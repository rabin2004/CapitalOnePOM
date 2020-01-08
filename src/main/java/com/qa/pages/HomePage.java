package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy (id="no-acct-uid")
	WebElement userNameField;
	
	@FindBy (id="no-acct-pw")
	WebElement passwordField;
	
	@FindBy (id="no-acct-submit")
	WebElement SignInTab;
	
	@FindBy (xpath = "//a[contains(text(),'Set Up Online Access')]")
	WebElement SignUpLink;
	
	@FindBy (linkText = "Credit Cards")
	WebElement CreditCardsLink;
	
	@FindBy (xpath = "//img[@alt='feedback']")
	WebElement FeedBackAlert;
	
	@FindBy (id = "unav-l1-support")
	WebElement SupportCenter;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void typeUserName(String Username) {
		userNameField.sendKeys(Username);
	}
	
	public void typePassword(String Password) {
		passwordField.sendKeys(Password);
	}
	
	public void clickSignInTab() {
		SignInTab.click();
	}
	
	public void clickSignUpLink() {
		SignUpLink.click();
	}
	
	public void clickIfYouArePrequalified() {
		Actions action = new Actions(driver);
		action.moveToElement(CreditCardsLink).build().perform();
		action.moveToElement(driver.findElement(By.linkText("See if You're Prequalified"))).click().perform();
	}
	
	public void clickFeedBackAlert() {
		FeedBackAlert.click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Usabilla Feedback Form Frame']")));
	}
	
	public void clickSupportCenter() {
		SupportCenter.click();
	}
}
