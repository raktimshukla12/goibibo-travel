package com.devops.src.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.devops.src.util.Constants;
import com.devops.src.util.Utils;

public class Main {
	static WebDriver driver;

	@Parameters({ "browser" })
	@BeforeTest
	public void testRead(String browser) throws Exception {
		driver = Utils.getDriver(browser);
		Utils.read(driver);
	}

	@Test
	public void Main_Enter_Invalid_Source_Invalid_Destination_Select_Departure_Date_Return_Date_Click_Search_Button_ValidateFunctionality()
			throws InterruptedException {
		Utils.clearInput(driver);
		Utils.invalidSource(driver);
		Utils.invalidDestination(driver);
		Utils.departureCalendar(driver);
		Utils.returnCalendar(driver);
		Utils.searchText(driver);
		Utils.waitInSec(Constants.FIVE_WAIT);
		Utils.assertExistence("User is not on Search Page", "search_page_label" ,driver);
	}

	@Test
	public void Main_Enter_Valid_Source_Invalid_Destination_Select_Departure_Date_Return_Date_Click_Search_Button_ValidateFunctionality()
			throws InterruptedException {
		Utils.navigateTo(driver);
		Utils.clearInput(driver);
		Utils.validSource(driver);
		Utils.invalidDestination(driver);
		Utils.departureCalendar(driver);
		Utils.returnCalendar(driver);
		Utils.searchText(driver);
		Utils.waitInSec(Constants.FIVE_WAIT);
		Utils.assertExistence("User is not on Search Page", "search_page_label" ,driver);
	}

	@Test
	public void Main_Enter_InValid_Source_Valid_Destination_Select_Departure_Date_Return_Date_Click_Search_Button_ValidateFunctionality()
			throws InterruptedException {
		Utils.navigateTo(driver);
		Utils.clearInput(driver);
		Utils.invalidSource(driver);
		Utils.validDestination(driver);
		Utils.departureCalendar(driver);
		Utils.returnCalendar(driver);
		Utils.searchText(driver);
		Utils.waitInSec(Constants.FIVE_WAIT);
		Utils.assertExistence("User is not on Search Page", "search_page_label" ,driver);
	}

	@Test
	public void Main_Enter_Empty_Source_Valid_Destination_Select_Departure_Date_Return_Date_Click_Search_Button_ValidateFunctionality()
			throws InterruptedException {
		Utils.navigateTo(driver);
		Utils.clearInput(driver);
		Utils.validDestination(driver);
		Utils.departureCalendar(driver);
		Utils.returnCalendar(driver);
		Utils.searchText(driver);
		Utils.waitInSec(Constants.FIVE_WAIT);
		Utils.assertExistence("User is not on Search Page", "search_page_label" ,driver);
	}

	@Test
	public void Main_Enter_Valid_Source_Empty_Destination_Select_Departure_Date_Return_Date_Click_Search_Button_ValidateFunctionality()
			throws InterruptedException {
		Utils.navigateTo(driver);
		Utils.clearInput(driver);
		Utils.validSource(driver);
		Utils.departureCalendar(driver);
		Utils.returnCalendar(driver);
		Utils.searchText(driver);
		Utils.waitInSec(Constants.FIVE_WAIT);
		Utils.assertExistence("User is not on Search Page", "search_page_label" ,driver);
	}

	@Test
	public void Main_Enter_Empty_Source_Empty_Destination_Select_Departure_Date_Return_Date_Click_Search_Button_ValidateFunctionality()
			throws InterruptedException {
		Utils.navigateTo(driver);
		Utils.clearInput(driver);
		Utils.departureCalendar(driver);
		Utils.returnCalendar(driver);
		Utils.searchText(driver);
		Utils.waitInSec(Constants.FIVE_WAIT);
		Utils.assertExistence("User is not on Search Page", "search_page_label" ,driver);
	}

	@Test
	public void Main_Enter_Valid_Source_Valid_Destination_Select_Departure_Date_Return_Date_Click_Search_Button_ValidateFunctionality ()
			throws InterruptedException {
		Utils.navigateTo(driver);
		Utils.clearInput(driver);
		Utils.validSource(driver);
		Utils.validDestination(driver);
		Utils.departureCalendar(driver);
		Utils.returnCalendar(driver);
		Utils.searchText(driver);
		Utils.waitInSec(Constants.FIVE_WAIT);
		Utils.assertExistence("User is on Search Page", "book_dest_page" ,driver);
	}
	
	@AfterClass
	public void testEnd() {
		driver.quit();
	}
}
