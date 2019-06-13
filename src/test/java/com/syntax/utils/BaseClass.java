package com.syntax.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public static WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	public static void setUpDriver() {
		
		ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);
		String browser= ConfigsReader.getProperty("browser");
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
			// for windows
			// System.setProperty("webdriver.chrome.driver",
			// "src/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "src/text/resources/drivers/geckodriver");
			driver = new FirefoxDriver();
			
		}else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "src/text/resources/drivers/IEDriverServer");
			driver=new InternetExplorerDriver();
			
		} else {
			System.out.println("browser given is wrong");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigsReader.getProperty("url"));
		//driver.manage().window().maximize();

	}
	@AfterMethod(alwaysRun=true)
	public static void tearDown()
	{
		driver.quit();
	}

}
