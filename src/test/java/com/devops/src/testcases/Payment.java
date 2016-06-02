package com.devops.src.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.devops.src.util.Constants;
import com.devops.src.util.ORFileReader;
import com.devops.src.util.Utils;

public class Payment {

	static WebDriver driver;

	@Parameters({ "browser" })
	@BeforeTest
	public void testRead(String browser) throws Exception {
		driver = Utils.getDriver(browser);
		Utils.read(driver);
	}

	@Test
	public void Payment_Select_UserTitle_Input_AdultName_Fields_EmailAddress_MobileNumber_Click_MakePayment_Button_ValidateFunctionality()
			throws InterruptedException {
		Utils.clearInput(driver);
		Utils.validSource(driver);
		Utils.validDestination(driver);
		Utils.departureCalendar(driver);
		Utils.returnCalendar(driver);
		Utils.searchText(driver);
		Utils.waitInSec(Constants.TEN_WAIT);
		driver.findElement(ORFileReader.findValue("book_btn")).click();
		Select selectLabel = new Select(driver.findElement(ORFileReader
				.findValue("username_label")));
		selectLabel.selectByVisibleText("Mr");
		driver.findElement(ORFileReader.findValue("user_firstname")).sendKeys(
				"Raktim");
		driver.findElement(ORFileReader.findValue("user_middlename")).sendKeys(
				"Rajiv");
		driver.findElement(ORFileReader.findValue("user_lastname")).sendKeys(
				"Shukla");
		driver.findElement(ORFileReader.findValue("user_email")).sendKeys(
				"raktimshukla@gmail.com");
		driver.findElement(ORFileReader.findValue("user_mobile")).sendKeys(
				"7830286464");
		driver.findElement(ORFileReader.findValue("makePayment_btn")).click();
		Utils.waitInSec(Constants.FIVE_WAIT);
		Utils.assertExistence("User is not on Transaction Page",
				"payment_image", driver);
	}

	@AfterTest
	public void testEnd() {
		driver.quit();
	}
}
