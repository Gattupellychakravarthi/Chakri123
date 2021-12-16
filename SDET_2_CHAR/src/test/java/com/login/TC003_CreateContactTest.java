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
		WebElement element=driver.findElement(By.xpath("//a[@title='Organizations']"));
		Assert.assertEquals("chakri3", element.getText());
	}

	@Test(groups = "Smoke Testing")
	public void CreatContactOnly() {
		Homepage home = new Homepage(driver);
		ContactInfo info = new ContactInfo(driver);
		Contactpage contact = new Contactpage(driver);
		home.conatactinfo();
		info.CreatContact();
		contact.CreatOnlylastname();
		contact.Contactsave();
		home.conatactinfo();
		info.searchcreatedcontact("Last Name");
		WebElement element=driver.findElement(By.xpath("//a[@title='Organizations']"));
		Assert.assertEquals("chakri3", element.getText());
	}

}
