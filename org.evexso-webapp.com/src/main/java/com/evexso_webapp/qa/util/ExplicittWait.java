package com.evexso_webapp.qa.util;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.evexso_webapp.qa.base.TestBase;

public class ExplicittWait extends TestBase {
	
	public static void clickon(WebDriver driver , WebElement element, int timeout) {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	public static void sendkeys(WebDriver driver , WebElement locator, int timeout, String value) {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		locator.sendKeys(value);
		
	}


	public static void expliwait(WebElement locator, int timeout) {
	WebDriverWait wait = new WebDriverWait(driver, timeout);
	wait.ignoring(ElementNotVisibleException.class).until(ExpectedConditions.elementToBeSelected(locator));
	}
}
