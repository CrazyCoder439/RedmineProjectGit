package testNG;

import pageObjectModel.LoginPageObjects;

import org.testng.annotations.Test;

import dataDriven1.DataForLogin;
import dataDriven1.WriteLoginDataResultsIntoExcel;

import java.io.IOException;

//import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//import org.testng.annotations.AfterClass;

public class TestNGLoginFuntionality {
	
	public static String expectedtitle;
	public static String actualtitle;
	public static String ANSI_GREEN = "\u001B[32m";
	public static String ANSI_RED = "\u001B[31m";
	public static String ANSI_RESET = "\u001B[37m";
	

	

 
@Test(priority = 1, enabled = true)
//TestCase - 1
	public void validateLoggingwithValidCredentials() throws IOException {
		
		try {
			
		TestNGClass.driver.findElement(LoginPageObjects.Signin).click();
		TestNGClass.driver.findElement(LoginPageObjects.Username).sendKeys(DataForLogin.readData(1, 1)); //login
		TestNGClass.driver.findElement(LoginPageObjects.Password).sendKeys(DataForLogin.readData(1, 2));		//password
		TestNGClass.driver.findElement(LoginPageObjects.Login).click();
		expectedtitle = "My account - Redmine demo"; //expected Message
		TestNGClass.driver.findElement(LoginPageObjects.MyAccount).click();
		actualtitle = TestNGClass.driver.getTitle(); //Get Current Title
	    
	    
	   
		}
		catch(Exception e) {
			System.out.println("I'm in Catch 1 Block");
			 
		}
	
		
		if(expectedtitle.equalsIgnoreCase(actualtitle)) {
			WriteLoginDataResultsIntoExcel.WriteData(1, 12,"Passed");
				System.out.println("Validate logging into the Application using valid Username and valid Password: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
				TestNGClass.driver.findElement(LoginPageObjects.Signout).click();
			}
			else {
				WriteLoginDataResultsIntoExcel.WriteData(1, 12,"Failed");
				System.out.println("Validate logging into the Application using valid Username and valid Password: "+  ANSI_RED +  "Failed" + ANSI_RESET);
				
			}
		
	}

@Test(priority = 2, enabled = true)
//TestCase - 2
public void validateUserFunctionalityByNavigateBackAfterSuccessfulLogin() throws IOException {
		String expectedtitle = null;
		String actualtitle = null;
		try {
			TestNGClass.driver.findElement(LoginPageObjects.Signin).click();
			TestNGClass.driver.findElement(LoginPageObjects.Username).sendKeys(DataForLogin.readData(1, 1)); //login
			TestNGClass.driver.findElement(LoginPageObjects.Password).sendKeys(DataForLogin.readData(1, 2));		//password
			TestNGClass.driver.findElement(LoginPageObjects.Login).click();
		expectedtitle = "My account - Redmine demo"; //expected Message
		TestNGClass.driver.findElement(LoginPageObjects.MyAccount).click();
		TestNGClass.driver.navigate().back(); //Navigate Back
		TestNGClass.driver.findElement(LoginPageObjects.MyAccount).click();
		actualtitle = TestNGClass.driver.getTitle(); //Get Current Title
	   
		}
	    catch(Exception e) {
			System.out.println("I'm in Catch 2 Block");
			}
	    
	   
	

	    if(expectedtitle.equalsIgnoreCase(actualtitle)) {
	    	WriteLoginDataResultsIntoExcel.WriteData(2, 12,"Passed");
			System.out.println("Validate user functionality by navigate back after successful login stays logged : "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			WriteLoginDataResultsIntoExcel.WriteData(2, 12,"Failed");
			System.out.println("Validate user functionality by navigate back after successful login stays logged: "+  ANSI_RED +  "Failed" + ANSI_RESET);
		}
		
	}
@Test(priority = 3, enabled = true)
//TestCase - 3
public void validateUserFunctionalityThatLoggedIntoCorrectUser() throws IOException {
		
		try {
			TestNGClass.driver.findElement(LoginPageObjects.Signin).click();
			TestNGClass.driver.findElement(LoginPageObjects.Username).sendKeys(DataForLogin.readData(1, 1)); //login
			TestNGClass.driver.findElement(LoginPageObjects.Password).sendKeys(DataForLogin.readData(1, 2));		//password
			TestNGClass.driver.findElement(LoginPageObjects.Login).click();
		expectedtitle = DataForLogin.readData(1, 2); //expected Message
		actualtitle = TestNGClass.driver.findElement(LoginPageObjects.UserActive).getText();
		
		}
	    catch(Exception e) {
			System.out.println("I'm in Catch 3 Block");
			}
		
		
		
	    if(expectedtitle.equalsIgnoreCase(actualtitle)) {
	    	WriteLoginDataResultsIntoExcel.WriteData(3, 12,"Passed");
			System.out.println("Validate user functionality that logged into Correct User: " +  ANSI_GREEN +  "Passed" + ANSI_RESET);
			TestNGClass.driver.findElement(By.linkText("Sign out")).click();
		}
		else {
			WriteLoginDataResultsIntoExcel.WriteData(3, 12,"Failed");
			System.out.println("Validate user functionality that logged into Correct User: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
	    
	
}
	

@Test(priority = 4, enabled = true)
//TestCase - 4
public void validateUserFunctionalityThatLoggedOutNavigateBackStillLoggedIn() throws IOException {
		
		try {
			TestNGClass.driver.findElement(LoginPageObjects.Signin).click();
			TestNGClass.driver.findElement(LoginPageObjects.Username).sendKeys(DataForLogin.readData(1, 1)); //login
			TestNGClass.driver.findElement(LoginPageObjects.Password).sendKeys(DataForLogin.readData(1, 2));		//password
			TestNGClass.driver.findElement(LoginPageObjects.Login).click();
		TestNGClass.driver.findElement(LoginPageObjects.Signout).click();
		TestNGClass.driver.navigate().back();
		expectedtitle = "Redmine demo"; //expected Message
		actualtitle = TestNGClass.driver.getTitle();
	   
		}
	    catch(Exception e) {
			System.out.println("I'm in Catch 4 Block");
			}
		
	    if(expectedtitle != actualtitle) {
	    	WriteLoginDataResultsIntoExcel.WriteData(4, 12,"Passed");
			System.out.println("Validate user functionality that Logged out Navigate back Still Logged In : " +  ANSI_GREEN +  "Passed" + ANSI_RESET);
			//TestNGClass.driver.findElement(By.linkText("Sign out")).click();
		}
		else {
			WriteLoginDataResultsIntoExcel.WriteData(4, 12,"Failed");
			System.out.println("Validate user functionality that Logged out Navigate back Still Logged In: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
	    
	
}	

	
@Test(priority = 5, enabled = true)
//TestCase - 5
public void validateLoggingwithInvalidUsernameInvalidPassword() throws IOException { //2
		try {
			TestNGClass.driver.findElement(LoginPageObjects.Signin).click();
			TestNGClass.driver.findElement(LoginPageObjects.Username).sendKeys(DataForLogin.readData(4, 1)); //login
			TestNGClass.driver.findElement(LoginPageObjects.Password).sendKeys(DataForLogin.readData(4, 2));		//password
			TestNGClass.driver.findElement(LoginPageObjects.Login).click();
		expectedtitle = "Invalid user or password";
		WebElement message = TestNGClass.driver.findElement(LoginPageObjects.Error);
	    actualtitle = message.getText();
	 
	   
		}
		catch(Exception e) {
			System.out.println("I'm in Catch 5 Block");
		}
		
		if(expectedtitle.equals(actualtitle)) {
			WriteLoginDataResultsIntoExcel.WriteData(5, 12,"Passed");
			System.out.println("Validate logging into the Application using Invalid Username and Invalid Password: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			WriteLoginDataResultsIntoExcel.WriteData(5, 12,"Failed");
			System.out.println("Validate logging into the Application using Invalid Username and Invalid Password: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
	    
}
	

@Test(priority = 6, enabled = true)
//TestCase - 6
public void validateLoggingwithInvalidUsernameValidPassword() throws IOException {
	try {
		TestNGClass.driver.findElement(LoginPageObjects.Signin).click();
		TestNGClass.driver.findElement(LoginPageObjects.Username).sendKeys(DataForLogin.readData(4, 1)); //login
		TestNGClass.driver.findElement(LoginPageObjects.Password).sendKeys(DataForLogin.readData(1, 2));		//password
		TestNGClass.driver.findElement(LoginPageObjects.Login).click();
		expectedtitle = "Invalid user or password";
		WebElement message = TestNGClass.driver.findElement(LoginPageObjects.Error);
	    actualtitle = message.getText();
	      
		}
	catch(Exception e) {
		System.out.println("I'm in Catch 6 Block");
		}
	
		if(expectedtitle.equals(actualtitle)) {
			WriteLoginDataResultsIntoExcel.WriteData(6, 12,"Passed");
			System.out.println("Validate logging into the Application using Invalid Username and Valid password: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			WriteLoginDataResultsIntoExcel.WriteData(6, 12,"Failed");
			System.out.println("Validate logging into the Application using Invalid Username and Valid password: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
		
		
}
@Test(priority = 7, enabled = true)
//TestCase - 7
public void validateLoggingwithValidUsernameInvalidPassword() throws IOException {
		
	try {
		TestNGClass.driver.findElement(LoginPageObjects.Signin).click();
		TestNGClass.driver.findElement(LoginPageObjects.Username).sendKeys(DataForLogin.readData(1, 1)); //login
		TestNGClass.driver.findElement(LoginPageObjects.Password).sendKeys(DataForLogin.readData(4, 2));		//password
		TestNGClass.driver.findElement(LoginPageObjects.Login).click();
		expectedtitle = "Invalid user or password";
		WebElement message = TestNGClass.driver.findElement(LoginPageObjects.Error);
	    actualtitle = message.getText();
		
		}
		catch(Exception e) {
		System.out.println("I'm in Catch 7 Block");
		}
	

	if(expectedtitle.equals(actualtitle)) {
		WriteLoginDataResultsIntoExcel.WriteData(7, 12,"Passed");
			System.out.println("Validate logging into the Application using Valid Username and Invalid password: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			WriteLoginDataResultsIntoExcel.WriteData(7, 12,"Failed");
			System.out.println("Validate logging into the Application using Valid Username and Invalid password: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		
	}
		
}
	
@Test(priority = 8, enabled = true)
//TestCase - 8
public void validateLoggingwithBlankInputs() throws IOException {
		
	try {

		TestNGClass.driver.findElement(LoginPageObjects.Signin).click();
		TestNGClass.driver.findElement(LoginPageObjects.Username).sendKeys(""); //login
		TestNGClass.driver.findElement(LoginPageObjects.Password).sendKeys("");		//password
		TestNGClass.driver.findElement(LoginPageObjects.Login).click();
		expectedtitle = "Invalid user or password";
		WebElement message = TestNGClass.driver.findElement(LoginPageObjects.Error);
	    actualtitle = message.getText();
	
	      
		}
	catch(Exception e) {
		System.out.println("I'm in Catch 8 Block");
		}
	
		if(expectedtitle.equals(actualtitle)) {
			WriteLoginDataResultsIntoExcel.WriteData(8, 12,"Passed");
			System.out.println("Validate logging into the Application using Blank Inputs: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			WriteLoginDataResultsIntoExcel.WriteData(8, 12,"Failed");
			System.out.println("Validate logging into the Application using Blank Inputs: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
		

}
	
@Test(priority = 9, enabled = true)
//TestCase - 9
public void validateForgottenPasswordLinkWithInvalidEmail() throws IOException {
		
		try {
		TestNGClass.driver.findElement(LoginPageObjects.Signin).click();
		TestNGClass.driver.findElement(LoginPageObjects.LostPassword).click();
		TestNGClass.driver.findElement(LoginPageObjects.Mail).sendKeys(DataForLogin.readData(4, 11));
		TestNGClass.driver.findElement(LoginPageObjects.MailSubmit).click();
		
		expectedtitle = "Unknown user.";
		WebElement message = TestNGClass.driver.findElement(LoginPageObjects.Error);
	    actualtitle = message.getText();
		}
	    catch(Exception e) {
			System.out.println("I'm in Catch 9 Block");
			}
		if(expectedtitle.equals(actualtitle)) {
			
			WriteLoginDataResultsIntoExcel.WriteData(9, 12,"Passed");
			System.out.println("Validate 'Forgotten Password' link with Invalid Username: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			WriteLoginDataResultsIntoExcel.WriteData(9, 12,"Failed");
			System.out.println("Validate 'Forgotten Password' link with Invalid Username: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
		
	    
}
	
	
@Test(priority = 10, enabled = true)
//TestCase - 10
public void validateForgottenPasswordLinkWithvalidEmail() throws IOException {
		
		try {
			TestNGClass.driver.findElement(LoginPageObjects.Signin).click();
			TestNGClass.driver.findElement(LoginPageObjects.LostPassword).click();
			TestNGClass.driver.findElement(LoginPageObjects.Mail).sendKeys(DataForLogin.readData(1, 11));
			TestNGClass.driver.findElement(LoginPageObjects.MailSubmit).click();
		
		expectedtitle = "An email with instructions to choose a new password has been sent to you.";
		WebElement message = TestNGClass.driver.findElement(LoginPageObjects.Flash);
	    actualtitle = message.getText();
		}
	    catch(Exception e) {
			System.out.println("I'm in Catch 10 Block");
			}
	  
		if(expectedtitle.equals(actualtitle)) {
			WriteLoginDataResultsIntoExcel.WriteData(10, 12,"Passed");
			System.out.println("Validate 'Forgotten Password' link with valid Email Id: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			WriteLoginDataResultsIntoExcel.WriteData(10, 12,"Failed");
			System.out.println("Validate 'Forgotten Password' link with valid Email Id: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
		
	    
}

	


}

	
