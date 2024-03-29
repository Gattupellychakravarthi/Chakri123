package com.Vitiger.POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.WebDriverUtil;

public class Homepage {
	WebDriver driver;
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutlink;
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement orglink;
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactlink;
	@FindBy(xpath = "//img[@style='padding: 0px;padding-left:5px']")
	private WebElement logoutimg;
    @FindBy(xpath="//a[@title='Organizations']")
    private WebElement validation;
    
    
	public WebElement getValidation() {
		return validation;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getLogoutimg() {
		return logoutimg;
	}

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void LogoutfromApp() throws InterruptedException {
		WebDriverUtil util = new WebDriverUtil(driver);
		Thread.sleep(2000);
		util.movetoelement(logoutimg);
		signoutlink.click();

	}

	public void Orginfoclick(){
		orglink.click();

	}
    public void conatactinfo() {
    	contactlink.click();
    }
   public void selectquotedd() {
	   
   }
}
