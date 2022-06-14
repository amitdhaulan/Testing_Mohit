package com.Amazon;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Loginmethod extends Invokedriver {

	// Login method for login user
	public void login(WebDriver driver) throws IOException {
		Loginobj lg = new Loginobj(driver);

		lg.accountlink().click();
		lg.continuebutton().click();
		lg.validation().getText().equalsIgnoreCase("");

		asser().assertEquals("Enter your email or mobile phone number", lg.validation().getText());
		Reporter.log("Validation message displayed", true);
		lg.email().sendKeys(getcustomproperty("name"));
		lg.continuebutton().click();
		lg.password().sendKeys(getcustomproperty("password"));
		lg.submit().click();
		Reporter.log("logged in successfully", true);
		asser().assertEquals("Hello, mohit", lg.loginassert().getText());
	
	}
}
