package com.Vtiger.genericUtil;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.naukri.com/");
		driver.manage().window().maximize();
		Set<String> windows = driver.getWindowHandles();
		for (String wh : windows) {
			
			String title = driver.switchTo().window(wh).getTitle();
			System.out.println(title);
			
		}

	}
}
