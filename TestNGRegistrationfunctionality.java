package testNG;


import org.testng.annotations.Test;

import dataDriven1.DataForRegister;
import dataDriven1.WriteDataIntoExcel;
import pageObjectModel.RegisterPageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class TestNGRegistrationfunctionality {
	
	public static String expectedtitle;
	public static String actualtitle;
	public static String ANSI_GREEN = "\u001B[32m";
	public static String ANSI_RED = "\u001B[31m";
	public static String ANSI_RESET = "\u001B[37m";
	
	

	 

 @Test(priority = 1, enabled = true)
/*TestCase 1 - Verify that user is able to create an account by providing all the fields"
1.Open a browser
2.Open the URL(http://demo.redmine.com)
3.Click on  Register
4.Enter all the correct inputs
5.Click on Submit.
 */
public void validateRegisterFunctionalitybyProvidingAllTheFields() throws IOException {
	
	try{
		TestNGClass.driver.findElement(RegisterPageObjects.Register).click();//click on Register Link
		TestNGClass.driver.findElement(RegisterPageObjects.UserLogin).sendKeys(DataForRegister.readData(1, 1)); //Enter login
		TestNGClass.driver.findElement(RegisterPageObjects.Password).sendKeys(DataForRegister.readData(1, 2)); //Enter password
		TestNGClass.driver.findElement(RegisterPageObjects.Confirmation).sendKeys(DataForRegister.readData(1, 3));//Enter Password Confirmation
		TestNGClass.driver.findElement(RegisterPageObjects.FirstName).sendKeys(DataForRegister.readData(1, 4)); //Enter Firstname
		TestNGClass.driver.findElement(RegisterPageObjects.Lastname).sendKeys(DataForRegister.readData(1, 7)); //Enter Lastname
		TestNGClass.driver.findElement(RegisterPageObjects.Email).sendKeys(DataForRegister.readData(1,11)); //Enter Email
		TestNGClass.driver.findElement(RegisterPageObjects.Submit).click(); //Click Submit
		expectedtitle = "Your account has been activated. You can now log in.";
		WebElement message = TestNGClass.driver.findElement(RegisterPageObjects.Flash);
	    actualtitle = message.getText();
	    
		}
		catch(Exception e) {
			System.out.println("I'm in Catch 1 block");
		}
		//Validating
		if(expectedtitle.equals(actualtitle)) {
			WriteDataIntoExcel.WriteData(1, 12,"Passed");
			
			System.out.println("Verify that user is able to create an account by providing all the fields is: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
			TestNGClass.driver.findElement(RegisterPageObjects.Signout).click();
		}
		else {
			System.out.println("Verify that user is able to create an account by providing all the fields is: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			WriteDataIntoExcel.WriteData(1, 12,"Failed");
		}
		
}
@Test(priority = 2,enabled = true)
/*TestCase 2 - "Verify that user is not able to create an account by leaving blank spaces in the mandatory fields."
1.Open a browser
2.Open the URL(http://demo.redmine.com)
3.Click on  Register.
4.Don’t enter anything into the Fields (Login, Password, Confirmation, First name, Last name, Email).
5.Click on Submit Button.
 */
	public void validateRegisterFunctionalitybyProvidingAllBlankSpaces() throws IOException {
	try {
		TestNGClass.driver.findElement(RegisterPageObjects.Register).click();//click on Register Link
		TestNGClass.driver.findElement(RegisterPageObjects.UserLogin).sendKeys(""); //Enter login
		TestNGClass.driver.findElement(RegisterPageObjects.Password).sendKeys(""); //Enter password
		TestNGClass.driver.findElement(RegisterPageObjects.Confirmation).sendKeys("");//Enter Password Confirmation
		TestNGClass.driver.findElement(RegisterPageObjects.FirstName).sendKeys(""); //Enter Firstname
		TestNGClass.driver.findElement(RegisterPageObjects.Lastname).sendKeys(""); //Enter Lastname
		TestNGClass.driver.findElement(RegisterPageObjects.Email).sendKeys(""); //Enter Email
		TestNGClass.driver.findElement(RegisterPageObjects.Submit).click(); //Click Submit
		expectedtitle = "Email cannot be blank\n"
				+ "Login cannot be blank\n"
				+ "First name cannot be blank\n"
				+ "Last name cannot be blank\n"
				+ "Password is too short (minimum is 4 characters)";
		WebElement message = TestNGClass.driver.findElement(RegisterPageObjects.Error);
		actualtitle = message.getText();
	}
	catch(Exception e) {
		System.out.println("I'm in Catch 2 block");
	}
		//System.out.println(actualtitle);
		
		//Validating
		
		if(expectedtitle.equals(actualtitle)) {
			WriteDataIntoExcel.WriteData(2, 12,"Passed");
			System.out.println("Validate Registering an account by leaving blank spaces in the mandatory fields: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			WriteDataIntoExcel.WriteData(2, 12,"Failed");
			System.out.println("Validate Registering an account by leaving blank spaces in the mandatory fields: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
	}

@Test(priority = 3,enabled = true)
/*TestCase 3 - "Validate registering an account by entering different passwords into “password field” and “confirmation password” field."
1.Open a browser
2.Open the URL(http://demo.redmine.com)
3.Click on  Register.
4.Enter new Account details into Mandatory Fields (Login, First name, Last name, Email).
5.Enter Password = 1234.
6.Enter Confirmation = abcd.
7.Click on Submit Button.
 */

void validateRegisterFunctionalitybyFillingDifferentPasswordsIntoPasswordAndConfirmation() throws IOException {
	try {
		TestNGClass.driver.findElement(RegisterPageObjects.Register).click();//click on Register Link
		TestNGClass.driver.findElement(RegisterPageObjects.UserLogin).sendKeys(DataForRegister.readData(3, 1)); //Enter login
		TestNGClass.driver.findElement(RegisterPageObjects.Password).sendKeys(DataForRegister.readData(3, 2)); //Enter password
		TestNGClass.driver.findElement(RegisterPageObjects.Confirmation).sendKeys(DataForRegister.readData(3, 3));//Enter Password Confirmation
		TestNGClass.driver.findElement(RegisterPageObjects.FirstName).sendKeys(DataForRegister.readData(3, 4)); //Enter Firstname
		TestNGClass.driver.findElement(RegisterPageObjects.Lastname).sendKeys(DataForRegister.readData(3, 7)); //Enter Lastname
		TestNGClass.driver.findElement(RegisterPageObjects.Email).sendKeys(DataForRegister.readData(3,11)); //Enter Email
		TestNGClass.driver.findElement(RegisterPageObjects.Submit).click(); //Click Submit
		expectedtitle = "Password doesn't match confirmation";
	WebElement message = TestNGClass.driver.findElement(RegisterPageObjects.Error);
	actualtitle = message.getText();
	//System.out.println(actualtitle);
	
	//Validating
	}
	catch(Exception e) {
		System.out.println("I'm in Catch 3 block");
	}
	if(expectedtitle.equals(actualtitle)) {
		WriteDataIntoExcel.WriteData(3, 12,"Passed");
		System.out.println("Validate registering an account by entering different passwords into “password field” and “confirmation password” field: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
		
	}
	else {
		WriteDataIntoExcel.WriteData(3, 12,"Failed");
		System.out.println("Validate registering an account by entering different passwords into “password field” and “confirmation password” field.: "+  ANSI_RED +  "Failed" + ANSI_RESET);
		
	}
}
@Test(priority = 4,enabled = true)
/*TestCase4 - "Validate registering an account by providing invalid email id."
1.Open a browser
2.Open the URL(http://demo.redmine.com)
3.Click on  Register.
4.Enter new Account details into all Fields (Login, Password, Confirmation, First name, Last name).
5.Enter an invalid email id.
6.Click on Submit Button.
 */
void validateRegisterFunctionalitybyProvidingInvalidEmailID() throws IOException {
	try {
		TestNGClass.driver.findElement(RegisterPageObjects.Register).click();//click on Register Link
		TestNGClass.driver.findElement(RegisterPageObjects.UserLogin).sendKeys(DataForRegister.readData(4, 1)); //Enter login
		TestNGClass.driver.findElement(RegisterPageObjects.Password).sendKeys(DataForRegister.readData(4, 2)); //Enter password
		TestNGClass.driver.findElement(RegisterPageObjects.Confirmation).sendKeys(DataForRegister.readData(4, 3));//Enter Password Confirmation
		TestNGClass.driver.findElement(RegisterPageObjects.FirstName).sendKeys(DataForRegister.readData(4, 4)); //Enter Firstname
		TestNGClass.driver.findElement(RegisterPageObjects.Lastname).sendKeys(DataForRegister.readData(4, 7)); //Enter Lastname
		TestNGClass.driver.findElement(RegisterPageObjects.Email).sendKeys(DataForRegister.readData(4,11)); //Enter Email
		TestNGClass.driver.findElement(RegisterPageObjects.Submit).click(); //Click Submit
		expectedtitle = "Email is invalid";
	WebElement message = TestNGClass.driver.findElement(RegisterPageObjects.Error);
	actualtitle = message.getText();
	//System.out.println(actualtitle);
	
	//Validating
	}
	catch(Exception e) {
		System.out.println("I'm in Catch 4 block");
	}
	if(expectedtitle.equals(actualtitle)) {
		WriteDataIntoExcel.WriteData(4, 12,"Passed");
		System.out.println("Validate registering an account by providing invalid email id: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
		
	}
	else {
		WriteDataIntoExcel.WriteData(4, 12,"Failed");
		System.out.println("Validate registering an account by providing invalid email id: "+  ANSI_RED +  "Failed" + ANSI_RESET);
		
	}
}

@Test(priority = 5,enabled = true)
/*TestCase5 - "Validate registering an account by providing all input fields except Login"
1.Open a browser
2.Open the URL(http://demo.redmine.com)
3.Click on  Register.
4.Enter new account details into all Fields except Login (Password, Confirmation, First name, Last name).
5.Click on Submit Button.
 */
void validateRegisterFunctionalitybyProvidingAllFieldsExceptLogin() throws IOException {
try {
	TestNGClass.driver.findElement(RegisterPageObjects.Register).click();//click on Register Link
	TestNGClass.driver.findElement(RegisterPageObjects.UserLogin).sendKeys(""); //Enter login
	TestNGClass.driver.findElement(RegisterPageObjects.Password).sendKeys(DataForRegister.readData(5, 2)); //Enter password
	TestNGClass.driver.findElement(RegisterPageObjects.Confirmation).sendKeys(DataForRegister.readData(5, 3));//Enter Password Confirmation
	TestNGClass.driver.findElement(RegisterPageObjects.FirstName).sendKeys(DataForRegister.readData(5, 4)); //Enter Firstname
	TestNGClass.driver.findElement(RegisterPageObjects.Lastname).sendKeys(DataForRegister.readData(5, 7)); //Enter Lastname
	TestNGClass.driver.findElement(RegisterPageObjects.Email).sendKeys(DataForRegister.readData(5,11)); //Enter Email
	TestNGClass.driver.findElement(RegisterPageObjects.Submit).click(); //Click Submit
	expectedtitle = "Login cannot be blank";
	WebElement message = TestNGClass.driver.findElement(RegisterPageObjects.Error);
	actualtitle = message.getText();
	//System.out.println(actualtitle);
	
	//Validating
}
catch(Exception e) {
	System.out.println("I'm in Catch 5 block");
}
	if(expectedtitle.equals(actualtitle)) {
		WriteDataIntoExcel.WriteData(5, 12,"Passed");
		System.out.println("Validate registering an account by providing all input fields except Login: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
		
	}
	else {
		WriteDataIntoExcel.WriteData(5, 12,"Failed");
		System.out.println("Validate registering an account by providing all input fields except Login: Failed"+  ANSI_RED +  "Failed" + ANSI_RESET);
		
	}

}

@Test(priority = 6,enabled = true)
/*TestCase6 - "Validate registering an account by providing all input fields except First Name"
1.Open a browser
2.Open the URL(http://demo.redmine.com)
3.Click on  Register.
4.Enter new account details into all Fields except First name (Login, Password, Confirmation, Last name).
5.Click on Submit Button.
 */
void validateRegisterFunctionalitybyProvidingAllFieldsExceptFirstName() throws IOException {
try {
	TestNGClass.driver.findElement(RegisterPageObjects.Register).click();//click on Register Link
	TestNGClass.driver.findElement(RegisterPageObjects.UserLogin).sendKeys(DataForRegister.readData(6, 1)); //Enter login
	TestNGClass.driver.findElement(RegisterPageObjects.Password).sendKeys(DataForRegister.readData(6, 2)); //Enter password
	TestNGClass.driver.findElement(RegisterPageObjects.Confirmation).sendKeys(DataForRegister.readData(6, 3));//Enter Password Confirmation
	TestNGClass.driver.findElement(RegisterPageObjects.FirstName).sendKeys(""); //Enter Firstname
	TestNGClass.driver.findElement(RegisterPageObjects.Lastname).sendKeys(DataForRegister.readData(6, 7)); //Enter Lastname
	TestNGClass.driver.findElement(RegisterPageObjects.Email).sendKeys(DataForRegister.readData(6,11)); //Enter Email
	TestNGClass.driver.findElement(RegisterPageObjects.Submit).click(); //Click Submit
	expectedtitle = "First name cannot be blank";
	WebElement message = TestNGClass.driver.findElement(RegisterPageObjects.Error);
	actualtitle = message.getText();
	//System.out.println(actualtitle);
	
	//Validating
}
catch(Exception e) {
	System.out.println("I'm in Catch 6 block");
}
	if(expectedtitle.equals(actualtitle)) {
		WriteDataIntoExcel.WriteData(6, 12,"Passed");
		System.out.println("Validate registering an account by providing all input fields except First name: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
	
	}
	else {
		WriteDataIntoExcel.WriteData(6, 12,"Failed");
		System.out.println("Validate registering an account by providing all input fields except First name: "+  ANSI_RED +  "Failed" + ANSI_RESET);
		
	}

}

@Test(priority = 7,enabled = true)
/*TestCase7 - "Validate registering an account by providing all input fields except Last Name"
1.Open a browser
2.Open the URL(http://demo.redmine.com)
3.Click on  Register.
4.Enter new account details into all Fields except Last name (Login, Password, Confirmation, First name).
5.Click on Submit Button.
 */
void validateRegisterFunctionalitybyProvidingAllFieldsExceptLastName() throws IOException {
try {
	TestNGClass.driver.findElement(RegisterPageObjects.Register).click();//click on Register Link
	TestNGClass.driver.findElement(RegisterPageObjects.UserLogin).sendKeys(DataForRegister.readData(7, 1)); //Enter login
	TestNGClass.driver.findElement(RegisterPageObjects.Password).sendKeys(DataForRegister.readData(7, 2)); //Enter password
	TestNGClass.driver.findElement(RegisterPageObjects.Confirmation).sendKeys(DataForRegister.readData(7, 3));//Enter Password Confirmation
	TestNGClass.driver.findElement(RegisterPageObjects.FirstName).sendKeys(DataForRegister.readData(7, 4)); //Enter Firstname
	TestNGClass.driver.findElement(RegisterPageObjects.Lastname).sendKeys(""); //Enter Lastname
	TestNGClass.driver.findElement(RegisterPageObjects.Email).sendKeys(DataForRegister.readData(7,11)); //Enter Email
	TestNGClass.driver.findElement(RegisterPageObjects.Submit).click(); //Click Submit
	expectedtitle = "Last name cannot be blank";
	WebElement message = TestNGClass.driver.findElement(RegisterPageObjects.Error);
	actualtitle = message.getText();
	//System.out.println(actualtitle);
	
	//Validating
}
catch(Exception e) {
	System.out.println("I'm in Catch 7 block");
}
	if(expectedtitle.equals(actualtitle)) {
		WriteDataIntoExcel.WriteData(7, 12,"Passed");
		System.out.println("Validate registering an account by providing all input fields except Last name: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
	
	}
	else {
		WriteDataIntoExcel.WriteData(7, 12,"Failed");
		System.out.println("Validate registering an account by providing all input fields except Last name: "+  ANSI_RED +  "Failed" + ANSI_RESET);
		
	}

}

@Test(priority = 8,enabled = true)
/*TestCase8 - "Validate registering an account by providing all input fields except Email Id"
1.Open a browser
2.Open the URL(http://demo.redmine.com)
3.Click on  Register.
4.Enter new account details into all Fields except Email(Login, Password, Confirmation, First name, Last name).
5.Click on Submit Button.
 */
void validateRegisterFunctionalitybyProvidingAllFieldsExceptEmailId() throws IOException {
try {
	TestNGClass.driver.findElement(RegisterPageObjects.Register).click();//click on Register Link
	TestNGClass.driver.findElement(RegisterPageObjects.UserLogin).sendKeys(DataForRegister.readData(8, 1)); //Enter login
	TestNGClass.driver.findElement(RegisterPageObjects.Password).sendKeys(DataForRegister.readData(8, 2)); //Enter password
	TestNGClass.driver.findElement(RegisterPageObjects.Confirmation).sendKeys(DataForRegister.readData(8, 3));//Enter Password Confirmation
	TestNGClass.driver.findElement(RegisterPageObjects.FirstName).sendKeys(DataForRegister.readData(8, 4)); //Enter Firstname
	TestNGClass.driver.findElement(RegisterPageObjects.Lastname).sendKeys(DataForRegister.readData(8, 7)); //Enter Lastname
	TestNGClass.driver.findElement(RegisterPageObjects.Email).sendKeys(""); //Enter Email
	TestNGClass.driver.findElement(RegisterPageObjects.Submit).click(); //Click Submit
	expectedtitle = "Email cannot be blank";
	WebElement message = TestNGClass.driver.findElement(RegisterPageObjects.Error);
	actualtitle = message.getText();
	//System.out.println(actualtitle);
	
	//Validating
}
catch(Exception e) {
	System.out.println("I'm in Catch 8 block");
}
	if(expectedtitle.equals(actualtitle)) {
		WriteDataIntoExcel.WriteData(8, 12,"Passed");
		System.out.println("Validate registering an account by providing all input fields except Email: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
		
	}
	else {
		WriteDataIntoExcel.WriteData(8, 12,"Failed");
		System.out.println("Validate registering an account by providing all input fields except Email: "+  ANSI_RED+  "Failed" + ANSI_RESET);
		
	}

}

@Test(priority = 9,enabled = true)
/*TestCase9 - "Validate registering an account by providing all input fields except Password"
1.Open a browser
2.Open the URL(http://demo.redmine.com)
3.Click on  Register.
4.Enter new account details into all Fields except Email(Login, Confirmation, First name, Last name).
5.Click on Submit Button.
 */
void validateRegisterFunctionalitybyProvidingAllFieldsExceptPassword() throws IOException {
try {
	TestNGClass.driver.findElement(RegisterPageObjects.Register).click();//click on Register Link
	TestNGClass.driver.findElement(RegisterPageObjects.UserLogin).sendKeys(DataForRegister.readData(9, 1)); //Enter login
	TestNGClass.driver.findElement(RegisterPageObjects.Password).sendKeys(""); //Enter password
	TestNGClass.driver.findElement(RegisterPageObjects.Confirmation).sendKeys(DataForRegister.readData(9, 3));//Enter Password Confirmation
	TestNGClass.driver.findElement(RegisterPageObjects.FirstName).sendKeys(DataForRegister.readData(9, 4)); //Enter Firstname
	TestNGClass.driver.findElement(RegisterPageObjects.Lastname).sendKeys(DataForRegister.readData(9, 7)); //Enter Lastname
	TestNGClass.driver.findElement(RegisterPageObjects.Email).sendKeys(DataForRegister.readData(9,11)); //Enter Email
	TestNGClass.driver.findElement(RegisterPageObjects.Submit).click(); //Click Submit
	expectedtitle = "Password is too short (minimum is 4 characters)\n"
			+ "Password doesn't match confirmation";
	WebElement message = TestNGClass.driver.findElement(RegisterPageObjects.Error);
	actualtitle = message.getText();
	//System.out.println(actualtitle);
	
	//Validating
}
catch(Exception e) {
	System.out.println("I'm in Catch 9 block");
}
	if(expectedtitle.equals(actualtitle)) {
		WriteDataIntoExcel.WriteData(9, 12,"Passed");
		System.out.println("Validate registering an account by providing all input fields except Password: " +  ANSI_GREEN +  "Passed" + ANSI_RESET);
		
	}
	else {
		WriteDataIntoExcel.WriteData(9, 12,"Failed");
		System.out.println("Validate registering an account by providing all input fields except Password: "+  ANSI_RED+  "Failed" + ANSI_RESET);
		
	}

}

@Test(priority = 10, enabled = true)
/*TestCase10 - "Validate registering an account by providing all input fields except Confirmation"
1.Open a browser
2.Open the URL(http://demo.redmine.com)
3.Click on  Register.
4.Enter new account details into all Fields except Confirmation(Login, Password, First name, Last name).
5.Click on Submit Button.
 */
void validateRegisterFunctionalitybyProvidingAllFieldsExceptConfirmation() throws IOException {
try {
	TestNGClass.driver.findElement(RegisterPageObjects.Register).click();//click on Register Link
	TestNGClass.driver.findElement(RegisterPageObjects.UserLogin).sendKeys(DataForRegister.readData(10, 1)); //Enter login
	TestNGClass.driver.findElement(RegisterPageObjects.Password).sendKeys(DataForRegister.readData(10, 2)); //Enter password
	TestNGClass.driver.findElement(RegisterPageObjects.Confirmation).sendKeys("");//Enter Password Confirmation
	TestNGClass.driver.findElement(RegisterPageObjects.FirstName).sendKeys(DataForRegister.readData(10, 4)); //Enter Firstname
	TestNGClass.driver.findElement(RegisterPageObjects.Lastname).sendKeys(DataForRegister.readData(10, 7)); //Enter Lastname
	TestNGClass.driver.findElement(RegisterPageObjects.Email).sendKeys(DataForRegister.readData(10,11)); //Enter Email
	TestNGClass.driver.findElement(RegisterPageObjects.Submit).click(); //Click Submit
	expectedtitle = "Password doesn't match confirmation";
	WebElement message = TestNGClass.driver.findElement(RegisterPageObjects.Error);
	actualtitle = message.getText();
	//System.out.println(actualtitle);
	
	//Validating
}
catch(Exception e) {
	System.out.println("I'm in Catch 10 block");
}
	if(expectedtitle.equals(actualtitle)) {
		WriteDataIntoExcel.WriteData(10, 12,"Passed");
		System.out.println("Validate registering an account by providing all input fields except Confirmation: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
		
	}
	else {
		WriteDataIntoExcel.WriteData(10, 12,"Failed");
		System.out.println("Validate registering an account by providing all input fields except Confirmation: "+  ANSI_RED +  "Failed" + ANSI_RESET);
		
	}

}

@Test(priority = 11, enabled = true)
/*TestCase11 - "Validate registering functionality by navigating back after Successfull User Resgistrtion"
1.Open a browser
2.Open the URL(http://demo.redmine.com)
3.Click on  Register.
4.Enter new account details into all Fields except Confirmation(Login, Password, First name, Last name).
5.Click on Submit Button.
6.Click back button.
 */
void validateRegisterFunctionalitybyNavigateBackAfterSuccessUserRegistrtion() throws IOException {
try {
	TestNGClass.driver.findElement(RegisterPageObjects.Register).click();//click on Register Link
	TestNGClass.driver.findElement(RegisterPageObjects.UserLogin).sendKeys(DataForRegister.readData(11, 1)); //Enter login
	TestNGClass.driver.findElement(RegisterPageObjects.Password).sendKeys(DataForRegister.readData(11, 2)); //Enter password
	TestNGClass.driver.findElement(RegisterPageObjects.Confirmation).sendKeys(DataForRegister.readData(11, 3));//Enter Password Confirmation
	TestNGClass.driver.findElement(RegisterPageObjects.FirstName).sendKeys(DataForRegister.readData(11, 4)); //Enter Firstname
	TestNGClass.driver.findElement(RegisterPageObjects.Lastname).sendKeys(DataForRegister.readData(11, 7)); //Enter Lastname
	TestNGClass.driver.findElement(RegisterPageObjects.Email).sendKeys(DataForRegister.readData(11,11)); //Enter Email
	TestNGClass.driver.findElement(RegisterPageObjects.Submit).click(); //Click Submit
	
	TestNGClass.driver.navigate().back(); // Navigate Back Command
	WebElement title = TestNGClass.driver.findElement(RegisterPageObjects.UserActive);
	actualtitle = title.getText();
	expectedtitle = DataForRegister.readData(2, 0); 
    
    //validate
}
catch(Exception e) {
	System.out.println("I'm in Catch 11 block");
}
    if(expectedtitle.equals(actualtitle)) {
    	WriteDataIntoExcel.WriteData(11, 12,"Passed");
		System.out.println("Validate registering functionality by navigating back after Successfull User Resgistrtion: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
		
    }
	else {
		WriteDataIntoExcel.WriteData(11, 12,"Failed");
		System.out.println("Validate registering functionality by navigating back after Successfull User Resgistrtion: "+  ANSI_RED +  "Failed" + ANSI_RESET);
		
	}
}
@Test(priority = 12 ,enabled = false)
/*TestCase12 - "Validate registering an account by providing already existing account"
1.Open a browser
2.Open the URL(http://demo.redmine.com)
3.Click on  Register.
4.Enter already existing account details into all Fields (Login, Password, Confirmation, First name, Last name, Email).
5.Click on Submit Button.
 */
void validateRegisterFunctionalitybyProvidingAlreadyExisingAccountDetails() throws IOException {
try {
	TestNGClass.driver.findElement(RegisterPageObjects.Register).click();//click on Register Link
	TestNGClass.driver.findElement(RegisterPageObjects.UserLogin).sendKeys(DataForRegister.readData(2, 0)); //Enter login
	TestNGClass.driver.findElement(RegisterPageObjects.Password).sendKeys("1234"); //Enter password
	TestNGClass.driver.findElement(RegisterPageObjects.Confirmation).sendKeys("1234");//Enter Password Confirmation
	TestNGClass.driver.findElement(RegisterPageObjects.FirstName).sendKeys(DataForRegister.readData(2, 1)); //Enter Firstname
	TestNGClass.driver.findElement(RegisterPageObjects.Lastname).sendKeys(DataForRegister.readData(2, 4)); //Enter Lastname
	TestNGClass.driver.findElement(RegisterPageObjects.Email).sendKeys(DataForRegister.readData(2,8)); //Enter Email
	TestNGClass.driver.findElement(RegisterPageObjects.Submit).click(); //Click Submit
	expectedtitle = "Email has already been taken\n"
			+ "Login has already been taken";
	WebElement message = TestNGClass.driver.findElement(RegisterPageObjects.Error);
	actualtitle = message.getText();
	//System.out.println(actualtitle);
	
	//Validating
}
catch(Exception e) {
	System.out.println("I'm in Catch 5 block");
}
	if(expectedtitle.equals(actualtitle)) {
		WriteDataIntoExcel.WriteData(12, 12,"Passed");
		System.out.println("Validate registering an account by providing already existing account: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
	}
	else {
		WriteDataIntoExcel.WriteData(12, 12,"Failed");
		System.out.println("Validate registering an account by providing already existing account: "+  ANSI_RED +  "Failed" + ANSI_RESET);
		
	}

}

}
