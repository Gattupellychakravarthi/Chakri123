package com.Vitiger.POMclasses;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Vtiger.genericUtil.FileUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class BaseClass {
	public WebDriver driver;
	public Applogin login;
	public static WebDriver sdriver;

	@BeforeSuite(groups = { "Smoke Testing", "Regression Testing" })
	public void setUp() {
		System.out.println("Connect to DB");
	}
   // @Parameters("Browser")
	@BeforeClass(groups = { "Smoke Testing", "Regression Testing" })
	
	public void BrowserLunchandGetUrl() throws IOException {
	
		String Browser = FileUtil.objforfileutil().readDatafromPropfile("browser");
		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		String url = FileUtil.objforfileutil().readDatafromPropfile("url");
		driver.get(url);
		WebDriverUtil Methods = new WebDriverUtil(driver);
		Methods.MaxiniseWindow();
		sdriver=driver;
	}

	@BeforeMethod(groups = { "Smoke Testing", "Regression Testing" })
	public void LoginintoApp() throws IOException {
		login = new Applogin(driver);
		login.login();
	}

	@AfterMethod(groups = { "Smoke Testing", "Regression Testing" })
	public void LogoutApp() throws InterruptedException {
		Homepage home = new Homepage(driver);
		home.LogoutfromApp();
	}

	@AfterClass(groups = { "Smoke Testing", "Regression Testing" })
	public void CloseBrowser() {
		driver.close();
	}

	@AfterSuite(groups = { "Smoke Testing", "Regression Testing" })
	public void disconnectfromDB() {
		System.out.println("disconnect");
	}
	public static void takeCreenshort(String name ) throws IOException {
		File srcfile = ((TakesScreenshot) sdriver).getScreenshotAs(OutputType.FILE);
		String destfile = System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File Filedest = new File(destfile);
		FileUtils.copyFile(srcfile, Filedest);
	
	}
}
