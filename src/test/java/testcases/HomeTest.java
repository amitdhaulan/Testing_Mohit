package testcases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Amazon.Homeobj;
import com.Amazon.Invokedriver;
import com.Amazon.Loginmethod;
import com.Amazon.Logoutmethod;
import com.Amazon.Searchproduct;



public class HomeTest extends Invokedriver {

	public WebDriver driver;

	@Test
	public void Home() throws  IOException {

		// Invoking driver
		driver = indriver();
		Loginmethod lm = new Loginmethod();
		lm.login(driver);

		// creating object of Homeobject class
		Homeobj lg = new Homeobj(driver);

		loadProperty();
		String productcategory = getcustomproperty("productcategory");
		String selectitem = getcustomproperty("selectproduct");

		// Searching the product
		lg.searchbar().sendKeys(productcategory);
		lg.searchbutton().click();
		Reporter.log("searching product", true);
		
		// Used explicitwait for product loading
		explicitWait(lg.productlist());

		// selecting the product
		Searchproduct sr = new Searchproduct(driver);
		sr.productsearch(selectitem);
		Reporter.log("product searched", true);

		// moving driver from parent to child window
		Windowhandle();

		lg.addtocart().click();
		asser().assertEquals("Added to Cart", lg.addcartassert().getText());
		Reporter.log("Item added to cart", true);
		lg.itemdbuy().click();

		explicitWait(lg.usethisaddress());
		lg.usethisaddress().click();

		// getting total item price
		String itemprice = lg.price().getText();
		Reporter.log("Order total =" + itemprice);
		Reporter.log("Checkout page", true);

		// user logout
		Logoutmethod logoutobj = new Logoutmethod();
		lg.amazonicon().click();
		lg.popbutton().click();
		logoutobj.logout(driver);
		driver.quit();

	}

	
	

// method for handling the window 


}
