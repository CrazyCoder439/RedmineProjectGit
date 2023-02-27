//Validate Login Functionality TestCases
package seleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFunctionalityTestCases {
	public static ChromeDriver driver;
	public static String ANSI_GREEN = "\u001B[32m";
	public static String ANSI_RED = "\u001B[31m";
	public static String ANSI_RESET = "\u001B[37m";
	
	
	void callBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/rajusaru/Desktop/Selenium/SoftwareDownloads/chromedriver_mac_arm64/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://demo.redmine.org/");
		driver.manage().window().maximize();
		
	}
	
	void quitBrowser() {
		driver.close();
	}
	
	/*TestCase 1 - "Validate logging into the application using valid credentials"
	 	1. Open a browser
		2. Open the URL(http://demo.redmine.com)
		3. Enter valid email address into the 'E-Mail Address' field 
		4. Enter valid password into the 'Password' field
		5. Click on 'Login' button
		*/
	 
	void validateLoggingwithValidCredentials() {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys("Sarayu44"); //login
		driver.findElement(By.id("password")).sendKeys("1234");		//password
		driver.findElement(By.name("login")).click();
		String expectedMessage = "My account - Redmine demo"; //expected Message
		driver.findElement(By.cssSelector("div[id='account']>ul>li>a[class='my-account']")).click();
		String actualtitle = driver.getTitle(); //Get Current Title
	    //System.out.println(actualtitle);
		
		
	    /*String url = driver.getCurrentUrl(); //Get Current URL Command
	    System.out.println(url);*/
	    
	    if(expectedMessage.equals(actualtitle)) {
			System.out.println("Validate logging into the Application using valid Email and valid Password: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			driver.findElement(By.linkText("Sign out")).click();
		}
		else {
			System.out.println("Validate logging into the Application using valid Email and valid Password: Failed");
			
		}
	    
		//Validating
		
		
	}

	/*TestCase 2 - "Validate logging into the Application using invalid email and invalid password."
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter invalid email address into the 'E-Mail Address' field 
	4. Enter invalid password into the 'Password' field
	5. Click on 'Login' button
 */
	void validateLoggingwithInvalidEmailInvalidPassword() {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys("Sarayyu");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.name("login")).click();
		String expectedtitle = "Invalid user or password";
		WebElement message = driver.findElement(By.id("flash_error"));
	      String actualtitle = message.getText();
		//Validating
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate logging into the Application using Invalid Email and Invalid Password: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			System.out.println("Validate logging into the Application using Invalid Email and Invalid Password: Failed");
			
		}
		
		
	}
	
	/*TestCase 3 - "Validate logging into the Application using invalid Email and valid Password"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter Invalid email address into the 'E-Mail Address' field 
	4. Enter valid password into the 'Password' field
	5. Click on 'Login' button
 */
	void validateLoggingwithInvalidEmailValidPassword() {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys("Sarayyu");
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.name("login")).click();
		String expectedtitle = "Invalid user or password";
		WebElement message = driver.findElement(By.id("flash_error"));
	      String actualtitle = message.getText();
		//Validating
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate logging into the Application using Invalid Email and Valid password: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			System.out.println("Validate logging into the Application using Invalid Email and Valid password: Failed");
			
		}
		
		
	}
	
	/*TestCase 4 - "Validate logging into the Application using invalid Email and valid Password"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter Invalid email address into the 'E-Mail Address' field 
	4. Enter valid password into the 'Password' field
	5. Click on 'Login' button
 */
	void validateLoggingwithValidEmailInvalidPassword() {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys("Sarayu44");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.name("login")).click();
		String expectedtitle = "Invalid user or password";
		WebElement message = driver.findElement(By.id("flash_error"));
	      String actualtitle = message.getText();
		//Validating
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate logging into the Application using Valid Email and Invalid password: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			System.out.println("Validate logging into the Application using Valid Email and Invalid password: Failed");
			
		}
		
		
	}
	
	/*TestCase 5 - "Validate logging into the Application without providing any credentials"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter nothing into the 'E-Mail Address' field 
	4. Enter nothing into the 'Password' field
	5. Click on 'Login' button
 */
	void validateLoggingwithBlankInputs() {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.name("login")).click();
		String expectedtitle = "Invalid user or password";
		WebElement message = driver.findElement(By.id("flash_error"));
	      String actualtitle = message.getText();
		//Validating
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate logging into the Application using Blank Inputs: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			System.out.println("Validate logging into the Application using Blank Inputs: Failed");
			
		}
		
		
	}
	
	/*TestCase 6 - "Validate 'Forgotten Password' link with Invalid Email Id"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter nothing into the 'E-Mail Address' field 
	4. Enter nothing into the 'Password' field
	5. Click on 'Lost Password' link.
	6. Enter Invalid email id into 'E-Mail Address' field.
	7. Click on Submit Button.
 */
	void validateForgottenPasswordLinkWithInvalidEmail() {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.linkText("Lost password")).click();
		driver.findElement(By.id("mail")).sendKeys("Sarayu@gmail.com");
		driver.findElement(By.name("commit")).click();
		
		String expectedtitle = "Unknown user.";
		WebElement message = driver.findElement(By.id("flash_error"));
	      String actualtitle = message.getText();
		//Validating
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate 'Forgotten Password' link with Invalid Email Id: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			System.out.println("Validate 'Forgotten Password' link with Invalid Email Id: Failed");
			
		}
		
		
	}
	
	
	/*TestCase 7 - "Validate 'Forgotten Password' link with valid Email Id"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter nothing into the 'E-Mail Address' field 
	4. Enter nothing into the 'Password' field
	5. Click on 'Lost Password' link.
	6. Enter valid email id into 'E-Mail Address' field.
	7. Click on Submit Button.
 */
	void validateForgottenPasswordLinkWithvalidEmail() {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.linkText("Lost password")).click();
		driver.findElement(By.id("mail")).sendKeys("Sarayu44@gmail.com");
		driver.findElement(By.name("commit")).click();
		
		String expectedtitle = "An email with instructions to choose a new password has been sent to you.";
		WebElement message = driver.findElement(By.id("flash_notice"));
	      String actualtitle = message.getText();
		//Validating
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate 'Forgotten Password' link with valid Email Id: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			System.out.println("Validate 'Forgotten Password' link with valid Email Id: Failed");
			
		}
		
		
	}

	/*TestCase 8 - "Validate user functionality by navigate back after successful login Stays Logged"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter valid details into the 'E-Mail Address' field 
	4. Enter valid detials into the 'Password' field
	5. Click on 'login' button.
	6. click on My account page.
	7. Navigate back button.
 */
	void validateUserFunctionalityByNavigateBackAfterSuccessfulLogin() {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys("Sarayu44"); //login
		driver.findElement(By.id("password")).sendKeys("1234");		//password
		driver.findElement(By.name("login")).click();
		String expectedMessage = "My account - Redmine demo"; //expected Message
		driver.findElement(By.cssSelector("div[id='account']>ul>li>a[class='my-account']")).click();
		driver.navigate().back(); //Navigate Back
		driver.findElement(By.cssSelector("div[id='account']>ul>li>a[class='my-account']")).click();
		String actualtitle = driver.getTitle(); //Get Current Title
	   // System.out.println(actualtitle);
		
		
	    /*String url = driver.getCurrentUrl(); //Get Current URL Command
	    System.out.println(url);*/
	    
	    if(expectedMessage.equalsIgnoreCase(actualtitle)) {
			System.out.println("Validate user functionality by navigate back after successful login stays logged : "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			driver.findElement(By.linkText("Sign out")).click();
		}
		else {
			System.out.println("Validate user functionality by navigate back after successful login stays logged: Failed");
			
		}
	}
	
	
	
	/*TestCase 9 - "Validate user functionality that logged into Correct User are not"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter valid details into the 'E-Mail Address' field 
	4. Enter valid detials into the 'Password' field
	5. Click on 'login' button.
	6. Click on My account page.
	7. Check Current User.

 */
	void validateUserFunctionalityThatLoggedIntoCorrectUser() {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys("Sarayu44"); //login
		driver.findElement(By.id("password")).sendKeys("1234");		//password
		driver.findElement(By.name("login")).click();
		String expectedMessage = "Sarayu44"; //expected Message
		String actualUser = driver.findElement(By.cssSelector("div[id='loggedas']>a[class='user active']")).getText();
	    //System.out.println(actualUser);
	    
	    if(expectedMessage.equalsIgnoreCase(actualUser)) {
			System.out.println("Validate user functionality that logged into Correct User are not: " +  ANSI_GREEN +  "Passed" + ANSI_RESET);
			driver.findElement(By.linkText("Sign out")).click();
		}
		else {
			System.out.println("Validate user functionality that logged into Correct User are not: Failed");
			
		}
	}
	
	
	// Main Method
	public static void main(String[] args) {
		// Create an object to call all methods of LoginFunctionalitytestCases Class
		
		LoginFunctionalityTestCases LF = new LoginFunctionalityTestCases();
		LF.callBrowser();
		LF.validateLoggingwithValidCredentials();
		LF.validateLoggingwithInvalidEmailInvalidPassword();
		LF.validateLoggingwithInvalidEmailValidPassword();
		LF.validateLoggingwithValidEmailInvalidPassword();
		LF.validateLoggingwithBlankInputs();
		LF.validateForgottenPasswordLinkWithInvalidEmail();
		LF.validateForgottenPasswordLinkWithvalidEmail();
		LF.validateUserFunctionalityByNavigateBackAfterSuccessfulLogin();
		LF.validateUserFunctionalityThatLoggedIntoCorrectUser();
		LF.quitBrowser();
		
	}

}
