package pageObjectModel;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPageObjects{
		
		//RegisterPageObjects RObjects = new RegisterPageObjects();
		WebDriver driver;

		
		//TestBox Elements
		
		public static By UserLogin = By.xpath("//input[@id='user_login']");
		public static By Password = By.xpath("//input[@id='user_password']");
		public static By Confirmation = By.xpath("//input[@id='user_password_confirmation']");
		public static By FirstName = By.xpath("//input[@id='user_firstname']");
		public static By Lastname = By.xpath("//input[@id='user_lastname']");
		public static By Email = By.xpath("//input[@id='user_mail']");
		public static By Language = By.xpath("//select[@id = 'user_language']");
		public static By Submit = By.xpath("//input[@name='commit']");
		
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
		public static By Error = By.xpath("//div[@id='errorExplanation']");
		
		//My account, UserActive & signout 
		
		
		public static By MyAccount = By.xpath("//a[@class = 'my-account']");
		public static By Signout = By.xpath("//a[@class = 'logout']");
		public static By UserActive = By.xpath("//a[@class = 'user active']");
		
		

}
