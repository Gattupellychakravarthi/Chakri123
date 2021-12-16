package com.Vitiger.POMclasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.ExcelUtil;
import com.Vtiger.genericUtil.JavaUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class CreatOrgniz {
	WebDriver driver;
	/*
	 * public String orgname = JavaUtil.objForJavaUtil().getfirstname() +
	 * JavaUtil.objForJavaUtil().generateRandomNumber();
	 */
	@FindBy(name = "accountname")
	private WebElement accountlink;

	@FindBy(name = "button")
	private WebElement submitbton;
	@FindBy(name = "industry")
	private WebElement industrydd;
	@FindBy(name = "rating")
	private WebElement ratingdd;
	@FindBy(name = "accounttype")
	private WebElement accountdd;
	@FindBy(name="phone")
	private WebElement Phonenumber;

	public WebElement getRatingdd() {
		return ratingdd;
	}

	public WebElement getAccountdd() {
		return accountdd;
	}

	public WebElement getIndustrydd() {
		return industrydd;
	}

	public WebElement getAccountlink() {
		return accountlink;
	}

	public WebElement getSubmitbton() {
		return submitbton;
	}

	public CreatOrgniz(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void SendOrgName() {
		submitbton.click();
	}

	public void CreatOrgNameClick(String orgname) {
		
	 accountlink.sendKeys(orgname);
		
	}

	public WebElement getPhonenumber() {
		return Phonenumber;
	}

	public void creatindustrydd(String Sheetname, int cell, String text)
			throws EncryptedDocumentException, IOException {
		WebDriverUtil util = new WebDriverUtil(driver);
		ExcelUtil Eutil = new ExcelUtil();
		util.selectvisibletextfromdd(industrydd, Eutil.ReaddatafromExcel(Sheetname, cell, text));

	}

	public void creatratingdd(String Sheetname, int cell, String text) throws EncryptedDocumentException, IOException {
		WebDriverUtil util = new WebDriverUtil(driver);
		ExcelUtil Eutil = new ExcelUtil();
		util.selectvisibletextfromdd(ratingdd, Eutil.ReaddatafromExcel(Sheetname, cell, text));

	}

	public void creataccountdd(String Sheetname, int cell, String text) throws EncryptedDocumentException, IOException {
		WebDriverUtil util = new WebDriverUtil(driver);
		ExcelUtil Eutil = new ExcelUtil();
		util.selectvisibletextfromdd(accountdd, Eutil.ReaddatafromExcel(Sheetname, cell, text));

	}
	public void CreatPhonenumber() {
		 Phonenumber.sendKeys(JavaUtil.objForJavaUtil().GetPhonenumber());
	
	}

	
}
