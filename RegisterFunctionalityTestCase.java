/*Validating Register Functionality of RedmineDemoProject*/

package seleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterFunctionalityTestCase {
	public static ChromeDriver driver; 

	
	void callBrowser() { //Method for Calling Browser
		System.setProperty("webdriver.chrome.driver", "/Users/rajusaru/Desktop/Selenium/SoftwareDownloads/chromedriver_mac_arm64/chromedriver");
		driver =new ChromeDriver(); //Call the browser
		driver.get("http://demo.redmine.org/"); // Call the Redmine URL in the browser
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Register")).click(); //click on Register Link//Maximize the Window
	}
	
	void quitBrowser() { //Method for Quiting Browser
		driver.quit(); //Close the Browser
	}
	
	/*TestCase 1 - Verify that user is able to create an account by providing all the fields"
	1.Open a browser
	2.Open the URL(http://demo.redmine.com)
	3.Click on  Register
	4.Enter all the correct inputs
	5.Click on Submit.
	 */
	public void validateRegisterFunctionalitybyProvidingAllTheFields() {
		//driver.findElement(By.linkText("Register")).click(); //click on Register Link
		driver.findElement(By.id("user_login")).sendKeys("Sarayu68"); //Enter login
		driver.findElement(By.id("user_password")).sendKeys("1234"); //Enter password
		driver.findElement(By.id("user_password_confirmation")).sendKeys("1234");//Enter Password Confirmation
		driver.findElement(By.id("user_firstname")).sendKeys("Sarayu66"); //Enter Firstname
		driver.findElement(By.id("user_lastname")).sendKeys("Singamsetty"); //Enter Lastname
		driver.findElement(By.id("user_mail")).sendKeys("Sarayu68@gmail.com"); //Enter Email
		driver.findElement(By.name("commit")).click(); //Click Submit
		String expectedtitle = "Your account has been activated. You can now log in.";
		WebElement message = driver.findElement(By.id("flash_notice"));
	      String actualtitle = message.getText();
		//Validating
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Verify that user is able to create an account by providing all the fields is: Passed");
			driver.findElement(By.linkText("Sign out")).click();
		}
		else {
			System.out.println("Verify that user is able to create an account by providing all the fields is: Failed");
			
		}
		
	}

	/*TestCase 2 - "Verify that user is not able to create an account by leaving blank spaces in the mandatory fields."
1.Open a browser
2.Open the URL(http://demo.redmine.com)
3.Click on  Register.
4.Don’t enter anything into the Fields (Login, Password, Confirmation, First name, Last name, Email).
5.Click on Submit Button.
 */
	void validateRegisterFunctionalitybyProvidingAllBlankSpaces() {
		//driver.findElement(By.linkText("Register")).click(); //click on Register Link
		driver.findElement(By.id("user_login")).sendKeys(""); //Enter login
		driver.findElement(By.id("user_password")).sendKeys(""); //Enter password
		driver.findElement(By.id("user_password_confirmation")).sendKeys("");//Enter Password Confirmation
		driver.findElement(By.id("user_firstname")).sendKeys(""); //Enter Firstname
		driver.findElement(By.id("user_lastname")).sendKeys(""); //Enter Lastname
		driver.findElement(By.id("user_mail")).sendKeys(""); //Enter Email
		driver.findElement(By.name("commit")).click(); //Click Submit errorExplanation
		String expectedtitle = "Email cannot be blank\n"
				+ "Login cannot be blank\n"
				+ "First name cannot be blank\n"
				+ "Last name cannot be blank\n"
				+ "Password is too short (minimum is 4 characters)";
		WebElement message = driver.findElement(By.id("errorExplanation"));
		String actualtitle = message.getText();
		//System.out.println(actualtitle);
		
		//Validating
		
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate Registering an account by leaving blank spaces in the mandatory fields: Passed");
		}
		else {
			System.out.println("Validate Registering an account by leaving blank spaces in the mandatory fields: Failed");
			
		}
	}
	
	
		
	/*TestCase 3 - "Validate registering an account by entering different passwords into “password field” and “confirmation password” field."
	1.Open a browser
	2.Open the URL(http://demo.redmine.com)
	3.Click on  Register.
	4.Enter new Account details into Mandatory Fields (Login, First name, Last name, Email).
	5.Enter Password = 1234.
	6.Enter Confirmation = abcd.
	7.Click on Submit Button.
	 */
	void validateRegisterFunctionalitybyFillingDifferentPasswordsIntoPasswordAndConfirmation() {
		//driver.findElement(By.linkText("Register")).click(); //click on Register Link
		driver.findElement(By.id("user_login")).sendKeys("Sarayu001"); //Enter login
		driver.findElement(By.id("user_password")).sendKeys("1234"); //Enter password
		driver.findElement(By.id("user_password_confirmation")).sendKeys("abcd");//Enter Password Confirmation
		driver.findElement(By.id("user_firstname")).sendKeys("Sarayu001"); //Enter Firstname
		driver.findElement(By.id("user_lastname")).sendKeys("Singamsetty"); //Enter Lastname
		driver.findElement(By.id("user_mail")).sendKeys("sarayu001@gmail.com"); //Enter Email
		driver.findElement(By.name("commit")).click(); //Click Submit errorExplanation
		String expectedtitle = "Password doesn't match confirmation";
		WebElement message = driver.findElement(By.id("errorExplanation"));
		String actualtitle = message.getText();
		//System.out.println(actualtitle);
		
		//Validating
		
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate registering an account by entering different passwords into “password field” and “confirmation password” field: Passed");
		}
		else {
			System.out.println("Validate registering an account by entering different passwords into “password field” and “confirmation password” field.: Failed");
			
		}
	}
	
	/*TestCase4 - "Validate registering an account by providing invalid email id."
	1.Open a browser
	2.Open the URL(http://demo.redmine.com)
	3.Click on  Register.
	4.Enter new Account details into all Fields (Login, Password, Confirmation, First name, Last name).
	5.Enter an invalid email id.
	6.Click on Submit Button.
	 */
	void validateRegisterFunctionalitybyProvidingInvalidEmailID() {
		
		driver.findElement(By.id("user_login")).sendKeys("Sarayu001"); //Enter login
		driver.findElement(By.id("user_password")).sendKeys("1234"); //Enter password
		driver.findElement(By.id("user_password_confirmation")).sendKeys("1234");//Enter Password Confirmation
		driver.findElement(By.id("user_firstname")).sendKeys("Sarayu001"); //Enter Firstname
		driver.findElement(By.id("user_lastname")).sendKeys("Singamsetty"); //Enter Lastname
		driver.findElement(By.id("user_mail")).sendKeys("sarayu001@.com"); //Enter Email
		driver.findElement(By.name("commit")).click(); //Click Submit errorExplanation
		String expectedtitle = "Email is invalid";
		WebElement message = driver.findElement(By.id("errorExplanation"));
		String actualtitle = message.getText();
		//System.out.println(actualtitle);
		
		//Validating
		
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate registering an account by providing invalid email id: Passed");
		}
		else {
			System.out.println("Validate registering an account by providing invalid email id: Failed");
			
		}
	}
		
	/*TestCase5 - "Validate registering an account by providing already existing account"
	1.Open a browser
	2.Open the URL(http://demo.redmine.com)
	3.Click on  Register.
	4.Enter already existing account details into all Fields (Login, Password, Confirmation, First name, Last name, Email).
	5.Click on Submit Button.
	 */
	void validateRegisterFunctionalitybyProvidingAlreadyExisingAccountDetails() {

		//driver.findElement(By.linkText("Register")).click(); //click on Register Link
		driver.findElement(By.id("user_login")).sendKeys("Sarayu44"); //Enter login
		driver.findElement(By.id("user_password")).sendKeys("1234"); //Enter password
		driver.findElement(By.id("user_password_confirmation")).sendKeys("1234");//Enter Password Confirmation
		driver.findElement(By.id("user_firstname")).sendKeys("Sarayu44"); //Enter Firstname
		driver.findElement(By.id("user_lastname")).sendKeys("Singamsetty"); //Enter Lastname
		driver.findElement(By.id("user_mail")).sendKeys("sarayu44@gmail.com"); //Enter Email
		driver.findElement(By.name("commit")).click(); //Click Submit errorExplanation
		String expectedtitle = "Email has already been taken\n"
				+ "Login has already been taken";
		WebElement message = driver.findElement(By.id("errorExplanation"));
		String actualtitle = message.getText();
		//System.out.println(actualtitle);
		
		//Validating
		
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate registering an account by providing already existing account: Passed");
		}
		else {
			System.out.println("Validate registering an account by providing already existing account: Failed");
			
		}
	
	}
	
	/*TestCase6 - "Validate registering an account by providing all input fields except Login"
	1.Open a browser
	2.Open the URL(http://demo.redmine.com)
	3.Click on  Register.
	4.Enter new account details into all Fields except Login (Password, Confirmation, First name, Last name).
	5.Click on Submit Button.
	 */
	void validateRegisterFunctionalitybyProvidingAllFieldsExceptLogin() {

		//driver.findElement(By.linkText("Register")).click(); //click on Register Link
		driver.findElement(By.id("user_login")).sendKeys(""); //Enter login
		driver.findElement(By.id("user_password")).sendKeys("1234"); //Enter password
		driver.findElement(By.id("user_password_confirmation")).sendKeys("1234");//Enter Password Confirmation
		driver.findElement(By.id("user_firstname")).sendKeys("Sarayu001"); //Enter Firstname
		driver.findElement(By.id("user_lastname")).sendKeys("Singamsetty"); //Enter Lastname
		driver.findElement(By.id("user_mail")).sendKeys("sarayu001@gmail.com"); //Enter Email
		driver.findElement(By.name("commit")).click(); //Click Submit errorExplanation
		String expectedtitle = "Login cannot be blank";
		WebElement message = driver.findElement(By.id("errorExplanation"));
		String actualtitle = message.getText();
		//System.out.println(actualtitle);
		
		//Validating
		
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate registering an account by providing all input fields except Login: Passed");
		}
		else {
			System.out.println("Validate registering an account by providing all input fields except Login: Failed");
			
		}
	
	}
	
	/*TestCase7 - "Validate registering an account by providing all input fields except First Name"
	1.Open a browser
	2.Open the URL(http://demo.redmine.com)
	3.Click on  Register.
	4.Enter new account details into all Fields except First name (Login, Password, Confirmation, Last name).
	5.Click on Submit Button.
	 */
	void validateRegisterFunctionalitybyProvidingAllFieldsExceptFirstName() {

		//driver.findElement(By.linkText("Register")).click(); //click on Register Link
		driver.findElement(By.id("user_login")).sendKeys("Sarayu001"); //Enter login
		driver.findElement(By.id("user_password")).sendKeys("1234"); //Enter password
		driver.findElement(By.id("user_password_confirmation")).sendKeys("1234");//Enter Password Confirmation
		driver.findElement(By.id("user_firstname")).sendKeys(""); //Enter Firstname
		driver.findElement(By.id("user_lastname")).sendKeys("Singamsetty"); //Enter Lastname
		driver.findElement(By.id("user_mail")).sendKeys("sarayu001@gmail.com"); //Enter Email
		driver.findElement(By.name("commit")).click(); //Click Submit errorExplanation
		String expectedtitle = "First name cannot be blank";
		WebElement message = driver.findElement(By.id("errorExplanation"));
		String actualtitle = message.getText();
		//System.out.println(actualtitle);
		
		//Validating
		
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate registering an account by providing all input fields except First name: Passed");
		}
		else {
			System.out.println("Validate registering an account by providing all input fields except First name: Failed");
			
		}
	
	}
	
	/*TestCase8 - "Validate registering an account by providing all input fields except Last Name"
	1.Open a browser
	2.Open the URL(http://demo.redmine.com)
	3.Click on  Register.
	4.Enter new account details into all Fields except Last name (Login, Password, Confirmation, First name).
	5.Click on Submit Button.
	 */
	void validateRegisterFunctionalitybyProvidingAllFieldsExceptLastName() {

		//driver.findElement(By.linkText("Register")).click(); //click on Register Link
		driver.findElement(By.id("user_login")).sendKeys("Sarayu001"); //Enter login
		driver.findElement(By.id("user_password")).sendKeys("1234"); //Enter password
		driver.findElement(By.id("user_password_confirmation")).sendKeys("1234");//Enter Password Confirmation
		driver.findElement(By.id("user_firstname")).sendKeys("Sarayu001"); //Enter Firstname
		driver.findElement(By.id("user_lastname")).sendKeys(""); //Enter Lastname
		driver.findElement(By.id("user_mail")).sendKeys("sarayu001@gmail.com"); //Enter Email
		driver.findElement(By.name("commit")).click(); //Click Submit errorExplanation
		String expectedtitle = "Last name cannot be blank";
		WebElement message = driver.findElement(By.id("errorExplanation"));
		String actualtitle = message.getText();
		//System.out.println(actualtitle);
		
		//Validating
		
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate registering an account by providing all input fields except Last name: Passed");
		}
		else {
			System.out.println("Validate registering an account by providing all input fields except Last name: Failed");
			
		}
	
	}
	
	/*TestCase9 - "Validate registering an account by providing all input fields except Email Id"
	1.Open a browser
	2.Open the URL(http://demo.redmine.com)
	3.Click on  Register.
	4.Enter new account details into all Fields except Email(Login, Password, Confirmation, First name, Last name).
	5.Click on Submit Button.
	 */
	void validateRegisterFunctionalitybyProvidingAllFieldsExceptEmailId() {

		//driver.findElement(By.linkText("Register")).click(); //click on Register Link
		driver.findElement(By.id("user_login")).sendKeys("Sarayu001"); //Enter login
		driver.findElement(By.id("user_password")).sendKeys("1234"); //Enter password
		driver.findElement(By.id("user_password_confirmation")).sendKeys("1234");//Enter Password Confirmation
		driver.findElement(By.id("user_firstname")).sendKeys("Sarayu001"); //Enter Firstname
		driver.findElement(By.id("user_lastname")).sendKeys("Singamsetty"); //Enter Lastname
		driver.findElement(By.id("user_mail")).sendKeys(""); //Enter Email
		driver.findElement(By.name("commit")).click(); //Click Submit errorExplanation
		String expectedtitle = "Email cannot be blank";
		WebElement message = driver.findElement(By.id("errorExplanation"));
		String actualtitle = message.getText();
		//System.out.println(actualtitle);
		
		//Validating
		
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate registering an account by providing all input fields except Email: Passed");
		}
		else {
			System.out.println("Validate registering an account by providing all input fields except Email: Failed");
			
		}
	
	}
	
	/*TestCase10 - "Validate registering an account by providing all input fields except Password"
	1.Open a browser
	2.Open the URL(http://demo.redmine.com)
	3.Click on  Register.
	4.Enter new account details into all Fields except Email(Login, Confirmation, First name, Last name).
	5.Click on Submit Button.
	 */
	void validateRegisterFunctionalitybyProvidingAllFieldsExceptPassword() {

		//driver.findElement(By.linkText("Register")).click(); //click on Register Link
		driver.findElement(By.id("user_login")).sendKeys("Sarayu001"); //Enter login
		driver.findElement(By.id("user_password")).sendKeys(""); //Enter password
		driver.findElement(By.id("user_password_confirmation")).sendKeys("1234");//Enter Password Confirmation
		driver.findElement(By.id("user_firstname")).sendKeys("Sarayu001"); //Enter Firstname
		driver.findElement(By.id("user_lastname")).sendKeys("Singamsetty"); //Enter Lastname
		driver.findElement(By.id("user_mail")).sendKeys("sarayu001@gmail.com"); //Enter Email
		driver.findElement(By.name("commit")).click(); //Click Submit errorExplanation
		String expectedtitle = "Password is too short (minimum is 4 characters)\n"
				+ "Password doesn't match confirmation";
		WebElement message = driver.findElement(By.id("errorExplanation"));
		String actualtitle = message.getText();
		//System.out.println(actualtitle);
		
		//Validating
		
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate registering an account by providing all input fields except Password: Passed");
		}
		else {
			System.out.println("Validate registering an account by providing all input fields except Password: Failed");
			
		}
	
	}
	
	/*TestCase11 - "Validate registering an account by providing all input fields except Confirmation"
	1.Open a browser
	2.Open the URL(http://demo.redmine.com)
	3.Click on  Register.
	4.Enter new account details into all Fields except Confirmation(Login, Password, First name, Last name).
	5.Click on Submit Button.
	 */
	void validateRegisterFunctionalitybyProvidingAllFieldsExceptConfirmation() {

		//driver.findElement(By.linkText("Register")).click(); //click on Register Link
		driver.findElement(By.id("user_login")).sendKeys("Sarayu001"); //Enter login
		driver.findElement(By.id("user_password")).sendKeys("1234"); //Enter password
		driver.findElement(By.id("user_password_confirmation")).sendKeys("");//Enter Password Confirmation
		driver.findElement(By.id("user_firstname")).sendKeys("Sarayu001"); //Enter Firstname
		driver.findElement(By.id("user_lastname")).sendKeys("Singamsetty"); //Enter Lastname
		driver.findElement(By.id("user_mail")).sendKeys("sarayu001@gmail.com"); //Enter Email
		driver.findElement(By.name("commit")).click(); //Click Submit errorExplanation
		String expectedtitle = "Password doesn't match confirmation";
		WebElement message = driver.findElement(By.id("errorExplanation"));
		String actualtitle = message.getText();
		//System.out.println(actualtitle);
		
		//Validating
		
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate registering an account by providing all input fields except Confirmation: Passed");
		}
		else {
			System.out.println("Validate registering an account by providing all input fields except Confirmation: Failed");
			
		}
	
	}
	
	/*TestCase12 - "Validate registering functionality by navigating back after Successfull User Resgistrtion"
	1.Open a browser
	2.Open the URL(http://demo.redmine.com)
	3.Click on  Register.
	4.Enter new account details into all Fields except Confirmation(Login, Password, First name, Last name).
	5.Click on Submit Button.
	6.Click back button.
	 */
	void validateRegisterFunctionalitybyNavigateBackAfterSuccessUserRegistrtion() {

		driver.findElement(By.linkText("Register")).click(); //click on Register Link
		driver.findElement(By.id("user_login")).sendKeys("Sarayu65"); //Enter login
		driver.findElement(By.id("user_password")).sendKeys("1234"); //Enter password
		driver.findElement(By.id("user_password_confirmation")).sendKeys("1234");//Enter Password Confirmation
		driver.findElement(By.id("user_firstname")).sendKeys("Sarayu65"); //Enter Firstname
		driver.findElement(By.id("user_lastname")).sendKeys("Singamsetty"); //Enter Lastname
		driver.findElement(By.id("user_mail")).sendKeys("sarayu65@gmail.com"); //Enter Email
		driver.findElement(By.name("commit")).click(); //Click Submit errorExplanation
		
		driver.navigate().back(); // Navigate Back Command
		String expectedurl = "http://demo.redmine.org/my/account"; //expected URL
	    String url = driver.getCurrentUrl(); //Get Current URL from current page
	    System.out.println(url);
	    //validate
	    if(expectedurl.equals(url)) {
			System.out.println("Validate registering functionality by navigating back after Successfull User Resgistrtion: Passed");
		}
		else {
			System.out.println("Validate registering functionality by navigating back after Successfull User Resgistrtion: Failed");
			
		}
	}
	
	
	// Main Method
	public static void main(String[] args) {
		
		//Create an Object to call all methods in the class RFTestCase
		RegisterFunctionalityTestCase RF =new RegisterFunctionalityTestCase();
		
		//Calling All Methods to implement TestCases
		RF.callBrowser();
		RF.validateRegisterFunctionalitybyProvidingAllTheFields();
		RF.validateRegisterFunctionalitybyProvidingAllBlankSpaces();
		RF.validateRegisterFunctionalitybyFillingDifferentPasswordsIntoPasswordAndConfirmation();
		RF.validateRegisterFunctionalitybyProvidingInvalidEmailID();
		RF.validateRegisterFunctionalitybyProvidingAlreadyExisingAccountDetails();
		RF.validateRegisterFunctionalitybyProvidingAllFieldsExceptLogin();
		RF.validateRegisterFunctionalitybyProvidingAllFieldsExceptFirstName();
		RF.validateRegisterFunctionalitybyProvidingAllFieldsExceptLastName();
		RF.validateRegisterFunctionalitybyProvidingAllFieldsExceptEmailId();
		RF.validateRegisterFunctionalitybyProvidingAllFieldsExceptPassword();
		RF.validateRegisterFunctionalitybyProvidingAllFieldsExceptConfirmation();
		RF.validateRegisterFunctionalitybyNavigateBackAfterSuccessUserRegistrtion();
		RF.quitBrowser();
		
		 
	}

}
