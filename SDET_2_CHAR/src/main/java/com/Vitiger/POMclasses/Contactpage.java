package com.Vitiger.POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.JavaUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class Contactpage {
	WebDriver driver;
	@FindBy(name = "firstname")
	private WebElement firstname;
	@FindBy(name = "lastname")
	private WebElement lastname;
	@FindBy(xpath = "//img[@style='cursor:hand;cursor:pointer']")
	private WebElement movetochildimg;
	@FindBy(id = "search_txt")
	private WebElement childsearchbox;
	@FindBy(name = "search")
	private WebElement searchlink;
	@FindBy(xpath = "//a[text()='chakri3']")
	private WebElement createdorglink;
	@FindBy(css = "select[name='salutationtype']")
	private WebElement contactnamedd;
	@FindBy(name = "button")
	private WebElement clicksavelink;

	public WebElement getClicksavelink() {
		return clicksavelink;
	}

	public WebElement getContactnamedd() {
		return contactnamedd;
	}

	public WebElement getFirtname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getMovetochildimg() {
		return movetochildimg;
	}

	public WebElement getChildsearchbox() {
		return childsearchbox;
	}

	public WebElement getSearchlink() {
		return searchlink;
	}

	public WebElement getCreatedorglink() {
		return createdorglink;
	}

	public Contactpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void CreatContact() {
		JavaUtil js = new JavaUtil();
		firstname.sendKeys(js.getfirstname());
		lastname.sendKeys(js.getlastname());
		movetochildimg.click();
	}

	public String CreatOnlylastname(String value) {

		lastname.sendKeys(value);
		return value;

	}

	public void contactnamedd(String text) {
		WebDriverUtil util = new WebDriverUtil(driver);
		util.selectvisibletextfromdd(contactnamedd, text);
	}

	public void ChildpageSearch(String value) {
		childsearchbox.sendKeys(value);
		searchlink.click();
		createdorglink.click();

	}

	public void Contactsave() {
		clicksavelink.click();
	}

}
