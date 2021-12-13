package com.Vitiger.POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Vtiger.genericUtil.WebDriverUtil;

public class OrganizInfo {
	WebDriver driver;
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement imageorg;
	@FindBy(name = "search_text")
	private WebElement orgsearchbox;
	@FindBy(name = "submit")
	private WebElement searchbotn;
	@FindBy(name = "search_field")
	private WebElement searchlink;
	@FindBy(xpath = "//a[@title='Organizations']")
	private WebElement clickorglink;
	@FindBy(xpath = "//a[@title='Organizations']")
	private WebElement validationlink;

	public WebElement getValidationlink() {
		return validationlink;
	}

	public WebElement getClickorglink() {
		return clickorglink;
	}

	public WebElement getOrgsearchbox() {
		return orgsearchbox;
	}

	public WebElement getSearchbotn() {
		return searchbotn;
	}

	public WebElement getImangeorg() {
		return imageorg;
	}

	public OrganizInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void creatorg() {
		imageorg.click();

	}

	public void searchorgname(String orgname) {

		orgsearchbox.sendKeys(orgname);

	}

	public void searchPhonenumber(String Phonenumber) {
		orgsearchbox.sendKeys(Phonenumber);

	}

	public void searchOrgNamedd(String text) throws InterruptedException {
		WebDriverUtil util = new WebDriverUtil(driver);
		util.selectvisibletextfromdd(searchlink, text);
		searchbotn.click();
	}

}
