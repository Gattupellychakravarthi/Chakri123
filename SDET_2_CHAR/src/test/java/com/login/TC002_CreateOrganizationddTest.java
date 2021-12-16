package com.login;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vitiger.POMclasses.BaseClass;
import com.Vitiger.POMclasses.CreatOrgniz;
import com.Vitiger.POMclasses.Homepage;
import com.Vitiger.POMclasses.OrganizInfo;
import com.Vtiger.genericUtil.JavaUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class TC002_CreateOrganizationddTest extends BaseClass {
	@Test(groups = "Regression Testing")
	public void CreatOrgDropdownTest() throws EncryptedDocumentException, IOException, InterruptedException {

		WebDriverUtil Methods = new WebDriverUtil(driver);
		Homepage home = new Homepage(driver);
		CreatOrgniz creat = new CreatOrgniz(driver);
		home.Orginfoclick();
		OrganizInfo info = new OrganizInfo(driver);
		info.creatorg();
		String orgname = JavaUtil.objForJavaUtil().getfirstname() + JavaUtil.objForJavaUtil().generateRandomNumber();
		creat.CreatOrgNameClick(orgname);
		creat.creatindustrydd("Sheet1", 0, "Construction");
		creat.creatratingdd("Sheet1", 1, "Active");
		creat.creataccountdd("Sheet1", 2, "Customer");
		creat.SendOrgName();
		Methods.pageloadtimeout();
		Methods.refresh();
		home.Orginfoclick();
		info.searchorgname(orgname);
		info.searchOrgNamedd("Organization Name");
		WebElement Orgname=null;
		Orgname = driver.findElement(By.xpath("//a[text()='"+orgname+"' and @title='Organizations']"));
		System.out.println(Orgname.isDisplayed());
		String actual=Orgname.getText();
		Assert.assertEquals( orgname, actual);

	}

}
