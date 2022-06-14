package com.Amazon;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.Assertion;

public class Invokedriver {

	public WebDriver driver;
	public  Properties prop;
	public String url;
	// Invoke driver generic method
	public WebDriver indriver() throws IOException {


		String url =	getcustomproperty("url");
		String browsername = getcustomproperty("browser");

		if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\exefiles/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
			Reporter.log("firefox launched", true);

		} else if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\exefiles/chromedriver.exe");
			driver = new ChromeDriver();
			// driver= new RemoteWebDriver(DesiredCapabilities.chrome());
			driver.get(url);
			implicitWaitForSeconds(driver, 15);
			driver.manage().window().maximize();
			Reporter.log("Chrome launched", true);

		} else if (browsername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", ".\\exefiles/msedgedriver.exe");
			driver = new EdgeDriver();
			// driver= new RemoteWebDriver(DesiredCapabilities.internetExplorer());
			driver.get(url);
			driver.manage().window().maximize();
			Reporter.log("IE launched", true);
		}

		return driver;
	}


	//  method for loading property file
	public void loadProperty() throws IOException {

		try {
			prop = new Properties();
			FileInputStream fil1 = new FileInputStream(System.getProperty("user.dir") + "\\resource\\data.properties");
			prop.load(fil1);

		} catch (IOException exception) {
			System.out.println(exception.getLocalizedMessage());
		}
	}


	public String  getcustomproperty(String propvar) throws IOException {
		loadProperty();

		if(prop.getProperty(propvar)== null ) {
			Reporter.log(propvar+ " This property is not present in the property file", true );
			System.exit(0);
		}

		return prop.getProperty(propvar); 
	}


	// Screenshot method for fail test cases generic method
	public static void TakeScreenshot(String testcaseName, WebDriver driver) throws IOException

	{
		// Creating instance of File
		File File = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationfile = System.getProperty("user.dir") + "\\reports\\" + testcaseName + ".png";
		FileUtils.copyFile(File, new File(destinationfile));
		Reporter.log("Loading property file", true);
	}

	// Explicit wait generic method
	public void explicitWait(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf(webElement));
		Reporter.log("Explicitwait complete", true);
	}

	// implicit wait generic method
	public static void implicitWaitForSeconds(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	// generic method for Assertion
	public static Assertion asser() {
		Assertion assertion1 = new Assertion();
		return assertion1;

	}

	// generic method for windowhandle
	public void Windowhandle() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
	}
}
