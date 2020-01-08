package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class EnrollmentPage extends TestBase {
	
	@FindBy (id = "lastName")
	WebElement LastName;
	
	@FindBy (id = "fullSSN1")
	WebElement SSNnumber;
	
	@FindBy (id = "fullSSN2")
	WebElement ITINnumber;
	
	@FindBy (id = "fullSSN3")
	WebElement BankAccountNumber;
	
	@FindBy (id = "form_dob_month")
	WebElement DOBmonth;
	
	@FindBy (id = "form_dob_day")
	WebElement DOBday;
	
	@FindBy (id = "form_dob_year")
	WebElement DOByear;
	
	@FindBy (id = "form_find_me_button")
	WebElement FindMeBtn;
	
	public EnrollmentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void typeLastName(String lastName) {
		LastName.sendKeys(lastName);;
	}
	
	public void typeSSNnumber(String SSN) {
		SSNnumber.sendKeys(SSN);
	}
	
	public void typeITINnumber(String itinNumber) {
		ITINnumber.sendKeys(itinNumber);
	}
	
	public void typeBankAccountNumber(String AccountNumber) {
		BankAccountNumber.sendKeys(AccountNumber);
	}
	
	public void selectDOBmonth(String BirthMonth) {
		Select select=new Select(DOBmonth);
		select.selectByVisibleText(BirthMonth);
	}
	
	public void selectDOBday(String BirthDay) {
		Select select=new Select(DOBday);
		select.selectByVisibleText(BirthDay);
	}
	
	public void selectDOByear(String BirthYear) {
		Select select=new Select(DOByear);
		select.selectByVisibleText(BirthYear);
	}
	
	public void clickFindMeBtn() {
		FindMeBtn.click();
	}

}
