package pageObjectModel;

import org.openqa.selenium.By;

public class LoginPageObjects {
	
			//Signin Elements
			public static By Username = By.xpath("//input[@id='username']");
			public static By Password = By.xpath("//input[@id='password']");
			
			public static By Login = By.xpath("//input[@name='login']");
			public static By LostPassword = By.linkText("Lost password");
			public static By Mail = By.xpath("//input[@id='mail']");
			public static By MailSubmit = By.xpath("//input[@name='commit']");
			//Link Elements
			public static By Home = By.xpath("//a[@class = 'home']");
			public static By Projects = By.xpath("//a[@class = 'projects']");
			public static By Help = By.xpath("//a[@class = 'help']");
			public static By Signin = By.xpath("//a[@class='login']");
			public static By Register = By.xpath("//a[@class='register']");
			public static By Search = By.xpath("//div[@id='quick-search']/form/label/a");
			public static By SearchButton = By.xpath("//input[@id='q']");
			
			//Validate & Error Explanation
			public static By Flash = By.xpath("//div[@id='flash_notice']");
			public static By Error = By.xpath("//div[@id='flash_error']");
			
			//My account, UserActive & signout 
			
			
			public static By MyAccount = By.xpath("//a[@class = 'my-account']");
			public static By Signout = By.xpath("//a[@class = 'logout']");
			public static By UserActive = By.xpath("//a[@class = 'user active']");
			
			

}
