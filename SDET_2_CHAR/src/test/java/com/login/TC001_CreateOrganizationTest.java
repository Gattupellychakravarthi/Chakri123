package com.login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vitiger.POMclasses.BaseClass;
import com.Vitiger.POMclasses.CreatOrgniz;
import com.Vitiger.POMclasses.Homepage;
import com.Vitiger.POMclasses.OrganizInfo;
import com.Vtiger.genericUtil.JavaUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

@Listeners(com.Vtiger.genericUtil.Listenersimplimentation.class)
public class TC001_CreateOrganizationTest extends BaseClass {

	@Test(groups = "Regression Testing")
	public void CreatOrganization() throws IOException, InterruptedException {
		WebDriverUtil Methods = new WebDriverUtil(driver);
		Homepage home = new Homepage(driver);
		OrganizInfo info = new OrganizInfo(driver);
		CreatOrgniz creat = new CreatOrgniz(driver);
		home.Orginfoclick();
		info.creatorg();
		String orgname = JavaUtil.objForJavaUtil().getfirstname() + JavaUtil.objForJavaUtil().generateRandomNumber();
		creat.CreatOrgNameClick(orgname);
		creat.SendOrgName();
		Methods.pageloadtimeout();
		Methods.refresh();
		home.Orginfoclick();
		info.searchorgname(orgname);
		info.searchOrgNamedd("Organization Name");
		WebElement Orgname = null;
		Methods.pageloadtimeout();
		Orgname = driver.findElement(By.xpath("//a[text()='" + orgname + "' and @title='Organizations']"));
		System.out.println(Orgname.isDisplayed());
		String actual = Orgname.getText();
		Assert.assertEquals(orgname, actual);
	}

	@Test(groups = "Smoke Testing")
	public void OrgNameWithNumber() throws InterruptedException {
		WebDriverUtil Methods = new WebDriverUtil(driver);
		Homepage home = new Homepage(driver);
		OrganizInfo info = new OrganizInfo(driver);
		CreatOrgniz creat = new CreatOrgniz(driver);
		home.Orginfoclick();
		info.creatorg();
		String orgname = JavaUtil.objForJavaUtil().getfirstname() + JavaUtil.objForJavaUtil().generateRandomNumber();
		creat.CreatOrgNameClick(orgname);
		creat.CreatPhonenumber();
		creat.SendOrgName();
		Methods.pageloadtimeout();
		Methods.refresh();
		home.Orginfoclick();
		info.searchorgname(orgname);
		info.searchOrgNamedd("Organization Name");
		WebElement Orgname = null;
		Thread.sleep(3000);
		Orgname = driver.findElement(By.xpath("//a[text()='" + orgname + "' and @title='Organizations']"));
		System.out.println(Orgname.isDisplayed());
		String actual = Orgname.getText();
		Assert.assertEquals(orgname, actual);
	}
}
