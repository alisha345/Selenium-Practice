package com.evexso_webapp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evexso_webapp.qa.base.TestBase;

public class LoginPage  extends TestBase{
	
	//Page Factory :OR
	
	@FindBy(xpath="//body[contains(@class,'ext-webkit ext-chrome')]/div/img[1]")
	WebElement eveXsoLogo;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}

}
