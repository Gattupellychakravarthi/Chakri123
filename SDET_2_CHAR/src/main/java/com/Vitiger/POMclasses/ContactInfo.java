package com.Vitiger.POMclasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.WebDriverUtil;

public class ContactInfo {
	WebDriver driver;
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement creatcontactimg;
	@FindBy(name = "search_text")
	private WebElement searchcretedcontactlink;
	@FindBy(name = "submit")
	private WebElement clicksearchlink;
	@FindBy(name = "search_field")
	private WebElement searchddlink;

	public WebElement getCreatcontactimg() {
		return creatcontactimg;
	}

	public WebElement getSearchcretedcontactlink() {
		return searchcretedcontactlink;
	}

	public WebElement getClikcsearchlink() {
		return clicksearchlink;
	}

	public WebElement getSearchddlink() {
		return searchddlink;
	}

	public ContactInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void SearchContactdd(WebElement element,String text) {
		WebDriverUtil util= new WebDriverUtil(driver);
		util.selectvisibletextfromdd(searchddlink, text);
	}
	public void CreatContact() {
		creatcontactimg.click();
	}
	public void searchcreatedcontact(String value) {
		searchcretedcontactlink.sendKeys(value);
		WebDriverUtil util = new WebDriverUtil(driver);
		util.selectvisibletextfromdd(searchddlink, value);
		clicksearchlink.click();
	}

}
