package com.Amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
		

public class Homeobj {

	WebDriver driver;

	public Homeobj(WebDriver driver) {
		
		this.driver = driver;

	}
	
	

	By Accountlink = By.xpath("//a[@id='nav-link-accountList']");
	By Searchbar = By.xpath("//input[@id='twotabsearchtextbox']");
	By Searchbutton = By.xpath("//input[@id='nav-search-submit-button']");
	By Starthere = By.xpath("//div[@id='nav-flyout-ya-newCust']//a[@class='nav-a'][normalize-space()='Start here.']");
	By productlist = By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']");
	By productsearchlist = By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']");
	By addtocart = By.xpath("//input[@id='add-to-cart-button']");
	By itemdbuy = By.xpath("//input[@name='proceedToRetailCheckout']");
	By Amazonicon = By.xpath("//i[@class='a-icon a-icon-logo clickable-heading']");
	By popbutton = By.xpath("//a[@class='a-button-text']");
	By addcartassert = By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']");
	By usethisaddress = By.xpath("//input[@aria-labelledby='orderSummaryPrimaryActionBtn-announce']");
	By price = By.xpath("//td[@class='a-color-price a-size-medium a-text-right grand-total-price aok-nowrap a-text-bold a-nowrap']");


//	methods returning webElements	
	
	public WebElement account() {

		return driver.findElement(Accountlink);
	}

	public WebElement searchbar() {

		return driver.findElement(Searchbar);
	}

	public WebElement starthere() {

		return driver.findElement(Starthere);
	}

	public WebElement searchbutton() {

		return driver.findElement(Searchbutton);
	}

	public WebElement itemdbuy() {

		return driver.findElement(itemdbuy);
	}

	public WebElement addtocart() {

		return driver.findElement(addtocart);
	}

	public WebElement amazonicon() {

		return driver.findElement(Amazonicon);
	}

	public WebElement popbutton() {

		return driver.findElement(popbutton);
	}

	public WebElement addcartassert() {

		return driver.findElement(addcartassert);
	}

	public WebElement productlist() {

		return driver.findElement(productlist);
	}

	public List<WebElement> productsearchlist() {

		return driver.findElements(productsearchlist);
	}

	public WebElement usethisaddress() {

		return driver.findElement(usethisaddress);
	}

	public WebElement price() {

		return driver.findElement(price);
	}

}
