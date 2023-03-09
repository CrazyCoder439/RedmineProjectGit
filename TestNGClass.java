package testNG;


import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

public class TestNGClass {
	public static ChromeDriver driver;
	
	@BeforeTest
	  public void beforeClass() {
		  System.setProperty("webdriver.chrome.driver", "/Users/rajusaru/Desktop/Selenium/SoftwareDownloads/chromedriver_mac_arm64/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://demo.redmine.org");
			driver.manage().window().maximize();
			System.out.println("Browser is opened");
	  }
	 @AfterTest
	  public void afterClass() {
		  
		driver.quit();
			System.out.println("Browser is Closed");
	  }

	
 
  
}
