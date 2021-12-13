package com.login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vitiger.POMclasses.BaseClass;
import com.Vitiger.POMclasses.ContactInfo;
import com.Vitiger.POMclasses.Contactpage;
import com.Vitiger.POMclasses.Homepage;
import com.Vtiger.genericUtil.JavaUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class TC003_CreateContactTest extends BaseClass {

	@Test(groups = "Regression Testing")
	public void CreatContact() throws IOException, InterruptedException {

		WebDriverUtil Methods = new WebDriverUtil(driver);
		Homepage home = new Homepage(driver);
		ContactInfo info = new ContactInfo(driver);
		Contactpage contact = new Contactpage(driver);
		home.conatactinfo();
		info.CreatContact();
		contact.contactnamedd("Mr.");
		String orgname = JavaUtil.objForJavaUtil().getfirstname() + JavaUtil.objForJavaUtil().generateRandomNumber();
		contact.CreatContact();
		Methods.switchtochild();
		contact.ChildpageSearch(orgname);
		Methods.switchtochild();
		contact.Contactsave();
		home.conatactinfo();
		info.searchcreatedcontact(orgname);
		WebElement ele2 = driver.findElement(By.xpath("//a[text()='chakri3' and @title='Organizations']"));
		String actual = ele2.getText();
		Assert.assertEquals(orgname, actual);
	}

	@Test(groups = "Smoke Testing")
	public void CreatContactOnly() {
		Homepage home = new Homepage(driver);
		ContactInfo info = new ContactInfo(driver);
		Contactpage contact = new Contactpage(driver);
		home.conatactinfo();
		info.CreatContact();
		String orgname = JavaUtil.objForJavaUtil().getlastname() + JavaUtil.objForJavaUtil().generateRandomNumber();
		contact.CreatOnlylastname();
		contact.Contactsave();
		home.conatactinfo();
		info.searchcreatedcontact("Last Name");
		WebElement ele2 = driver.findElement(By.xpath("//a[text()='chakri3' and @title='Organizations']"));
		String actual = ele2.getText();
		Assert.assertEquals(orgname, actual);
	}

}