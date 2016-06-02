package com.devops.src.util;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class Utils {
	
	@BeforeSuite
	public static void read (WebDriver driver) throws IOException {
		ORFileReader.loadObjects("Main");
		ORFileReader.loadObjects("Booking");
		ORFileReader.loadObjects("Payment");
		driver.get(Constants.LOCALURL);
		driver.manage().window().maximize();
	}
	
	public static WebDriver getDriver(String browser) throws Exception {
        WebDriver driver;
        if (browser.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else if(browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "config//chromedriver.exe");
            driver = new ChromeDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
	
	
	
	public static void navigateTo(WebDriver driver) {
        driver.navigate().to("https://www.goibibo.com/");
    }
	
	public static void waitInSec(long numberOfSeconds) throws InterruptedException {
		Thread.sleep(numberOfSeconds * 1000L);
	}
	public static void clearInput (WebDriver driver) {
		driver.findElement(ORFileReader.findValue("src_input_box")).clear();
		driver.findElement(ORFileReader.findValue("dest_input_box")).clear();
	}
	public static void invalidSource (WebDriver driver) {
		driver.findElement(ORFileReader.findValue("src_input_box")).sendKeys("....");
	}
	public static void invalidDestination (WebDriver driver) {
		driver.findElement(ORFileReader.findValue("dest_input_box")).sendKeys("...........");
	}
	public static void validSource (WebDriver driver) throws InterruptedException {
		WebElement srcKeys = driver.findElement(ORFileReader.findValue("src_input_box"));
		srcKeys.sendKeys("New Delhi");
		Thread.sleep(500);
		srcKeys.sendKeys(Keys.ENTER);
	}
	public static void validDestination(WebDriver driver) throws InterruptedException {	
		driver.findElement(ORFileReader.findValue("dest_input_box")).clear();
		WebElement destKeys = driver.findElement(ORFileReader.findValue("dest_input_box"));
		destKeys.sendKeys("Pune");
		Thread.sleep(500);
		destKeys.sendKeys(Keys.ENTER);
	}
	public static void departureCalendar (WebDriver driver) {
		driver.findElement(ORFileReader.findValue("departure_date")).click();
		driver.getWindowHandle();
		driver.findElement(ORFileReader.findValue("departure_calendar")).click();
	}
	public static void returnCalendar (WebDriver driver) {
		driver.findElement(ORFileReader.findValue("return_date")).click();
		driver.getWindowHandle();
		driver.findElement(ORFileReader.findValue("return_calendar")).click();
	}
	public static void assertExistence (String Message, String assertText, WebDriver driver) {
		Assert.assertTrue(driver.findElement(ORFileReader.findValue(assertText)).isDisplayed(), Message);
	}
	public static void searchText (WebDriver driver) {
		driver.findElement(ORFileReader.findValue("search_btn")).click();
	}
}
