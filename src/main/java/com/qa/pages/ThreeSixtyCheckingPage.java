package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ThreeSixtyCheckingPage extends TestBase {
	
	@FindBy (linkText = "Open Account")
	WebElement OpenAccountBtn;
	
	public ThreeSixtyCheckingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOpenAccountBtn() {
		OpenAccountBtn.click();
	}

}
