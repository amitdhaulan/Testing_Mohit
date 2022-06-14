package com.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

public class Logoutmethod {

	// method for user logout
	public void logout(WebDriver driver) {
		
		Logoutobj lgo = new Logoutobj(driver);
		Actions hover = new Actions(driver);
		hover.moveToElement(lgo.account()).perform();
		lgo.logout().click();
		Invokedriver.asser().assertEquals("Sign-In", lgo.logoutassert().getText());
		Reporter.log("user logout", true);
		
	}
	

}
