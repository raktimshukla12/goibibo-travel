package com.devops.src.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.devops.src.util.Constants;
import com.devops.src.util.ORFileReader;
import com.devops.src.util.Utils;

public class FlightSearchResult {
	
	static WebDriver driver;
	
	@Parameters
	({ "browser" })
	
	@BeforeTest
	public void testRead(String browser) throws Exception {
		driver = Utils.getDriver(browser);
		Utils.read(driver);
	}
	
	@Test
	public void FlightSearchResult_Select_Lowest_ArrivalFare_Lowest_DepartureFare_Click_Book_Button_ValidateFunctionality ()
			throws InterruptedException {
		Utils.clearInput(driver);
		Utils.validSource(driver);
		Utils.validDestination(driver);
		Utils.departureCalendar(driver);
		Utils.returnCalendar(driver);
		Utils.searchText(driver);
		Utils.waitInSec(Constants.FIVE_WAIT);
		driver.findElement(ORFileReader.findValue("book_btn")).click();
		Utils.waitInSec(Constants.TWO_WAIT);
		Utils.assertExistence("User is not on Payment Page", "payment_label" ,driver);
	}
	
	@Test
	public void FlightSearchResult_Enter_Empty_Source_Empty_Destination_Select_DepartureDate_ReturnDate_Click_Search_Button_ValidateFunctionality ()
			throws InterruptedException {
		Utils.navigateTo(driver);
		Utils.clearInput(driver);
		Utils.validSource(driver);
		Utils.validDestination(driver);
		Utils.departureCalendar(driver);
		Utils.returnCalendar(driver);
		Utils.searchText(driver);
		Utils.waitInSec(Constants.FIVE_WAIT);
		driver.findElement(ORFileReader.findValue("book_form_source")).clear();
		driver.findElement(ORFileReader.findValue("book_form_destination")).clear();
		driver.findElement(ORFileReader.findValue("book_form_btn")).click();
		Utils.assertExistence("User is not on Book Page", "book_image" ,driver);
	}
	
	@AfterClass
	public void testEnd() {
		driver.quit();
	}
}
