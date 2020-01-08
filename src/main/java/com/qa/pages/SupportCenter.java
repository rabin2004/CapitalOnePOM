package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class SupportCenter extends TestBase {
	
	@FindBy (linkText = "Activate Debit Card")
	WebElement ActivateDebitCard;
	
	@FindBy (linkText = "Make a Deposit")
	WebElement MakeADeposit;
	
	@FindBy (linkText = "Activate Credit Card")
	WebElement ActivateCreditCard;
	
	@FindBy (linkText = "Make Credit Card Payment")
	WebElement MakeCreditCardPayment;
	
	public SupportCenter() {
		PageFactory.initElements(driver, this);
	}

	public void clickActivateDebitCard() {
		ActivateDebitCard.isEnabled();
		ActivateDebitCard.isDisplayed();
		ActivateDebitCard.click();
	}
	
	public void clickMakeADeposit() {
		MakeADeposit.isEnabled();
		MakeADeposit.isDisplayed();
		MakeADeposit.click();
	}
	
	public void clickActivateCreditCard() {
		ActivateCreditCard.isEnabled();
		ActivateCreditCard.isDisplayed();
		ActivateCreditCard.click();
	}
	
	public void clickMakeCreditCardPayment() {
		MakeCreditCardPayment.isEnabled();
		MakeCreditCardPayment.isDisplayed();
		MakeCreditCardPayment.click();
	}
}
