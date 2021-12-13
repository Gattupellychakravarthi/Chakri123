package com.Vtiger.genericUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class sampleTest {
	WebDriver driver;
    @Test
	public void cmdlineparameter() {
		String Browser = System.getProperty("Browser");
		String url = System.getProperty("url");
	    System.out.println(Browser);
	    System.out.println(url);

		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
			
		}
		driver.get(url);
	}
}
