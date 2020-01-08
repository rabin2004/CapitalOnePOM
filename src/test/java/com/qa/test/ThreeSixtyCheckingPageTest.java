package com.qa.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.ThreeSixtyCheckingPage;

public class ThreeSixtyCheckingPageTest extends TestBase {

	HomePage homepage;
	ThreeSixtyCheckingPage tSCheckingPage;
	public String Data = "C:\\Users\\User\\Desktop\\eclipse\\CapitalOnePOM\\src\\main\\java\\com\\qa"
			+ "\\testData\\DataForNewAcc.xlsx";
	
	public ThreeSixtyCheckingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
		tSCheckingPage = new ThreeSixtyCheckingPage();
	}
	
	@Test
	public void OpenThreeSixtyCheckingAccount() throws IOException {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Checking & Savings"))).build().perform();
		action.moveToElement(driver.findElement(By.partialLinkText("360 Checking"))).click().perform();
		
		tSCheckingPage.clickOpenAccountBtn();
		driver.findElement(By.xpath("//button[contains(text(), 'No')]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Continue')]")).click();
		
		File DataFile = new File(Data);
		FileInputStream DataStream = new FileInputStream(DataFile);
		Workbook wb = new XSSFWorkbook(DataStream);
		Sheet DataSheet = wb.getSheet("Sheet1");
		int RowCount = DataSheet.getLastRowNum()-DataSheet.getFirstRowNum();
		System.out.println("Number of Rows: "+RowCount);
		
		for(int value=1; value<=RowCount; value++) {
			Row row = DataSheet.getRow(value);
			
			driver.findElement(By.id("first-name")).sendKeys(row.getCell(0).getStringCellValue());
			driver.findElement(By.id("last-name")).sendKeys(row.getCell(1).getStringCellValue());
			
			driver.findElement(By.id("button-4")).click();
			driver.navigate().back();
			driver.findElement(By.id("first-name")).clear();
			driver.findElement(By.id("last-name")).clear();
		}
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
