package com.Amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class Searchproduct extends Invokedriver {


	
	public Searchproduct(WebDriver driver) {
			
			this.driver = driver;

		}
	
	public void productsearch(String prodname)  {

		Homeobj lst = new Homeobj(driver);
		List<WebElement> produccts = lst.productsearchlist();

		for (int i = 0; i < produccts.size(); i++) {
			String name = produccts.get(i).getText();
			if (name.equalsIgnoreCase(prodname)) {
				
				driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).get(i)
						.click();
				Reporter.log("selected the product", true);
		
			}

		}

	}
	
}
